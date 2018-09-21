package seng202.team10.Control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import seng202.team10.Model.ActivitiesData.Activity;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import seng202.team10.Model.ActivitiesData.DateTime;
=======
=======
=======
import seng202.team10.Model.ActivitiesData.DateTime;
>>>>>>> 81b0c6a... Re-added launch mapscene
>>>>>>> fa48cc98... Re-added launch mapscene
import seng202.team10.Model.ActivitiesData.Route;
>>>>>>> 0fbb14ad... Added functionality for the map controller
=======
import seng202.team10.Model.ActivitiesData.Route;
<<<<<<< HEAD
>>>>>>> dc1460de... Added functionality for the map controller
=======
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Route;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 874b31ca... Re-added launch mapscene
=======
=======
import seng202.team10.Model.Exceptions.InvalidUserException;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
=======
=======
import seng202.team10.Model.Exceptions.UniqueNameException;
>>>>>>> dd450156... Fixed up Unique name error and got it completely working so that it catches all errors on Create profile and edit profile.
import seng202.team10.Model.Exceptions.UserNameException;
>>>>>>> 4e37ab85... Finished Implementing new Login Screen Layout.
=======
=======
import seng202.team10.Model.Exceptions.UniqueNameException;
>>>>>>> 68814ead... Fixed up Unique name error and got it completely working so that it catches all errors on Create profile and edit profile.
import seng202.team10.Model.Exceptions.UserNameException;
>>>>>>> 6e249b39... Finished Implementing new Login Screen Layout.
import seng202.team10.Model.FileOperations.FileReader;
>>>>>>> 88343792... loading existing users from file when logging in, deleted some old test users
=======
=======
import seng202.team10.Model.Exceptions.InvalidUserException;
>>>>>>> 0e69f208... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
import seng202.team10.Model.FileOperations.FileReader;
>>>>>>> 61ade368... loading existing users from file when logging in, deleted some old test users
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.UserProfile;
import seng202.team10.Visual.*;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Optional;
=======
import java.util.concurrent.TimeUnit;
<<<<<<< HEAD
>>>>>>> 327730ca... Added a small delay for the map loading the first time
=======
>>>>>>> cf34074... Added a small delay for the map loading the first time
>>>>>>> 3110e544... Added a small delay for the map loading the first time

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
<<<<<<< HEAD
<<<<<<< HEAD
        // Added a test user.
        users.add(new UserProfile("Potato", 75, 180, new DateTime(2000,1,1,1,1,1), "Male"));
        users.get(0).setMaxHeartRate(210);
        loadAllUsers();
        loadAllScenes();
        primaryStage.setTitle("Coach Potato");
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
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
>>>>>>> 4fada315... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
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
>>>>>>> 09152fc2... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 197d533e... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
        primaryStage.setScene(loginScene);
=======
        primaryStage.setScene(goalsScene);
>>>>>>> 9358b9ec... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
        primaryStage.setScene(goalsScene);
=======
        primaryStage.setScene(uploadDataScene);
>>>>>>> 73cd1563... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
<<<<<<< HEAD
        primaryStage.setScene(mainScene);
>>>>>>> 6d5417be... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
        primaryStage.setScene(uploadDataScene);
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
        primaryStage.setScene(mainScene);
>>>>>>> f3f8025... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
<<<<<<< HEAD
>>>>>>> 4fada315... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
=======
        primaryStage.setScene(mainScene);
>>>>>>> 0c713de... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
        primaryStage.setScene(mainScene);
>>>>>>> 896c223... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
        primaryStage.setScene(mainScene);
