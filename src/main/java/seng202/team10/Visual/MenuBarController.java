package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;

/**
 * Menu Bar Controller Class for Coach Potato SENG202 2018S2
 */
public class MenuBarController implements Controllable {

    private GUIController app;
    @FXML private Button menu;
    @FXML private VBox drawer;
    //@FXML private HBox drawerHBox;
    @FXML private Pane allScreensPane;
    @FXML private Button selectProfileButton;
    @FXML private Button viewProfileButton;
    @FXML private Button uploadDataButton;
    @FXML private Button viewActivitiesButton;
    @FXML private Button goalsButton;
    @FXML private Button analysisButton;


    /**
     * Setter method for the GUIController
     * @param app GUIController: the gui controller for this program.
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * starts the menu setup
     */
    @Override
    public void setUpScene()
    {
        //(URL url, ResourceBundle rb)
        //drawerHBox.setVisible(false);
        drawerAction();

    }


    /**
     * Method to draw the navigation drawer.
     */
    @FXML private void drawerAction()
    {

        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        if (drawer.getTranslateX() != 0) {
            openNav.play();
        } else {
            closeNav.setToX(-(drawer.getWidth()));
            closeNav.play();
        }
    }


    /**
     * Method to launch the login scene.
     */
    @FXML public void openChooseProfile()
    {
        moveDrawer();
        app.launchLoginScene();
    }


    /**
     * Method to launch the view profile scene.
     */
    @FXML public void openViewProfile()
    {
        moveDrawer();
        app.launchProfileScene();
    }


    /**
     * Method to launch the upload data scene.
     */
    @FXML public void openUploadData()
    {
        moveDrawer();
        app.launchUploadDataScene();
    }


    /**
     * Method to launch the view activities scene.
     */
    @FXML public void openViewActivities()
    {
        moveDrawer();
        app.launchActivityViewerScene();
    }


    /**
     * Method to launch the goals scene.
     */
    @FXML public void openGoals()
    {
        moveDrawer();
        app.launchGoalsScene();
    }


    /**
     * Method to launch the data analysis scene.
     */
    @FXML public void openAnalysis()
    {
        moveDrawer();
        app.launchDataAnalysisScene();
    }


    /**
     * Method to move the navigation drawer as appropriate.
     */
    private void moveDrawer()
    {
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        closeNav.setToX(-(drawer.getWidth()));
        closeNav.play();
        setUpScene();
    }
}
