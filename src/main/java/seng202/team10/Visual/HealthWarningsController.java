package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    @FXML private VBox tWarningsVBox;
    @FXML private VBox bWarningsVBox;
    @FXML private VBox cWarningsVBox;
    @FXML private ScrollPane warningsScrollPane;
    private WebEngine engine;


    public void setApp(GUIController app)
    {
        this.app = app;
    }


    public void setUpScene()
    {
        getWarningLists();
        createWarningPanes();
        setUpLabels();
        engine = googleWebView.getEngine();
        engine.load("https://google.com");
//        warningsScrollPane.focusedProperty().addListener((ov, oldV, newV) -> {
//        if (!newV) {
//            hideWarningsScrollPane();
//        }
//    });
    }


    /**
     * Method to create warning panes and add them to their correct VBox's
     */
    private void createWarningPanes()
    {
        // Tachycardia
        for (HealthWarning healthWarning: tachycardiaWarnings) {
            new WarningPane(healthWarning, this, tWarningsVBox);
        }
        // Bradycardia
        for (HealthWarning healthWarning: bradycardiaWarnings) {
            new WarningPane(healthWarning, this, bWarningsVBox);
        }
        // Cardiovascular Mortality
        for (HealthWarning healthWarning: cardiovascularMortalityWarnings) {
            new WarningPane(healthWarning, this, cWarningsVBox);
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
        //TODO this is very slow...
    }


    @FXML public void showCardiovascularMortalityWarnings()
    {
        warningsScrollPane.setVisible(true);
        cWarningsVBox.setVisible(true);
    }


    @FXML public void showBradycardiaWarnings()
    {
        warningsScrollPane.setVisible(true);
        bWarningsVBox.setVisible(true);
    }


    @FXML public void showTachycardiaWarnings()
    {
        warningsScrollPane.setVisible(true);
        tWarningsVBox.setVisible(true);
    }

    @FXML public void hideWarningsScrollPane()
    {
        warningsScrollPane.setVisible(false);
        tWarningsVBox.setVisible(false);
        bWarningsVBox.setVisible(false);
        cWarningsVBox.setVisible(false);
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
