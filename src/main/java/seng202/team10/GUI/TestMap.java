package seng202.team10.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestMap extends Application {

    private Scene scene;
    @Override public void start(Stage stage) {
//        // create the scene
//        stage.setTitle("Web View");
//        scene = new Scene(new Browser(),750,500, Color.web("#666970"));
//        stage.setScene(scene);
////        scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
//        stage.show();
    }
//
//    class Browser extends Region {
//
//        final WebView browser = new WebView();
//        final WebEngine webEngine = browser.getEngine();
//
//        public Browser() {
//            //apply the styles
//            getStyleClass().add("browser");
//            // load the web page
//            webEngine.load("https://maps.googleapis.com/maps/api/js?callback=myMap");
//            //add the web view to the scene
//            getChildren().add(browser);
//
//        }
//        private Node createSpacer() {
//            Region spacer = new Region();
//            HBox.setHgrow(spacer, Priority.ALWAYS);
//            return spacer;
//        }
//
//        @Override protected void layoutChildren() {
//            double w = getWidth();
//            double h = getHeight();
//            layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
//        }
//
//        @Override protected double computePrefWidth(double height) {
//            return 750;
//        }
//
//        @Override protected double computePrefHeight(double width) {
//            return 500;
//        }
//    }
//
//    static { // use system proxy settings when standalone application
//        System.setProperty("java.net.useSystemProxies", "true");
//    }
//
//    public static void main(String[] args){
//        Application.launch(args);
//    }
}