package seng202.team10.Visual;


import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Route;
import seng202.team10.Model.UserProfile;

import java.io.IOException;
//import seng202.team10.Control.WindowStyle;

/**
<<<<<<< HEAD
 * TitleBarController Class for Coach Potato
 * SENG202 2018S2
=======
 * Controller class for the title bar, which loads and launches every major scene.
 *
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class TitleBarController {


    private MainController mainController ;
    private Pane createProfilePane;
    private Pane loginPane;
    private Pane profilePane;
    private Pane uploadDataPane;
    private Pane activityViewerPane;
    private Pane goalPane;
    private Pane graphsPane;
    private Pane entryPane;
    private Pane mapPane;
    private Pane healthWarningPane;

    private UserProfile currentUser;
    @FXML private Pane currentScene;
    @FXML private Button menuButton;
    @FXML private Button warningButton;
    @FXML private VBox menuBar;
    @FXML private ImageView profileMenuIcon;
    private CreateProfileController createProfileController;
    private LoginController loginController;
    private ProfileController profileController;
    private UploadDataController uploadDataController;
    private ActivityViewerController activityViewerController;
    private GoalController goalsController;
    private GraphsController graphsController;
    private EntryViewerController entryViewerController;
    private MapController mapController;
    private HealthWarningsController healthWarningController;


    /**
<<<<<<< HEAD
     * Setter Method for the GUIController
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
=======
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setMainController(MainController mainController)
    {
<<<<<<< HEAD
        this.app = mainController;
>>>>>>> 86ffe4b1... Refactored GUIController to be called MainController
=======
        this.mainController = mainController;
>>>>>>> be0346c6... Refactored "app" to "mainController"
    }


    /**
<<<<<<< HEAD
     * Sets up objects that require it prior to showing the scene
=======
     * Sets up objects that require it prior to showing the scene.
     * @throws IOException when there is an error.
>>>>>>> 662d506f... Renamed the data analysis screen to the graphs screen
     */
    public void setUpScene() throws IOException
    {
        loadAllPanes();
        if  (mainController. getUserNames().isEmpty()) {
            openCreateProfile();
        } else {
            openLogin();
        }
    }


    /**
     * Set up method for the health warnings flag.
     */
    public void setUpWarningFlag()
    {
        warningButton.setVisible(false);
        if (currentUser.getActiveHealthWarnings().size() > 0) {
            warningButton.setVisible(true);
            warningButton.setTooltip(new Tooltip("You currently have " +
                                                 currentUser.getActiveHealthWarnings().size() +
                                                 " active health warnings.\nPlease click here to view them."));
        }
    }


    /**
<<<<<<< HEAD
     * Set the new scene to be displayed
=======
     * Set the new scene to be displayed.
     * @param newPane  The <b>Pane</b> being set to the scene.
>>>>>>> 662d506f... Renamed the data analysis screen to the graphs screen
     */
    public void setScene(Pane newPane)
    {
        if (newPane == createProfilePane || newPane == loginPane) {
            menuButton.setVisible(false);
        } else {
            menuButton.setVisible(true);
        }
        currentScene.getChildren().setAll(newPane);
    }


    /**
     * Method to create all panes used by the application
     * @throws IOException if an error occurs
     */
    private void loadAllPanes() throws IOException
    {
        FXMLLoader createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        createProfilePane = createProfileLoader.load();
        createProfileController = createProfileLoader.getController();
        createProfileController.setMainController(this.mainController);
        createProfileController.setUpScene();


        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
        loginPane = loginLoader.load();
        loginController = loginLoader.getController();
        loginController.setMainController(this.mainController);
        loginController.setUpScene();


        FXMLLoader profileLoader = new FXMLLoader(getClass().getResource("/fxml/profileScreen.fxml"));
        profilePane = profileLoader.load();
        profileController = profileLoader.getController();
        profileController.setMainController(this.mainController);
        profileController.setUpScene();


        FXMLLoader uploadDataLoader = new FXMLLoader(getClass().getResource("/fxml/uploadDataScreen.fxml"));
        uploadDataPane = uploadDataLoader.load();
        uploadDataController = uploadDataLoader.getController();
        uploadDataController.setMainController(this.mainController);
        uploadDataController.setUpScene();


        FXMLLoader activityViewerLoader = new FXMLLoader(getClass().getResource("/fxml/activityViewerScreen.fxml"));
        activityViewerPane = activityViewerLoader.load();
        activityViewerController = activityViewerLoader.getController();
        activityViewerController.setMainController(this.mainController);


        FXMLLoader goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        goalPane = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setMainController(this.mainController);
        goalsController.setUpScene();


        FXMLLoader graphsLoader = new FXMLLoader(getClass().getResource("/fxml/graphsScreen.fxml"));
        graphsPane = graphsLoader.load();
        graphsController = graphsLoader.getController();
        graphsController.setMainController(this.mainController);


        FXMLLoader entryLoader = new FXMLLoader(getClass().getResource("/fxml/entryViewerScreen.fxml"));
        entryPane = entryLoader.load();
        entryViewerController = entryLoader.getController();
        entryViewerController.setMainController(this.mainController);


        FXMLLoader mapLoader = new FXMLLoader((getClass().getResource("/fxml/mapScreen.fxml")));
        mapPane = mapLoader.load();
        mapController = mapLoader.getController();
        mapController.setMainController(this.mainController);
        

        FXMLLoader healthWarningLoader = new FXMLLoader((getClass().getResource("/fxml/healthWarningsScreen.fxml")));
        healthWarningPane = healthWarningLoader.load();
        healthWarningController = healthWarningLoader.getController();
        healthWarningController.setMainController(this.mainController);
    }


    /**
     * Method called when the minimise button is pressed.
     * Minimises the screen to the task bar.
     */
    @FXML public void minimise()
    {
        mainController .minimise();
    }


    /**
     * Method called when the close button is pressed.
     * Closes the application.
     */
    @FXML public void close()
    {
        Platform.exit();
    }


    /**
     * Method to display the create profile screen
     */
    @FXML protected  void openCreateProfile()
    {
        slideMenu(false);
        createProfileController.toggleBackButton();
        setScene(createProfilePane);
    }


    /**
     * Method to display the login screen
     */
    @FXML public void openLogin()
    {
        mainController .setCurrentUser(null);
        mainController .loadUserDetails();
        loginController.setUpScene();
        slideMenu(false);
        setScene(loginPane);
    }


    /**
     * Method to display the view profile screen
     */
    @FXML public void openViewProfile()
    {
        profileController.setCurrentUser(currentUser);
        try {
            profileMenuIcon.setImage(new Image("Images/profile" + currentUser.getGender() + ".png"));
        } catch (IllegalArgumentException exception) {
            mainController .createPopUp(Alert.AlertType.ERROR, "Error", "Could not find profile icon");
        }
        profileController.setUpScene();
        mainController .getDataWriter().saveProfile(currentUser);
        profileController.setUserDetails();
        slideMenu(false);
        // Set up warning flag if necessary
        setUpWarningFlag();
        setScene(profilePane);
    }


    /**
     * Method to display the upload data screen
     */
    @FXML public void openUploadData()
    {

        uploadDataController.setUpScene();
        mainController .getDataWriter().saveProfile(currentUser);
        slideMenu(false);
        setScene(uploadDataPane);
    }


    /**
     * Method to display the view activities screen
     */
    @FXML public void openViewActivities()
    {

        mainController .getDataWriter().saveProfile(currentUser);
        activityViewerController.setUpScene();
        slideMenu(false);
        setScene(activityViewerPane);
    }


    /**
     * Method to display the goals screen
     */
    @FXML public void openGoals()
    {
        mainController .getDataWriter().saveProfile(currentUser);
        goalsController.addGoalsToTable();
        goalsController.resetTextFields();
        slideMenu(false);
        setScene(goalPane);
    }


    /**
<<<<<<< HEAD
     * Method to display the analysis screen
=======
     * Method to display the graphs screen.
     * @param activity  The <b>Activity</b> the graph is being viewed of.
>>>>>>> 662d506f... Renamed the data analysis screen to the graphs screen
     */
    @FXML public void openGraphs(Activity activity)
    {
        mainController .getDataWriter().saveProfile(currentUser);
        graphsController.setActivity(activity);
        graphsController.setUpScene();
        slideMenu(false);
        setScene(graphsPane);
    }


    /**
<<<<<<< HEAD
     * Method to display the entry viewer screen
=======
     * Method to display the entry viewer screen.
     * @param activity  The <b>Activity</b> the entries are being viewed of.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    @FXML protected  void openEntry(Activity activity)
    {
        slideMenu(false);
        entryViewerController.setUpScene(activity);
        mainController .getDataWriter().saveProfile(currentUser);
        setScene(entryPane);
    }


    /**
<<<<<<< HEAD
     * Method to display the map screen
=======
     * Method to display the map screen.
     * @param activity  The <b>Activity</b> the map is being viewed of.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    @FXML public void openMap(Activity activity)
    {
        slideMenu(false);
        mapController.setActivity(activity);
        mapController.setUpScene();
        Route newRoute = mapController.makeRoute(activity);
        mapController.displayRoute(newRoute);
        setScene(mapPane);
    }


    /**
     * Method to display the health warnings screen
     */
    @FXML public void openWarnings()
    {
        healthWarningController.setUpScene();
        slideMenu(false);
        setScene(healthWarningPane);
        healthWarningController.createWarningPanes();
    }


    /**
     * Method called when the menu button is pressed
     * Displays the menu
     */
    @FXML public void menuSelected()
    {
        slideMenu(true);
    }


    /**
     * Method called when the menu button is selected.
     * calls the animation of the menu bar.
     */
    private void slideMenu(Boolean clicked)
    {
        TranslateTransition openNav = new TranslateTransition(new Duration(350), menuBar);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), menuBar);
        if (clicked && (menuBar.getTranslateX() < -10)) {
            openNav.setToX(0);
            openNav.play();
        } else if (menuBar.getTranslateX() > -10) {
            closeNav.setToX(-(menuBar.getWidth()));
            closeNav.play();
        }
    }


    /**
     * Getter Method for the Goals Controller
     * @return GoalController
     */
    public GoalController getGoalController()
    {
        return goalsController;
    }


    /**
     * Setter method for the current user.
     * @param currentProfile UserProfile: current logged in user.
     */
    public void setCurrentProfile(UserProfile currentProfile)
    {
        this.currentUser = currentProfile;
    }


    /**
     * Getter method for the current logged in user
     * @return UserProfile
     */
    public UserProfile getCurrentProfile()
    {
        return currentUser;
    }


    /**
     * Resets the help text areas and the health warning scroll pane to be invisible.
     * Called when the title bar is clicked.
     */
    @FXML public void titleClicked()
    {
        createProfileController.hideHelpTextArea();
        loginController.hideHelpTextArea();
        profileController.hideHelpTextArea();
        uploadDataController.hideHelpTextAreas();
        activityViewerController.hideHelpTextArea();
        goalsController.hideHelpTextArea();
        graphsController.hideHelpTextArea();
        entryViewerController.hideHelpTextArea();
        mapController.hideHelpTextArea();
        healthWarningController.hideWarningsScrollPane();
//        healthWarningController.hideHelpTextArea();
//        healthWarningController.ideHelpTextArea();

    }
}
