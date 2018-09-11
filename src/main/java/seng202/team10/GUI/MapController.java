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
        webEngine.load("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d11556.353949034337!2d172.61863394979792!3d-43.53000993499655!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2snz!4v1536374411725\" width=\"600\" height=\"450\" frameborder=\"0\" style=\"border:0\" allowfullscreen></iframe>");


    }

    static { // use system proxy settings when standalone application
        System.setProperty("java.net.useSystemProxies", "true");
    }

    @FXML
    public void goToActivityViewer() {
        System.out.println("boop");
    }
}
