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
import seng202.team10.Model.FileOperations.Parser;
import seng202.team10.Model.Exceptions.NoDataFoundException;
import seng202.team10.Model.Exceptions.DuplicateEntryException;
import seng202.team10.Model.Exceptions.ExistingActivityException;
import seng202.team10.Model.Exceptions.ExistingElementException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Upload Data Controller Class for Coach Potato SENG202 2018S2
 */
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
    @FXML private VBox drawer;
    @FXML private Button helpButtonManualActivity;
    @FXML private Button helpButtonUploadFile;
    @FXML private Button uploadButton;
    @FXML private Button clearTableButton;
    @FXML private Button deleteEntryButton;
    @FXML private Button addEntryButton;
    @FXML private Button submitDataButton;
    @FXML private TextArea manualEntryHelpTextArea;
    @FXML private TextArea uploadFileHelpTextArea;


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app The main controller being passed in
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
        // Set up help text areas
        setUpHelpTextAreas();
        // Set tool tips for buttons
        setUpToolTips();
        // Set up the table view
        setUpTableView();
        // Set up the listners
        setUpListners();
    }


    /**
     * Set up method for the change listeners
     */
    private void setUpListners()
    {
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


    /**
     * Set up method for the table view
     */
    private void setUpTableView()
    {
        // Set up the columns in the table.
        dateColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("dateString"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("timeString"));
        heartRateColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("heartRateString"));
        latitudeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("latitudeString"));
        longitudeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("longitudeString"));
        elevationColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("elevationString"));
        // Load entries array
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
     * Set up method for the tool tips
     */
    private void setUpToolTips()
    {
        browseButton.setTooltip(new Tooltip("Open a browser window to select your .csv file from"));
        helpButtonManualActivity.setTooltip(new Tooltip("Need Help?"));
        helpButtonUploadFile.setTooltip(new Tooltip("Need Help?"));
        uploadButton.setTooltip(new Tooltip("Upload the data from the selected file"));
        clearTableButton.setTooltip(new Tooltip("Clear the table of values to start again"));
        deleteEntryButton.setTooltip(new Tooltip("Delete the selected entry"));
        addEntryButton.setTooltip(new Tooltip("Add the entry you have input into the text fields"));
        submitDataButton.setTooltip(new Tooltip("Create the activity from the data in the table and add it to your profile"));
        // Set tool tips for text fields
        filePathTextField.setTooltip(new Tooltip("Please enter the file path of the file you wish to upload,\n" +
                                                 "E.g. \"Walk in the woods\""));
        activityNameTextField.setTooltip(new Tooltip("Please enter a name that describes your activity,\n" +
                                                     "E.g. \"Walk in the woods\""));
        dateTextField.setTooltip(new Tooltip("Please enter the date that your entry point was taken on,\n" +
                                             "Using the format DD/MM/YYYY"));
        timeTextField.setTooltip(new Tooltip("Please enter the time that your entry point was taken on,\n" +
                                             "Using the format HH:MM:SS in 24 hour time"));
        heartRateTextField.setTooltip(new Tooltip("Please enter your heart rate at the time of this entry point\n" +
                                                  "Must be an integer in the range 1 to 300"));
        latitudeTextField.setTooltip(new Tooltip("Please enter your latitude at the time of this entry\n" +
                                                 "Must be in the range -90.0 to 90.0\n" +
                                                 "Preferred accuracy is 6 decimal places"));
        longitudeTextField.setTooltip(new Tooltip("Please enter your latitude at the time of this entry\n" +
                                                  "Must be in the range -180.0 to 180.0\n" +
                                                  "Preferred accuracy is 6 decimal places"));
        elevationTextField.setTooltip(new Tooltip("Please enter your elevation at the time of this entry\n" +
                                                  "Must be in the range -430.0 to 8850.0\n" +
                                                  "Preferred accuracy is 2 decimal places"));
        // Set tool tip for the table view.
        manualDataTableView.setTooltip(new Tooltip("This table shows the Entries you have already entered in chronological order.\n" +
                                                   "You can double click on a value if you wish to edit it.\n" +
                                                   "Please remember to use the correct format when editting values"));
    }


    /**
     * Set up method for the help text areas
     */
    private void setUpHelpTextAreas()
    {
        manualEntryHelpTextArea.setVisible(false);
        uploadFileHelpTextArea.setVisible(false);
        manualEntryHelpTextArea.setText("Welcome to the Manual Activity Entry Section!\n\n" +
                                        "In this section, you can manually enter each entry point of an activity along with the name of the activity. " +
                                        "Each new entry will be added to the table in chronological order and prompts will be given for invalid data formats. " +
                                        "If you wish to edit an existing entry just double click on it and enter the new value. " +
                                        "Please remember to use the correct format when editing entries.\n\n" +
                                        "Hover the mouse over each button or field to see a brief discription of what it does.");
        uploadFileHelpTextArea.setText("Welcome to the Upload File Section!\n\n" +
                                       "In this section, you can select a .csv file to be uploaded. " +
                                       "Simply type in the file path or click on the browse button " +
                                       "(the button with the little picture of a folder on it) " +
                                       "and navigate to your desired file. Then click the Upload File button and your file will be uploaded. " +
                                       "A pop up will then be displayed to tell you how many Activities were succesfully uploaded to your profile.\n\n" +
                                       "Hover the mouse over each button or field to see a brief discription of what it does.");
        manualEntryHelpTextArea.setWrapText(true);
        uploadFileHelpTextArea.setWrapText(true);
    }


    /**
     * Method called when focus to the help text area is lost or when the pane is clicked on.
     * Hides the help text area.
     */
    @FXML public void hideHelpTextAreas()
    {
        manualEntryHelpTextArea.setVisible(false);
        uploadFileHelpTextArea.setVisible(false);
        browseButton.requestFocus();
    }


    /**
     * Method called when the manual activity help button is pushed.
     * Displays the help text area.
     */
    @FXML public void displayManualActivityHelp()
    {
        manualEntryHelpTextArea.setVisible(true);
        manualEntryHelpTextArea.requestFocus();
    }


    /**
     * Method called when the upload file help button is pushed.
     * Displays the help text area.
     */
    @FXML public void displayUploadFileHelp()
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
     * Method to create an ObservableList&gt;Entry&lt; object for the TableView
     * @return ObservableList&gt;Entry&lt;
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


    /**
     * Method to create an Activity object from the entries input by the user and add it to the User Profile when the Submit Data button is pushed
     */
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
    @FXML public void openChooseProfile()
    {
        moveDrawer();
        app.launchLoginScene();
    }


    /**
     * Method to launch the view profile scene.
     */
    @FXML public void openViewProfile()
    {
        moveDrawer();
        app.launchProfileScene();
    }


    /**
     * Method to launch the upload data scene.
     */
    @FXML public void openUploadData()
    {
        moveDrawer();
        app.launchUploadDataScene();
    }


    /**
     * Method to launch the view activities scene.
     */
    @FXML public void openViewActivities()
    {
        moveDrawer();
        app.launchActivityViewerScene();
    }


    /**
     * Method to launch the goals scene.
     */
    @FXML public void openGoals()
    {
        moveDrawer();
        app.launchGoalsScene();
    }


    /**
     * Method to launch the data analysis scene.
     */
    @FXML public void openAnalysis()
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
