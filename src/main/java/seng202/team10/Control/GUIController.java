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
=======
import seng202.team10.Model.Exceptions.ExistingElementException;
import seng202.team10.Model.Exceptions.InvalidUserException;
import seng202.team10.Model.Exceptions.NoDataFoundException;
>>>>>>> 8ec9ce7d... Wrote some tests for GUIController and added some dependencies for when we test the JavaFX controllers (Not this deliverable)
import seng202.team10.Model.Exceptions.UniqueNameException;
<<<<<<< HEAD
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
=======
>>>>>>> 7f979e0c... Wrote some more tests for Activity, Entry, Position classes and JavaDocs for those classes.
import seng202.team10.Model.FileOperations.FileReader;
>>>>>>> 61ade368... loading existing users from file when logging in, deleted some old test users
import seng202.team10.Model.FileOperations.FileWriter;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.UserProfile;
import seng202.team10.Visual.*;

import java.io.FileNotFoundException;
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
public class GUIController extends Application {


    private Scene titleBarScene;
    private TitleBarController titleBarController;

    private Stage primaryStage;
    private ArrayList<UserProfile> users = new ArrayList<>();

    private Parser parser = new Parser();
    private FileWriter dataWriter = new FileWriter();
    private FileReader dataReader = new FileReader();
    private ArrayList<String> userNames;
    private double[] offset_XY;

    private Parent root;

    //private Goals goals = new Goals(currentUser);

    /**
     * A lot of the initial setup when the program is launched. loads profiles and scenes to the stage
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
<<<<<<< HEAD
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
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> d0273878... Checking if profiles folder exists and creating it if it doesn't upon startup
=======
>>>>>>> 316efe3... Checking if profiles folder exists and creating it if it doesn't upon startup
>>>>>>> c8eb71f2... Checking if profiles folder exists and creating it if it doesn't upon startup
        try {
//            Added a test user.
//            users.add(new UserProfile("Potato", 75, 180, new DateTime(2000, 1, 1, 1, 1, 1), "Male"));
//            users.get(0).setMaxHeartRate(210);
        } catch (IllegalArgumentException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
        }
=======
//        try {
////            Added a test user.
////            users.add(new UserProfile("Potato", 75, 180, new DateTime(2000, 1, 1, 1, 1, 1), "Male"));
////            users.get(0).setMaxHeartRate(210);
//        } catch (IllegalArgumentException exception) {
//            createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
//        }
>>>>>>> b2c438da... Played around with the GUI a bit further and created a new branch for it in case I break everything.
=======
        if(!dataReader.checkFileExists("./profiles")) {
            dataWriter.createProfileFolder();
        }
<<<<<<< HEAD
>>>>>>> e7a69fc0... Worked extensively on the GUI. now have a working custom title bar, a new colour theme which has been implemented on login, profile, and createprofile screens.
=======
//        try {
//            Added a test user.
//            users.add(new UserProfile("Potato", 75, 180, new DateTime(2000, 1, 1, 1, 1, 1), "Male"));
//            users.get(0).setMaxHeartRate(210);
//        } catch (IllegalArgumentException exception) {
//            createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
//        }
>>>>>>> b3cd6623... last minute changes
            loadAllUsers();
            loadTitleBar();
            allowDrag(root, primaryStage);
            primaryStage.setTitle("Coach Potato");
            primaryStage.setResizable(false);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
//            primaryStage.setOpacity(0.9);
            titleBarScene.setFill(Color.TRANSPARENT);
            primaryStage.setScene(titleBarScene);
            primaryStage.show();
            this.primaryStage = primaryStage;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 4e37ab85... Finished Implementing new Login Screen Layout.
=======
>>>>>>> 5997e6c... Finished Implementing new Login Screen Layout.
>>>>>>> 6e249b39... Finished Implementing new Login Screen Layout.
=======
=======
        loadAllUsers();
        loadTitleBar();
        allowDrag(root, primaryStage);
        primaryStage.setTitle("Coach Potato");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.setOpacity(0.9);
        titleBarScene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(titleBarScene);
        primaryStage.show();
        this.primaryStage = primaryStage;
>>>>>>> 86964199... Changed a few JUnit tests to fix pipeline issues caused by recent merge, still failing on the future goals tests as adding 3 days at the end of the month throws an exception.
    }

    /**
     * loads all the users in the profiles folder and adds them to the users arraylist
     */
    private void loadAllUsers()
    {
        userNames = dataReader.getExistingUsers();
        for(String username: userNames){
            users.add(dataReader.loadExistingProfile(username));
        }
>>>>>>> f7b90380... Small tweaks to fix pipeline issues caused by recent merge.
    }


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


<<<<<<< HEAD
<<<<<<< HEAD
=======

//    public void titleClicked()
//    {
//        dragDelta.x = primaryStage.getX();
//        dragDelta.y = primaryStage.getY();
//    }
//
//
//
//    public void titleReleased()
//    {
//        primaryStage.setX()
//    }


=======
>>>>>>> ab4fbb4f... Did some futher work on the GUI design, commented out tests in GUIControllerTest as they are no longer applicable after the refactor
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
>>>>>>> b2c438da... Played around with the GUI a bit further and created a new branch for it in case I break everything.
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
     */
    public void uploadDataToUser(UserProfile user, String filePath) throws FileNotFoundException, NoDataFoundException, ExistingElementException
    {
        ArrayList<String> fileContents = parser.getFileContents(filePath);
        ArrayList<ArrayList<String>> formattedFileContents = parser.formatFileContents(fileContents);
        ArrayList<Activity> activities = parser.processFile(formattedFileContents);
        user.addActivities(activities);
    }

<<<<<<< HEAD

