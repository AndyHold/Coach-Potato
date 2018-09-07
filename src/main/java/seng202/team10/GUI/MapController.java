package seng202.team10.GUI;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import seng202.team10.Control.GUIController;

public class MapController implements Controllable{

    private GUIController guiController;
    private WebEngine webEngine;

    @FXML WebView mapWebView;


    @Override
    public void setApp(GUIController guiController) {
        this.guiController = guiController;
    }

    @Override
    public void setUpScene() {
        webEngine = mapWebView.getEngine();
        webEngine.load("https://www.google.com/maps/@-43.5223396,172.5775872,15z");

    }

    @FXML
    public void goToActivityViewer() {
        System.out.println("boop");
    }
}
