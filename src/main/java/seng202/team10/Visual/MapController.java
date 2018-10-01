package seng202.team10.Visual;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;
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

import java.io.IOException;
import java.net.URL;
import java.util.Map;
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
<<<<<<< HEAD
     * sets this scene to be the currently active one
     * @param guiController
=======
     * Method to set this scene to be the currently active one.
     * @param guiController  The main controller being passed in.
>>>>>>> b97cfda5... Map not loading first time again. Made some minor edits
     */
    @Override
    public void setApp(GUIController guiController)
    {
        this.guiController = guiController;
    }


    /**
     * Method to display a route on the map, and show the map to the user.
     * @param newRoute the Route being displayed
     */
    public void displayRoute(Route newRoute)
    {
        webEngine.getLoadWorker().stateProperty().addListener(
<<<<<<< HEAD
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
=======
                (ov, oldState, newState) -> {
                    if (newState == Worker.State.SUCCEEDED) {
                        String scriptToExecute = "displayRoute(" + newRoute.toJSONArray() + ");";

                        webEngine.executeScript(scriptToExecute);
>>>>>>> 216b75b3... 1) Fixed one of the git issues assigned to me - the average speed on the profile screen. 2) Fixed the calendar and made it look bigger, still need to add activities to it and also goals if time permits.
                    }
                });
    }

    /**
     * Method to set up the scene. Pre-renders the map and sets up tool tips.
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
<<<<<<< HEAD
     * goes back to the data analysis screen
     */
    @FXML public void goToDataAnalysis()
    {
//        guiController.launchActivityViewerScene();
        guiController.getTitleBar().openAnalysis();
=======
     * Method to open the view activities screen.
     * Called when the back button is pressed.
     */
    @FXML void openViewActivities() {
        this.app.getTitleBar().openViewActivities();
>>>>>>> 3e2b2c22... Changed the screens so that now the graphs are only accessible from view activities, same with map.
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
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        String template = "";
        try {
            template = Resources.toString(Resources.getResource("map.html"), Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String renderedTemplate = jinjava.render(template, context);
    }
}
