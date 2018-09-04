package seng202.team10.GUI;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
            heartRateText.setText("Average Heart Rate: " + String.valueOf((currentUser.getActivities().get(0).getAverageHeartRate())) + " bpm");
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
}
