package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.UserProfile;

public class LoginController implements Controllable{
    private GUIController app;

    @FXML
    private Button loginButton;

    @FXML
    private Button newProfileButton;

    @FXML
    private ComboBox<String> userComboBox;

    @FXML
    private Label userErrorLabel;

    public void setApp(GUIController app) {
        this.app = app;
    }

    /**
     *
     */
    public void setUpScene() {
        ObservableList<String> userNames = FXCollections.observableArrayList();
        for (UserProfile user : app.getUsers()) {
            userNames.add(user.getName());
        }
        userComboBox.setItems(userNames);
        userComboBox.setVisibleRowCount(10);
        userErrorLabel.setVisible(false);
        if (!userNames.isEmpty()) {
            loginButton.setDisable(false);
        }
    }

    @FXML
    public void login() throws Exception {
        setUpScene();
        String userName = userComboBox.getValue();
        if (userName == null) {
            userErrorLabel.setVisible(true);
        } else {
            for (UserProfile user : app.getUsers()) {
                if (userName == user.getName()) {
                    app.setCurrentProfile(user);
                    app.launchProfileScene();
                }
            }
        }
    }

    @FXML
    public void createProfile() throws Exception {
        setUpScene();
        app.launchCreateProfileScene();
    }

}
