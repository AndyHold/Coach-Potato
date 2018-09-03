package seng202.team10.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

public class activityViewerController {

    private GUIController app;

    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private Button filterApplyButton;
    @FXML private TableView<Activity> activitiesTableView;
    @FXML private TableColumn<Activity, String> nameColumn;
    @FXML private TableColumn<Activity, String> starttimeColumn;
    @FXML private TableColumn<Activity, String> durationColumn;
    @FXML private TableColumn<Activity, String> speedColumn;
    @FXML private TableColumn<Activity, String> distanceColumn;
    @FXML private TableColumn<Activity, String> heartrateColumn;
    @FXML private TableColumn<Activity, String> entrynoColumn;
    @FXML private Button entryViewerButton;
    @FXML private Button mapButton;

    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene() {
        //populate table with activities of current profile
    }

    /**
     * fills the table with the activities to display. used by setUpScene as well as applyFilter
     * @param displayActivities the arraylist of activity objects to be displayed in the table
     */
    private void populateTable(ArrayList<Activity> displayActivities){
        //update table to display the passed in activities
    }

    /**
     * updates table with entries between the two datepickers when the filterApplyButton is pressed
     */
    @FXML public void applyFilter(){
        //get startdate and enddate from datepickers
        //create new activitylist from activities in profile that have dates between start/end
        //pass new activities into populate table
    }


    /**
     * opens the entryViewer screen with the selected activity when the entryViewerButton is pressed
     */
    @FXML public void openEntries(){
        //set currentActivity to the currently selected row of the table
        //app.launchEntryViewerScene(currentActivity);
    }


    /**
     * opens the routemap screen for the selected activity when the openMap button is pressed
     */
    @FXML public void openMap(){
        //open a map screen with the selected activity to view routemap
    }


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }
}