>>>>>>> 6d5417b... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
<<<<<<< HEAD
>>>>>>> 197d533e... Modified tests to fix pipeline, (Main change was to parser so complete url's could be accepted not just files from one directory)
=======
=======
=======
=======
>>>>>>> 6d929aa... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
>>>>>>> 4022cc1... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
>>>>>>> 1b1f8a0... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
>>>>>>> 09152fc2... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
        if (users.isEmpty()) {
            primaryStage.setScene(createProfileScene);
        } else {
            primaryStage.setScene(loginScene);
        }
//        primaryStage.setScene(mainScene);
<<<<<<< HEAD
>>>>>>> 1b1f8a0b... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
=======
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
>>>>>>> 09152fc2... Now starts on the createProfile scene if no users are found, otherwise starts on login screen.
        //primaryStage.setScene(goalsScene);
>>>>>>> 879a82d8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
        primaryStage.show();
        this.primaryStage = primaryStage;

=======
=======
        if(!dataReader.checkFileExists("./profiles")){
            dataWriter.createProfileFolder();
        }
<<<<<<< HEAD
>>>>>>> d0273878... Checking if profiles folder exists and creating it if it doesn't upon startup
=======
>>>>>>> 316efe3... Checking if profiles folder exists and creating it if it doesn't upon startup
>>>>>>> c8eb71f2... Checking if profiles folder exists and creating it if it doesn't upon startup
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
<<<<<<< HEAD
>>>>>>> 4e37ab85... Finished Implementing new Login Screen Layout.
=======
>>>>>>> 5997e6c... Finished Implementing new Login Screen Layout.
>>>>>>> 6e249b39... Finished Implementing new Login Screen Layout.
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
        dataWriter.saveProfile(currentUser);
        primaryStage.setScene(profileScene);

<<<<<<< HEAD
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> dc1460de... Added functionality for the map controller
=======
//    public void launchProfileScene() {
//      profileController.setUpScene();
//      primaryStage.setScene(profileScene);
//    }roo
>>>>>>> 9358b9ec... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.

=======
>>>>>>> 879a82d8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======

>>>>>>> f05f9ca3... Created constructors for userProfile and Added a test user.
=======

<<<<<<< HEAD
=======
>>>>>>> 5e839bc... Created constructors for userProfile and Added a test user.
=======

<<<<<<< HEAD
>>>>>>> dc1460de... Added functionality for the map controller
=======

    public void checkUniqueName(String userName) throws UniqueNameException
    {
        for (UserProfile userProfile: this.getUsers()) {
            if (userProfile.getName().equals(userName)) {
                throw new UniqueNameException();
            }
        }
    }


>>>>>>> 6e249b39... Finished Implementing new Login Screen Layout.
    public void launchMapScene(Activity activity) {
        mapController.setActivity(activity);
        mapController.setUpScene();
        Route newRoute = mapController.makeRoute(activity);
        mapController.displayRoute(newRoute);
        primaryStage.setScene(mapScene);
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 0fbb14ad... Added functionality for the map controller
=======
>>>>>>> 431c3ad... Added functionality for the map controller
>>>>>>> dc1460de... Added functionality for the map controller
=======
>>>>>>> 431c3ad... Added functionality for the map controller
>>>>>>> fa48cc98... Re-added launch mapscene
=======
=======

    public void checkUniqueName(String userName) throws UniqueNameException
    {
        for (UserProfile userProfile: this.getUsers()) {
            if (userProfile.getName().equals(userName)) {
                throw new UniqueNameException();
            }
        }
    }


>>>>>>> 4e37ab85... Finished Implementing new Login Screen Layout.
    public void launchMapScene(Activity activity) {
        mapController.setActivity(activity);
        mapController.setUpScene();
        Route newRoute = mapController.makeRoute(activity);
        mapController.displayRoute(newRoute);
        primaryStage.setScene(mapScene);
    }

<<<<<<< HEAD
>>>>>>> 874b31ca... Re-added launch mapscene
=======
>>>>>>> 81b0c6a... Re-added launch mapscene
>>>>>>> fa48cc98... Re-added launch mapscene
    public void launchGoalsScene() {
        //goalsController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
        goalsController.updateGoals();
=======
        dataWriter.saveProfile(currentUser);
<<<<<<< HEAD
>>>>>>> 541edbd0... Saving and loading of profiles to/from folder
=======
>>>>>>> 0c1d4e0... Saving and loading of profiles to/from folder
<<<<<<< HEAD
>>>>>>> 5f1c6fb1... Saving and loading of profiles to/from folder
=======
        dataWriter.saveProfile(currentUser);
        goalsController.addGoalsToTable();
>>>>>>> 3e145f3c... Now call addGoalsToTable when profile is set. Added text fields and areas for achieved and failed goals. Implemented addGoalsToTable, updateAchievedListView, updateFailedListView, and printPastGoalsReview functions in GoalController. In review goal methods, now compares current time to target date to see if you have failed your goal. Added achievedGoalNames, failedGoalNames and futureGoalNames ArrayLists to Goals.
=======
=======
        dataWriter.saveProfile(currentUser);
        goalsController.addGoalsToTable();
>>>>>>> 429f29b... Now call addGoalsToTable when profile is set. Added text fields and areas for achieved and failed goals. Implemented addGoalsToTable, updateAchievedListView, updateFailedListView, and printPastGoalsReview functions in GoalController. In review goal methods, now compares current time to target date to see if you have failed your goal. Added achievedGoalNames, failedGoalNames and futureGoalNames ArrayLists to Goals.
>>>>>>> 03dfdb44... Now call addGoalsToTable when profile is set. Added text fields and areas for achieved and failed goals. Implemented addGoalsToTable, updateAchievedListView, updateFailedListView, and printPastGoalsReview functions in GoalController. In review goal methods, now compares current time to target date to see if you have failed your goal. Added achievedGoalNames, failedGoalNames and futureGoalNames ArrayLists to Goals.
        primaryStage.setScene(goalsScene);

    }
=======

//    public void launchGoalsScene() {
//      goalsController.setUpScene();
//      primaryStage.setScene(goalsScene);
//    }
>>>>>>> 73cd1563... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.

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
<<<<<<< HEAD
<<<<<<< HEAD
=======

//        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
//        Parent root = goalsLoader.load();
//        goalsController = goalsLoader.getController();
//        goalsController.setApp(this);
//        goalsController.setUpScene();
//        goalsScene = new Scene(root, 900, 600);


>>>>>>> 879a82d8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
//        loginScene = loadNewScene("/fxml/loginScreen.fxml");
//        createProfileScene = loadNewScene("/fxml/createProfileScreen.fxml");
//        profileScene = loadNewScene("/fxml/profileScreen.fxml");
//        goalsScene = loadNewScene("/fxml/goalsScreen.fxml");
//        uploadDataScene = loadNewScene("/fxml/uploadDataScreen.fxml");

<<<<<<< HEAD

        loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
        Parent root = loginLoader.load();
        loginController = loginLoader.getController();
        loginController.setApp(this);
        loginController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        loginScene = new Scene(root, 800, 400);
=======


        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        Parent root = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setApp(this);
        goalsController.setUpScene();
        goalsScene = new Scene(root, 900, 600);

=======
>>>>>>> 879a82d8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
//        loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
//        Parent root = loginLoader.load();
//        loginController = loginLoader.getController();
//        loginController.setApp(this);
//        loginController.setUpScene();
//        loginScene = new Scene(root, 800, 400);
<<<<<<< HEAD
>>>>>>> 9358b9ec... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
        loginScene = new Scene(root, 900, 600);
=======
        loginScene = new Scene(root, 900, 630);
>>>>>>> ef5ea113... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        loginScene = new Scene(root, 1280, 720);
>>>>>>> 663db25d... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.

<<<<<<< HEAD
        mainLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
        VBox mainVBox = mainLoader.load();
        mainController = mainLoader.getController();
        mainController.setApp(this);
        mainController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
        mainScene = new Scene(mainVBox, 900, 600);
>>>>>>> a215ecbf... Implemented the main Screen and merged all screens together, still have to do more on it to get it done properly.
=======
>>>>>>> 879a82d8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
        mainScene = new Scene(mainVBox, 900, 630);
>>>>>>> ef5ea113... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
        mainScene = new Scene(mainVBox, 1280, 720);
>>>>>>> 663db25d... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
//        mainLoader = new FXMLLoader(getClass().getResource("/fxml/mainScreen.fxml"));
//        VBox mainVBox = mainLoader.load();
//        mainController = mainLoader.getController();
//        mainController.setApp(this);
//        mainController.setUpScene();
//        mainScene = new Scene(mainVBox, 1280, 720);
>>>>>>> 240eba13... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.

        createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        Pane paneCP = createProfileLoader.load();
        createProfileController = createProfileLoader.getController();
        createProfileController.setApp(this);
        createProfileController.setUpScene();
        createProfileScene = new Scene(paneCP, 1280, 720);

        profileLoader = new FXMLLoader(getClass().getResource("/fxml/profileScreen.fxml"));
<<<<<<< HEAD
        Pane PaneP = profileLoader.load();
        profileController = profileLoader.getController();
        profileController.setApp(this);
        profileController.setUpScene();
        profileScene = new Scene(PaneP, 1280, 720);

<<<<<<< HEAD
<<<<<<< HEAD
//        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
//        Pane paneG = goalsLoader.load();
//        goalsController = goalsLoader.getController();
//        goalsController.setApp(this);
//        goalsController.setUpScene();
//        goalsScene = new Scene(paneG, 900, 600);
=======

>>>>>>> 9358b9ec... Create new Goals instance in GUIController. Added various buttons, entry boxes and labels to the create goal tab. Implemented an action handler for the create button that creates a goal that is store either as a current goal or future goal. Added arraylist for createdGoals into Goals class and getter method. Edited create goal method to establish whether a goal is current or for the future.
=======
        GridPane gridPaneP = profileLoader.load();
        ProfileController profileController = profileLoader.getController();
//        profileController.setApp(this);
//        profileController.setUpScene();
        profileScene = new Scene(gridPaneP, 900, 600);


>>>>>>> 879a82d8... Added remove goal button, review progress button and goal progress text field. Edited the check goal and remove goal methods in Goals class. Created reviewGoal and removeGoal action handlers in GoalController. Changed the return types of the reviewing goals methods. Introduced a getGoalObject method.
=======
        goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        Pane paneG = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setApp(this);
        goalsController.setUpScene();
        goalsScene = new Scene(paneG, 1280, 720);
>>>>>>> 240eba13... 1)Linked all the screens together so that we can go to any screen from any screen. 2)deleted unused files. 3)Fixed calendar. 4) Gui improvement on all screens.

        uploadDataLoader = new FXMLLoader(getClass().getResource("/fxml/uploadDataScreen.fxml"));
        Pane paneUD = uploadDataLoader.load();
        uploadDataController = uploadDataLoader.getController();
        uploadDataController.setApp(this);
        uploadDataController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
        uploadDataScene = new Scene(paneUD, 900, 600);
