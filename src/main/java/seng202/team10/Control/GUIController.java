package seng202.team10.Control;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Route;
import seng202.team10.Model.Exceptions.ExistingElementException;
import seng202.team10.Model.Exceptions.InvalidUserException;
import seng202.team10.Model.Exceptions.NoDataFoundException;
import seng202.team10.Model.Exceptions.UniqueNameException;
import seng202.team10.Model.FileOperations.FileReader;
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.UserProfile;
import seng202.team10.Visual.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


/**
 * This is the main controller for the application. This class creates and launches scenes,
 * stores all data needed and functions as the general controller. It passes itself into
 * controllers so they can access any information they need.
 */
public class GUIController extends Application {


    private Scene titleBarScene;
    private TitleBarController titleBarController;

    private Stage primaryStage;
    private ArrayList<UserProfile> users = new ArrayList<>();

    private Parser parser = new Parser();
    private FileWriter dataWriter = new FileWriter();
    private FileReader dataReader = new FileReader();
    private ArrayList<String> userNames = new ArrayList<>();
    private double[] offset_XY;

    private Parent root;
    private ArrayList<String> userGenders = new ArrayList<>();


    /**
     * A lot of the initial setup when the program is launched. loads profiles and scenes to the stage
     * @param primaryStage The main stage of the application that all scenes will be set to.
     * @throws Exception When the stage is null
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        if(!dataReader.checkFileExists("./profiles")) {
            dataWriter.createProfileFolder();
        }
//        loadAllUsers();
        loadUserDetails();
        loadTitleBar();
        allowDrag(root, primaryStage);
        primaryStage.setTitle("Coach Potato");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        titleBarScene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(titleBarScene);
        primaryStage.show();
        this.primaryStage = primaryStage;
    }


    /**
     * Method to load usernames and genders from the filenames.
     */
    public void loadUserDetails()
    {
        userNames.clear();
        userGenders.clear();
        dataReader.getExistingUsers(userNames, userGenders);
    }


    /**
     * Getter method for the data reader
     * @return FileReader
     */
    public FileReader getDataReader()
    {
        return dataReader;
    }

    /**
     * Getter method for the user genders in an ArrayList of strings
     * @return ArrayList
     */
    public ArrayList<String> getUserGenders()
    {
        return userGenders;
    }


    //    /**
//     * loads all the users in the profiles folder and adds them to the users arraylist
//     */
//    private void loadAllUsers() throws IOException, ClassNotFoundException {
//        userNames = dataReader.getExistingUsers();
//        for (String username : userNames) {
//            try {
//                users.add(dataReader.loadExistingProfile(username));
//            } catch(InvalidClassException exception) {
//                String option = createPopUp(Alert.AlertType.CONFIRMATION, "Error", "Could not load profile: " + username + "\nWould you like to delete it?");
//                if (option.equals("OK")) {
//                    getDataWriter().deleteProfile(username);
//                }
//            }
//        }
//        userNames = dataReader.getExistingUsers();
//    }


    /**
     * Method to set the window as draggable.
     * @param root Parent: the root scene loader of the window.
     * @param stage Stage: the primary stage.
     */
    private void allowDrag(Parent root, Stage stage)
    {
        Rectangle2D
                screenBounds = Screen.getPrimary()
                .getVisualBounds();
        root.setOnMousePressed((MouseEvent p) -> {
            offset_XY = new double[]{p.getSceneX(), p.getSceneY()};
        });

        root.setOnMouseDragged((MouseEvent d) -> {
            //Ensures the stage is not dragged past the taskbar
            if (d.getScreenY()<(screenBounds.getMaxY()-20))
                stage.setY(d.getScreenY() - offset_XY[1]);
            stage.setX(d.getScreenX() - offset_XY[0]);
        });

        root.setOnMouseReleased((MouseEvent r)-> {
            //Ensures the stage is not dragged past top of screen
            if (stage.getY()<0.0) stage.setY(0.0);
        });
    }


    /**
     * Getter Method for the usernames arraylist
     * @return ArrayList: User Names
     */
    public ArrayList getUserNames() {
        return userNames;
    }

    /**
     * Getter Method for the primary stage
     * @return Stage: the primary stage of the application
     */
    public Stage getPrimaryStage()
    {
        return primaryStage;
    }


    /**
     * Method to minimise the window to the task bar.
     */
    public void minimise()
    {
        primaryStage.setIconified(true);
    }


    /**
     * Getter method for the Parser
     * @return Parser
     */
    public Parser getParser()
    {
        return this.parser;
    }


