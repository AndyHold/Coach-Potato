package seng202.team10.Control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seng202.team10.GUI.*;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.Goals;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

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
    private activityViewerController activityViewerController;

    private FXMLLoader entryViewerLoader;
    private Scene entryViewerScene;
    private entryViewerController entryViewerController;

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        primaryStage.setScene(loginScene);
=======
        primaryStage.setScene(goalsScene);
>>>>>>> a590442... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
        primaryStage.setScene(goalsScene);
>>>>>>> f0140c6... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
        primaryStage.setScene(goalsScene);
>>>>>>> b7d8c0b... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
        primaryStage.setScene(goalsScene);
>>>>>>> 9358b9e... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
        primaryStage.setScene(goalsScene);
        //primaryStage.setScene(goalsScene);
>>>>>>> 9a77444... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
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

    public void launchMainScene() throws Exception {
        mainController.setUpScene();
        primaryStage.setScene(mainScene);
    }

    /**
     * Sets the scene on the primary stage to the login scene.
     * @throws Exception Not implemented.
     */
    public void launchLoginScene() throws Exception {
        loginController.setUpScene();
        primaryStage.setScene(loginScene);
    }

<<<<<<< HEAD
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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    }
=======
//    public void launchProfileScene() {
//      profileController.setUpScene();
//      primaryStage.setScene(profileScene);
//    }roo
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> a590442... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
>>>>>>> f0140c6... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
>>>>>>> b7d8c0b... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
>>>>>>> 9358b9e... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.

