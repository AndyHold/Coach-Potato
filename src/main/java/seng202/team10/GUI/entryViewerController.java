package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Entry;

import java.util.ArrayList;


public class entryViewerController {

    private GUIController app;
    private Activity loadedActivity;

    @FXML private Label activityNameLabel;
    @FXML private TableView<Entry> entriesTableView;
    @FXML private TableColumn<Entry, String> dateColumn;
    @FXML private TableColumn<Entry, String> timeColumn;
    @FXML private TableColumn<Entry, String> heartRateColumn;
    @FXML private TableColumn<Entry, String> latitudeColumn;
    @FXML private TableColumn<Entry, String> longitudeColumn;
    @FXML private TableColumn<Entry, String> elevationColumn;
    @FXML private Button activityReturnButton;


    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene(Activity loadActivity){
        loadedActivity = loadActivity;
        activityNameLabel.setText(loadedActivity.getName());
        ObservableList<Entry> entries = FXCollections.observableArrayList(loadedActivity.getEntries());
        dateColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("dateString"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("timeString"));
        heartRateColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("heartRateString"));
        latitudeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("latitudeString"));
        longitudeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("longitudeString"));
        elevationColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("elevationString"));
        // Load entries array
        entriesTableView.setItems(entries);
        entriesTableView.setEditable(true);
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        timeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        heartRateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        latitudeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        longitudeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        elevationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
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
     * returns to the activityViewer when the activityReturnButton is pressed
     */
    @FXML public void returnToActivities() throws Exception{
        app.launchActivityViewerScene();
    }




    @FXML public void changeTimeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeTime(editedCell.getNewValue().toString());
    }


    @FXML public void changeDateCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeDate(editedCell.getNewValue().toString());
    }


    @FXML public void changeHeartRateCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeHeartRate(editedCell.getNewValue().toString());
    }


    @FXML public void changeLatitudeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeLatitude(editedCell.getNewValue().toString());
    }


    @FXML public void changeLongitudeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeLongitude(editedCell.getNewValue().toString());
    }


    @FXML public void changeElevationCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeElevation(editedCell.getNewValue().toString());
    }
}
