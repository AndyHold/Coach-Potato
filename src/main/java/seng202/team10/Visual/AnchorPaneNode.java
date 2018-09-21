package seng202.team10.Visual;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import seng202.team10.Model.ActivitiesData.Activity;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Create an anchor pane that can store additional data.
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;

    public String printActivities() {
        String todayActivities = "";
        for (Activity activity: activities) {
            todayActivities += (activity.getName() + " : " + activity.getStartDateTime().getTimeAsString() + " - " + activity.getEndDateTime().getTimeAsString() + "\n");
        }
        return todayActivities;
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

        this.setOnMouseClicked(e -> System.out.println("This pane's date is: " + date));
        this.setOnMouseClicked(e -> System.out.println(printActivities()));
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

}
