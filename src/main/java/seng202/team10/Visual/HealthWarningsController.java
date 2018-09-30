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

public class HealthWarningsController implements Controllable {


    private GUIController app;
    private ObservableList<HealthWarning> tachycardiaWarnings;
    private ObservableList<HealthWarning> bradycardiaWarnings;
    ObservableList<HealthWarning> cardiovascularMortalityWarnings;
    @FXML private Label tachycardiaActivitiesLabel;
    @FXML private Label bradycardiaActivitiesLabel;
    @FXML private Label cardiovascularMortalityActivitiesLabel;
    @FXML private ImageView tachycardiaIcon;
    @FXML private ImageView bradycardiaIcon;
    @FXML private ImageView cardiovascularMortalityIcon;
    @FXML private WebView googleWebView;
    private WebEngine engine;


    public void setApp(GUIController app)
    {
        this.app = app;
    }


    public void setUpScene()
    {
        getWarningLists();
        setUpLabels();
        engine = googleWebView.getEngine();
        engine.load("https://google.com");
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


    @FXML public void showCardiovascularMortalityWarnings()
    {

    }


    @FXML public void showBradycardiaWarnings()
    {

    }


    @FXML public void showTachycardiaWarnings()
    {

    }


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
