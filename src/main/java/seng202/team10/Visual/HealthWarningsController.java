package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
        getWarningLists();
        setLabelsUp();
        engine = googleWebView.getEngine();
        engine.load("https://google.com");
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
    private void setLabelsUp()
    {
        tachycardiaIcon.setVisible(false);
        bradycardiaIcon.setVisible(false);
        cardiovascularMortalityIcon.setVisible(false);
        if (tachycardiaWarnings.size() > 0) {
            tachycardiaActivitiesLabel.setText("You currently have " + tachycardiaWarnings.size() + " warnings.");
            tachycardiaIcon.setVisible(true);

        }
        if (bradycardiaWarnings.size() > 0) {
            bradycardiaActivitiesLabel.setText("You currently have " + bradycardiaWarnings.size() + " warnings.");
            bradycardiaIcon.setVisible(true);
        }
        if (cardiovascularMortalityWarnings.size() > 0) {
            cardiovascularMortalityActivitiesLabel.setText("You currently have " + cardiovascularMortalityWarnings.size() + " warnings.");
            cardiovascularMortalityIcon.setVisible(true);
        } else {
            cardiovascularMortalityActivitiesLabel.setText("You currently have no warnings.");
        }
    }


    @FXML public void showCardiovascularMortalityWarnings()
    {

    }


    @FXML public void showBradycardiaWarnings()
    {

    }


    @FXML public void showTachycardiaWarnings()
    {

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
