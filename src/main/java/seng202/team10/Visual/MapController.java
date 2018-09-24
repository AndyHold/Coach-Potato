package seng202.team10.Visual;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Route;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Controllable, Initializable{

    private GUIController guiController;
    private WebEngine webEngine;
    private boolean firstLoad = true;
    private boolean firstMapView = false;
    private Activity activity;
    private Route route;

    @FXML private WebView mapWebView;
    @FXML private Label activityLabel;
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    @FXML private Button backButton;


    /**
     * sets this scene to be the currently active one
     * @param guiController
     */
    @Override
    public void setApp(GUIController guiController)
    {
        this.guiController = guiController;
    }


    /**
     * displays the route on the map
     * @param newRoute the Route being displayed
     */
    public void displayRoute(Route newRoute)
    {
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            String scriptToExecute = "displayRoute(" + newRoute.toJSONArray() + ");";
                            try {
                                webEngine.executeScript(scriptToExecute);
                            } catch (netscape.javascript.JSException exception) {
                                guiController.createPopUp(Alert.AlertType.ERROR, "Error", "Could not connect to the internet. Please connect and try again.");
                            }
                        }
                    }
                });
    }


    /**
     * sets up the initial scene with all the areas
     */
    @Override
    public void setUpScene()
    {
        // Set tool tips
        setUpToolTips();
        //Set up help text area
        setUpHelpTextArea();

        webEngine = mapWebView.getEngine();
        webEngine.load(this.getClass().getResource("/map.html").toExternalForm());
        if (firstMapView) {
            firstMapView = false;
            guiController.refreshMapScene(this.activity);
        }

        if (firstLoad) {
            firstMapView = true;
            firstLoad = false;
        }
        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    /**
     * Set up method for the help text area
     */
    private void setUpHelpTextArea()
    {
        helpTextArea.setText("Welcome to the Map View Screen!\n\n" +
                             "On this screen you can view a map of the route taken in the activity selected in the previous screen.\n\n" +
                             "- To Zoom in and out select the + and - buttons on the\n" +
                             "  right side of the map.\n" +
                             "- To add satelite view or terrain view select the layers icon\n" +
                             "  in the bottom right of the map and choose the desired\n" +
                             "  view.\n" +
                             "- To return to the Analysis Screen select the Back button.\n\n" +
                             "The start of your activity is marked by the green pin and the end is marked by the finish flag.");
        helpTextArea.setWrapText(true);
        helpTextArea.setVisible(false);
    }


    /**
     * set up method for the tool tips
     */
    private void setUpToolTips()
    {
        backButton.setTooltip(new Tooltip("Click here to return to the Analysis Screen."));
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
     * Setter method for the activity being mapped
     * @param activity Activity: activity being mapped
     */
    public void setActivity(Activity activity)
    {
        this.activity = activity;
        this.activityLabel.setText(activity.getName());
    }


    /**
     * goes back to the data analysis screen
     */
    @FXML public void goToActivityViewer()
    {
//        guiController.launchActivityViewerScene();
        guiController.launchDataAnalysisScene();
    }


    /**
     * creates a new Route from an activity
     * @param activity the activity being mapped
     * @return the Route opject of the activity
     */
    public Route makeRoute(Activity activity)
    {
        Route route = new Route();
        for (Entry entry : activity.getEntries()) {
            route.addPosition(entry.getPosition());
        }
        return route;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
