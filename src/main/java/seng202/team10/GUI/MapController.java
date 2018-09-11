package seng202.team10.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;

import java.net.URL;
import java.util.ResourceBundle;

public class MapController implements Controllable, Initializable{

    private GUIController guiController;
    private WebEngine webEngine;
    private Activity activity;

    @FXML WebView mapWebView;

//    @FXML Label activityLabel;

    @Override
    public void setApp(GUIController guiController) {
        this.guiController = guiController;
    }

    @Override
    public void setUpScene() {

    }

//    private Route routeA = new Route(
//            new Position(37.772, -122.214, 0),
//            new Position(21.291,  -157.821, 0),
//            new Position(-18.142, 178.431, 0),
//            new Position(-27.467, 153.027, 0)
//    );
//
//    private Route routeB = new Route(
//            new Position(-33.946111, 151.177222, 0),
//            new Position(-43.489444, 172.532222, 0)
//    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        initMap();
//        webEngine.getLoadWorker().stateProperty().addListener(
//                new ChangeListener<Worker.State>() {
//                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
//                        if (newState == Worker.State.SUCCEEDED) {
//                            displayRoute(routeA);
//                        }
//                    }
//                });
//        routeSelection.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == routeARadioButton) {
//                displayRoute(routeA);
//            } else {
//                displayRoute(routeB);
//            }
//        });
    }
//
//    private void initMap() {
//        webEngine = mapWebView.getEngine();
//        webEngine.load(MapController.class.getResource("/map.html").toExternalForm());
//    }

//    private void displayRoute(Route newRoute) {
//        String scriptToExecute = "displayRoute(" + newRoute.toJSONArray() + ");";
//        webEngine.executeScript(scriptToExecute);
//    }

//    private void displayRoute(Route newRoute) {
//        String scriptToExecute = "displayRoute(" + newRoute.toJSONArray() + ");";
//        webEngine.executeScript(scriptToExecute);
//    }
//
//    @Override
//    public void setUpScene() {
//
//        webEngine = mapWebView.getEngine();
//        webEngine.load(this.getClass().getResource("/map.html").toExternalForm());
//
////        this.activity = guiController.getCurrentProfile().getActivities().get(0);
////        System.out.println(activity.getEntries());
//        Route route = new Route(
//                new Position(30.2553368, -97.83891084, 0)
//        );
//
//        this.displayRoute(route);
//    }
//
//    static { // use system proxy settings when standalone application
//        System.setProperty("java.net.useSystemProxies", "true");
//    }
//
    @FXML
    public void goToActivityViewer() {
        System.out.println("boop");
    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        webEngine = mapWebView.getEngine();
//        webEngine.load(this.getClass().getResource("/map.html").toExternalForm());
//
////        this.activity = guiController.getCurrentProfile().getActivities().get(0);
////        System.out.println(activity.getEntries());
//        Route route = new Route(
//                new Position(30.2553368, -97.83891084, 0)
//        );
//
//        this.displayRoute(route);
//    }
}
