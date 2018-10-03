package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.HealthWarning;
import seng202.team10.Model.ActivitiesData.HealthWarningType;

import javax.swing.text.html.ListView;
import java.util.ArrayList;

public class HealthWarningsController implements Controllable {


    private GUIController app;
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
    private WebEngine engine;


    public void setApp(GUIController app)
    {
        this.app = app;
    }


    public void setUpScene()
    {
        hideWarningsScrollPane();
        getWarningLists();
        setUpLabels();

        engine = googleWebView.getEngine();
        engine.load("https://google.com");
//        warningsScrollPane.focusedProperty().addListener((ov, oldV, newV) -> {
//        if (!newV) {
//            hideWarningsScrollPane();
//        }});
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
     * Getter method for the <b>GUIController</b>
     * @return the <b>GUIController</b>
     */
    public GUIController getApp()
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
    private void showWarningPane(Pane warningPane)
    {
        warningsScrollPane.setVisible(true);
        warningPane.setVisible(true);
        warningsScrollPane.requestFocus();
        double newHeight = warningPane.getChildren().size() * 115;
        warningsParentPane.setStyle("-fx-min-height: " + newHeight + "; " +
                                    "-fx-max-height: " + newHeight + ";");
    }


    @FXML public void hideWarningsScrollPane()
    {
        warningsScrollPane.setVisible(false);
        tWarningsPane.setVisible(false);
        bWarningsPane.setVisible(false);
        cWarningsPane.setVisible(false);
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
