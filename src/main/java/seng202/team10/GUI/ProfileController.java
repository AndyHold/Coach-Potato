package seng202.team10.GUI;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.UserProfile;


import java.awt.*;
import java.text.DecimalFormat;
import java.time.YearMonth;

public class ProfileController {

    private GUIController app;

    @FXML Pane calendarPane;
    @FXML private javafx.scene.control.Label welcomeProfileLabel;
    @FXML private javafx.scene.control.Label qoutesLabel;
    @FXML private javafx.scene.control.Label weightValueLabel;
    @FXML private javafx.scene.control.Label heightValueLabel;
    @FXML private javafx.scene.control.Label bmiValueLabel;
    @FXML private HBox activity1HBox;
    @FXML private HBox activity2HBox;
    @FXML private HBox activity3HBox;
    @FXML private Text activity1Text;
    @FXML private Text activity2Text;
    @FXML private Text activity3Text;
    @FXML private HBox distanceHBox;
    @FXML private HBox velocityHBox;
    @FXML private HBox heartRateHBox;
    @FXML private Text distanceText;
    @FXML private Text velocityText;
    @FXML private Text heartRateText;
    @FXML private Button menu;
    @FXML private VBox drawer;

    public void setApp(GUIController app){
        this.app = app;
    }

    public void setUpScene() {
        calendarPane.getChildren().add(new FullCalendarView(YearMonth.now()).getView());
        activity1HBox.setVisible(false);
        activity2HBox.setVisible(false);
        activity3HBox.setVisible(false);
        distanceHBox.setVisible(false);
        velocityHBox.setVisible(false);
        heartRateHBox.setVisible(false);
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

    public void setUserDetails() {
        DecimalFormat df2 = new DecimalFormat(".##");
        setUpScene();
        UserProfile currentUser = app.getCurrentProfile();
        welcomeProfileLabel.setText("Welcome " + String.valueOf(currentUser.getName()) + ", Let's do it!");
        weightValueLabel.setText(df2.format((currentUser.getWeight())));
        heightValueLabel.setText(df2.format((currentUser.getHeight())));
        bmiValueLabel.setText(df2.format((currentUser.calcBmi())) + " - " + currentUser.getBmiCategory());

        if (currentUser.getActivities().size() > 0) {
            activity1Text.setText(currentUser.getActivities().get(0).getName());
            distanceText.setText("Total Distance Covered: " + df2.format(currentUser.getActivities().get(0).getTotalDistance()) + " km");
            velocityText.setText("Average Velocity: " + df2.format(currentUser.getActivities().get(0).getAverageVelocity()) + " m/s");
            heartRateText.setText("Average Heart Rate: " + String.valueOf((currentUser.getActivities().get(0).getAverageHeartRate()).intValue()) + " bpm");
            activity1HBox.setVisible(true);
            distanceHBox.setVisible(true);
            velocityHBox.setVisible(true);
            heartRateHBox.setVisible(true);

            if (currentUser.getActivities().size() > 1) {
                activity2HBox.setVisible(true);
                activity2Text.setText(currentUser.getActivities().get(1).getName());
                if (currentUser.getActivities().size() > 2) {
                    activity3HBox.setVisible(true);
                    activity3Text.setText(currentUser.getActivities().get(2).getName());
                }
            }
        }
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
        //app.launchAnalysisScreen();
    }
}