    /**
     * Sets the scene on the primary stage to the login scene.
     */
    public void launchLoginScene()
    {
        currentUser = null;
        loginController.setUpScene();
        primaryStage.setScene(loginScene);
    }

<<<<<<< HEAD
<<<<<<< HEAD
    /**dNewScene("/fxml/loginScreen.fxml");
=======
=======
>>>>>>> e7a69fc0... Worked extensively on the GUI. now have a working custom title bar, a new colour theme which has been implemented on login, profile, and createprofile screens.
    /*dNewScene("/fxml/loginScreen.fxml");
>>>>>>> 37d12d4e... Added a load of missing javadoc all over the place
        createProfileScene = loadNewScene("/fxml/createProfileScreen.fxml");
        profileScene = loadNewScene("/fxml/profileScreen.fxml");
        goalsScene = loadNewScene("/fxml/goalsScreen.fxml");
        uploadDataScene */
<<<<<<< HEAD
     /**
     * Sets the scene on the primary stage to the profile scene.
     */
    public void launchProfileScene()
    {
        profileController.setUpScene();
        dataWriter.saveProfile(currentUser);
        profileController.setUserDetails();
        primaryStage.setScene(profileScene);
<<<<<<< HEAD

<<<<<<< HEAD
=======
>>>>>>> 34b35cb9... Fixed and refactored lot of code to finish the profile screen, calendar implementation. Also fixed couple of GUI errors on profile screen by manual testing.
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
=======
>>>>>>> e7a69fc0... Worked extensively on the GUI. now have a working custom title bar, a new colour theme which has been implemented on login, profile, and createprofile screens.

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

=======
    /**
     * checks to see if a profile already exists with a specific username
     * @param userName the username being checked
     * @throws UniqueNameException
     */
>>>>>>> 37d12d4e... Added a load of missing javadoc all over the place
    public void checkUniqueName(String userName) throws UniqueNameException
    {
        if (titleBarController.getCurrentProfile() == null || !userName.contentEquals(titleBarController.getCurrentProfile().getName())) {
            for (UserProfile userProfile : this.getUsers()) {
                if (userProfile.getName().equals(userName)) {
                    throw new UniqueNameException();
                }
            }
        }
<<<<<<< HEAD

    }

<<<<<<< HEAD

<<<<<<< HEAD
>>>>>>> 4e37ab85... Finished Implementing new Login Screen Layout.
    public void launchMapScene(Activity activity) {
=======
=======
    /**
     * sets up and launches the map scene for a specific activity
     * @param activity the activity being mapped
     */
>>>>>>> 37d12d4e... Added a load of missing javadoc all over the place
    public void launchMapScene(Activity activity)
    {
>>>>>>> 8ec9ce7d... Wrote some tests for GUIController and added some dependencies for when we test the JavaFX controllers (Not this deliverable)
        mapController.setActivity(activity);
        mapController.setUpScene();
        Route newRoute = mapController.makeRoute(activity);
        mapController.displayRoute(newRoute);
        primaryStage.setScene(mapScene);
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 874b31ca... Re-added launch mapscene
=======
>>>>>>> 81b0c6a... Re-added launch mapscene
>>>>>>> fa48cc98... Re-added launch mapscene
    public void launchGoalsScene() {
=======
=======
    /**
     * sets up the goals screen and loads it onto the primary stage
     */
>>>>>>> 37d12d4e... Added a load of missing javadoc all over the place
    public void launchGoalsScene()
    {
>>>>>>> 8ec9ce7d... Wrote some tests for GUIController and added some dependencies for when we test the JavaFX controllers (Not this deliverable)
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
    public void launchUploadDataScene()
    {
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
=======
>>>>>>> e7a69fc0... Worked extensively on the GUI. now have a working custom title bar, a new colour theme which has been implemented on login, profile, and createprofile screens.
    }


    /**
<<<<<<< HEAD
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
=======
>>>>>>> f7b90380... Small tweaks to fix pipeline issues caused by recent merge.
     * Initalizes every loader, controller and scene for each scene. Also runs the setApp(this) and
     * setUpScene methods for each.
     * @throws Exception Not implemented.
     */
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
    public void loadAllScenes() throws Exception
    {
>>>>>>> 8ec9ce7d... Wrote some tests for GUIController and added some dependencies for when we test the JavaFX controllers (Not this deliverable)
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
=======
    public void loadTitleBar() throws Exception
    {
        FXMLLoader titleBarLoader = new FXMLLoader(getClass().getResource("/fxml/titleBar.fxml"));
        root = titleBarLoader.load();
        titleBarController = titleBarLoader.getController();
        titleBarController.setApp(this);
        titleBarController.setUpScene();
        titleBarScene = new Scene(root, 1280, 750);
>>>>>>> e7a69fc0... Worked extensively on the GUI. now have a working custom title bar, a new colour theme which has been implemented on login, profile, and createprofile screens.
    }


    /**
     * Creates a new profile (and adds the test data to it for now).
     * @param newUser  The profile being created.
     */
    public void createUser(UserProfile newUser) throws InvalidUserException
    {
        if (newUser.getName() != null &&
                newUser.getWeight() != 0.0 &&
                newUser.getHeight() != 0.0 &&
                newUser.getBirthDate() != null &&
                newUser.getGender() != null) {
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
        this.titleBarController.setCurrentProfile(userProfile);
        this.titleBarController.getGoalController().addGoalsToTable();
    }

    /**
     * Gets the list of user profiles.
     * @return  a ArrayList<UserProfile> object of the user profiles.
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
     * obligatory main method. launches the thing
     * @param args
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
