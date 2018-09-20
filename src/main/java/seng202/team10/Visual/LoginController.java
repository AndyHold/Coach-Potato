package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.UserProfile;

public class LoginController implements Controllable{
    private GUIController app;

    @FXML private Button loginButton;
    @FXML private Button newProfileButton;
    @FXML private ComboBox<String> userComboBox;
    @FXML private Label userErrorLabel;
    @FXML private ImageView user1Image;
    @FXML private ImageView user2Image;
    @FXML private ImageView user3Image;
    @FXML private ImageView user4Image;
    @FXML private ImageView user5Image;
    @FXML private Button user1Button;
    @FXML private Button user2Button;
    @FXML private Button user3Button;
    @FXML private Button user4Button;
    @FXML private Button user5Button;
    @FXML private Label user1Label;
    @FXML private Label user2Label;
    @FXML private Label user3Label;
    @FXML private Label user4Label;
    @FXML private Label user5Label;


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
        user1Image.setVisible(true);
        user2Image.setVisible(true);
        user3Image.setVisible(true);
        user4Image.setVisible(true);
        user5Image.setVisible(true);
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
