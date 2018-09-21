package seng202.team10.Control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Route;
import seng202.team10.Model.Exceptions.InvalidUserException;
import seng202.team10.Model.Exceptions.UniqueNameException;
import seng202.team10.Model.Exceptions.UserNameException;
import seng202.team10.Model.FileOperations.FileReader;
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.UserProfile;
import seng202.team10.Visual.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * This is the main controller for the application. This class creates and launches scenes,
 * stores all data needed and functions as the general controller. It passes itself into
 * controllers so they can access any information they need.
 */
public class GUIController extends Application{

    private FXMLLoader mainLoader;
    private Scene mainScene;
    private MainScreenController mainController;

    private FXMLLoader loginLoader;
    private Scene loginScene;
    private LoginController loginController;

    private FXMLLoader createProfileLoader;
    private Scene createProfileScene;
    private CreateProfileController createProfileController;

    private FXMLLoader profileLoader;
    private Scene profileScene;
    private ProfileController profileController;

    private FXMLLoader goalsLoader;
    private Scene goalsScene;
    private GoalController goalsController;

    private FXMLLoader uploadDataLoader;
    private Scene uploadDataScene;
    private UploadDataController uploadDataController;

    private FXMLLoader dataAnalysisLoader;
    private Scene dataAnalysisScene;
    private DataAnalysisController dataAnalysisController;

    private FXMLLoader activityViewerLoader;
    private Scene activityViewerScene;
    private ActivityViewerController activityViewerController;

    private FXMLLoader entryViewerLoader;
    private Scene entryViewerScene;
    private EntryViewerController entryViewerController;

    private FXMLLoader mapLoader;
    private Scene mapScene;
    private MapController mapController;

    private Stage primaryStage;
    private ArrayList<UserProfile> users = new ArrayList<>();


    private UserProfile currentUser;
    private Parser parser = new Parser();
    private FileWriter dataWriter = new FileWriter();
    private FileReader dataReader = new FileReader();

