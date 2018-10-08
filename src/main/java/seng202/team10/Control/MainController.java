package seng202.team10.Control;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.FileOperations.*;
import seng202.team10.Model.UserProfile;
import seng202.team10.Visual.*;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;


/**
 * Class that acts as the main controller for the application. Creates and launches scenes,
 * stores all data needed and functions. Passes itself into controllers so they can access any information they need.
 */
public class MainController extends Application {

    private Scene titleBarScene;
    private TitleBarController titleBarController;
    private Stage primaryStage;
    private Parser parser = new Parser();
    private FileWriter dataWriter = new FileWriter();
    private FileReader dataReader = new FileReader();
    private ArrayList<String> userNames = new ArrayList<>();
    private double[] offset_XY;
    private Parent root;
    private ArrayList<String> userGenders = new ArrayList<>();


    /**
     * Method to perform the initial setup when the program is launched. Loads profiles and scenes to the stage.
     * @param primaryStage The main stage of the application that all scenes will be set to.
     * @throws Exception When the stage is null.
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        if(!dataReader.checkFileExists("./profiles")) {
            dataWriter.createProfileFolder();
        }
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
     * Method to set the window as draggable.
     * @param root  The <b>Parent</b> scene loader of the window.
     * @param stage  The primary <b>Stage</b> of the application.
     */
    private void allowDrag(Parent root, Stage stage)
    {
        Rectangle2D
                screenBounds = Screen.getPrimary()
                .getVisualBounds();
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent p) {
                offset_XY = new double[]{p.getSceneX(), p.getSceneY()};
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent d) {
                //Ensures the stage is not dragged past the taskbar
                if (d.getScreenY() < (screenBounds.getMaxY() - 20))
                    stage.setY(d.getScreenY() - offset_XY[1]);
                stage.setX(d.getScreenX() - offset_XY[0]);
            }
        });

        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent r) {
                //Ensures the stage is not dragged past top of screen
                if (stage.getY() < 0.0) stage.setY(0.0);
            }
        });
    }


    /**
     * Method to load usernames and genders from the filenames.
     */
    public void loadUserDetails()
    {
        // repopulate the user lists
        dataReader.getExistingUsers(userNames, userGenders);
    }


    /**
     * Getter method for the data reader.
     * @return A <b>FileReader</b> for reading data from files.
     */
    public FileReader getDataReader()
    {
        return dataReader;
    }

    /**
     * Getter method for the user genders.
     * @return An <b>ArrayList&lt;String&gt;</b> of the genders of users.
     */
    public ArrayList<String> getUserGenders()
    {
        return userGenders;
    }


    /**
     * Getter method for the user names.
     * @return An <b>ArrayList&lt;String&gt;</b> of user names.
     */
    public ArrayList<String> getUserNames() {
        return userNames;
    }

    /**
     * Getter method for the primary stage.
     * @return The primary <b>Stage</b> of the application.
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
     * Getter method for the parser.
     * @return A <b>Parser</b> for parsing data.
     */
    public Parser getParser()
    {
        return this.parser;
    }


    /**
     * Getter method for data writer
     * @return A <b>FileWriter</b> for writing to files.
     */
    public FileWriter getDataWriter()
    {
        return this.dataWriter;
    }


    /**
     * Method to upload the data from a file and store it in the specified user profile.
     *
     * @param user  The <b>UserProfile</b> that the data is uploaded to.
     * @param filePath A <b>String</b> of the file path the data is stored at.
     * @throws FileNotFoundException When there's no file to be found
     * @throws NoDataFoundException When there's no data to be found in the file
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
     * Method to check if a profile already exists with a specific username.
     * @param userName A <b>String</b> of the username being checked.
     * @throws UniqueNameException When a profile already exists with that name.
     */
    public String checkUniqueName(String userName) throws UniqueNameException
    {
        String nnameString = userName.replaceAll("\\s+", " ");
        nnameString = nnameString.trim();
        if (titleBarController.getCurrentProfile() == null || !nnameString.contentEquals(titleBarController.getCurrentProfile().getName())) {
            for (String name : this.getUserNames()) {
                if (name.equals(nnameString)) {
                    throw new UniqueNameException();
                }
            }
        }
        return nnameString;
    }


    /**
     * Method to initialize the loader, controller and scene for the title bar.
     * @throws Exception When the resources cannot be found.
     */
    private void loadTitleBar() throws Exception
    {
        FXMLLoader titleBarLoader = new FXMLLoader(getClass().getResource("/fxml/titleBar.fxml"));
        root = titleBarLoader.load();
        titleBarController = titleBarLoader.getController();
        titleBarController.setMainController(this);
        titleBarController.setUpScene();
        titleBarScene = new Scene(root, 1280, 750);
    }


    /**
     * Method to create a new user profile.
     * @param newUser  The <b>UserProfile</b> being created.
     * @throws InvalidUserException When the newUser has invalid data.
     */
    public void createUser(UserProfile newUser) throws InvalidUserException
    {
        if (newUser.getName() != null &&
                newUser.getWeight() != 0.0 &&
                newUser.getHeight() != 0.0 &&
                newUser.getBirthDate() != null &&
                newUser.getGender() != null) {
            newUser.setLastWeightUpdate(DateTime.now());
            getDataWriter().saveProfile(newUser);
        } else {
            throw new InvalidUserException();
        }
    }


    /**
     * Setter for the user profile.
     * @param userProfile  The <b>UserProfile</b> that's logged in.
     */
    public void setCurrentProfile(UserProfile userProfile) {
        this.titleBarController.setCurrentProfile(userProfile);
        this.getTitleBar().getGoalController().setCurrentUser(userProfile);
        this.titleBarController.getGoalController().addGoalsToTable();
    }


    /**
     * Obligatory main method. Launches the program.
     * @param args Not used main function variable.
     */
    public static void main(String[] args)
    {
        launch(args);
    }


    /**
     * Method to display a pop up window with a title, a message and a type of alert (error, message or warning).
     * @param type An <b>Alert.AlertType</b> of the type of alert.
     * @param title A <b>String</b> of the title of the pop up window.
     * @param message A <b>String</b> of the message to display to the user.
     * @return  A <b>String</b> of the message displayed.
     */
    public String createPopUp(Alert.AlertType type, String title, String message)
    {
        Alert errorPopUp = new Alert(type);
        errorPopUp.setTitle(title);
        errorPopUp.setContentText(message);
        errorPopUp.setHeaderText(null);
        Optional<ButtonType> buttonType = errorPopUp.showAndWait();
        try {
            return buttonType.get().getText();
        } catch (NoSuchElementException exception) {
            // If the close button in the top left is selected, cancel the pop up.
            return "Cancel";
        }
    }

    /**
     * Getter method for the title bar controller.
     * @return A <b>TitleBarController</b> object.
     */
    public TitleBarController getTitleBar() {
        return titleBarController;
    }


    /**
     * Setter method for current user.
     * @param currentUser The <b>UserProfile</b> of the currently logged in user.
     */
    public void setCurrentUser(UserProfile currentUser)
    {
        this.titleBarController.setCurrentProfile(currentUser);
    }
}
