package seng202.team10.Visual;


import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.HealthWarning;
import seng202.team10.Model.ActivitiesData.HealthWarningType;
<<<<<<< HEAD
import seng202.team10.Model.UserProfile;

import java.net.InetAddress;
=======

import java.io.IOException;
import java.net.InetAddress;
import seng202.team10.Model.UserProfile;

import java.net.UnknownHostException;
>>>>>>> a9f2ebdd... Fixed the exceptions when there is no internet
import java.util.ArrayList;

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======

>>>>>>> 6757ee04... Removed bad import to fix the pipeline
/**
 * Health Warnings Controller class for Coach Potato
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
public class HealthWarningsController implements Controllable {


    private MainController mainController;
    private ObservableList<HealthWarning> tachycardiaWarnings;
    private ObservableList<HealthWarning> bradycardiaWarnings;
<<<<<<< HEAD
    ObservableList<HealthWarning> cardiovascularMortalityWarnings;
=======
    private ObservableList<HealthWarning> cardiovascularMortalityWarnings;
<<<<<<< HEAD
    private ArrayList<WarningPane> tWarnings= new ArrayList<>();
    private ArrayList<WarningPane> bWarnings= new ArrayList<>();
    private ArrayList<WarningPane> cWarnings= new ArrayList<>();
>>>>>>> 48ad2079... Implemented a clear all button on the health warnings screen. Found some issues with the clear functionality so had to fix it a bit.
=======
    private ArrayList<WarningPane> tWarnings = new ArrayList<>();
    private ArrayList<WarningPane> bWarnings = new ArrayList<>();
    private ArrayList<WarningPane> cWarnings = new ArrayList<>();
>>>>>>> d01aa415... Removed User arraylist from GUI Controller which led me to lots of bugs which I fixed.
    @FXML private Label tachycardiaActivitiesLabel;
    @FXML private Label bradycardiaActivitiesLabel;
    @FXML private Label cardiovascularMortalityActivitiesLabel;
    @FXML private ImageView tachycardiaIcon;
    @FXML private ImageView bradycardiaIcon;
    @FXML private ImageView cardiovascularMortalityIcon;
    @FXML private WebView googleWebView;
    @FXML private Pane tWarningsPane;
    @FXML private Pane bWarningsPane;
    @FXML private Pane cWarningsPane;
    @FXML private Pane warningsParentPane;
    @FXML private ScrollPane warningsScrollPane;
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    @FXML private Button backButton;
    @FXML private Button homeButton;
    @FXML private Button forwardButton;
    @FXML private Button tachycardiaViewButton;
    @FXML private Button tachycardiaLearnMorebutton;
    @FXML private Button bradycardiaViewbutton;
    @FXML private Button bradycardiaLearnMoreButton;
    @FXML private Button cardiovascularMortalityViewButton;
    @FXML private Button cardiovascularMortalityLearnMoreButton;
    private WebEngine engine;
    private UserProfile currentUser;


<<<<<<< HEAD
    public void setApp(GUIController app)
    {
        this.app = app;
=======
    /**
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setMainController(MainController mainController)
    {
<<<<<<< HEAD
        this.app = mainController;
>>>>>>> 86ffe4b1... Refactored GUIController to be called MainController
=======
        this.mainController = mainController;
>>>>>>> be0346c6... Refactored "app" to "mainController"
    }


    public void setUpScene()
    {
        currentUser = mainController.getTitleBar().getCurrentProfile();
        // Set up help and tooltips
        setUpHelpTextArea();
        setUpToolTips();
        hideInfoBoxes();
        // Set up the current warnings
        getWarningLists();
        setUpLabels();
<<<<<<< HEAD
        // Set up the web view
=======


>>>>>>> 89478d66... added popups on health warnings when it can't connect to google
        engine = googleWebView.getEngine();
        engine.load("https://google.com");

        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
        if (!newV) {
            hideHelpTextArea();
        }});
    }


    /**
     * Set up method for the help text area
     */
    private void setUpHelpTextArea()
    {
        helpTextArea.setText("Welcome to the Health Warnings Screen!\n\n" +
                             "On this screen you can view/clear the different health warnings you have recieved and get more information via google.\n\n" +
                             "- To view/clear your current health warnings:\n" +
                             "\t- Locate the desired warning type in the panes on\n" +
                             "\t  the right.\n" +
                             "\t- Click on the button with the warning symbol to\n" +
                             "\t  open the warnings pane. This brings up your\n" +
                             "\t  current warnings for the type selected including the\n" +
                             "\t  activity the warning was detected on.\n" +
                             "\t- Click the Clear button to remove the warning or the\n" +
                             "\t  Clear All button to remove all warnings of that type.\n" +
                             "- To learn more about each warning type:\n" +
                             "\t- Click on the Learn More button for the desired type.\n" +
                             "\t  This will bring up a google search for the warning in\n" +
                             "\t  the google web view on the left.\n" +
                             "\t- Use the Back, Home, and Forward buttons at the\n" +
                             "\t  bottom of the web view to navigate as you desire.\n\n" +
                             "Hover the mouse over each button to see a brief discription of what it does.");
        helpTextArea.setWrapText(true);
        helpTextArea.setVisible(false);
    }


    /**
     * Set up method for the tool tips
     *
     */
    private void setUpToolTips()
    {
        helpButton.setTooltip(new Tooltip("Need Help?"));
        backButton.setTooltip(new Tooltip("Click here to go back one page."));
        homeButton.setTooltip(new Tooltip("Click here to return to the Google home page."));
        forwardButton.setTooltip(new Tooltip("Click here to go foward one page."));
        tachycardiaViewButton.setTooltip(new Tooltip("Click here to view a list of the activities \n" +
                "this health warning."));
        tachycardiaLearnMorebutton.setTooltip(new Tooltip("Click here to search the web for \n" +
                "information about this health warning."));
        bradycardiaViewbutton.setTooltip(new Tooltip("Click here to view a list of the activities \n" +
                "this health warning."));
        bradycardiaLearnMoreButton.setTooltip(new Tooltip("Click here to search the web for \n" +
                "information about this health warning."));
        cardiovascularMortalityViewButton.setTooltip(new Tooltip("Click here to view a list of the activities \n" +
                "this health warning."));
        cardiovascularMortalityLearnMoreButton.setTooltip(new Tooltip("Click here to search the web for \n" +
                "information about this health warning."));
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
    }


    /**
     * Method to return to the previous webpage visited
     * Called when the back button is selected
     */
    @FXML public void goBack()
    {
        // Get the history entries as an observable list with the current index.
        WebHistory history = engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        int index = history.getCurrentIndex();
        // Create a new thread to change the page if the index is in range.
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if ((entryList.size() > 1) && (index > 0)) {
                    history.go(-1);
                } else {
                    history.go(0);
                }
            }
        });
    }


    /**
     * Method to return to the next webpage visited if you are back in the web history
     * Called when the forward button is selected
     */
    @FXML public void goForward()
    {
        // Get the history entries as an observable list with the current index.
        WebHistory history = engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        int index = history.getCurrentIndex();
        // Create a new thread to change the page if the index is in range.
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if ((entryList.size() > 1) && (index < entryList.size() - 1)) {
                    history.go(1);
                } else {
                    history.go(0);
                }
            }
        });
    }


    /**
     * Method to return to the home webpage which is currently www.google.com
     */
    @FXML public void goHome()
    {
        boolean reachable = false;
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
<<<<<<< HEAD
            boolean reachable = address.isReachable(10000);
        } catch (Exception e) {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to Google, Web Search is currently available");
=======
            reachable = address.isReachable(600);
        } catch (IOException e) {
            ;
        }
        if (reachable) {
            engine.load("https://google.com");
        } else {
            mainController.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to Google, 'google.com' currently available");
>>>>>>> a9f2ebdd... Fixed the exceptions when there is no internet
        }
    }


    /**
     * Method to create warning panes and add them to their correct VBox's
     */
    public void createWarningPanes()
    {
        // clear all warning lists
        tWarningsPane.getChildren().clear();
        bWarningsPane.getChildren().clear();
        cWarningsPane.getChildren().clear();
        tWarnings.clear();
        bWarnings.clear();
        cWarnings.clear();
        // Make all Tachycardia warning panes
        for (HealthWarning healthWarning: tachycardiaWarnings) {
            tWarnings.add(new WarningPane(healthWarning, this, tWarningsPane));
        }
        // Make all Bradycardia warning panes
        for (HealthWarning healthWarning: bradycardiaWarnings) {
            bWarnings.add(new WarningPane(healthWarning, this, bWarningsPane));
        }
        // Make all Cardiovascular Mortality warning panes
        for (HealthWarning healthWarning: cardiovascularMortalityWarnings) {
            cWarnings.add(new WarningPane(healthWarning, this, cWarningsPane));
        }
    }


    private void getWarningLists()
    {
        tachycardiaWarnings = FXCollections.observableArrayList(currentUser.getWarnings(HealthWarningType.TACHYCARDIA));
        bradycardiaWarnings = FXCollections.observableArrayList(currentUser.getWarnings(HealthWarningType.BRADYCARDIA));
        cardiovascularMortalityWarnings = FXCollections.observableArrayList(currentUser.getWarnings(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


<<<<<<< HEAD
    private void setLabelsUp()
=======
    /**
     * Initializes labels and icons for each health condition.
     */
    private void setUpLabels()
>>>>>>> 4f1b7d76... Fixed tests so that new format of error exceptions does not break the pipeline.
    {
        tachycardiaIcon.setVisible(false);
        bradycardiaIcon.setVisible(false);
        cardiovascularMortalityIcon.setVisible(false);
        if (tachycardiaWarnings.size() > 0) {
            tachycardiaActivitiesLabel.setText("You currently have " + tachycardiaWarnings.size() + " warnings.");
            tachycardiaIcon.setVisible(true);
        } else {
            tachycardiaActivitiesLabel.setText("You currently have no warnings.");
        }
        if (bradycardiaWarnings.size() > 0) {
            bradycardiaActivitiesLabel.setText("You currently have " + bradycardiaWarnings.size() + " warnings.");
            bradycardiaIcon.setVisible(true);
        } else {
            bradycardiaActivitiesLabel.setText("You currently have no warnings.");
        }
        if (cardiovascularMortalityWarnings.size() > 0) {
            cardiovascularMortalityActivitiesLabel.setText("You currently have " + cardiovascularMortalityWarnings.size() + " warnings.");
            cardiovascularMortalityIcon.setVisible(true);
        } else {
            cardiovascularMortalityActivitiesLabel.setText("You currently have no warnings.");
        }
    }


    /**
     * Method to remove a warning from the user and the screen.
     * @param healthWarning the <b>HealthWarning</b> being removed
     */
    public void removeWarning(HealthWarning healthWarning)
    {
        currentUser.removeHealthWarning(healthWarning);
        mainController.getDataWriter().saveProfile(currentUser);
        switch(healthWarning.getType())
        {
            case TACHYCARDIA:
                tachycardiaWarnings.remove(healthWarning);
                break;
            case BRADYCARDIA:
                bradycardiaWarnings.remove(healthWarning);
                break;
            case CARDIOVASCULAR_MORTALITY:
                cardiovascularMortalityWarnings.remove(healthWarning);
                break;
        }
        setUpLabels();
        mainController.getTitleBar().setUpWarningFlag();
    }


    /**
     * Getter method for the <b>MainController</b>
     * @return the <b>MainController</b>
     */
    public MainController getMainController()
    {
        return this.mainController;
    }


    /**
     * Method to display the tachicardia warnings pane if it is not empty
     */
    @FXML public void showTachycardiaWarnings()
    {
        hideWarningsScrollPane();
        if (tachycardiaWarnings.size() > 0) {
            showWarningPane(tWarningsPane);
        }
        warningsScrollPane.setLayoutY(20);
    }


    /**
     * Method to display the bradycardia warnings pane if it is not empty
     */
    @FXML public void showBradycardiaWarnings()
    {
        hideWarningsScrollPane();
        if (bradycardiaWarnings.size() > 0) {
            showWarningPane(bWarningsPane);
        }
        warningsScrollPane.setLayoutY(250);
    }


    /**
     * Method to display the cardiovascular mortality warnings pane if it is not empty
     */
    @FXML public void showCardiovascularMortalityWarnings()
    {
        hideWarningsScrollPane();
        if (cardiovascularMortalityWarnings.size() > 0) {
            showWarningPane(cWarningsPane);
        }
        warningsScrollPane.setLayoutY(440);
    }


    /**
     * Method to clear all Warnings in the visible pane.
     * Called when the Clear All button is selected.
     */
    @FXML public void clearAllWarnings()
    {
        if (tWarningsPane.isVisible()) {
            clearWarnings(tWarningsPane, tWarnings);
        } else if (bWarningsPane.isVisible()) {
            clearWarnings(bWarningsPane, bWarnings);
        } else {
            clearWarnings(cWarningsPane, cWarnings);
        }
    }


    /**
     * Method to clear all warnings of the given pane
     * @param clearPane a <b>Pane</b> to be cleared
     * @param warnings an <b>ArrayList&lt;WarningPane&gt;</b> of Warning Panes in the clearPane
     */
    private void clearWarnings(Pane clearPane, ArrayList<WarningPane> warnings)
        {
            // Create and play a Transition effect for the entire pane containing the warnings
            TranslateTransition clear = new TranslateTransition(new Duration(350), clearPane);
            clear.setToX(-380);
            clear.play();
            // When transition finished empty the pane, clear the warnings and put it back in place.
            clear.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    hideWarningsScrollPane();
                    clearPane.setTranslateX(0);
                    for (WarningPane warningPane: warnings) {
                        warningPane.clearWarningSolo();
                    }
                    warnings.clear();
                }
            });
        }


    /**
     * Method to show the warning Pane and stretch it to fit the values it requires.
     * @param warningPane a <b>Pane</b> containing the warnings of one of the three types.
     */
    private void showWarningPane(Pane warningPane)
    {
        // Show the panes, request focus and set the height of the pane depending on how many warnings it contains.
        warningsScrollPane.setVisible(true);
        warningPane.setVisible(true);
        warningsScrollPane.requestFocus();
        double newHeight = warningPane.getChildren().size() * 115;
        warningsParentPane.setStyle("-fx-min-height: " + newHeight + "; " +
                                    "-fx-max-height: " + newHeight + ";");
    }


    /**
     * Method to hide the warnings scroll pane.
     */
    public void hideWarningsScrollPane()
    {
        warningsScrollPane.setVisible(false);
        tWarningsPane.setVisible(false);
        bWarningsPane.setVisible(false);
        cWarningsPane.setVisible(false);
    }


