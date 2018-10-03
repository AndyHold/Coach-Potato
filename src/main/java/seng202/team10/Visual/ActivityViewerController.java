package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.HealthWarning;

import javax.swing.text.html.ImageView;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Controller for the Activity Viewer Screen, which displays and filters lists of activities
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class ActivityViewerController {

    private GUIController app;
    private ObservableList<String> types;

    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private Button filterApplyButton;
    @FXML private Button clearFiltersButton;
    @FXML private TableView<Activity> activitiesTableView;
    @FXML private TableColumn<Activity, String> nameColumn;
    @FXML private TableColumn<Activity, String> typeColumn;
    @FXML private TableColumn<Activity, String> starttimeColumn;
    @FXML private TableColumn<Activity, Integer> entrynoColumn;
    @FXML private Button entryViewerButton;
    @FXML private Button helpButton;
    @FXML private TextArea helpTextArea;
    @FXML private ComboBox typeSelect;
    @FXML private Label distanceLabel;
    @FXML private Label durationLabel;
    @FXML private Label speedLabel;
    @FXML private Label heartRateLabel;
    private int currentIndex = -1;


    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene()
    {
        // Set tool tips for all elements
        setToolTips();
        // Set up help text area
        setUpHelpArea();
        // Set up type combo box
        createTypesList();
        typeSelect.setItems(types);
        typeSelect.setVisibleRowCount(8);
        // Set up table view
        setUpTableView();
        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
        clearFilters();
    }


    /**
     * Set up method for the elements in the table view.
     */
    private void setUpTableView()
    {
        ObservableList<Activity> activities = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getActivities());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("typeString"));
        starttimeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("timeString"));
        entrynoColumn.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("entryno"));
        populateTable(activities);
        activitiesTableView.refresh();
    }


    /**
     * Method to create the types list for the types combo box
     */
    private void createTypesList()
    {
        types = FXCollections.observableArrayList();
        types.add("All");
        types.add("Walk");
        types.add("Run");
        types.add("Hike");
        types.add("Cycle");
        types.add("Swim");
        types.add("Workout");
        types.add("Other");
    }


    /**
     * Set up method for the help text area
     */
    private void setUpHelpArea()
    {
        helpTextArea.setText("Welcome to the Activity View Screen!\n\n" +
                             "On this screen you can sort your activities by different values, view activities between selected dates, " +
                             "and view/edit the entries in an activity\n\n" +
                             "- To sort your activities simply click on the title of the\n" +
                             "  value you wish to sort by. Hint: Try clicking multiple\n" +
                             "  times.\n" +
                             "- To View activities between selected dates:\n" +
                             "\t- Click the \"From\" date selector and choose the date\n" +
                             "\t  to start from.\n" +
                             "\t- Click the \"To\" date selector and choose the date to\n" +
                             "\t  end on.\n" +
                             "\t- Click the \"Type\" Drop down and select a type of\n" +
                             "\t  activity to filter.\n" +
                             "\t- Click the Apply Filters button and the activities in\n" +
                             "\t  the table will be updated.\n" +
                             "\t- If you wish to return to viewing al activities simply\n" +
                             "\t  click the Clear Filters button.\n" +
                             "- To view/edit the entries in an activity:\n" +
                             "\t- Click the activity you wish to view/edit.\n" +
                             "\t- Click the View Entries button and you will be\n" +
                             "\t  navigated to the Entry View Screen.\n\n" +
                             "Hover the mouse over each button item to see what it is for.");
        helpTextArea.setWrapText(true);
        helpTextArea.setVisible(false);
    }


    /**
     * Set up method for the tool tips
     */
    private void setToolTips()
    {
        startDate.setTooltip(new Tooltip("Please select the date you wish to filter from."));
        endDate.setTooltip(new Tooltip("Please select the date you wish to filter until."));
        typeSelect.setTooltip(new Tooltip("Please select the type of activity you wish to view."));
        filterApplyButton.setTooltip(new Tooltip("Click here to apply the selected filters."));
        clearFiltersButton.setTooltip(new Tooltip("Click here to clear the filters and view all activities in your profile."));
        helpButton.setTooltip(new Tooltip("Need Help?"));
        activitiesTableView.setTooltip(new Tooltip("Your activities are listed in this table\n" +
                                                   "Please click a title to sort the activities by that value."));
        entryViewerButton.setTooltip(new Tooltip("Click here to view the Entries in the selected activity.\n" +
                                                 "Note: You must have clicked on an activity in the table for this button to be used."));
    }


    /**
     * Method to fill the table with the activities to display used by setUpScene as well as applyFilter.
     * @param displayActivities An <b>ArrayList&gt;Activity&lt;</b> to be displayed in the table.
     */
    private void populateTable(ObservableList<Activity> displayActivities)
    {
        activitiesTableView.setItems(displayActivities);
        activitiesTableView.refresh();
    }


    /**
     * Method to check weather a new activity is selected and if so call for the stats to be updated to reflect that activity.
     * Called when the table view is clicked with the mouse.
     */
    @FXML public void updateStatLabels()
    {
        if (activitiesTableView.getSelectionModel().getSelectedIndex() != currentIndex) {
            currentIndex = activitiesTableView.getSelectionModel().getSelectedIndex();
            setUpStatLabels(activitiesTableView.getSelectionModel().getSelectedItem());
        }

    }


    /**
     * Method to update the stat labels with their respective stats from the activity given.
     * @param selectedActivity an <b>Activity</b> to get the stats from.
     */
    private void setUpStatLabels(Activity selectedActivity)
    {
        distanceLabel.setText(selectedActivity.getDistanceKM().toString());
        durationLabel.setText(String.valueOf(selectedActivity.getDurationMins()));
        speedLabel.setText(selectedActivity.getSpeedKMH().toString());
        heartRateLabel.setText(String.valueOf(selectedActivity.getAverageHeartRate()));
    }


    /**
     * Method to check if an activity is selected and call the view graph screen if so, otherwise create a pop up error.
     * Called when the view graph button is selected.
     */
    @FXML private void viewGraph()
    {
        if(activitiesTableView.getSelectionModel().getSelectedItem() != null) {
            app.getTitleBar().openGraphs(activitiesTableView.getSelectionModel().getSelectedItem());
        } else {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Please select an Activity first");
        }
    }


    /**
     * Method to check if an activity is selected and call the view map screen if so, otherwise create a pop up error.
     * Called when the view map button is selected.
     */
    @FXML private void viewMap()
    {
        if(activitiesTableView.getSelectionModel().getSelectedItem() != null) {
            app.getTitleBar().openMap(activitiesTableView.getSelectionModel().getSelectedItem());
        } else {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Please select an Activity first");
        }
    }


    /**
     * Method to update table with activities between the two date pickers and of matching type
     * Called when the filterApplyButton is pressed.
     */
    @FXML public void applyFilter()
    {
        ArrayList<Activity> newActivities = new ArrayList<>();
        for(Activity profileActivity: app.getTitleBar().getCurrentProfile().getActivities()) {
            newActivities.add(profileActivity);
        }
        LocalDate lowerDate = startDate.getValue();
        LocalDate upperDate = endDate.getValue();
        String typeSelected = (String) typeSelect.getValue();
        DateTime lowerDateTime = null;
        DateTime upperDateTime = null;
        //Datetime check and creation
        if (lowerDate != null) {
            if(lowerDate.getYear() < 1900 || lowerDate.getYear() > 2100){
                app.createPopUp(Alert.AlertType.ERROR, "Error", "Please choose a lower date between 1900 and 2100");
            } else {
                lowerDateTime = new DateTime(lowerDate.getYear(), lowerDate.getMonthValue(), lowerDate.getDayOfMonth(), 0, 0, 1);
            }
        }
        if (upperDate != null) {
            if (upperDate.getYear() > 2100 || upperDate.getYear() < 1900) {
                app.createPopUp(Alert.AlertType.ERROR, "Error", "Please choose an upper date between 1900 and 2100");
            } else {
                upperDateTime = new DateTime(upperDate.getYear(), upperDate.getMonthValue(), upperDate.getDayOfMonth(), 23, 59, 59);
            }
        }
        if((lowerDateTime != null) && (upperDateTime != null)) {
            if(lowerDateTime.isAfter(upperDateTime)) {
                app.createPopUp(Alert.AlertType.ERROR, "Error", "Please make sure your lower date is earlier than your upper date");
                lowerDateTime = null;
                upperDateTime = null;
            }
        }

        ArrayList<Activity> badActivities = new ArrayList<>();

        //lower date filter
        if(lowerDateTime != null) {
            for(Activity checkActivity: newActivities) {
                if (checkActivity.getStartDateTime().isBefore(lowerDateTime)) {
                    badActivities.add(checkActivity);
                }
            }
        }
        //upper date filter
        if(upperDateTime != null) {
            for(Activity checkActivity: newActivities) {
                if (checkActivity.getEndDateTime().isAfter(upperDateTime)) {
                    badActivities.add(checkActivity);
                }
            }
        }
        //type filter
        if(!(typeSelected == null || typeSelected.equals("All"))) {
            for(Activity checkActivity: newActivities) {
                if (!(typeSelected.equals(checkActivity.getTypeString()))) {
                    badActivities.add(checkActivity);
                }
            }
        }
        //removal of activities, reload table
        newActivities.removeAll(badActivities);
        ObservableList<Activity> obsActivities = FXCollections.observableArrayList(newActivities);
        populateTable(obsActivities);
    }


    /**
     * Method called when the help button is pushed.
     * Displays the help text area.
     */
    @FXML private void displayHelp()
    {
        helpTextArea.setVisible(true);
        helpTextArea.requestFocus();
    }


    /**
     * Method called when focus to the help text area is lost or when the pane is clicked on.
     * Hides the help text area.
     */
    @FXML public void hideHelpTextArea()
    {
        helpTextArea.setVisible(false);
        helpButton.requestFocus();
    }


    /**
     * Method to reload the full table and clear filter selection when the clearFiltersButton is pressed
     */
    @FXML public void clearFilters()
    {
        ObservableList<Activity> activities = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getActivities());
        populateTable(activities);
        typeSelect.setValue(null);
        startDate.setValue(null);
        endDate.setValue(null);

    }


    /**
     * method to open the entryViewer screen with the selected activity when the entryViewerButton is pressed
     */
    @FXML public void openEntries()
    {
        if(activitiesTableView.getSelectionModel().getSelectedItem() != null) {
            app.getTitleBar().openEntry(activitiesTableView.getSelectionModel().getSelectedItem());
        } else {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Please select an Activity first");
        }
    }


    /**
     * Method to remove the currently selected Activity from the profile
     */
    @FXML public void deleteActivity()
    {
        if(activitiesTableView.getSelectionModel().getSelectedItem() != null) {
            Activity toDelete = activitiesTableView.getSelectionModel().getSelectedItem();
            app.getTitleBar().getCurrentProfile().deleteActivity(toDelete);
            app.getTitleBar().setUpWarningFlag();
        } else {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Please select an Activity first");
        }
        populateTable(FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getActivities()));
    }


    /**
     * Setter method to pass the GUIController into this controller.
     * @param guiController <b>GUIController:</b> The main controller.
     */
    public void setApp(GUIController guiController)
    {
        this.app = guiController;
    }
}
