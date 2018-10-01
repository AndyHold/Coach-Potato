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
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Route;
import seng202.team10.Model.UserProfile;

import java.io.IOException;

/**
 * Controller class for the title bar, which loads and launches every major scene.
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class TitleBarController {


    private GUIController app;
    private Pane createProfilePane;
    private Pane loginPane;
    private Pane profilePane;
    private Pane uploadDataPane;
    private Pane activityViewerPane;
    private Pane goalPane;
    private Pane analysisPane;
    private Pane entryPane;
    private Pane mapPane;
    private Pane healthWarningPane;

    @FXML private Pane currentScene;
    @FXML private Button menuButton;
    private CreateProfileController createProfileController;
    private LoginController loginController;
    @FXML private VBox menuBar;
    @FXML private Button warningButton;
    private ProfileController profileController;
    private UploadDataController uploadDataController;
    private ActivityViewerController activityViewerController;
    private GoalController goalsController;
    private DataAnalysisController dataAnalysisController;
    private UserProfile currentUser;
    private EntryViewerController entryViewerController;
    private MapController mapController;
    private HealthWarningsController healthWarningController;
    @FXML private ImageView profileMenuIcon;


    /**
     * Setter method to pass the GUIController into this controller.
     * @param guiController <b>GUIController:</b> The main controller.
     */
    public void setApp(GUIController guiController)
    {
        this.app = guiController;
    }


    /**
     * Sets up objects that require it prior to showing the scene.
     */
    public void setUpScene() throws IOException
    {
        loadAllPanes();
        if (app.getUserNames().isEmpty()) {
            openCreateProfile();
        } else {
            openLogin();
        }
    }


    /**
     * Set up method for the health warnings flag.
     */
    protected void setUpWarningFlag()
    {
        if (currentUser.getActiveHealthWarnings().size() > 0) {
            warningButton.setVisible(true);
            warningButton.setTooltip(new Tooltip("You currently have " +
                                                 currentUser.getActiveHealthWarnings().size() +
                                                 " active health warnings.\nPlease click here to view them."));
        }
    }


    /**
     * Set the new scene to be displayed.
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
     * Method to create all panes used by the application.
     * @throws IOException if an error occurs.
     */
    private void loadAllPanes() throws IOException
    {
        FXMLLoader createProfileLoader = new FXMLLoader(getClass().getResource("/fxml/createProfileScreen.fxml"));
        createProfilePane = createProfileLoader.load();
        createProfileController = createProfileLoader.getController();
        createProfileController.setApp(this.app);
        createProfileController.setUpScene();


        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/fxml/loginScreen.fxml"));
        loginPane = loginLoader.load();
        loginController = loginLoader.getController();
        loginController.setApp(this.app);
        loginController.setUpScene();


        FXMLLoader profileLoader = new FXMLLoader(getClass().getResource("/fxml/profileScreen.fxml"));
        profilePane = profileLoader.load();
        profileController = profileLoader.getController();
        profileController.setApp(this.app);
        profileController.setUpScene();


        FXMLLoader uploadDataLoader = new FXMLLoader(getClass().getResource("/fxml/uploadDataScreen.fxml"));
        uploadDataPane = uploadDataLoader.load();
        uploadDataController = uploadDataLoader.getController();
        uploadDataController.setApp(this.app);
        uploadDataController.setUpScene();


        FXMLLoader activityViewerLoader = new FXMLLoader(getClass().getResource("/fxml/activityViewerScreen.fxml"));
        activityViewerPane = activityViewerLoader.load();
        activityViewerController = activityViewerLoader.getController();
        activityViewerController.setApp(this.app);


        FXMLLoader goalsLoader = new FXMLLoader(getClass().getResource("/fxml/goalsScreen.fxml"));
        goalPane = goalsLoader.load();
        goalsController = goalsLoader.getController();
        goalsController.setApp(this.app);
        goalsController.setUpScene();


        FXMLLoader dataAnalysisLoader = new FXMLLoader(getClass().getResource("/fxml/dataAnalysisScreen.fxml"));
        analysisPane = dataAnalysisLoader.load();
        dataAnalysisController = dataAnalysisLoader.getController();
        dataAnalysisController.setApp(this.app);


        FXMLLoader entryLoader = new FXMLLoader(getClass().getResource("/fxml/entryViewerScreen.fxml"));
        entryPane = entryLoader.load();
        entryViewerController = entryLoader.getController();
        entryViewerController.setApp(this.app);


        FXMLLoader mapLoader = new FXMLLoader((getClass().getResource("/fxml/mapScreen.fxml")));
        mapPane = mapLoader.load();
        mapController = mapLoader.getController();
        mapController.setApp(this.app);
        
        
        FXMLLoader healthWarningLoader = new FXMLLoader((getClass().getResource("/fxml/healthWarningsScreen.fxml")));
        healthWarningPane = healthWarningLoader.load();
        healthWarningController = healthWarningLoader.getController();
        healthWarningController.setApp(this.app);
    }


    /**
     * Method called when the minimise button is pressed.
     * Minimises the screen to the task bar.
     */
    @FXML public void minimise()
    {
        app.minimise();
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
     * Method to display the create profile screen.
     */
    @FXML protected  void openCreateProfile()
    {
        slideMenu(false);
        createProfileController.toggleBackButton();
        setScene(createProfilePane);
    }


    /**
     * Method to display the login screen.
     */
    @FXML public void openLogin()
    {
        app.setCurrentUser(null);
        app.loadUserDetails();
        loginController.setUpScene();
        slideMenu(false);
        setScene(loginPane);
    }


    /**
     * Method to display the view profile screen.
     */
    @FXML public void openViewProfile()
    {
        profileController.setCurrentUser(currentUser);
        try {
            profileMenuIcon.setImage(new Image("Images/profile" + currentUser.getGender() + ".png"));
        } catch (IllegalArgumentException exception) {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not find profile icon");
        }
        profileController.setUpScene();
        app.getDataWriter().saveProfile(currentUser);
        profileController.setUserDetails();
        slideMenu(false);
        // Set up warning flag if necessary
        setUpWarningFlag();
        setScene(profilePane);
    }


    /**
     * Method to display the upload data screen.
     */
    @FXML public void openUploadData()
    {

        uploadDataController.setUpScene();
        app.getDataWriter().saveProfile(currentUser);
        slideMenu(false);
        setScene(uploadDataPane);
    }


    /**
     * Method to display the view activities screen.
     */
    @FXML public void openViewActivities()
    {

        app.getDataWriter().saveProfile(currentUser);
        activityViewerController.setUpScene();
        slideMenu(false);
        setScene(activityViewerPane);
    }


    /**
     * Method to display the goals screen.
     */
    @FXML public void openGoals()
    {
        app.getDataWriter().saveProfile(currentUser);
        goalsController.addGoalsToTable();
        slideMenu(false);
        setScene(goalPane);
    }


    /**
     * Method to display the analysis screen.
     */
    @FXML public void openAnalysis(Activity activity)
    {
        app.getDataWriter().saveProfile(currentUser);
        dataAnalysisController.setActivity(activity);
        dataAnalysisController.setUpScene();
        slideMenu(false);
        setScene(analysisPane);
    }


    /**
     * Method to display the entry viewer screen.
     */
    @FXML protected  void openEntry(Activity activity)
    {
        slideMenu(false);
        entryViewerController.setUpScene(activity);
        app.getDataWriter().saveProfile(currentUser);
        setScene(entryPane);
    }


    /**
     * Method to display the map screen.
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
     * Method to display the health warnings screen.
     */
    @FXML public void openWarnings()
    {
        healthWarningController.setUpScene();
        slideMenu(false);
        setScene(healthWarningPane);
    }


    /**
     * Method called when the menu button is pressed.
     * Displays the menu.
     */
    @FXML public void menuSelected()
    {
        slideMenu(true);
    }


    /**
     * Method called when the menu button is selected.
     * Calls the animation of the menu bar.
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
     * Getter method for the Goals Controller.
     * @return GoalController
     */
    public GoalController getGoalController()
    {
        return goalsController;
    }


    /**
     * Setter method for the current user.
     * @param currentProfile <b>UserProfile</b> of the currently logged in user.
     */
    public void setCurrentProfile(UserProfile currentProfile)
    {
        this.currentUser = currentProfile;
    }


    /**
     * Getter method for the currently logged in user.
     * @return <b>UserProfile</b> of the currently logged in user.
     */
    public UserProfile getCurrentProfile()
    {
        return currentUser;
    }
}
