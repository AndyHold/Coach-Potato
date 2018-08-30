package seng202.team10.GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import seng202.team10.Control.GUIController;

public class LoginControl {
    private GUIController app;

    @FXML
    Button loginButton;

    @FXML
    Button newProfileButton;


    public void setApp(GUIController app) {
        this.app = app;
    }

    @FXML
    public void login() {
        loginButton.setText("A thing happened.");
//        app.launchProfileScene(user);

    }

    @FXML
    public void createProfile() throws Exception {
        app.launchCreateProfileScene();
    }

}
