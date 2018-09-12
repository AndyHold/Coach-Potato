package seng202.team10.GUI;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
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
    @FXML private VBox drawer;

    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene() {
        //populateTable(app.getCurrentProfile().getActivities());

        ObservableList<Activity> activities = FXCollections.observableArrayList(app.getCurrentProfile().getActivities());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("nameString"));
        starttimeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("timeString"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("durationString"));
        speedColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("speedString"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("distanceString"));
        heartrateColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("heartString"));
        entrynoColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("entrynoString"));

        activitiesTableView.setItems(activities);

        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        starttimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        durationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        speedColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        distanceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        heartrateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        entrynoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    /**
     * fills the table with the activities to display. used by setUpScene as well as applyFilter
     * @param displayActivities the arraylist of activity objects to be displayed in the table
     */
    private void populateTable(ArrayList<Activity> displayActivities){


    }

    /**
     * updates table with entries between the two datepickers when the filterApplyButton is pressed
     */
    @FXML public void applyFilter(){
        // TODO get startdate and enddate from datepickers
        // TODO add a dropdown for a specific type of activity
        // TODO create new activitylist from activities in profile that match filters
        // TODO pass new activities into populate table

    }


    /**
     * opens the entryViewer screen with the selected activity when the entryViewerButton is pressed
     */
    @FXML public void openEntries() throws Exception{
        //TODO set currentActivity to the currently selected row of the table
        Activity currentActivity = app.getCurrentProfile().getActivities().get(1);
        app.launchEntryViewerScene(currentActivity);
    }


    /**
     * opens the routemap screen for the selected activity when the openMap button is pressed
     */
    @FXML public void openMap(){
        // TODO open a map screen with the selected activity to view routemap
    }


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * the menu
     */
    @FXML private void drawerAction() {

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

    @FXML public void openChooseProfile() throws Exception {
        moveDrawer();
        app.launchLoginScene();
    }

    @FXML public void openViewProfile() throws Exception {
        moveDrawer();
        app.launchProfileScene();
    }

    @FXML public void openUploadData() throws Exception {
        moveDrawer();
        app.launchUploadDataScene();
    }

    @FXML public void openViewActivities() throws Exception {
        moveDrawer();
        app.launchActivityViewerScene();
    }

    @FXML public void openGoals() throws Exception {
        moveDrawer();
        app.launchGoalsScene();
    }

    @FXML public void openAnalysis() throws Exception {
        moveDrawer();
        app.launchDataAnalysisScene();
    }

    private void moveDrawer() {
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        closeNav.setToX(-(drawer.getWidth()));
        closeNav.play();
        setUpScene();
    }
}
