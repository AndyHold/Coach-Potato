package seng202.team10.Visual;


import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Route;
import seng202.team10.Model.UserProfile;

import java.io.IOException;
//import seng202.team10.Control.WindowStyle;

/**
 * TitleBarController Class for Coach Potato
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

    @FXML private Pane currentScene;
    @FXML private Button menuButton;
    private CreateProfileController createProfileController;
    private LoginController loginController;
    @FXML private VBox menuBar;
    private ProfileController profileController;
    private UploadDataController uploadDataController;
    private ActivityViewerController activityViewerController;
    private GoalController goalsController;
    private DataAnalysisController dataAnalysisController;
    private UserProfile currentUser;
    private EntryViewerController entryViewerController;
    private MapController mapController;

    /**
     * Setter Method for the GUIController
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene() throws IOException {
        loadAllPanes();
        if (app.getUserNames().isEmpty()) {
            openCreateProfile();
        } else {
            openLogin();
        }
    }


    /**
     * Set the new scene to be displayed
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
    }


    @FXML public void minimise()
    {
        app.minimise();
    }


    @FXML public void close()
    {
        Platform.exit();
    }


    @FXML public void openCreateProfile()
    {
        System.out.println("Create");
        slideMenu(false);
        createProfileController.toggleBackButton();
        setScene(createProfilePane);
    }


    @FXML public void openLogin()
    {
        app.setCurrentUser(null);
        loginController.setUpScene();
        slideMenu(false);
        setScene(loginPane);
    }


    @FXML public void openViewProfile()
    {
        profileController.setUpScene();
        app.getDataWriter().saveProfile(currentUser);
        profileController.setUserDetails();
        slideMenu(false);
        setScene(profilePane);
    }


    @FXML public void openUploadData()
    {

        uploadDataController.setUpScene();
        app.getDataWriter().saveProfile(currentUser);
        slideMenu(false);
        setScene(uploadDataPane);
    }


    @FXML public void openViewActivities()
    {

        app.getDataWriter().saveProfile(currentUser);
        activityViewerController.setUpScene();
        slideMenu(false);
        setScene(activityViewerPane);
    }


    @FXML public void openGoals()
    {
        app.getDataWriter().saveProfile(currentUser);
        goalsController.addGoalsToTable();
        slideMenu(false);
        setScene(goalPane);
    }


    @FXML public void openAnalysis()
    {
        app.getDataWriter().saveProfile(currentUser);
        dataAnalysisController.setUpScene();
        slideMenu(false);
        setScene(analysisPane);
    }


    public void openEntry(Activity activity)
    {
        slideMenu(false);
        entryViewerController.setUpScene(activity);
        app.getDataWriter().saveProfile(currentUser);
        setScene(entryPane);
    }


    public void openMap(Activity activity)
    {
        mapController.setActivity(activity);
        mapController.setUpScene();
        Route newRoute = mapController.makeRoute(activity);
        mapController.displayRoute(newRoute);
        setScene(mapPane);
    }


    @FXML public void menuSelected()
    {
        slideMenu(true);
    }


    /**
     * Method called when the menu button is selected.
     * calls the animation of the menu bar.
     */
    public void slideMenu(Boolean clicked)
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
     * @return
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
}
