package seng202.team10.Visual;

import com.sun.istack.internal.NotNull;
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

import java.util.ArrayList;

<<<<<<< HEAD
=======
/**
 * Health Warnings Controller class for Coach Potato
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
public class HealthWarningsController implements Controllable {


    private MainController app;
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


<<<<<<< HEAD
    public void setApp(GUIController app)
    {
        this.app = app;
=======
    /**
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setApp(MainController mainController)
    {
        this.app = mainController;
>>>>>>> 86ffe4b1... Refactored GUIController to be called MainController
    }


    public void setUpScene()
    {
        setUpHelpTextArea();
        setUpToolTips();
        hideInfoBoxes();
        getWarningLists();
        setUpLabels();

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
     * TODO finish these
     */
    private void setUpToolTips()
    {
        helpButton.setTooltip(new Tooltip("Need Help?"));
//        googleWebView
//        backButton
//        homeButton
//        forwardButton
//        tachycardiaViewButton
//        tachycardiaLearnMorebutton
//        bradycardiaViewbutton
//        bradycardiaLearnMoreButton
//        cardiovascularMortalityViewButton
//        cardiovascularMortalityLearnMoreButton
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


    @FXML public void goBack()
    {
        WebHistory history = engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        int index = history.getCurrentIndex();

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


    @FXML public void goForward()
    {
        WebHistory history = engine.getHistory();
        ObservableList<WebHistory.Entry> entryList = history.getEntries();
        int index = history.getCurrentIndex();

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

    @FXML public void goHome()
    {

        engine.load("https://google.com");
    }


    /**
     * Method to create warning panes and add them to their correct VBox's
     */
    public void createWarningPanes()
    {
        tWarningsPane.getChildren().clear();
        bWarningsPane.getChildren().clear();
        cWarningsPane.getChildren().clear();
        tWarnings.clear();
        bWarnings.clear();
        cWarnings.clear();
        // Tachycardia
        for (HealthWarning healthWarning: tachycardiaWarnings) {
            tWarnings.add(new WarningPane(healthWarning, this, tWarningsPane));
        }
        // Bradycardia
        for (HealthWarning healthWarning: bradycardiaWarnings) {
            bWarnings.add(new WarningPane(healthWarning, this, bWarningsPane));
        }
        // Cardiovascular Mortality
        for (HealthWarning healthWarning: cardiovascularMortalityWarnings) {
            cWarnings.add(new WarningPane(healthWarning, this, cWarningsPane));
        }
    }


    private void getWarningLists()
    {
        tachycardiaWarnings = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getWarnings(HealthWarningType.TACHYCARDIA));
        bradycardiaWarnings = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getWarnings(HealthWarningType.BRADYCARDIA));
        cardiovascularMortalityWarnings = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getWarnings(HealthWarningType.CARDIOVASCULAR_MORTALITY));
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
        app.getTitleBar().getCurrentProfile().removeHealthWarning(healthWarning);
        app.getDataWriter().saveProfile(app.getTitleBar().getCurrentProfile());
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
        app.getTitleBar().setUpWarningFlag();
    }


    /**
     * Getter method for the <b>MainController</b>
     * @return the <b>MainController</b>
     */
    public MainController getApp()
    {
        return this.app;
    }


    @FXML public void showTachycardiaWarnings()
    {
        hideWarningsScrollPane();
        if (tachycardiaWarnings.size() > 0) {
            showWarningPane(tWarningsPane);
        }
        warningsScrollPane.setLayoutY(20);
    }


    @FXML public void showBradycardiaWarnings()
    {
        hideWarningsScrollPane();
        if (bradycardiaWarnings.size() > 0) {
            showWarningPane(bWarningsPane);
        }
        warningsScrollPane.setLayoutY(250);
    }


    @FXML public void showCardiovascularMortalityWarnings()
    {
        hideWarningsScrollPane();
        if (cardiovascularMortalityWarnings.size() > 0) {
            showWarningPane(cWarningsPane);
        }
        warningsScrollPane.setLayoutY(440);
    }


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


    private void clearWarnings(Pane clearPane, ArrayList<WarningPane> warnings)
        {
            TranslateTransition clear = new TranslateTransition(new Duration(350), clearPane);
            clear.setToX(-380);
            clear.play();
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
     * @param warningPane
     */
    private void showWarningPane(@NotNull Pane warningPane)
    {
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
     */
>>>>>>> 41a3421e... Implemented navigation buttons for health warnings screen. Added some new icons for various things.
    @FXML public void showTachycardiaSearch()
    {
        engine.load(HealthWarningType.TACHYCARDIA.getURL());
    }


    @FXML public void showBradycardiaSearch()
    {
        engine.load(HealthWarningType.BRADYCARDIA.getURL());
    }


    @FXML public void showCardiovascularSearch()
    {
        engine.load(HealthWarningType.CARDIOVASCULAR_MORTALITY.getURL());
    }



}
