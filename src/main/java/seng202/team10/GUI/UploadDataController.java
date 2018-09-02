package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Position;

import java.io.File;

public class UploadDataController {

    private GUIController app;


    @FXML private TextField filePathTextField;
    @FXML private Button browseButton;
    @FXML private Button uploadButton;
    @FXML private TableView<Entry> manualDataTableView;
    @FXML private TableColumn<Entry, String> dateColumn;
    @FXML private TableColumn<Entry, String> timeColumn;
    @FXML private TableColumn<Entry, String> heartRateColumn;
    @FXML private TableColumn<Entry, String> latitudeColumn;
    @FXML private TableColumn<Entry, String> longitudeColumn;
    @FXML private TableColumn<Entry, String> elevationColumn;
    @FXML private Button submitDataButton;
    @FXML private TextField activityNameTextField;
    @FXML private ComboBox intensityComboBox;
    @FXML private TextField dateTextField;
    @FXML private TextField timeTextField;
    @FXML private TextField heartRateTextField;
    @FXML private TextField latitudeTextField;
    @FXML private TextField longitudeTextField;
    @FXML private TextField elevationTextField;
    @FXML private Button addEntryButton;


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene()
    {

        //Set the values in the intensity ComboBox
        ObservableList<String> intensities = FXCollections.observableArrayList();
        intensities.add("Low");
        intensities.add("Medium");
        intensities.add("High");
        intensityComboBox.setItems(intensities);
        intensityComboBox.setVisibleRowCount(3);
        //Set up the columns in the table.
        dateColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("dateString"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("timeString"));
        heartRateColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("heartRateString"));
        latitudeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("latitudeString"));
        longitudeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("longitudeString"));
        elevationColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("elevationString"));
        //load dummy data
        manualDataTableView.setItems(getEntries());
        // Update the table to allow the columns to be editable
        manualDataTableView.setEditable(true);
        dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        timeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        heartRateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        latitudeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        longitudeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        elevationColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }


    @FXML public void changeTimeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeTime(editedCell.getNewValue().toString());
    }


    @FXML public void changeDateCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeDate(editedCell.getNewValue().toString());
    }


    @FXML public void changeHeartRateCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeHeartRate(editedCell.getNewValue().toString());
    }


    @FXML public void changeLatitudeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeLatitude(editedCell.getNewValue().toString());
    }


    @FXML public void changeLongitudeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeLongitude(editedCell.getNewValue().toString());
    }


    @FXML public void changeElevationCellEvent(TableColumn.CellEditEvent editedCell)
    {
        //NEED TO ERROR CHECK THE INPUT VALUE HERE
        Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
        entrySelected.changeElevation(editedCell.getNewValue().toString());
    }


    public ObservableList<Entry> getEntries()
    {
        ObservableList<Entry> entries = FXCollections.observableArrayList();
        entries.add(new Entry(true, new DateTime(1900, 10, 2, 2, 2, 2), 80, new Position(-43.5222767, 172.5809189, 14.0)));
        return entries;
    }



    @FXML public void addEntryToTableView()
    {
        // NEED TO ERROR CHECK THIS
        String date = dateTextField.getText();
        String[] dateArray = date.split("/");
        int year = Integer.valueOf(dateArray[2]);
        int month = Integer.valueOf(dateArray[1]);
        int day = Integer.valueOf(dateArray[0]);
        String time = timeTextField.getText();
        String[] timeArray = time.split(":");
        int hour = Integer.valueOf((timeArray[0]));
        int minute = Integer.valueOf((timeArray[1]));
        int second = Integer.valueOf((timeArray[2]));
        double heartRate = Double.valueOf(heartRateTextField.getText());
        double latitude = Double.valueOf(latitudeTextField.getText());
        double longitude = Double.valueOf(longitudeTextField.getText());
        double elevation = Double.valueOf(elevationTextField.getText());
        Entry newEntry = new Entry(false, new DateTime(year, month, day, hour, minute, second), heartRate, new Position(latitude, longitude, elevation));
        manualDataTableView.getItems().add(newEntry);
    }


    @FXML public void uploadData()
    {
        // NEED TO SORT ERROR HANDLING
        // this.app.getCurrentProfile().uploadFile(filePathTextField.getText());

    }


    @FXML public void submitData()
    {
        //
    }


    @FXML public void browse()
    {
        // Create a file chooser
        FileChooser fileChooser = new FileChooser();
        // Get the selected file
        File selectedFile = fileChooser.showOpenDialog(null);
        // Check if the file is null
        if (selectedFile != null) {
            filePathTextField.setText(selectedFile.getAbsolutePath());
        }
//        else {
//            Alert errorPopUp = new Alert(Alert.AlertType.ERROR);
//            errorPopUp.setTitle("ERROR");
//            errorPopUp.setContentText("File does not exist or is corrupted!");
//            errorPopUp.setHeaderText(null);
//            errorPopUp.showAndWait();
//        }

    }
}
