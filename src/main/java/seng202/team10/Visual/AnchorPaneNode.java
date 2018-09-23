package seng202.team10.Visual;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import seng202.team10.Control.DataAnalysis;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Goals.UserProfile;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;
    private DataAnalysis dataAnalysis = new DataAnalysis();
    private UserProfile currentUser;

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;
    }

    private ProfileController profileController;

    public String printDistance() {
        double distance = 0.0;
        String distanceCovered = "Distance Covered: ";
        for (Activity activity: activities) {
            distance += activity.getTotalDistance();
        }
        distanceCovered += String.format("%.2f km", distance/1000);
        return distanceCovered;
    }

    public String printSpeed() {
        double speed = 0.0;
        String averageSpeed = "Average speed: ";
        for (Activity activity: activities) {
            speed += activity.getSpeedKMH();
        }
        averageSpeed += String.format("%.2f km/h", speed);
        return averageSpeed;
    }

    public String printCalories() {
        double calories = 0.0;
        for (Activity activity: activities) {
            calories += (dataAnalysis.getCaloriesFromActivity(activity, currentUser)).get(activity.getEntries().size()-1);
        }
        String caloriesBurned = "Calories burned: " + String.format("%.2f", calories);
        return caloriesBurned;
    }

    public String printTimeSpent() {
        int time = 0;
        for (Activity activity: activities) {
            time += activity.getTotalDuration();
        }

        int minutes = time/60;
        int seconds = time%60;
        String timeSpent = "Time spent: " + String.valueOf(minutes) + ":" + String.valueOf(seconds) + " minutes";
        return timeSpent;
    }

    public void onMouseClicked() {
        DateTime dateToday = new DateTime(date.getYear(), date.getMonthValue(), date.getDayOfMonth(),0,0,0);
        this.profileController.dailyStatsLabel.setText("Daily Statistics for " + dateToday.getDateAsString());
        this.profileController.activity1Text.setText(this.printDistance());
        this.profileController.activity2Text.setText(this.printCalories());
        this.profileController.activity3Text.setText(this.printTimeSpent());
        this.profileController.activity1HBox.setVisible(true);
        this.profileController.activity2HBox.setVisible(true);
        this.profileController.activity3HBox.setVisible(true);
        this.profileController.dailyStatsLabel.setVisible(true);
    }

    private ArrayList<Activity> activities = new ArrayList<>();

    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    public AnchorPaneNode(Node... children) {
        super(children);
        // Add action handler for mouse clicked
        this.setOnMouseEntered(e -> this.setStyle("-fx-background-color: #C2185B"));
        this.setOnMouseExited(e -> this.setStyle("-fx-background-color: null"));
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public void setCurrentUser(UserProfile currentUser) {this.currentUser = currentUser;}
}
