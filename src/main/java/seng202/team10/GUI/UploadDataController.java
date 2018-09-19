package seng202.team10.GUI;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.*;
<<<<<<< HEAD
import seng202.team10.Model.Exceptions.DuplicateEntryException;
import seng202.team10.Model.Exceptions.ExistingActivityException;
import seng202.team10.Model.Exceptions.ExistingElementException;
=======
import seng202.team10.Model.DuplicateEntryException;
import seng202.team10.Model.ExistingActivityException;
import seng202.team10.Model.ExistingElementException;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.NoDataFoundException;
<<<<<<< HEAD
>>>>>>> 6e50a5fd... Added several alerts and pop up windows for different cases of parsing data
=======
>>>>>>> fa9df04... Added several alerts and pop up windows for different cases of parsing data
>>>>>>> 3228303f... Added several alerts and pop up windows for different cases of parsing data

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UploadDataController {

    private GUIController app;
    private Parser parser = new Parser();


    @FXML private TextField filePathTextField;
    @FXML private TableView<Entry> manualDataTableView;
    @FXML private TableColumn<Entry, String> dateColumn;
    @FXML private TableColumn<Entry, String> timeColumn;
    @FXML private TableColumn<Entry, String> heartRateColumn;
    @FXML private TableColumn<Entry, String> latitudeColumn;
    @FXML private TableColumn<Entry, String> longitudeColumn;
    @FXML private TableColumn<Entry, String> elevationColumn;
    @FXML private TextField activityNameTextField;
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
<<<<<<< HEAD
<<<<<<< HEAD
        //Set the values in the intensity ComboBox
        ObservableList<String> intensities = FXCollections.observableArrayList();
        intensities.add("Low");
        intensities.add("Medium");
        intensities.add("High");
        intensityComboBox.setItems(intensities);
        intensityComboBox.setVisibleRowCount(3);
        //Set up the columns in the table.
=======
        // Set the values in the intensity ComboBox
//        ObservableList<String> intensities = FXCollections.observableArrayList();
//        intensities.add("Walk");
//        intensities.add("Run");
//        intensities.add("Hike");
//        intensities.add("Cycle");
//        intensities.add("Swim");
//        intensities.add("Workout");
//        intensities.add("Other");
//        intensityComboBox.setItems(intensities);
//        intensityComboBox.setVisibleRowCount(3);
=======
<<<<<<< HEAD
>>>>>>> 6b17c394... refactored Activity to have start date time not set in the constructor but after the entries have been added. Changed all code using this functionality to make it a lot simpler. Also fixed the issue where data was not being saved properly after being uploaded, simply called to re serialize after each submission of manual data or file ulpoaded.
=======
>>>>>>> d6582a5... refactored Activity to have start date time not set in the constructor but after the entries have been added. Changed all code using this functionality to make it a lot simpler. Also fixed the issue where data was not being saved properly after being uploaded, simply called to re serialize after each submission of manual data or file ulpoaded.
>>>>>>> 57562dae... refactored Activity to have start date time not set in the constructor but after the entries have been added. Changed all code using this functionality to make it a lot simpler. Also fixed the issue where data was not being saved properly after being uploaded, simply called to re serialize after each submission of manual data or file ulpoaded.
        // Set up the columns in the table.
<<<<<<< HEAD
>>>>>>> 72a43850... Renamed ActivityIntensity to be ActivityType, fixed all methods and attributes of Activity to be directed to this and moved the determine type method into the ActivityType Enum. Also got rid of the ComboBox in the upload Data screen as the type is now determined from the name. Fixed a few bugs that this process created and found another unrelated bug in the process which i have created an issue for in git and put a TODO in the code for it.
=======
>>>>>>> ca7698b... Renamed ActivityIntensity to be ActivityType, fixed all methods and attributes of Activity to be directed to this and moved the determine type method into the ActivityType Enum. Also got rid of the ComboBox in the upload Data screen as the type is now determined from the name. Fixed a few bugs that this process created and found another unrelated bug in the process which i have created an issue for in git and put a TODO in the code for it.
>>>>>>> 8ff5c56f... Renamed ActivityIntensity to be ActivityType, fixed all methods and attributes of Activity to be directed to this and moved the determine type method into the ActivityType Enum. Also got rid of the ComboBox in the upload Data screen as the type is now determined from the name. Fixed a few bugs that this process created and found another unrelated bug in the process which i have created an issue for in git and put a TODO in the code for it.
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
        } catch(ArrayIndexOutOfBoundsException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Invalid date, please select a correct date format DD/MM/YYYY in between 1900-2100");
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
            entrySelected.setHeartRate(Integer.valueOf(editedCell.getNewValue().toString()));
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
            entrySelected.setLatitude(Double.valueOf(editedCell.getNewValue().toString()));
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
            entrySelected.setLongitude(Double.valueOf(editedCell.getNewValue().toString()));
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
            entrySelected.setElevation(Double.valueOf(editedCell.getNewValue().toString()));
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
     * // TODO make a catch for future dates.
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
            if (manualDataTableView.getItems().size() == 0) {
                newEntry.setFirstEntry(true);
                manualDataTableView.getItems().add(0, newEntry);
            } else {
                int index = 0;
                while (index < manualDataTableView.getItems().size() && newEntry.getTime().isAfter(manualDataTableView.getItems().get(index).getTime())) {
                    index++;
                }
                if (!(index == manualDataTableView.getItems().size()) && manualDataTableView.getItems().get(index).getTime().isEqual(newEntry.getTime())) {
                    throw new DuplicateEntryException();
                } else if (index == 0) {
                    newEntry.setFirstEntry(true);
                    manualDataTableView.getItems().get(0).setFirstEntry(false);
                    manualDataTableView.getItems().add(index, newEntry);
                } else {
                    manualDataTableView.getItems().add(index, newEntry);
                }
            }
        } catch(NumberFormatException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", "Invalid input, please only enter valid numbers");
        } catch(IllegalArgumentException | DuplicateEntryException exception) {
            createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
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
                ArrayList<String> fileContents = this.parser.getFileContents(filename);
                ArrayList<ArrayList<String>> formattedFile = this.parser.formatFileContents(fileContents);
                ArrayList<Activity> newActivities = this.parser.processFile(formattedFile);
                app.getCurrentProfile().addActivities(newActivities);
                app.getDataWriter().saveProfile(app.getCurrentProfile()); // Reserialize profile after adding data
                if (this.parser.getBadActivities() > 0) {
                    String discardedMessage = String.valueOf(this.parser.getBadActivities()) + " of " + String.valueOf(newActivities.size() + this.parser.getBadActivities()) + " activities found were discarded due to being unparsable";
                    createPopUp(Alert.AlertType.WARNING, "Warning", discardedMessage);
                }
                else {
                    createPopUp(Alert.AlertType.INFORMATION, "Success", String.valueOf(newActivities.size()) +" activities have been successfully uploaded to your profile");
                }
                //TODO have an option to cut to Data Viewer or to upload/input another File/Activity when one is submitted.
                //TODO this will require a custom pop up button (Low Priority).
            } catch (FileNotFoundException exception) {
                createPopUp(Alert.AlertType.ERROR, "Error", "File not found, please choose a valid csv file");
            } catch (ExistingElementException exception) {
                createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
            } catch (NoDataFoundException exception) {
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
        try {
            // Get name of activity
            String activityName = activityNameTextField.getText();
            if (manualDataTableView.getItems().size() < 2) {
                // If Entry list is empty send error
                createPopUp(Alert.AlertType.ERROR, "Entry Error", "You have not added enough Entries to the list");
            } else {
                // Else get date of first Entry
                ObservableList<Entry> currentEntries = manualDataTableView.getItems();
                // Create Activity
                Activity newActivity = new Activity(activityName);
                newActivity.setType(ActivityType.determineType(activityName));
                // Iterate over Entries and add them to Activity
                for (Entry entry: currentEntries) {
                    newActivity.addEntry(entry);
                }
                newActivity.postEntriesSetUp();
                // Add Activity to user profile.
                app.getCurrentProfile().addActivity(newActivity);
                // Reserialize profile after adding data
                app.getDataWriter().saveProfile(app.getCurrentProfile());
                // Display a success pop up
                createPopUp(Alert.AlertType.INFORMATION, "Success", "You have successfully created the activity \"" + activityName + "\"");
                // Reset table, text field and ComboBox to be blank
                clearTableView();
                activityNameTextField.setText("");
//                intensityComboBox.setValue(null);
                // TODO figure out why these cause errors in the graphs(only did it with one of size 2 though so that could be it)
            }
        } // Catch Exceptions and display error messages
        catch(IllegalArgumentException | ExistingActivityException exception) {
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

    @FXML public void openViewProfile() {
        moveDrawer();
        app.launchProfileScene();
    }

    @FXML public void openUploadData() {
        moveDrawer();
        app.launchUploadDataScene();
    }

    @FXML public void openViewActivities() throws Exception {
        moveDrawer();
        app.launchActivityViewerScene();
    }

    @FXML public void openGoals(){
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
