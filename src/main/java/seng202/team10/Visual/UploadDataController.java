package seng202.team10.Visual;

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
<<<<<<< HEAD
<<<<<<< HEAD
=======
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.Exceptions.NoDataFoundException;
>>>>>>> 3418f00... Merge remote-tracking branch 'origin/master'
import seng202.team10.Model.Exceptions.DuplicateEntryException;
import seng202.team10.Model.Exceptions.ExistingActivityException;
import seng202.team10.Model.Exceptions.ExistingElementException;
=======
import seng202.team10.Model.DuplicateEntryException;
import seng202.team10.Model.ExistingActivityException;
import seng202.team10.Model.ExistingElementException;
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.NoDataFoundException;
>>>>>>> fa9df04... Added several alerts and pop up windows for different cases of parsing data

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class UploadDataController {

    private GUIController app;
    private Parser parser = new Parser();
    private boolean firstTime = true;


    @FXML private TextField filePathTextField;
    @FXML private Button browseButton;
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    @FXML private VBox drawer;
<<<<<<< HEAD
=======
>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.

=======
    @FXML private Button helpButtonManualActivity;
    @FXML private Button helpButtonUploadFile;
    @FXML private Button uploadButton;
    @FXML private Button clearTableButton;
    @FXML private Button deleteEntryButton;
    @FXML private Button addEntryButton;
    @FXML private Button submitDataButton;
    @FXML private TextArea manualEntryHelpTextArea;
    @FXML private TextArea uploadFileHelpTextArea;
>>>>>>> c55beac... Added help button and tool tip functionality to the Upload Data screen

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
>>>>>>> d6582a5... refactored Activity to have start date time not set in the constructor but after the entries have been added. Changed all code using this functionality to make it a lot simpler. Also fixed the issue where data was not being saved properly after being uploaded, simply called to re serialize after each submission of manual data or file ulpoaded.
=======
        manualEntryHelpTextArea.setVisible(false);
        uploadFileHelpTextArea.setVisible(false);
        manualEntryHelpTextArea.setText("Welcome to the Manual Activity Entry Section!\n\nIn this section, you can manually enter each entry point of an activity along with the name of the activity. Each new entry will be added to the table in chronological order and prompts will be given for invalid data formats. If you wish to edit an existing entry just double click on it and enter the new value. Please remember to use the correct format when editing entries.\n\nHover the mouse over each button or field to see a brief discription of what it does.");
        uploadFileHelpTextArea.setText("Welcome to the Upload File Section!\n\nIn this section, you can select a .csv file to be uploaded. Simply type in the file path or click on the browse button (the button with the little picture of a folder on it) and navigate to your desired file. Then click the Upload File button and your file will be uploaded. A pop up will then be displayed to tell you how many Activities were succesfully uploaded to your profile.\n\nHover the mouse over each button or field to see a brief discription of what it does.");
        manualEntryHelpTextArea.setWrapText(true);
        uploadFileHelpTextArea.setWrapText(true);
        // Set tool tips for buttons
        browseButton.setTooltip(new Tooltip("Open a browser window to select your .csv file from"));
        helpButtonManualActivity.setTooltip(new Tooltip("Need Help?"));
        helpButtonUploadFile.setTooltip(new Tooltip("Need Help?"));
        uploadButton.setTooltip(new Tooltip("Upload the data from the selected file"));
        clearTableButton.setTooltip(new Tooltip("Clear the table of values to start again"));
        deleteEntryButton.setTooltip(new Tooltip("Delete the selected entry"));
        addEntryButton.setTooltip(new Tooltip("Add the entry you have input into the text fields"));
        submitDataButton.setTooltip(new Tooltip("Create the activity from the data in the table and add it to your profile"));
        // Set tool tips for text fields
        filePathTextField.setTooltip(new Tooltip("Please enter the file path of the file you wish to upload,\nE.g. \"Walk in the woods\""));
        activityNameTextField.setTooltip(new Tooltip("Please enter a name that describes your activity,\nE.g. \"Walk in the woods\""));
        dateTextField.setTooltip(new Tooltip("Please enter the date that your entry point was taken on,\nUsing the format DD/MM/YYYY"));
        timeTextField.setTooltip(new Tooltip("Please enter the time that your entry point was taken on,\nUsing the format HH:MM:SS in 24 hour time"));
        heartRateTextField.setTooltip(new Tooltip("Please enter your heart rate at the time of this entry point\nMust be an integer in the range 1 to 300"));
        latitudeTextField.setTooltip(new Tooltip("Please enter your latitude at the time of this entry\nMust be in the range -90.0 to 90.0\nPreferred accuracy is 6 decimal places"));
        longitudeTextField.setTooltip(new Tooltip("Please enter your latitude at the time of this entry\nMust be in the range -180.0 to 180.0\nPreferred accuracy is 6 decimal places"));
        elevationTextField.setTooltip(new Tooltip("Please enter your elevation at the time of this entry\nMust be in the range -430.0 to 8850.0\nPreferred accuracy is 2 decimal places"));
<<<<<<< HEAD
>>>>>>> c55beac... Added help button and tool tip functionality to the Upload Data screen
=======
        // Set tool tip for the table view.
        manualDataTableView.setTooltip(new Tooltip("This table shows the Entries you have already entered in chronological order.\nYou can double click on a value if you wish to edit it.\nPlease remember to use the correct format when editting values"));
>>>>>>> 7673868... Modified the text of one of the help text areas and made it so if clicked anywhere outside the text area it is hiden.
        // Set up the columns in the table.
>>>>>>> ca7698b... Renamed ActivityIntensity to be ActivityType, fixed all methods and attributes of Activity to be directed to this and moved the determine type method into the ActivityType Enum. Also got rid of the ComboBox in the upload Data screen as the type is now determined from the name. Fixed a few bugs that this process created and found another unrelated bug in the process which i have created an issue for in git and put a TODO in the code for it.
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

        // Set the focus to the browse button on entry
        filePathTextField.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
            if(newValue && firstTime){
                browseButton.requestFocus(); // Delegate the focus to container
                firstTime = false; // Variable value changed for future references
            }
        });

        // Hide the help text fields when focus is lost
        manualEntryHelpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                manualEntryHelpTextArea.setVisible(false);
            }
        });

        uploadFileHelpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                uploadFileHelpTextArea.setVisible(false);
            }
        });
    }


    @FXML public void hideHelpTextAreas()
    {
        manualEntryHelpTextArea.setVisible(false);
        uploadFileHelpTextArea.setVisible(false);
        browseButton.requestFocus();
    }


    @FXML public void manualActivityHelp()
    {
        manualEntryHelpTextArea.setVisible(true);
        manualEntryHelpTextArea.requestFocus();
    }


    @FXML public void uploadFileHelp()
    {
        uploadFileHelpTextArea.setVisible(true);
        uploadFileHelpTextArea.requestFocus();
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
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Time invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
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
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Date invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
        } catch(ArrayIndexOutOfBoundsException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Invalid date, please select a correct date format DD/MM/YYYY in between 1900-2100");
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
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "HeartRate invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
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
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Latitude invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
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
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Longitude invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
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
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Elevation invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
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
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Invalid input, please only enter valid numbers");
        } catch(IllegalArgumentException | DuplicateEntryException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
        }
    }


    /**
     * Method to upload data from a file when the upload data button is pushed
     */
    @FXML public void uploadData()
    {
        String filename = filePathTextField.getText();
        if (filename.length() == 0) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "No file path, please select a csv file");
        } else {
            try {
                ArrayList<String> fileContents = this.parser.getFileContents(filename);
                ArrayList<ArrayList<String>> formattedFile = this.parser.formatFileContents(fileContents);
                ArrayList<Activity> newActivities = this.parser.processFile(formattedFile);
                app.getCurrentProfile().addActivities(newActivities);
                app.getDataWriter().saveProfile(app.getCurrentProfile()); // Reserialize profile after adding data
                if (this.parser.getBadActivities() > 0) {
                    String discardedMessage = String.valueOf(this.parser.getBadActivities()) + " of " + String.valueOf(newActivities.size() + this.parser.getBadActivities()) + " activities found were discarded due to being unparsable";
                    this.app.createPopUp(Alert.AlertType.WARNING, "Warning", discardedMessage);
                }
                else {
                    this.app.createPopUp(Alert.AlertType.INFORMATION, "Success", String.valueOf(newActivities.size()) +" activities have been successfully uploaded to your profile");
                }
                //TODO have an option to cut to Data Viewer or to upload/input another File/Activity when one is submitted.
                //TODO this will require a custom pop up button (Low Priority).
            } catch (FileNotFoundException exception) {
                this.app.createPopUp(Alert.AlertType.ERROR, "Error", "File not found, please choose a valid csv file");
            } catch (ExistingElementException | NoDataFoundException exception) {
                this.app.createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
            }
        }
    }