=======
        uploadDataScene = new Scene(paneUD, 1280, 720);
>>>>>>> 663db25d... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.

        dataAnalysisLoader = new FXMLLoader(getClass().getResource("/fxml/dataAnalysisScreen.fxml"));
        Pane paneDA = dataAnalysisLoader.load();
        dataAnalysisController = dataAnalysisLoader.getController();
        dataAnalysisController.setApp(this);
//        dataAnalysisController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
        dataAnalysisScene = new Scene(paneDA, 900, 600);
=======
        dataAnalysisScene = new Scene(paneDA, 1280, 720);
>>>>>>> d7480a7a... Added map Controller
=======
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
>>>>>>> e4a580e1... Added map Controller

        activityViewerLoader = new FXMLLoader(getClass().getResource("/fxml/activityViewerScreen.fxml"));
        Pane paneAV = activityViewerLoader.load();
        activityViewerController = activityViewerLoader.getController();
        activityViewerController.setApp(this);
<<<<<<< HEAD
=======
<<<<<<< HEAD
//        activityViewerController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
<<<<<<< HEAD
//        activityViewerController.setUpScene();
<<<<<<< HEAD
        activityViewerScene = new Scene(paneAV, 900, 600);
=======
<<<<<<< HEAD
=======
        activityViewerScene = new Scene(paneAV, 1280, 720);
