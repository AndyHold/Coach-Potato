package seng202.team10.GUI;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.*;
import seng202.team10.Model.DuplicateEntryException;
import seng202.team10.Model.ExistingActivityException;
import seng202.team10.Model.ExistingElementException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UploadDataController {

    private GUIController app;


    @FXML private TextField filePathTextField;
    @FXML private TableView<Entry> manualDataTableView;
    @FXML private TableColumn<Entry, String> dateColumn;
    @FXML private TableColumn<Entry, String> timeColumn;
    @FXML private TableColumn<Entry, String> heartRateColumn;
    @FXML private TableColumn<Entry, String> latitudeColumn;
    @FXML private TableColumn<Entry, String> longitudeColumn;
    @FXML private TableColumn<Entry, String> elevationColumn;
    @FXML private TextField activityNameTextField;
    @FXML private ComboBox intensityComboBox;
    @FXML private TextField dateTextField;
    @FXML private TextField timeTextField;
    @FXML private TextField heartRateTextField;
    @FXML private TextField latitudeTextField;
    @FXML private TextField longitudeTextField;
    @FXML private TextField elevationTextField;

    @FXML private VBox drawer;


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


    /**
     * Method to change the time of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeTimeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
            entrySelected.changeTime(editedCell.getNewValue().toString());
        } catch(NumberFormatException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Time invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            createPopUp(Alert.AlertType.ERROR, "Error", message);
        }
    }


    /**
     * Method to change the date of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeDateCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
            entrySelected.changeDate(editedCell.getNewValue().toString());
        }  catch(NumberFormatException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Date invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            createPopUp(Alert.AlertType.ERROR, "Error", message);
        }
    }


    /**
     * Method to change the Heart Rate of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeHeartRateCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
            entrySelected.changeHeartRate(editedCell.getNewValue().toString());
        } catch(NumberFormatException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "HeartRate invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            createPopUp(Alert.AlertType.ERROR, "Error", message);
        }
    }


    /**
     * Method to change the Latitude of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeLatitudeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
            entrySelected.changeLatitude(editedCell.getNewValue().toString());
        } catch(NumberFormatException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Latitude invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            createPopUp(Alert.AlertType.ERROR, "Error", message);
        }

    }


    /**
     * Method to change the Longitude of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeLongitudeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
            entrySelected.changeLongitude(editedCell.getNewValue().toString());
        } catch(NumberFormatException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Longitude invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            createPopUp(Alert.AlertType.ERROR, "Error", message);
        }

    }


    /**
     * Method to change the Elevation of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeElevationCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = manualDataTableView.getSelectionModel().getSelectedItem();
            entrySelected.changeElevation(editedCell.getNewValue().toString());
        } catch(NumberFormatException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Elevation invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            createPopUp(Alert.AlertType.ERROR, "Error", message);
        }
    }


    /**
     * Method to create an ObservableList<Entry> object for the TableView
     * @return ObservableList<Entry>
     */
    public ObservableList<Entry> getEntries()
    {
        ObservableList<Entry> entries = FXCollections.observableArrayList();
        return entries;
    }


    /**
     * Method to add an entry input by the user when the add entry button is pushed
     */
    @FXML public void addEntryToTableView()
    {
        try {
            String date = dateTextField.getText();
            String time = timeTextField.getText();
            DateTime dateTime = app.getParser().parseDateTimeFromStrings(date, time);
            int heartRate = Integer.valueOf(heartRateTextField.getText());
            double latitude = Double.valueOf(latitudeTextField.getText());
            double longitude = Double.valueOf(longitudeTextField.getText());
            double elevation = Double.valueOf(elevationTextField.getText());boolean firstEntry = false;
            Entry newEntry = new Entry(dateTime, heartRate, new Position(latitude, longitude, elevation));
//            if (manualDataTableView.getItems().size() == 0) {
//                newEntry.setFirstEntry(true);
//                manualDataTableView.getItems().add(0, newEntry);
//            } else {
//                int index = 0;
//                while (index < manualDataTableView.getItems().size() && newEntry.getTime().isAfter(manualDataTableView.getItems().get(index).getTime())) {
//                    index++;
//                }
//                if (manualDataTableView.getItems().get(index).getTime().isEqual(newEntry.getTime())) {
//                    throw new DuplicateEntryException();
//                } else if (index == 0) {
//                    newEntry.setFirstEntry(true);
//                    manualDataTableView.getItems().get(0).setFirstEntry(false);
//                    manualDataTableView.getItems().add(index, newEntry);
//                }
//            }
        } catch(NumberFormatException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Invalid input, please only enter valid numbers");
        } catch(IllegalArgumentException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
//        } catch(DuplicateEntryException exception) {
//            createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
        }
    }


    /**
     * Method to upload data from a file when the upload data button is pushed
     */
    @FXML public void uploadData()
    {
        String filename = filePathTextField.getText();
        if (filename.length() == 0) {
            createPopUp(Alert.AlertType.ERROR, "Error", "No file path, please select a csv file");
        } else {
            try {
                ArrayList<String> fileContents = app.getParser().getFileContents(filename);
                ArrayList<ArrayList<String>> formattedFile = app.getParser().formatFileContents(fileContents);
                ArrayList<Activity> newActivities = app.getParser().processFile(formattedFile);
                app.getCurrentProfile().addActivities(newActivities);
                createPopUp(Alert.AlertType.INFORMATION, "Success", "Your file has been successfully uploaded to your profile");
                //TODO need to add data to table instead of uploading straight to profile. Confirmation message for clearing table.
            } catch (FileNotFoundException exception) {
                createPopUp(Alert.AlertType.ERROR, "Error", "File not found, please choose a valid csv file");
            } catch (ExistingElementException exception) {
                createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
            }
        }
    }

<<<<<<< HEAD
=======

    /**
     * Method to create an Activity object from the entries input by the user and add it to the User Profile when the Submit Data button is pushed
     */
>>>>>>> 73cd1563... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
    @FXML public void submitData()
    {
        //TODO Check if data is already in the profile before uploading.
        try {
            // Get name of activity
            String activityName = activityNameTextField.getText();
            // Check an intensity has been chosen
            if (intensityComboBox.getValue() == null) {
                // If not send error message
                createPopUp(Alert.AlertType.ERROR, "Activity Intensity Error", "Please choose an activity intensity");
            } else {
                // Else get the intensity
                String intensityString = (String) intensityComboBox.getValue();
                ActivityIntensity activityIntensity = ActivityIntensity.getIntensityFromString(intensityString);
                // Check Entry list is not empty
                if (manualDataTableView.getItems().size() == 0) {
                    // If Entry list is empty send error
                    createPopUp(Alert.AlertType.ERROR, "Entry Error", "You have not added any Entries to the list");
                } else {
                    // Else get date of first Entry
                    ObservableList<Entry> currentEntries = manualDataTableView.getItems();
                    DateTime startDateTime = currentEntries.get(0).getTime();
                    // Create Activity
                    Activity newActivity = new Activity(activityName, startDateTime);
                    // newActivity.setIntensity(activityIntensity);
                    // Iterate over Entries and add them to Activity
                    for (Entry entry: currentEntries) {
                        newActivity.addEntry(entry);
                    }
                    // Add Activity to user profile.
                    app.getCurrentProfile().addActivity(newActivity);
                    createPopUp(Alert.AlertType.INFORMATION, "Success", "You have successfully created the activity \"" + activityName + "\"");
                    clearTableView();
                    activityNameTextField.setText("");
                    intensityComboBox.setValue(null);
                }
            }
        }
        catch(IllegalArgumentException exception) {
            createPopUp(Alert.AlertType.ERROR, "Data Error", exception.getMessage());
        }
        catch(ExistingActivityException exception) {
            createPopUp(Alert.AlertType.ERROR, "Data Error", exception.getMessage());
        }
    }


    /**
     * Method to clear the TableView of current Entries when the Clear Table button is pushed
     */
    @FXML public void clearTableView()
    {
        for (int i = manualDataTableView.getItems().size() - 1; i >= 0; i--) {
            manualDataTableView.getItems().remove(0);
        }
    }


    /**
     * Method to delete the selected entry from the table when the Delete Entry button is pushed
     */
    @FXML public void deleteEntryFromTableView()
    {
        try {
            int index = manualDataTableView.getSelectionModel().getSelectedIndex();
            manualDataTableView.getItems().remove(index);
        } catch(ArrayIndexOutOfBoundsException ex) {
            createPopUp(Alert.AlertType.ERROR, "Entry Table Error", "No Entry was selected from the table");
        }
    }


    /**
     * Method to display a pop up window with a title a message and a type (depending on if you want an error or information etc)
     * @param type Alert.AlertType: type of alert
     * @param title String: Title of pop up window
     * @param message String: Message to display to user
     */
    private void createPopUp(Alert.AlertType type, String title, String message)
    {
        Alert errorPopUp = new Alert(type);
        errorPopUp.setTitle(title);
        errorPopUp.setContentText(message);
        errorPopUp.setHeaderText(null);
        errorPopUp.showAndWait();
    }


    /**
     * Method to open a browse window to select a file and input the URL to the File Select Text Field
     */
    @FXML public void browse()
    {
        // Create a file chooser
        FileChooser fileChooser = new FileChooser();
        // Set Filter to only accept .csv files
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("CSV FILES (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(filter);
        // Get the selected file
        File selectedFile = fileChooser.showOpenDialog(null);
        // Check if the file is null
        if (selectedFile != null) {
            filePathTextField.setText(selectedFile.getAbsolutePath());
        }
    }

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
