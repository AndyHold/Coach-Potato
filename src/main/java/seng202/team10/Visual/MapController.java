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
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.Entry;
import seng202.team10.Model.ActivitiesData.Route;

import java.net.URL;
import java.io.IOException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Controller class for the map screen, where a map of an activity is displayed.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class MapController implements Controllable, Initializable{

    private MainController mainController ;
    private WebEngine webEngine;
    private Activity activity;
    private Route route;

    @FXML private WebView mapWebView;
    @FXML private Label activityLabel;
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    @FXML private Button backButton;
    @FXML private Label noInternetLabel;
    private String renderedTemplate;


    /**
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }


    /**
     * Method to display a route on the map, and show the map to the user.
     * @param newRoute The <b>Route</b> being displayed.
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
                                noInternetLabel.setVisible(false);
                            } catch (Exception exception) {
                            }
                        }
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
        noInternetLabel.setVisible(true);

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
                             "- To move the map simply hold down the right mouse\n" +
                             "  button and drag the mouse in the direction you wish.\n" +
                             "- To return to the Graphs Screen select the Back button.\n\n" +
                             "The start of your activity is marked by the green pin and the end is marked by the finish flag.");
        helpTextArea.setWrapText(true);
        helpTextArea.setVisible(false);
    }


    /**
     * Set up method for the tool tips
     */
    private void setUpToolTips()
    {
        backButton.setTooltip(new Tooltip("Click here to return to the View Activities screen."));
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
     * Setter method for the activity being mapped.
     * @param activity The <b>Activity</b> being mapped.
     */
    public void setActivity(Activity activity)
    {
        this.activity = activity;
        this.activityLabel.setText(activity.getName());
    }

    /**
     * Method to open the view activities screen.
     * Called when the back button is pressed.
     */
    @FXML void openViewActivities() {
        this.mainController.getTitleBar().openViewActivities();
    }

    /**
     * Creates a new Route from an activity.
     * @param activity The <b>Activity</b> being mapped.
     * @return A <b>Route</b> object made from the activity.
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
        renderedTemplate = jinjava.render(template, context);
    }
}