=======
>>>>>>> 9a77444... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
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
     * Sets the scene on the primary stage to the data analysis scene.
     */
    public void launchDataAnalysisScene() throws Exception {
        dataAnalysisController.setActivity(currentUser.getActivities().get(0));
        dataAnalysisController.setUpScene();
        primaryStage.setScene(dataAnalysisScene);
    }

    /**
     * Sets the scene on the primary stage to the entry viewer scene.
     */
    public void launchEntryViewerScene(Activity activity) throws Exception {
//        entryViewerController.setActivity(activity);
        primaryStage.setScene(entryViewerScene);
    }

    /**
     * Sets the scene on the primary stage to the activity viewer scene.
     */
    public void launchActivityViewerScene() throws Exception {
        primaryStage.setScene(activityViewerScene);
    }

    /**
     * Initalizes every loader, controller and scene for each scene. Also runs the setApp(this) and
     * setUpScene methods for each.
     * @throws Exception Not implemented.
     */
    public void loadAllScenes() throws Exception{
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.

        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        Parent root = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setApp(this);
        goalsController.setUpScene();
        goalsScene = new Scene(root, 900, 600);


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 9a77444... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
//        loginScene = loadNewScene("/fxml/loginScreen.fxml");
//        createProfileScene = loadNewScene("/fxml/createProfileScreen.fxml");
//        profileScene = loadNewScene("/fxml/profileScreen.fxml");
//        goalsScene = loadNewScene("/fxml/goalsScreen.fxml");
//        uploadDataScene = loadNewScene("/fxml/uploadDataScreen.fxml");

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
        Parent root = loginLoader.load();
        loginController = loginLoader.getController();
        loginController.setApp(this);
        loginController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        loginScene = new Scene(root, 800, 400);
=======
=======
>>>>>>> f0140c6... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
>>>>>>> b7d8c0b... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
>>>>>>> 9358b9e... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.


        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        Parent root = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setApp(this);
        goalsController.setUpScene();
        goalsScene = new Scene(root, 900, 600);

=======
>>>>>>> 9a77444... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
//        loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
//        Parent root = loginLoader.load();
//        loginController = loginLoader.getController();
//        loginController.setApp(this);
//        loginController.setUpScene();
//        loginScene = new Scene(root, 800, 400);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> a590442... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
>>>>>>> f0140c6... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
>>>>>>> b7d8c0b... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
>>>>>>> 9358b9e... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
=======
>>>>>>> f47d49d... Implemented the main Screen and merged all screens together, still have to do more on it to get it done properly.
=======
>>>>>>> 9852212... Implemented the main Screen and merged all screens together, still have to do more on it to get it done properly.
=======
>>>>>>> a215ecb... Implemented the main Screen and merged all screens together, still have to do more on it to get it done properly.
        loginScene = new Scene(root, 900, 600);
=======
        loginScene = new Scene(root, 900, 630);
>>>>>>> 483c3e6... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        loginScene = new Scene(root, 900, 630);
>>>>>>> 3b7cb94... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        loginScene = new Scene(root, 900, 630);
>>>>>>> 1990352... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        loginScene = new Scene(root, 900, 630);
>>>>>>> ef5ea11... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.

        mainLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
        VBox mainVBox = mainLoader.load();
        mainController = mainLoader.getController();
        mainController.setApp(this);
        mainController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        mainScene = new Scene(mainVBox, 900, 600);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 668e9dc... Implemented the main Screen and merged all screens together, still have to do more on it to get it done properly.
=======
>>>>>>> f47d49d... Implemented the main Screen and merged all screens together, still have to do more on it to get it done properly.
=======
>>>>>>> 9852212... Implemented the main Screen and merged all screens together, still have to do more on it to get it done properly.
=======
>>>>>>> a215ecb... Implemented the main Screen and merged all screens together, still have to do more on it to get it done properly.
=======
>>>>>>> 9a77444... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
        mainScene = new Scene(mainVBox, 900, 630);
>>>>>>> 483c3e6... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        mainScene = new Scene(mainVBox, 900, 630);
>>>>>>> 3b7cb94... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        mainScene = new Scene(mainVBox, 900, 630);
>>>>>>> 1990352... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        mainScene = new Scene(mainVBox, 900, 630);
>>>>>>> ef5ea11... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.

        createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        Pane paneCP = createProfileLoader.load();
        createProfileController = createProfileLoader.getController();
        createProfileController.setApp(this);
        createProfileController.setUpScene();
        createProfileScene = new Scene(paneCP, 900, 630);

        profileLoader = new FXMLLoader(getClass().getResource("/fxml/profileScreen.fxml"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        Pane PaneP = profileLoader.load();
        profileController = profileLoader.getController();
        profileController.setApp(this);
        profileController.setUpScene();
        //profileController.setUserDetails();
        profileScene = new Scene(PaneP, 900, 630);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
//        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
//        Pane paneG = goalsLoader.load();
//        goalsController = goalsLoader.getController();
//        goalsController.setApp(this);
//        goalsController.setUpScene();
//        goalsScene = new Scene(paneG, 900, 600);
=======

>>>>>>> a590442... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======

>>>>>>> f0140c6... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======

>>>>>>> b7d8c0b... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======

>>>>>>> 9358b9e... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
        GridPane gridPaneP = profileLoader.load();
        ProfileController profileController = profileLoader.getController();
//        profileController.setApp(this);
//        profileController.setUpScene();
        profileScene = new Scene(gridPaneP, 900, 600);


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 9a77444... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.

        uploadDataLoader = new FXMLLoader(getClass().getResource("/fxml/uploadDataScreen.fxml"));
        Pane paneUD = uploadDataLoader.load();
        uploadDataController = uploadDataLoader.getController();
        uploadDataController.setApp(this);
        uploadDataController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        uploadDataScene = new Scene(paneUD, 900, 600);

        dataAnalysisLoader = new FXMLLoader(getClass().getResource("/fxml/dataAnalysisScreen.fxml"));
        Pane paneDA = dataAnalysisLoader.load();
        dataAnalysisController = dataAnalysisLoader.getController();
        dataAnalysisController.setApp(this);
//        dataAnalysisController.setUpScene();
        dataAnalysisScene = new Scene(paneDA, 900, 600);

        activityViewerLoader = new FXMLLoader(getClass().getResource("/fxml/activityViewerScreen.fxml"));
        Pane paneAV = activityViewerLoader.load();
        activityViewerController = activityViewerLoader.getController();
        activityViewerController.setApp(this);
//        activityViewerController.setUpScene();
        activityViewerScene = new Scene(paneAV, 900, 600);

        entryViewerLoader = new FXMLLoader(getClass().getResource("/fxml/entryViewerScreen.fxml"));
        Pane paneEV = entryViewerLoader.load();
        entryViewerController = entryViewerLoader.getController();
        entryViewerController.setApp(this);
//        entryViewerController.setUpScene();
        entryViewerScene = new Scene(paneEV, 900, 600);
=======
        uploadDataScene = new Scene(paneUD, 900, 630);
>>>>>>> 483c3e6... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        uploadDataScene = new Scene(paneUD, 900, 630);
>>>>>>> 3b7cb94... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        uploadDataScene = new Scene(paneUD, 900, 630);
>>>>>>> 1990352... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        uploadDataScene = new Scene(paneUD, 900, 630);
>>>>>>> ef5ea11... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
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