>>>>>>> 9ec6680... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
=======
//        ActivityViewerController.setUpScene();
>>>>>>> 561798b... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
        activityViewerScene = new Scene(paneAV, 1280, 720);
>>>>>>> 410d95e... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
=======
//        ActivityViewerController.setUpScene();
>>>>>>> 0e69f208... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
        activityViewerScene = new Scene(paneAV, 1280, 720);
>>>>>>> 663db25d... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.

        entryViewerLoader = new FXMLLoader(getClass().getResource("/fxml/entryViewerScreen.fxml"));
        Pane paneEV = entryViewerLoader.load();
        entryViewerController = entryViewerLoader.getController();
        entryViewerController.setApp(this);
<<<<<<< HEAD
=======
<<<<<<< HEAD
//        entryViewerController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
<<<<<<< HEAD
//        entryViewerController.setUpScene();
<<<<<<< HEAD
<<<<<<< HEAD
        entryViewerScene = new Scene(paneEV, 900, 600);
=======
        uploadDataScene = new Scene(paneUD, 900, 630);
>>>>>>> ef5ea113... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
<<<<<<< HEAD
=======
        uploadDataScene = new Scene(paneUD, 900, 630);
>>>>>>> ef5ea11... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.
=======
>>>>>>> e4a580e1... Added map Controller
        entryViewerScene = new Scene(paneEV, 900, 630);
=======
=======
//        EntryViewerController.setUpScene();
>>>>>>> 0e69f208... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
        entryViewerScene = new Scene(paneEV, 1280, 720);
<<<<<<< HEAD
>>>>>>> 663db25d... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
>>>>>>> 410d95e... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
        entryViewerScene = new Scene(paneEV, 1280, 720);
>>>>>>> 30ac4eb... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
=======
=======
//        EntryViewerController.setUpScene();
>>>>>>> 561798b... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.
        entryViewerScene = new Scene(paneEV, 1280, 720);
>>>>>>> 663db25... Changes to GUI controller to link all the screens together, changed the size of the screens and still need to link goals and view activities screen.
>>>>>>> 2d5633a2... Refactored createPopUp method in uploadData to be in GUIController so it can be used by all other screens.

        mapLoader = new FXMLLoader(getClass().getResource("/fxml/mapScreen.fxml"));
        Pane paneMap = mapLoader.load();
        mapController = mapLoader.getController();
        mapController.setApp(this);
        mapController.setUpScene();
        mapScene = new Scene(paneMap, 1280, 720);
<<<<<<< HEAD
>>>>>>> d7480a7a... Added map Controller
=======
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
>>>>>>> e4a580e1... Added map Controller
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
    public String createPopUp(Alert.AlertType type, String title, String message)
    {
        Alert errorPopUp = new Alert(type);
        errorPopUp.setTitle(title);
        errorPopUp.setContentText(message);
        errorPopUp.setHeaderText(null);
        Optional<ButtonType> buttonType = errorPopUp.showAndWait();
        return buttonType.get().getText();
    }
}