    /**
     * Getter method for data writer
     * @return FileWriter
     */
    public FileWriter getDataWriter()
    {
        return this.dataWriter;
    }


    /**
     * Uploads the data from a file and stores it in the specified user profile.
     *
     * @param user  The user profile that the data is uploaded to.
     * @param filePath The file path the data is stored at.
     * @throws FileNotFoundException When theres no file to be found
     * @throws NoDataFoundException When theres no data to be found in the file
     * @throws ExistingElementException When the data in the file has already been uploaded
     */
    public void uploadDataToUser(UserProfile user, String filePath) throws FileNotFoundException, NoDataFoundException, ExistingElementException
    {
        ArrayList<String> fileContents = parser.getFileContents(filePath);
        ArrayList<ArrayList<String>> formattedFileContents = parser.formatFileContents(fileContents);
        ArrayList<Activity> activities = parser.processFile(formattedFileContents);
        user.addActivities(activities);
    }


    /**
     * checks to see if a profile already exists with a specific username
     * @param userName the username being checked
     * @throws UniqueNameException When a profile already exists with that name.
     */
    public void checkUniqueName(String userName) throws UniqueNameException
    {
        if (titleBarController.getCurrentProfile() == null || !userName.contentEquals(titleBarController.getCurrentProfile().getName())) {
            for (UserProfile userProfile : this.getUsers()) {
                if (userProfile.getName().equals(userName)) {
                    throw new UniqueNameException();
                }
            }
        }
    }


    /**
     * updates the map scene with a specific activity
     * @param activity the activity being mapped
     */
    public void refreshMapScene(Activity activity)
    {
        this.getTitleBar().openAnalysis();
        try {
            TimeUnit.MICROSECONDS.sleep(90000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.getTitleBar().openMap(activity);
    }


    /**
     * Initalizes every loader, controller and scene for each scene. Also runs the setApp(this) and
     * setUpScene methods for each.
     * @throws Exception Not implemented.
     */
    public void loadTitleBar() throws Exception
    {
        FXMLLoader titleBarLoader = new FXMLLoader(getClass().getResource("/fxml/titleBar.fxml"));
        root = titleBarLoader.load();
        titleBarController = titleBarLoader.getController();
        titleBarController.setApp(this);
        titleBarController.setUpScene();
        titleBarScene = new Scene(root, 1280, 750);
    }


    /**
     * Creates a new profile (and adds the test data to it for now).
     * @param newUser  The profile being created.
     * @throws InvalidUserException when the user is invalid
     */
    public void createUser(UserProfile newUser) throws InvalidUserException
    {
        if (newUser.getName() != null &&
                newUser.getWeight() != 0.0 &&
                newUser.getHeight() != 0.0 &&
                newUser.getBirthDate() != null &&
                newUser.getGender() != null) {

            getDataWriter().saveProfile(newUser);
        } else {
            throw new InvalidUserException();
        }
    }


    /**
     * Sets the current user profile.
     * @param userProfile  The user profile that's logged in.
     */
    public void setCurrentProfile(UserProfile userProfile) {
        this.titleBarController.setCurrentProfile(userProfile);
        this.titleBarController.getGoalController().addGoalsToTable();
    }

    /**
     * Gets the list of user profiles.
     * @return  a ArrayList&gt;UserProfile&lt; object of the user profiles.
     */
    public ArrayList<UserProfile> getUsers()
    {
        return users;
    }

    /**
     * Sets the user profiles.
     * @param users  The list of users stored in the app.
     */
    public void setUsers(ArrayList<UserProfile> users)
    {
        this.users = users;
    }


    /**
     * obligatory main method. launches the program
     * @param args Not implemented
     */
    public static void main(String[] args)
    {
        launch(args);
    }


    /**
     * Method to display a pop up window with a title a message and a type (depending on if you want an error or information etc)
     * @param type Alert.AlertType: type of alert
     * @param title String: Title of pop up window
     * @param message String: Message to display to user
     * @return  String
     */
    public String createPopUp(Alert.AlertType type, String title, String message)
    {
        Alert errorPopUp = new Alert(type);
        errorPopUp.setTitle(title);
        errorPopUp.setContentText(message);
        errorPopUp.setHeaderText(null);
        Optional<ButtonType> buttonType = errorPopUp.showAndWait();
        return buttonType.get().getText();
    }

    public TitleBarController getTitleBar() {
        return titleBarController;
    }


    /**
     * Setter Method for current user
     * @param currentUser UserProfile: Current logged in user.
     */
    public void setCurrentUser(UserProfile currentUser) {
        this.titleBarController.setCurrentProfile(currentUser);
    }
}
