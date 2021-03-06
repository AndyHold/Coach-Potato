package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import seng202.team10.Model.ActivitiesData.DataAnalysis;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Goals.Goal;
import seng202.team10.Model.UserProfile;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Subclass of an anchor pane that can store additional data.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;
    private DataAnalysis dataAnalysis = new DataAnalysis();
    private UserProfile currentUser;
    private ProfileController profileController;
    private ArrayList<Activity> activities = new ArrayList<>();
    private ArrayList<Goal> todayGoals = new ArrayList<>();
    private String style = null;

    /**
     * Setter method to set the profile controller for this Scene.
     * @param profileController The <b>profileController</b> being set.
     */
    protected void setProfileController(ProfileController profileController)
    {
        this.profileController = profileController;
    }

    /**
     * Method to calculate the total distance for this pane's date and returns it as a string.
     * @return A <b>String</b> descrbing the distance covered.
     */
    private String printDistance()
    {
        double distance = 0.0;
        String distanceCovered = "Distance Covered: ";
        for (Activity activity: activities) {
            distance += activity.getTotalDistance();
        }
        distanceCovered += String.format("%.2f km", distance/1000);
        return distanceCovered;
    }

    /**
     * Method to calculate the average speed for this pane's date and returns it as a string.
     * @return A <b>String</b> describing the average speed
     */
    public String printSpeed()
    {
        double speed = 0.0;
        String averageSpeed = "Average speed: ";
        for (Activity activity: activities) {
            speed += activity.getSpeedKMH();
        }
        averageSpeed += String.format("%.2f km/h", speed);
        return averageSpeed;
    }

    /**
     * Method to calculate the calories burned for this pane's date and returns it as a string.
     * @return A <b>String</b> describing the calories burned.
     */
    private String printCalories()
    {
        double calories = 0.0;
        for (Activity activity: activities) {
            calories += (dataAnalysis.getCaloriesFromActivity(activity, currentUser)).get(activity.getEntries().size()-1);
        }
        return "Calories burned: " + String.format("%.2f", calories);
    }

    /**
     * Method to calculate the total time spent for this pane's date and returns it as a string.
     * @return A <b>String</b> describing the time spent
     */
    private String printTimeSpent()
    {
        int time = 0;
        for (Activity activity: activities) {
            time += activity.getTotalDuration();
        }

        int minutes = time/60;
        int seconds = time%60;
        return "Time spent: " + String.valueOf(minutes) + ":" + String.valueOf(seconds) + " minutes";
    }

    /**
     * Method to update the statistics on the profile screen when the pane is clicked.
     */
    public void onMouseClicked()
    {
        DateTime dateToday = new DateTime(date.getYear(), date.getMonthValue(), date.getDayOfMonth(),0,0,0);
        this.profileController.dailyStatsLabel.setText("Statistics for " + dateToday.getDateAsString());
        this.profileController.activity1Text.setText(this.printDistance());
        this.profileController.activity2Text.setText(this.printCalories());
        this.profileController.activity3Text.setText(this.printTimeSpent());
        this.profileController.activity1HBox.setVisible(true);
        this.profileController.activity2HBox.setVisible(true);
        this.profileController.activity3HBox.setVisible(true);
        this.profileController.dailyStatsLabel.setVisible(true);
        this.profileController.statsClickLabel.setVisible(false);

        this.profileController.goalStats1HBox.setVisible(false);
        this.profileController.goalStats2HBox.setVisible(false);
        this.profileController.goalStats3HBox.setVisible(false);
        this.profileController.activityStats1HBox.setVisible(false);
        this.profileController.activityStats2HBox.setVisible(false);
        this.profileController.activityStats3HBox.setVisible(false);
        this.profileController.activitiesClickLabel.setVisible(true);
        this.profileController.goalsClickLabel.setVisible(true);

        ObservableList<Goal> goalsList = FXCollections.observableArrayList();
        for (Goal todayGoal : todayGoals) {
            goalsList.add(todayGoal);
        }
        this.profileController.goalsListView.setItems(goalsList);
        if (goalsList.size() < 1) {
            this.profileController.goalsListClickLabel.setText("No goals were found for this date.");
            this.profileController.goalsListClickLabel.setVisible(true);
        } else {
            this.profileController.goalsListClickLabel.setVisible(false);
        }

        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        for (Activity activity : activities) {
            activitiesList.add(activity);
        }
        this.profileController.activitiesListView.setItems(activitiesList);
        if (activitiesList.size() < 1) {
            this.profileController.activitiesListClickLabel.setText("No activities were found for this date.");
            this.profileController.activitiesListClickLabel.setVisible(true);
        } else {
            this.profileController.activitiesListClickLabel.setVisible(false);
        }
    }

    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    AnchorPaneNode(Node... children)
    {
        super(children);
        // Add action handler for mouse clicked
        this.setOnMouseEntered(e -> {
            style = this.getStyle();
            this.setStyle("-fx-background-color: #0097A7");
        });
        this.setOnMouseExited(e -> this.setStyle(style));
    }

    /**
     * Getter method to get the pane's date.
     * @return date LocalDate
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Setter method to set the pane's date.
     * @param date LocalDate
     */
    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    /**
     * Getter method to get the pane's activities.
     * @return An <b>ArrayList&lt;Activity&gt;</b>
     */
    public ArrayList<Activity> getActivities()
    {
        return activities;
    }

    /**
     * Setter method to set the pane's activities.
     * @param activities An <b>ArrayList&lt;Activity&gt;</b>
     */
    public void setActivities(ArrayList<Activity> activities)
    {
        this.activities = activities;
    }

    /**
     * Setter method to set the current user profile.
     * @param currentUser <b>UserProfile</b>
     */
    protected void setCurrentUser(UserProfile currentUser)
    {
        this.currentUser = currentUser;
    }

    /**
     * Getter method to get the pane's goals.
     * @return An <b>ArrayList&lt;Goal&gt;</b>
     */
    public ArrayList<Goal> getTodayGoals() {
        return todayGoals;
    }

    /**
     * Setter method to set current user's goals.
     * @param todayGoals An <b>ArrayList&lt;Goal&gt;</b>
     */
    protected void setTodayGoals(ArrayList<Goal> todayGoals) {
        this.todayGoals = todayGoals;
    }


}
