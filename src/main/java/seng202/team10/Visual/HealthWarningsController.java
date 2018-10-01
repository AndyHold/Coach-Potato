package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.HealthWarning;
import seng202.team10.Model.ActivitiesData.HealthWarningType;

import javax.swing.text.html.ListView;

/**
 * Health Warnings Controller class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class HealthWarningsController implements Controllable {


    private GUIController app;
    private ObservableList<HealthWarning> tachycardiaWarnings;
    private ObservableList<HealthWarning> bradycardiaWarnings;
    private ObservableList<HealthWarning> cardiovascularMortalityWarnings;
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
    @FXML private ScrollPane warningsScrollPane;
    private WebEngine engine;


    /**
     * Setter method to pass the GUIController into this controller.
     * @param guiController <b>GUIController:</b> The main controller.
     */
    public void setApp(GUIController guiController)
    {
        this.app = guiController;
    }


    /**
     * Sets up objects that require it prior to showing the scene.
     */
    public void setUpScene()
    {
        warningsScrollPane.setVisible(false);
        getWarningLists();
        setUpLabels();
        engine = googleWebView.getEngine();
        engine.load("https://google.com");
        warningsScrollPane.focusedProperty().addListener((ov, oldV, newV) -> {
        if (!newV) {
            hideWarningsScrollPane();
        }
    });
    }


    /**
     * Method to create warning panes and add them to their correct VBox's
     */
    public void createWarningPanes()
    {
        // Tachycardia
        for (HealthWarning healthWarning: tachycardiaWarnings) {
            new WarningPane(healthWarning, this, tWarningsPane);
        }
        // Bradycardia
        for (HealthWarning healthWarning: bradycardiaWarnings) {
            new WarningPane(healthWarning, this, bWarningsPane);
        }
        // Cardiovascular Mortality
        for (HealthWarning healthWarning: cardiovascularMortalityWarnings) {
            new WarningPane(healthWarning, this, cWarningsPane);
        }
    }


    /**
     * Method to get lists of warnings for each type of health condition.
     */
    private void getWarningLists()
    {
        tachycardiaWarnings = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getWarnings(HealthWarningType.TACHYCARDIA));
        bradycardiaWarnings = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getWarnings(HealthWarningType.BRADYCARDIA));
        cardiovascularMortalityWarnings = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getWarnings(HealthWarningType.CARDIOVASCULAR_MORTALITY));
    }


    /**
     * Initializes labels and icons for each health condition.
     */
    private void setUpLabels()
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
        //TODO this is very slow...
    }


    /**
     * Getter method for the <b>GUIController</b>
     * @return the <b>GUIController</b>
     */
    public GUIController getApp()
    {
        return this.app;
    }


    @FXML public void showCardiovascularMortalityWarnings()
    {
        warningsScrollPane.setVisible(true);
        cWarningsPane.setVisible(true);
    }


    @FXML public void showBradycardiaWarnings()
    {
        warningsScrollPane.setVisible(true);
        bWarningsPane.setVisible(true);
    }


    @FXML public void showTachycardiaWarnings()
    {
        warningsScrollPane.setVisible(true);
        tWarningsPane.setVisible(true);
    }

    @FXML public void hideWarningsScrollPane()
    {
        warningsScrollPane.setVisible(false);
        tWarningsPane.setVisible(false);
        bWarningsPane.setVisible(false);
        cWarningsPane.setVisible(false);
    }

    /**
     * Method to search the web page for tachycardia.
     */
    @FXML public void showTachycardiaSearch()
    {
        engine.load(HealthWarningType.TACHYCARDIA.getURL());
    }

    /**
     * Method to search the web page for brachycardia.
     */
    @FXML public void showBradycardiaSearch()
    {
        engine.load(HealthWarningType.BRADYCARDIA.getURL());
    }

    /**
     * Method to search the web page for cardiovascular mortality.
     */
    @FXML public void showCardiovascularSearch()
    {
        engine.load(HealthWarningType.CARDIOVASCULAR_MORTALITY.getURL());
    }



}
