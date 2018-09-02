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
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

public class GUIController extends Application {

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

    @Override
    public void start(Stage primaryStage) throws Exception{
        loadAllScenes();
        primaryStage.setTitle("Coach Potato");
        primaryStage.setScene(loginScene);
        primaryStage.show();
        this.primaryStage = primaryStage;
    }

//    public void setMainController(MainController mainController) {
//        this.mainController = mainController;
//    }

    public void uploadDataToUser(UserProfile user, String filePath) throws Exception{
        ArrayList<String> fileContents = parser.getFileContents(filePath);
        ArrayList<ArrayList<String>> formattedFileContents = parser.formatFileContents(fileContents);
        ArrayList<Activity> activities = parser.processFile(formattedFileContents);
        user.addActivities(activities);
    }

    public void launchLoginScene() throws Exception {
        loginController.setUpScene();
        primaryStage.setScene(loginScene);
    }

    public void launchProfileScene(UserProfile user) {
//      profileController.setUpScene(user);
      primaryStage.setScene(profileScene);
    }

//    public void launchGoalsScene() {
//      goalsController.setUpScene();
//      primaryStage.setScene(goalsScene);
//    }

    public void launchUploadDataScene() {
      uploadDataController.setUpScene();
      primaryStage.setScene(uploadDataScene);
    }

    public void launchCreateProfileScene() throws Exception {
        primaryStage.setScene(createProfileScene);
    }

    public void loadAllScenes() throws Exception{
        loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
        Parent root = loginLoader.load();
        loginController = loginLoader.getController();
        loginController.setApp(this);
        loginController.setUpScene();
        loginScene = new Scene(root, 800, 400);

        createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        GridPane gridPaneCP = createProfileLoader.load();
        createProfileController = createProfileLoader.getController();
        createProfileController.setApp(this);
        createProfileController.setUpScene();
        createProfileScene = new Scene(gridPaneCP, 800, 400);

        profileLoader = new FXMLLoader(getClass().getResource("/fxml/profileScreen.fxml"));
        GridPane gridPaneP = profileLoader.load();
        ProfileController profileController = profileLoader.getController();
//        profileController.setApp(this);
//        profileController.setUpScene();
        profileScene = new Scene(gridPaneP, 900, 600);

//        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
//        GridPane gridPaneG = goalsLoader.load();
//        goalsController = goalsLoader.getController();
//        goalsController.setApp(this);
//        goalsController.setUpScene();
//        goalsScene = new Scene(gridPaneG, 900, 600);

        uploadDataLoader = new FXMLLoader(getClass().getResource("/fxml/uploadDataScreen.fxml"));
        Pane paneUD = uploadDataLoader.load();
        uploadDataController = uploadDataLoader.getController();
        uploadDataController.setApp(this);
        uploadDataController.setUpScene();
        uploadDataScene = new Scene(paneUD, 900, 600);
    }

    public void createUser(UserProfile newUser) throws Exception{
        users.add(newUser);
        setCurrentProfile(newUser);
        uploadDataToUser(currentUser, "testdata.csv");
    }

    public void setCurrentProfile(UserProfile userProfile) {
        this.currentUser = userProfile;
    }

    public UserProfile getCurrentProfile() {
        return this.currentUser;
    }

    public ArrayList<UserProfile> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserProfile> users) {
        this.users = users;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
