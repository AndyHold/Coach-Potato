package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.UserProfile;

import java.time.LocalDate;
import java.util.ArrayList;

public class ActivityViewerController {

    private GUIController app;

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
        // Set up help text area
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

        ObservableList<String> types = FXCollections.observableArrayList();
        types.add("All");
        types.add("Walk");
        types.add("Run");
        types.add("Hike");
        types.add("Cycle");
        types.add("Swim");
        types.add("Workout");
        types.add("Other");
        typeSelect.setItems(types);
        typeSelect.setVisibleRowCount(8);
        ObservableList<Activity> activities = FXCollections.observableArrayList(app.getCurrentProfile().getActivities());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("typeString"));
        starttimeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("timeString"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Activity, Double>("DurationMins"));
        speedColumn.setCellValueFactory(new PropertyValueFactory<Activity, Double>("SpeedKMH"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<Activity, Double>("DistanceKM"));
        heartrateColumn.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("averageHeartRate"));
        entrynoColumn.setCellValueFactory(new PropertyValueFactory<Activity, Integer>("entryno"));
        populateTable(activities);

        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }

    /**
     * method to fill the table with the activities to display. used by setUpScene as well as applyFilter
     * @param displayActivities the arraylist of activity objects to be displayed in the table
     */
    private void populateTable(ObservableList<Activity> displayActivities)
    {
        activitiesTableView.setItems(displayActivities);
//        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        starttimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        durationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        speedColumn.setCellFactory(TextFieldTableCell.forTableColumn());
////        distanceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        heartrateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        entrynoColumn.setCellFactory(TextFieldTableCell.forTableColumn());

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
            DateTime lowerDateTime = new DateTime(lowerDate.getYear(), lowerDate.getMonthValue(), lowerDate.getDayOfMonth(), 0, 0, 1);
            DateTime upperDateTime = new DateTime(upperDate.getYear(), upperDate.getMonthValue(), upperDate.getDayOfMonth(), 23, 59, 59);
            for (Activity eachActivity : app.getCurrentProfile().getActivities()) {
                if (lowerDateTime.isBefore(eachActivity.getStartDateTime()) && upperDateTime.isAfter(eachActivity.getStartDateTime())) {
                    dateFiltered.add(eachActivity);
                }
            }
        } else {
            dateFiltered = app.getCurrentProfile().getActivities();
        }
        ArrayList<Activity> typeFiltered = new ArrayList<>();
        for (Activity eachActivity : dateFiltered) {
            if (typeSelected == null || typeSelected == "All" || typeSelected == eachActivity.getTypeString()) {
                typeFiltered.add(eachActivity);
            }
        }
        ObservableList<Activity> newActivities = FXCollections.observableArrayList(typeFiltered);
        populateTable(newActivities);
    }


    @FXML private void displayHelp()
    {
        helpTextArea.setVisible(true);
        helpTextArea.requestFocus();
    }


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
        ObservableList<Activity> activities = FXCollections.observableArrayList(app.getCurrentProfile().getActivities());
        populateTable(activities);
        typeSelect.setValue(null);
        startDate.setValue(null);
        endDate.setValue(null);

    }

    /**
     * method to open the entryViewer screen with the selected activity when the entryViewerButton is pressed
     */
    @FXML public void openEntries() throws Exception
    {
        if(activitiesTableView.getSelectionModel().getSelectedItem() != null) {
            app.launchEntryViewerScene(activitiesTableView.getSelectionModel().getSelectedItem());
        } else {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Please select an Activity first");
        }
    }

<<<<<<< HEAD
=======
    /**
     * method to create a popup to display a message
     * @param type the type of alert (often error)
     * @param title the title of the popup box
     * @param message the text in the popup
     */
    private void createPopUp(Alert.AlertType type, String title, String message)
    {
        Alert errorPopUp = new Alert(type);
        errorPopUp.setTitle(title);
        errorPopUp.setContentText(message);
        errorPopUp.setHeaderText(null);
        errorPopUp.showAndWait();
    }
<<<<<<< HEAD
>>>>>>> 14d13f79... Clear filters button properly reloads the table and clears filter selections
=======
>>>>>>> debfc12... Clear filters button properly reloads the table and clears filter selections
>>>>>>> 304a880b... Clear filters button properly reloads the table and clears filter selections

    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * Method to draw the navigation drawer.
     */
    @FXML private void drawerAction()
    {

        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        if (drawer.getTranslateX() != 0) {
            openNav.play();
        } else {
            closeNav.setToX(-(drawer.getWidth()));
            closeNav.play();
        }
    }
    /**
     * Method to launch the login scene.
     */
    @FXML public void openChooseProfile() throws Exception
    {
        moveDrawer();
        app.launchLoginScene();
    }

    /**
     * Method to launch the view profile scene.
     */
    @FXML public void openViewProfile() throws Exception
    {
        moveDrawer();
        app.launchProfileScene();
    }

    /**
     * Method to launch the upload data scene.
     */
    @FXML public void openUploadData() throws Exception
    {
        moveDrawer();
        app.launchUploadDataScene();
    }

    /**
     * Method to launch the view activities scene.
     */
    @FXML public void openViewActivities() throws Exception
    {
        moveDrawer();
        app.launchActivityViewerScene();
    }

    /**
     * Method to launch the goals scene.
     */
    @FXML public void openGoals() throws Exception
    {
        moveDrawer();
        app.launchGoalsScene();
    }

    /**
     * Method to launch the data analysis scene.
     */
    @FXML public void openAnalysis() throws Exception
    {
        moveDrawer();
        app.launchDataAnalysisScene();
    }

    /**
     * Method to move the navigation drawer as appropriate.
     */
    private void moveDrawer()
    {
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        closeNav.setToX(-(drawer.getWidth()));
        closeNav.play();
        setUpScene();
    }
}
