package seng202.team10.GUI;

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
    @FXML private TableColumn<Activity, String> typeColumn;
    @FXML private TableColumn<Activity, String> starttimeColumn;
    @FXML private TableColumn<Activity, String> durationColumn;
    @FXML private TableColumn<Activity, String> speedColumn;
    @FXML private TableColumn<Activity, String> distanceColumn;
    @FXML private TableColumn<Activity, String> heartrateColumn;
    @FXML private TableColumn<Activity, String> entrynoColumn;
    @FXML private Button entryViewerButton;
    @FXML private ComboBox typeSelect;
    @FXML private VBox drawer;

    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene() {
        ObservableList<String> types = FXCollections.observableArrayList();
        types.add("walk");
        types.add("run");
        types.add("hike");
        types.add("cycle");
        types.add("swim");
        types.add("workout");
        types.add("other");
        typeSelect.setItems(types);
        typeSelect.setVisibleRowCount(7);
        ObservableList<Activity> activities = FXCollections.observableArrayList(app.getCurrentProfile().getActivities());
        nameColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("typeString"));
        starttimeColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("timeString"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("durationString"));
        speedColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("speedString"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("distanceString"));
        heartrateColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("heartString"));
        entrynoColumn.setCellValueFactory(new PropertyValueFactory<Activity, String>("entrynoString"));
        populateTable(activities);

    }

    /**
     * fills the table with the activities to display. used by setUpScene as well as applyFilter
     * @param displayActivities the arraylist of activity objects to be displayed in the table
     */
    private void populateTable(ObservableList<Activity> displayActivities){
        activitiesTableView.setItems(displayActivities);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        starttimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        durationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        speedColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        distanceColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        heartrateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        entrynoColumn.setCellFactory(TextFieldTableCell.forTableColumn());

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
        if(activitiesTableView.getSelectionModel().getSelectedItem() != null) {
            app.launchEntryViewerScene(app.getCurrentProfile().getActivities().get(activitiesTableView.getSelectionModel().getSelectedIndex()));
        } else {
            createPopUp(Alert.AlertType.ERROR, "Error", "Please select an Activity first");
        }
    }

    private void createPopUp(Alert.AlertType type, String title, String message)
    {
        Alert errorPopUp = new Alert(type);
        errorPopUp.setTitle(title);
        errorPopUp.setContentText(message);
        errorPopUp.setHeaderText(null);
        errorPopUp.showAndWait();
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
