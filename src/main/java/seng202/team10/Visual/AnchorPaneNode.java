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
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;
    private DataAnalysis dataAnalysis = new DataAnalysis();
    private UserProfile currentUser;
    private ProfileController profileController;
    private ArrayList<Activity> activities = new ArrayList<>();
    private ArrayList<Goal> todayGoals = new ArrayList<>();

    /**
     * Setter method to set the profile controller for this Scene.
     * @param profileController profileController
     */
    protected void setProfileController(ProfileController profileController)
    {
        this.profileController = profileController;
    }

    /**
     * Method to calculate the total distance for this pane's date and returns it as a string.
     * @return distanceCovered String
     */
    public String printDistance()
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
     * @return averageSpeed String
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
     * @return caloriesBurned String
     */
    public String printCalories()
    {
        double calories = 0.0;
        for (Activity activity: activities) {
            calories += (dataAnalysis.getCaloriesFromActivity(activity, currentUser)).get(activity.getEntries().size()-1);
        }
        String caloriesBurned = "Calories burned: " + String.format("%.2f", calories);
        return caloriesBurned;
    }

    /**
     * Method to calculate the total time spent for this pane's date and returns it as a string.
     * @return timeSpent String
     */
    public String printTimeSpent()
    {
        int time = 0;
        for (Activity activity: activities) {
            time += activity.getTotalDuration();
        }

        int minutes = time/60;
        int seconds = time%60;
        String timeSpent = "Time spent: " + String.valueOf(minutes) + ":" + String.valueOf(seconds) + " minutes";
        return timeSpent;
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
        this.profileController.activitiesLabel.setVisible(false);
        this.profileController.goalsListLabel.setVisible(false);

        ObservableList<Object> goalsList = FXCollections.observableArrayList();
        for (Goal todayGoal : todayGoals) {
            goalsList.add(todayGoal.getGoalName() + ": " + todayGoal.getGoalType());
        }
        this.profileController.goalsListView.setItems(goalsList);

        ObservableList<Object> activitiesList = FXCollections.observableArrayList();
        for (Activity activity : activities) {
            activitiesList.add(activity.getName() + ": " + activity.getTypeString());
        }
        this.profileController.activitiesListView.setItems(activitiesList);
    }

    /**
     * Create a anchor pane node. Date is not assigned in the constructor.
     * @param children children of the anchor pane
     */
    public AnchorPaneNode(Node... children)
    {
        super(children);
        // Add action handler for mouse clicked
        this.setOnMouseEntered(e -> this.setStyle("-fx-background-color: #0097A7"));
        this.setOnMouseExited(e -> this.setStyle("-fx-background-color: null"));
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
     * @return activities ArrayList of Activity.
     */
    public ArrayList<Activity> getActivities()
    {
        return activities;
    }

    /**
     * Setter method to set the pane's activities.
     * @param activities ArrayList of Activity.
     */
    public void setActivities(ArrayList<Activity> activities)
    {
        this.activities = activities;
    }

    /**
     * Setter method to set the current user profile.
     * @param currentUser UserProfile
     */
    protected void setCurrentUser(UserProfile currentUser)
    {
        this.currentUser = currentUser;
    }

    /**
     * Getter method to get the pane's goals.
     * @return todayGoals Arraylist of goals
     */
    public ArrayList<Goal> getTodayGoals() {
        return todayGoals;
    }

    /**
     * Setter method to set current user's goals.
     * @param todayGoals Arraylist of goals
     */
    protected void setTodayGoals(ArrayList<Goal> todayGoals) {
        this.todayGoals = todayGoals;
    }


}