    //private Goals goals = new Goals(currentUser);

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        if(!dataReader.checkFileExists("./profiles")){
            dataWriter.createProfileFolder();
        }
        try {
            // Added a test user.
            users.add(new UserProfile("Potato", 75, 180, new DateTime(2000, 1, 1, 1, 1, 1), "Male"));
            users.get(0).setMaxHeartRate(210);
        } catch (IllegalArgumentException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
        }
            loadAllUsers();
            loadAllScenes();
            primaryStage.setTitle("Coach Potato");
            if (users.isEmpty()) {
                primaryStage.setScene(createProfileScene);
            } else {
                primaryStage.setScene(loginScene);
            }
            //        primaryStage.setScene(mainScene);
            //primaryStage.setScene(goalsScene);
            primaryStage.show();
            this.primaryStage = primaryStage;
    }

    /**
     * loads all the users in the profiles folder and adds them to the users arraylist
     */
    private void loadAllUsers() {
        ArrayList<String> userNames = dataReader.getExistingUsers();
        for(String username: userNames){
            users.add(dataReader.loadExistingProfile(username));
        }
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
     * @throws Exception Not implemented yet.
     */
    public void uploadDataToUser(UserProfile user, String filePath) throws Exception{
        ArrayList<String> fileContents = parser.getFileContents(filePath);
        ArrayList<ArrayList<String>> formattedFileContents = parser.formatFileContents(fileContents);
        ArrayList<Activity> activities = parser.processFile(formattedFileContents);
        user.addActivities(activities);
    }


    /**
     * Sets the scene on the primary stage to the login scene.
     * @throws Exception Not implemented.
     */
    public void launchLoginScene()
    {
        loginController.setUpScene();
        primaryStage.setScene(loginScene);
    }

    /**dNewScene("/fxml/loginScreen.fxml");
        createProfileScene = loadNewScene("/fxml/createProfileScreen.fxml");
        profileScene = loadNewScene("/fxml/profileScreen.fxml");
//        goalsScene = loadNewScene("/fxml/goalsScreen.fxml");
        uploadDataScene
     * Sets the scene on the primary stage to the profile scene.
     */
    public void launchProfileScene() {
//        profileController.setUpScene();
        profileController.setUserDetails();
        dataWriter.saveProfile(currentUser);
        primaryStage.setScene(profileScene);

    }


    public void checkUniqueName(String userName) throws UniqueNameException
    {
        for (UserProfile userProfile: this.getUsers()) {
            if (userProfile.getName().equals(userName)) {
                throw new UniqueNameException();
            }
        }
    }


    public void launchMapScene(Activity activity) {
        mapController.setActivity(activity);
        mapController.setUpScene();
        Route newRoute = mapController.makeRoute(activity);
        mapController.displayRoute(newRoute);
        primaryStage.setScene(mapScene);
    }

    public void launchGoalsScene() {
        //goalsController.setUpScene();
        dataWriter.saveProfile(currentUser);
        goalsController.addGoalsToTable();
        primaryStage.setScene(goalsScene);
    }

    /**
     * Sets the scene on the primary stage to the upload data scene.
     */
    public void launchUploadDataScene() {
        uploadDataController.setUpScene();
        dataWriter.saveProfile(currentUser);
        primaryStage.setScene(uploadDataScene);
    }

    /**
     * Sets the scene on the primary stage to the create profile scene.
     */
    public void launchCreateProfileScene()
    {
        createProfileController.toggleBackButton();
        primaryStage.setScene(createProfileScene);
    }

    /**
     * Sets the scene on the primary stage to the data analysis scene.
     */
    public void launchDataAnalysisScene()
    {
//        dataAnalysisController.setActivity(currentUser.getActivities().get(0));
        dataAnalysisController.setUpScene();
        dataWriter.saveProfile(currentUser);
        primaryStage.setScene(dataAnalysisScene);
    }

    /**
     * Sets the scene on the primary stage to the entry viewer scene.
     */
    public void launchEntryViewerScene(Activity activity)
    {
        entryViewerController.setUpScene(activity);
        dataWriter.saveProfile(currentUser);
        primaryStage.setScene(entryViewerScene);
    }

    /**
     * Sets the scene on the primary stage to the activity viewer scene.
     */
    public void launchActivityViewerScene()
    {
        activityViewerController.setUpScene();
        dataWriter.saveProfile(currentUser);
        primaryStage.setScene(activityViewerScene);
    }

    public void refreshMapScene(Activity activity) {
        this.launchDataAnalysisScene();
        try {
            TimeUnit.MICROSECONDS.sleep(90000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.launchMapScene(activity);
    }

    /**
     * Initalizes every loader, controller and scene for each scene. Also runs the setApp(this) and
     * setUpScene methods for each.
     * @throws Exception Not implemented.
     */
    public void loadAllScenes() throws Exception{
//        loginScene = loadNewScene("/fxml/loginScreen.fxml");
//        createProfileScene = loadNewScene("/fxml/createProfileScreen.fxml");
//        profileScene = loadNewScene("/fxml/profileScreen.fxml");
//        goalsScene = loadNewScene("/fxml/goalsScreen.fxml");
//        uploadDataScene = loadNewScene("/fxml/uploadDataScreen.fxml");


        loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
        Parent root = loginLoader.load();
        loginController = loginLoader.getController();
        loginController.setApp(this);
        loginController.setUpScene();
        loginScene = new Scene(root, 1280, 720);

//        mainLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
//        VBox mainVBox = mainLoader.load();
//        mainController = mainLoader.getController();
//        mainController.setApp(this);
//        mainController.setUpScene();
//        mainScene = new Scene(mainVBox, 1280, 720);

        createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        Pane paneCP = createProfileLoader.load();
        createProfileController = createProfileLoader.getController();
        createProfileController.setApp(this);
        createProfileController.setUpScene();
        createProfileScene = new Scene(paneCP, 1280, 720);

        profileLoader = new FXMLLoader(getClass().getResource("/fxml/profileScreen.fxml"));
        Pane PaneP = profileLoader.load();
        profileController = profileLoader.getController();
        profileController.setApp(this);
        profileController.setUpScene();
        profileScene = new Scene(PaneP, 1280, 720);

        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        Pane paneG = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setApp(this);
        goalsController.setUpScene();
        goalsScene = new Scene(paneG, 1280, 720);

        uploadDataLoader = new FXMLLoader(getClass().getResource("/fxml/uploadDataScreen.fxml"));
        Pane paneUD = uploadDataLoader.load();
        uploadDataController = uploadDataLoader.getController();
        uploadDataController.setApp(this);
        uploadDataController.setUpScene();
        uploadDataScene = new Scene(paneUD, 1280, 720);

        dataAnalysisLoader = new FXMLLoader(getClass().getResource("/fxml/dataAnalysisScreen.fxml"));
        Pane paneDA = dataAnalysisLoader.load();
        dataAnalysisController = dataAnalysisLoader.getController();
        dataAnalysisController.setApp(this);
//        dataAnalysisController.setUpScene();
        dataAnalysisScene = new Scene(paneDA, 1280, 720);

        activityViewerLoader = new FXMLLoader(getClass().getResource("/fxml/activityViewerScreen.fxml"));
        Pane paneAV = activityViewerLoader.load();
        activityViewerController = activityViewerLoader.getController();
        activityViewerController.setApp(this);
//        ActivityViewerController.setUpScene();
        activityViewerScene = new Scene(paneAV, 1280, 720);

        entryViewerLoader = new FXMLLoader(getClass().getResource("/fxml/entryViewerScreen.fxml"));
        Pane paneEV = entryViewerLoader.load();
        entryViewerController = entryViewerLoader.getController();
        entryViewerController.setApp(this);
//        EntryViewerController.setUpScene();
        entryViewerScene = new Scene(paneEV, 1280, 720);

        mapLoader = new FXMLLoader(getClass().getResource("/fxml/mapScreen.fxml"));
        Pane paneMap = mapLoader.load();
        mapController = mapLoader.getController();
        mapController.setApp(this);
        mapController.setUpScene();
        mapScene = new Scene(paneMap, 1280, 720);
    }

//    public Pair<Scene, Controllable> loadNewScene(String fxmlPath) throws Exception{
//           FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
//           Pane pane = loader.load();
//           Controllable controller = loader.getController();
//           controller.setApp(this);
//           controller.setUpScene();
//           return new Scene(pane, 900, 600);
//    }

    /**
     * Creates a new profile (and adds the test data to it for now).
     * @param newUser  The profile being created.
     */
    public void createUser(UserProfile newUser) throws InvalidUserException
    {
        //TODO this should be in UserProfile???
        if (newUser.getName() != null && newUser.getWeight() != 0.0 && newUser.getHeight() != 0.0 && newUser.getBirthDate() != null && newUser.getGender() != null && newUser.getMaxHeartrate() != 0) {
            users.add(newUser);
        } else {
            throw new InvalidUserException();
        }
    }


    /**
     * Sets the current user profile.
     * @param userProfile  The user profile that's logged in.
     */
    public void setCurrentProfile(UserProfile userProfile) {
        this.currentUser = userProfile;
        this.goalsController.addGoalsToTable();
    }

    /**
     * Gets the currently logged in user.
     * @return  a UserProfile object of the currently logged in user.
     */
    public UserProfile getCurrentProfile() {
        return this.currentUser;
    }

    /**
     * Gets the list of user profiles.
     * @return  a ArrayList<UserProfile> object of the user profiles.
     */
    public ArrayList<UserProfile> getUsers() {
        return users;
    }

    /**
     * Sets the user profiles.
     * @param users  The list of users stored in the app.
     */
    public void setUsers(ArrayList<UserProfile> users) {
        this.users = users;
    }




    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Method to display a pop up window with a title a message and a type (depending on if you want an error or information etc)
     * @param type Alert.AlertType: type of alert
     * @param title String: Title of pop up window
     * @param message String: Message to display to user
     */
    public void createPopUp(Alert.AlertType type, String title, String message)
    {
        Alert errorPopUp = new Alert(type);
        errorPopUp.setTitle(title);
        errorPopUp.setContentText(message);
        errorPopUp.setHeaderText(null);
        errorPopUp.showAndWait();
    }
}