<<<<<<< HEAD
=======

    /**
     * Method to create an Activity object from the entries input by the user and add it to the User Profile when the Submit Data button is pushed
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> b21c354... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
    @FXML public void submitData()
    {
        try {
            // Get name of activity
            String activityName = activityNameTextField.getText();
            if (manualDataTableView.getItems().size() < 2) {
                // If Entry list is empty send error
                this.app.createPopUp(Alert.AlertType.ERROR, "Entry Error", "You have not added enough Entries to the list");
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
                this.app.createPopUp(Alert.AlertType.INFORMATION, "Success", "You have successfully created the activity \"" + activityName + "\"");
                // Reset table, text field and ComboBox to be blank
                clearTableView();
                activityNameTextField.setText("");
//                intensityComboBox.setValue(null);
                // TODO figure out why these cause errors in the graphs(only did it with one of size 2 though so that could be it)
            }
        } // Catch Exceptions and display error messages
        catch(IllegalArgumentException | ExistingActivityException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Data Error", exception.getMessage());
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
            this.app.createPopUp(Alert.AlertType.ERROR, "Entry Table Error", "No Entry was selected from the table");
        }
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    }

    @FXML private void drawerAction() {

<<<<<<< HEAD
=======
    /**
     * Method to draw the navigation drawer.
     */
    @FXML private void drawerAction()
    {

>>>>>>> 8a6e898... Wrote JavaDoc for the menu button and bar on most of the main controllers and also for few methods that were pending.
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        //setUpScene();
        //app.launchAnalysisScene();
=======
>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
        setUpScene();
>>>>>>> 63c2d62... Uncommented the launchDataAnalysis method and refactored some duplicate code into a method.
=======
        setUpScene();
>>>>>>> 82bc121... Uncommented the launchDataAnalysis method and refactored some duplicate code into a method.
=======
        setUpScene();
>>>>>>> ee3e10f... Uncommented the launchDataAnalysis method and refactored some duplicate code into a method.
=======
        setUpScene();
>>>>>>> 54f11f8... Uncommented the launchDataAnalysis method and refactored some duplicate code into a method.
    }
}
