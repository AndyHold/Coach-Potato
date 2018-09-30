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

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Activity Viewer Controller Class for Coach Potato SENG202 2018S2
 */
public class ActivityViewerController {

    private GUIController app;
    private ObservableList<String> types;
    private ObservableList<Activity> activities;

    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private Button filterApplyButton;
    @FXML private Button clearFiltersButton;
    @FXML private TableView<Activity> activitiesTableView;
    @FXML private TableColumn<Activity, String> nameColumn;
    @FXML private TableColumn<Activity, String> typeColumn;
    @FXML private TableColumn<Activity, String> starttimeColumn;
    @FXML private TableColumn<Activity, Double> durationColumn;
    @FXML private TableColumn<Activity, Double> speedColumn;
    @FXML private TableColumn<Activity, Double> distanceColumn;
    @FXML private TableColumn<Activity, Integer> heartrateColumn;
    @FXML private TableColumn<Activity, Integer> entrynoColumn;
    @FXML private Button entryViewerButton;
    @FXML private Button helpButton;
    @FXML private TextArea helpTextArea;
    @FXML private ComboBox typeSelect;
    @FXML private VBox drawer;


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
    }


    /**
     * Set up method for the elements in the table view.
     */
    private void setUpTableView()
    {
        activities = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getActivities());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("typeString"));
        starttimeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("timeString"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Activity, Double>("DurationMins"));
        speedColumn.setCellValueFactory(new PropertyValueFactory<Activity, Double>("SpeedKMH"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<Activity, Double>("DistanceKM"));
        heartrateColumn.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("averageHeartRate"));
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
     * method to fill the table with the activities to display. used by setUpScene as well as applyFilter
     * @param displayActivities the arraylist of activity objects to be displayed in the table
     */
    private void populateTable(ObservableList<Activity> displayActivities)
    {
        activitiesTableView.setItems(displayActivities);
    }

    /**
     * Method to update table with activities between the two datepickers and of matching type when the filterApplyButton is pressed
     */
    @FXML public void applyFilter()
    {
        ArrayList<Activity> dateFiltered = new ArrayList<>();
        LocalDate lowerDate = startDate.getValue();
        LocalDate upperDate = endDate.getValue();
        String typeSelected = (String) typeSelect.getValue();
        if (lowerDate != null && upperDate != null) {
            if(lowerDate.getYear() < 1900 || lowerDate.getYear() > 2100 || upperDate.getYear() > 2100 || upperDate.getYear() < 1900 || lowerDate.getYear() > upperDate.getYear()){
                app.createPopUp(Alert.AlertType.ERROR, "Error", "Please choose dates between 1900 and 2100, and make sure the first date is earlier than the second");
                dateFiltered = app.getTitleBar().getCurrentProfile().getActivities();
            } else {
                DateTime lowerDateTime = new DateTime(lowerDate.getYear(), lowerDate.getMonthValue(), lowerDate.getDayOfMonth(), 0, 0, 1);
                DateTime upperDateTime = new DateTime(upperDate.getYear(), upperDate.getMonthValue(), upperDate.getDayOfMonth(), 23, 59, 59);
                for (Activity eachActivity : app.getTitleBar().getCurrentProfile().getActivities()) {
                    if (lowerDateTime.isBefore(eachActivity.getStartDateTime()) && upperDateTime.isAfter(eachActivity.getStartDateTime())) {
                        dateFiltered.add(eachActivity);
                    }
                }
            }
        } else {
            dateFiltered = app.getTitleBar().getCurrentProfile().getActivities();
        }
        ArrayList<Activity> typeFiltered = new ArrayList<>();
        for (Activity eachActivity : dateFiltered) {
            if (typeSelected == null || typeSelected.equals("All") || typeSelected.equals(eachActivity.getTypeString())) {
                typeFiltered.add(eachActivity);
            }
        }
        ObservableList<Activity> newActivities = FXCollections.observableArrayList(typeFiltered);
        populateTable(newActivities);
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
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }
}
