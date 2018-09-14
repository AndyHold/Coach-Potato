package seng202.team10.Control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import seng202.team10.GUI.*;
import seng202.team10.Model.ActivitiesData.Activity;
<<<<<<< HEAD
=======
import seng202.team10.Model.ActivitiesData.DateTime;
>>>>>>> 81b0c6a... Re-added launch mapscene
import seng202.team10.Model.ActivitiesData.Route;
import seng202.team10.Model.FileOperations.FileReader;
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
    public void start(Stage primaryStage) throws Exception{
        // Added a test user.
        users.add(new UserProfile("Potato", 75, 180, new DateTime(2000,1,1,1,1,1), "Male"));
        loadAllUsers();
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
        primaryStage.setScene(uploadDataScene);
>>>>>>> b21c354... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
        primaryStage.setScene(uploadDataScene);
>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
        primaryStage.setScene(uploadDataScene);
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
        primaryStage.setScene(uploadDataScene);
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
        primaryStage.setScene(mainScene);
>>>>>>> f3f8025... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
        primaryStage.setScene(mainScene);
>>>>>>> 0c713de... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
        primaryStage.setScene(mainScene);
>>>>>>> 896c223... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
        primaryStage.setScene(mainScene);
>>>>>>> 6d5417b... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
=======
>>>>>>> 6d929aa... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
>>>>>>> 4022cc1... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
>>>>>>> 1b1f8a0... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
        if (users.isEmpty()) {
            primaryStage.setScene(createProfileScene);
        } else {
            primaryStage.setScene(loginScene);
        }
//        primaryStage.setScene(mainScene);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 76138f6... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
>>>>>>> 6d929aa... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
>>>>>>> 4022cc1... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
>>>>>>> 1b1f8a0... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
        //primaryStage.setScene(goalsScene);
>>>>>>> 9a77444... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
        primaryStage.show();
        this.primaryStage = primaryStage;

    }

    /**
     * loads all the users in the profiles folder and adds them to the users arraylist
     */
    private void loadAllUsers() {
        ArrayList<String> userNames = dataReader.getExistingUsers();
        for(String username: userNames){
            System.out.println(username);
            users.add(dataReader.loadExistingProfile(username));
        }
    }


    public Parser getParser()
    {
        return this.parser;
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

<<<<<<< HEAD
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
        primaryStage.setScene(profileScene);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======

>>>>>>> 5e839bc... Created constructors for userProfile and Added a test user.
=======

    public void launchMapScene(Activity activity) {
        mapController.setActivity(activity);
        mapController.setUpScene();
        Route newRoute = mapController.makeRoute(activity);
        mapController.displayRoute(newRoute);
        primaryStage.setScene(mapScene);
    }

<<<<<<< HEAD
>>>>>>> 431c3ad... Added functionality for the map controller
=======
    public void launchMapScene(Activity activity) {
        mapController.setActivity(activity);
        mapController.setUpScene();
        Route newRoute = mapController.makeRoute(activity);
        mapController.displayRoute(newRoute);
        primaryStage.setScene(mapScene);
    }

>>>>>>> 81b0c6a... Re-added launch mapscene
    public void launchGoalsScene() {
        //goalsController.setUpScene();
        goalsController.updateGoals();
        primaryStage.setScene(goalsScene);

    }
=======
=======
>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.

//    public void launchGoalsScene() {
//      goalsController.setUpScene();
//      primaryStage.setScene(goalsScene);
//    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> b21c354... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.

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
//        dataAnalysisController.setActivity(currentUser.getActivities().get(0));
        dataAnalysisController.setUpScene();
        primaryStage.setScene(dataAnalysisScene);
    }

    /**
     * Sets the scene on the primary stage to the entry viewer scene.
     */
    public void launchEntryViewerScene(Activity activity) throws Exception {
        entryViewerController.setUpScene(activity);
        primaryStage.setScene(entryViewerScene);
    }

    /**
     * Sets the scene on the primary stage to the activity viewer scene.
     */
    public void launchActivityViewerScene() throws Exception {
        activityViewerController.setUpScene();
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 2f5af1f... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 438a3e8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 879a82d... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.

//        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
//        Parent root = goalsLoader.load();
//        goalsController = goalsLoader.getController();
//        goalsController.setApp(this);
//        goalsController.setUpScene();
//        goalsScene = new Scene(root, 900, 600);


<<<<<<< HEAD
<<<<<<< HEAD
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
=======
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
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


//        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
//        Parent root = goalsLoader.load();
//        goalsController = goalsLoader.getController();
//        goalsController.setApp(this);
//        goalsController.setUpScene();
//        goalsScene = new Scene(root, 900, 600);

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
=======
        loginScene = new Scene(root, 1280, 720);
>>>>>>> 9ec6680... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        loginScene = new Scene(root, 1280, 720);
>>>>>>> 410d95e... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        loginScene = new Scene(root, 1280, 720);
>>>>>>> 30ac4eb... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        loginScene = new Scene(root, 1280, 720);
>>>>>>> 663db25... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        mainLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
        VBox mainVBox = mainLoader.load();
        mainController = mainLoader.getController();
        mainController.setApp(this);
        mainController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
        mainScene = new Scene(mainVBox, 1280, 720);
>>>>>>> 9ec6680... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        mainScene = new Scene(mainVBox, 1280, 720);
>>>>>>> 410d95e... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        mainScene = new Scene(mainVBox, 1280, 720);
>>>>>>> 30ac4eb... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        mainScene = new Scene(mainVBox, 1280, 720);
>>>>>>> 663db25... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
=======
>>>>>>> 1862dba... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 6e92841... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 240eba1... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
//        mainLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
//        VBox mainVBox = mainLoader.load();
//        mainController = mainLoader.getController();
//        mainController.setApp(this);
//        mainController.setUpScene();
//        mainScene = new Scene(mainVBox, 1280, 720);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8e53f9b... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 1862dba... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 6e92841... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 240eba1... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.

        createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        Pane paneCP = createProfileLoader.load();
        createProfileController = createProfileLoader.getController();
        createProfileController.setApp(this);
        createProfileController.setUpScene();
        createProfileScene = new Scene(paneCP, 1280, 720);

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
        profileScene = new Scene(PaneP, 1280, 720);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> 1862dba... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 6e92841... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 240eba1... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        Pane paneG = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setApp(this);
        goalsController.setUpScene();
        goalsScene = new Scene(paneG, 1280, 720);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8e53f9b... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 1862dba... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 6e92841... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.
=======
>>>>>>> 240eba1... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.

        uploadDataLoader = new FXMLLoader(getClass().getResource("/fxml/uploadDataScreen.fxml"));
        Pane paneUD = uploadDataLoader.load();
        uploadDataController = uploadDataLoader.getController();
        uploadDataController.setApp(this);
        uploadDataController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        uploadDataScene = new Scene(paneUD, 900, 600);
=======
        uploadDataScene = new Scene(paneUD, 1280, 720);
>>>>>>> 9ec6680... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        uploadDataScene = new Scene(paneUD, 1280, 720);
>>>>>>> 410d95e... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        uploadDataScene = new Scene(paneUD, 1280, 720);
>>>>>>> 30ac4eb... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        uploadDataScene = new Scene(paneUD, 1280, 720);
>>>>>>> 663db25... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.

        dataAnalysisLoader = new FXMLLoader(getClass().getResource("/fxml/dataAnalysisScreen.fxml"));
        Pane paneDA = dataAnalysisLoader.load();
        dataAnalysisController = dataAnalysisLoader.getController();
        dataAnalysisController.setApp(this);
//        dataAnalysisController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        dataAnalysisScene = new Scene(paneDA, 900, 600);
=======
        dataAnalysisScene = new Scene(paneDA, 1280, 720);
>>>>>>> 8c1f178... Added map Controller
=======
        dataAnalysisScene = new Scene(paneDA, 1280, 720);
>>>>>>> 3940c8a... Added map Controller
=======
        dataAnalysisScene = new Scene(paneDA, 1280, 720);
>>>>>>> 661d1cc... Added map Controller
=======
        dataAnalysisScene = new Scene(paneDA, 1280, 720);
>>>>>>> d7480a7... Added map Controller

        activityViewerLoader = new FXMLLoader(getClass().getResource("/fxml/activityViewerScreen.fxml"));
        Pane paneAV = activityViewerLoader.load();
        activityViewerController = activityViewerLoader.getController();
        activityViewerController.setApp(this);
//        activityViewerController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        activityViewerScene = new Scene(paneAV, 900, 600);
=======
        activityViewerScene = new Scene(paneAV, 1280, 720);
>>>>>>> 9ec6680... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        activityViewerScene = new Scene(paneAV, 1280, 720);
>>>>>>> 410d95e... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        activityViewerScene = new Scene(paneAV, 1280, 720);
>>>>>>> 30ac4eb... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        activityViewerScene = new Scene(paneAV, 1280, 720);
>>>>>>> 663db25... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.

        entryViewerLoader = new FXMLLoader(getClass().getResource("/fxml/entryViewerScreen.fxml"));
        Pane paneEV = entryViewerLoader.load();
        entryViewerController = entryViewerLoader.getController();
        entryViewerController.setApp(this);
//        entryViewerController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
        entryViewerScene = new Scene(paneEV, 900, 630);
=======
        entryViewerScene = new Scene(paneEV, 1280, 720);
>>>>>>> 9ec6680... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        entryViewerScene = new Scene(paneEV, 1280, 720);
>>>>>>> 410d95e... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        entryViewerScene = new Scene(paneEV, 1280, 720);
>>>>>>> 30ac4eb... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        entryViewerScene = new Scene(paneEV, 1280, 720);
>>>>>>> 663db25... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.

        mapLoader = new FXMLLoader(getClass().getResource("/fxml/mapScreen.fxml"));
        Pane paneMap = mapLoader.load();
        mapController = mapLoader.getController();
        mapController.setApp(this);
        mapController.setUpScene();
        mapScene = new Scene(paneMap, 1280, 720);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8c1f178... Added map Controller
=======
>>>>>>> 3940c8a... Added map Controller
=======
>>>>>>> 661d1cc... Added map Controller
=======
>>>>>>> d7480a7... Added map Controller
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




    public static void main(String[] args) {
        launch(args);
    }
}
