package seng202.team10.GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    private Activity activity;

    @FXML private WebView mapWebView;

    @FXML private Label activityLabel;

    @Override
    public void setApp(GUIController guiController) {
        this.guiController = guiController;
    }

//    @Override
//    public void setUpScene() {
//
//    }

    private Route route;

//    private void initMap() {
//        webEngine = mapWebView.getEngine();
//        webEngine.load(MapController.class.getResource("/map.html").toExternalForm());
//    }

    public void displayRoute(Route newRoute) {
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            String scriptToExecute = "displayRoute(" + newRoute.toJSONArray() + ");";

                            webEngine.executeScript(scriptToExecute);
                        }
                    }
                });



    }

    @Override
    public void setUpScene() {

        webEngine = mapWebView.getEngine();
        webEngine.load(this.getClass().getResource("/map.html").toExternalForm());


//
//
//        webEngine = mapWebView.getEngine();
//        webEngine.load(this.getClass().getResource("/map.html").toExternalForm());
//        System.out.println("Hello");
//        route = makeRoute(activity);
//        System.out.println("Hello there");
//        this.displayRoute(route);
//        System.out.println("Howdy");
    }
//    }

//    static { // use system proxy settings when standalone application
//        System.setProperty("java.net.useSystemProxies", "true");
//    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        this.activityLabel.setText(activity.getName());
    }

    @FXML
    public void goToActivityViewer() throws Exception{
//        guiController.launchActivityViewerScene();
        guiController.launchDataAnalysisScene();
    }

    public Route makeRoute(Activity activity) {
        Route route = new Route();
        for (Entry entry : activity.getEntries()) {
            route.addPosition(entry.getPosition());
        }
        return route;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        webEngine = mapWebView.getEngine();
//        webEngine.load(this.getClass().getResource("/map.html").toExternalForm());
//        this.activity = guiController.getCurrentProfile().getActivities().get(0);
//        System.out.println(activity.getEntries());

//        this.displayRoute(routeA);
    }
}
