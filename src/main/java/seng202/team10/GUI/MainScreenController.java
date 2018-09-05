package seng202.team10.GUI;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;

public class MainScreenController implements Controllable {

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

    public void setApp(GUIController app) {
        this.app = app;
    }
    
    //@Override
   public void setUpScene(){
        //(URL url, ResourceBundle rb)
        //drawerHBox.setVisible(false);
        drawerAction();

    }
    
    private void drawerAction() {

        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        menu.setOnAction((ActionEvent evt) -> {

            if (drawer.getTranslateX() != 0) {
                openNav.play();
                //drawerHBox.setVisible(true);
            } else {
                closeNav.setToX(-(drawer.getWidth()));
                closeNav.play();
                //drawerHBox.setVisible(false);
            }
        });
    }


    @FXML public void openChooseProfile() throws Exception {
        setUpScene();
        app.launchLoginScene();
    }

    @FXML public void openViewProfile() throws Exception {
        setUpScene();
        app.launchProfileScene();
    }

    @FXML public void openUploadData() throws Exception {
        setUpScene();
        app.launchUploadDataScene();
    }

    @FXML public void openViewActivities() throws Exception {
        setUpScene();
        //app.launchViewActivitiesScreen();
    }

    @FXML public void openGoals() throws Exception {
        setUpScene();
        //app.launchGoalsScreen();
    }

    @FXML public void openAnalysis() throws Exception {
        setUpScene();
        app.launchDataAnalysisScene();
    }

}