<<<<<<< HEAD
=======
    /**
     * Method to hide the warnings scroll box and the help text area
     * Called when the background Pane is clicked on.
     */
    public void hideInfoBoxes()
    {
        hideWarningsScrollPane();
        hideHelpTextArea();
    }


    /**
     * Method to search the web page for tachycardia.
     * Called when the Learn More button for tachycardia is selected.
     */
>>>>>>> 41a3421e... Implemented navigation buttons for health warnings screen. Added some new icons for various things.
    @FXML public void showTachycardiaSearch()
    {
        boolean reachable = false;
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
<<<<<<< HEAD
            boolean reachable = address.isReachable(10000);
        } catch (Exception e) {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to Google, 'Learn More' currently available");
=======
            reachable = address.isReachable(600);
        } catch (IOException e) {
            ;
        }
        if (reachable) {
            engine.load(HealthWarningType.TACHYCARDIA.getURL());
        } else {
            mainController.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to Google, 'Learn More' currently available");
>>>>>>> a9f2ebdd... Fixed the exceptions when there is no internet
        }

    }


<<<<<<< HEAD
=======
    /**
     * Method to search the web page for brachycardia.
     * Called when the Learn More button for brachycardia is selected.
     */
>>>>>>> aac42ab6... Javadoc'd HealthWarningsController
    @FXML public void showBradycardiaSearch()
    {
        boolean reachable = false;
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
<<<<<<< HEAD
            boolean reachable = address.isReachable(10000);
        } catch (Exception e) {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to Google, 'Learn More' currently available");
=======
            reachable = address.isReachable(600);
        } catch (IOException e) {
            ;
        }
        if (reachable) {
            engine.load(HealthWarningType.BRADYCARDIA.getURL());
        } else {
            mainController.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to Google, 'Learn More' currently available");
>>>>>>> a9f2ebdd... Fixed the exceptions when there is no internet
        }

    }

<<<<<<< HEAD

=======
    /**
     * Method to search the web page for cardiovascular mortality.
     * Called when the Learn More button for cardiovascular mortality is selected.
     */
>>>>>>> aac42ab6... Javadoc'd HealthWarningsController
    @FXML public void showCardiovascularSearch()
    {
        boolean reachable = false;
        try{
            InetAddress address = InetAddress.getByName("www.google.com");
<<<<<<< HEAD
            boolean reachable = address.isReachable(10000);
        } catch (Exception e) {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to Google, 'Learn More' currently available");
=======
            reachable = address.isReachable(600);
        } catch (IOException e) {
            ;
        }
        if (reachable) {
            engine.load(HealthWarningType.CARDIOVASCULAR_MORTALITY.getURL());
        } else {
            mainController.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to Google, 'Learn More' currently available");
>>>>>>> a9f2ebdd... Fixed the exceptions when there is no internet
        }

    }

}
