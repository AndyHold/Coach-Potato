package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.Exceptions.EntryOutOfSequenceException;

import java.util.ArrayList;

/**
<<<<<<< HEAD
 * EntryViewerController Class for Coach Potato
 * SENG202 2018S2
=======
 * Controller class for the entry viewer screen, where lists of entries for activities are displayed.
 *
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class EntryViewerController {

    private MainController app;
    private Activity loadedActivity;

    @FXML private Label activityNameLabel;
    @FXML private TableView<Entry> entriesTableView;
    @FXML private TableColumn<Entry, String> dateColumn;
    @FXML private TableColumn<Entry, String> timeColumn;
    @FXML private TableColumn<Entry, String> heartRateColumn;
    @FXML private TableColumn<Entry, String> latitudeColumn;
    @FXML private TableColumn<Entry, String> longitudeColumn;
    @FXML private TableColumn<Entry, String> elevationColumn;
    @FXML private TableColumn<Entry, String> distanceColumn;
    @FXML private TableColumn<Entry, String> speedColumn;
    @FXML private Button activityReturnButton;
    @FXML private Button helpButton;
    @FXML private TextArea helpTextArea;
    private ObservableList<Entry> entries;


    /**
     * Method to set up objects that require it prior to showing the scene
     * @param loadActivity
     */
    public void setUpScene(Activity loadActivity)
    {
        // Set tool tips
        setToolTips();
        // Set up help text area
        setUpHelpTextArea();
        // Set the activity
        loadedActivity = loadActivity;
        activityNameLabel.setText(loadedActivity.getName());
        // Set up the content for the table view
        setUpTableView();
        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    /**
     * Method to set up the table view with the entries from the activity
     */
    private void setUpTableView()
    {
        // Create and set property values
        entries = FXCollections.observableArrayList(loadedActivity.getEntries());
        dateColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("dateString"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("timeString"));
        heartRateColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("heartRateString"));
        latitudeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("latitudeString"));
        longitudeColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("longitudeString"));
        elevationColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("elevationString"));
        distanceColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("distanceString"));
        speedColumn.setCellValueFactory(new PropertyValueFactory<Entry, String>("velocityString"));
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
     * Set up method for the help text area
     */
    private void setUpHelpTextArea()
    {
        helpTextArea.setText("Welcome to the Entry View Screen!\n\n" +
                             "On this screen you can view and edit the entries in the activity displayed or return to the Activity View Screen.\n" +
                             "To edit an entry:\n" +
                             "\t- Locate the entry and field to be edited in the table.\n" +
                             "\t- Double click on that cell in the table.\n" +
                             "\t- You should now be able to edit that values in the\n" +
                             "\t  table.\n" +
                             "\t- When you are finished push enter and the value will\n" +
                             "\t  be updated.\n" +
                             "\tIf you enter an invalid value a pop up will appear to\n" +
                             "\tlet you know where you went wrong.\n" +
                             "To return to the Activity View Screen simply click the Back to Activity View button.\n\n" +
                             "Hover over each item for a brief description of what it does.");
        helpTextArea.setVisible(false);
        helpTextArea.setWrapText(true);
    }


    /**
     * Set up method for the tool tips
     */
    private void setToolTips()
    {
        entriesTableView.setTooltip(new Tooltip("The entries for this activity are listed in this table\n" +
                                                "Double click on a cell to edit that value.\n" +
                                                "Note: A pop up will occur if an invalid value is used."));
        activityReturnButton.setTooltip(new Tooltip("Click here to return to the Activity View Screen."));
        helpButton.setTooltip(new Tooltip("Need Help?"));
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
<<<<<<< HEAD
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
=======
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setApp(MainController mainController)
    {
        this.app = mainController;
>>>>>>> 86ffe4b1... Refactored GUIController to be called MainController
    }


    /**
     * Method to return to the activityViewer when the activityReturnButton is pressed and saves changes to entries
     */
    @FXML public void returnToActivities()
    {
        ArrayList<Entry> savingEntries = new ArrayList<>(this.entries);
        loadedActivity.setEntries(savingEntries);
        loadedActivity.postEntriesSetUp();
        loadedActivity.checkEntriesForWarnings(app.getTitleBar().getCurrentProfile());
        app.getTitleBar().setUpWarningFlag();
        app.getTitleBar().openViewActivities();
    }

    /**
<<<<<<< HEAD
     * method to check if a list of entries are in time sequence
     * @param checkingEntries the arraylist of entries being checked
     * @return true if the order is correct, false if not
=======
     * Method to check if a list of entries are in time sequence.
     * @param checkingEntries The <b>ArrayList&lt;Entry&gt;</b> being checked.
     * @throws EntryOutOfSequenceException if the entries are not in time sequence.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    private void checkContinuity(ArrayList<Entry> checkingEntries) throws EntryOutOfSequenceException {
        if (checkingEntries.size() > 1) {
            for(int i = 0; i < checkingEntries.size() - 1; i++){
                if (checkingEntries.get(i).getTime().isAfter(checkingEntries.get(i+1).getTime())){
                    throw new EntryOutOfSequenceException();
                }
            }
        }
    }

    /**
     * Method to change the time of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeTimeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
        String oldTime = entrySelected.getTimeString();
        try {
            ArrayList<Entry> checkingEntries = new ArrayList<>(this.entries);
            entrySelected.changeTime(editedCell.getNewValue().toString());
            checkContinuity(checkingEntries);
        } catch(NumberFormatException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Time invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
        } catch (EntryOutOfSequenceException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Invalid time, entries not in sequence");
            entrySelected.changeTime(oldTime);
        }
        entriesTableView.refresh();
    }


    /**
     * Method to change the date of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeDateCellEvent(TableColumn.CellEditEvent editedCell)
    {
        Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
        String oldDate = entrySelected.getDateString();
        try {
            ArrayList<Entry> checkingEntries = new ArrayList<>(this.entries);
            entrySelected.changeDate(editedCell.getNewValue().toString());
            checkContinuity(checkingEntries);
        }  catch(NumberFormatException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Date invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
        } catch (EntryOutOfSequenceException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Invalid date, entries not in sequence");
            entrySelected.changeDate(oldDate);
        }
        entriesTableView.refresh();
    }


    /**
     * Method to change the Heart Rate of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeHeartRateCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
            entrySelected.setHeartRate(Integer.valueOf(editedCell.getNewValue().toString()));
        } catch(NumberFormatException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "HeartRate invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
        }
        entriesTableView.refresh();
    }


    /**
     * Method to change the Latitude of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeLatitudeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
            entrySelected.setLatitude(Double.valueOf(editedCell.getNewValue().toString()));
        } catch(NumberFormatException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Latitude invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
        }
        entriesTableView.refresh();

    }


    /**
     * Method to change the Longitude of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeLongitudeCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
            entrySelected.setLongitude(Double.valueOf(editedCell.getNewValue().toString()));
        } catch(NumberFormatException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Longitude invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
        }
        entriesTableView.refresh();

    }


    /**
     * Method to change the Elevation of an Entry when it is modified in the TableView
     * @param editedCell TableColumn.CellEditEvent: Cell edited by the user
     */
    @FXML public void changeElevationCellEvent(TableColumn.CellEditEvent editedCell)
    {
        try {
            Entry entrySelected = entriesTableView.getSelectionModel().getSelectedItem();
            entrySelected.setElevation(Double.valueOf(editedCell.getNewValue().toString()));
        } catch(NumberFormatException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Elevation invalid, must be a valid number");
        } catch(IllegalArgumentException exception) {
            String message = exception.getMessage();
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", message);
        }
        entriesTableView.refresh();
    }
}
