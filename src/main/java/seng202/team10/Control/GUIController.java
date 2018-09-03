package seng202.team10.Control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import seng202.team10.GUI.*;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.Goal;
import seng202.team10.Model.Goals;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

/**
 * This is the main controller for the application. This class creates and launches scenes,
 * stores all data needed and functions as the general controller. It passes itself into
 * controllers so they can access any information they need.
 */
public class GUIController extends Application{

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

    private Stage primaryStage;
    private ArrayList<UserProfile> users = new ArrayList<UserProfile>();


    private UserProfile currentUser;
    private Parser parser = new Parser();
    private FileWriter dataWriter = new FileWriter();

    private Goals goals = new Goals(currentUser);

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadAllScenes();
        primaryStage.setTitle("Coach Potato");
        primaryStage.setScene(goalsScene);
        //primaryStage.setScene(goalsScene);
        primaryStage.show();
        this.primaryStage = primaryStage;
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
    public void launchLoginScene() throws Exception {
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
        profileController.setUserDetails();
//        profileController.setUpScene();
        primaryStage.setScene(profileScene);
//        profileController.setUserDetails();

    }

    public void launchGoalsScene() {
      goalsController.setUpScene();
      primaryStage.setScene(goalsScene);
    }

    /**
     * Sets the scene on the primary stage to the upload data scene.
     */
    public void launchUploadDataScene() {
        uploadDataController.setUpScene();
        primaryStage.setScene(uploadDataScene);
    }

    /**
     * Sets the scene on the primary stage to the create profile scene.
     */
    public void launchCreateProfileScene() throws Exception {
        primaryStage.setScene(createProfileScene);
    }


    /**
     * Initalizes every loader, controller and scene for each scene. Also runs the setApp(this) and
     * setUpScene methods for each.
     * @throws Exception Not implemented.
     */
    public void loadAllScenes() throws Exception{

        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        Parent root = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setApp(this);
        goalsController.setUpScene();
        goalsScene = new Scene(root, 900, 600);


//        loginScene = loadNewScene("/fxml/loginScreen.fxml");
//        createProfileScene = loadNewScene("/fxml/createProfileScreen.fxml");
//        profileScene = loadNewScene("/fxml/profileScreen.fxml");
//        goalsScene = loadNewScene("/fxml/goalsScreen.fxml");
//        uploadDataScene = loadNewScene("/fxml/uploadDataScreen.fxml");

//        loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
//        Parent root = loginLoader.load();
//        loginController = loginLoader.getController();
//        loginController.setApp(this);
//        loginController.setUpScene();
//        loginScene = new Scene(root, 800, 400);

        createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        Pane paneCP = createProfileLoader.load();
        createProfileController = createProfileLoader.getController();
        createProfileController.setApp(this);
        createProfileController.setUpScene();
        createProfileScene = new Scene(paneCP, 900, 600);

        profileLoader = new FXMLLoader(getClass().getResource("/fxml/profileScreen.fxml"));
        Pane PaneP = profileLoader.load();
        profileController = profileLoader.getController();
        profileController.setApp(this);
        profileController.setUpScene();
        //profileController.setUserDetails();
        profileScene = new Scene(PaneP, 900, 600);



        uploadDataLoader = new FXMLLoader(getClass().getResource("/fxml/uploadDataScreen.fxml"));
        Pane paneUD = uploadDataLoader.load();
        uploadDataController = uploadDataLoader.getController();
        uploadDataController.setApp(this);
        uploadDataController.setUpScene();
        uploadDataScene = new Scene(paneUD, 900, 600);
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
     * @throws Exception Not implemented
     */
    public void createUser(UserProfile newUser) throws Exception{
        users.add(newUser);
        uploadDataToUser(newUser, "testdata.csv"); //REMOVE LATER
    }

    /**
     * Sets the current user profile.
     * @param userProfile  The user profile that's logged in.
     */
    public void setCurrentProfile(UserProfile userProfile) {
        this.currentUser = userProfile;
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

    public Goals getGoalsInstance() {
        return goals;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
