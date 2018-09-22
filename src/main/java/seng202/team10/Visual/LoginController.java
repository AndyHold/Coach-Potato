package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

/**
 * LoginController Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class LoginController implements Controllable{
    private GUIController app;


    @FXML private ImageView userOneImage;
    @FXML private ImageView userTwoImage;
    @FXML private ImageView userThreeImage;
    @FXML private ImageView userFourImage;
    @FXML private ImageView userFiveImage;
    @FXML private Button userOneButton;
    @FXML private Button userTwoButton;
    @FXML private Button userThreeButton;
    @FXML private Button userFourButton;
    @FXML private Button userFiveButton;
    @FXML private Label userOneNameLabel;
    @FXML private Label userTwoNameLabel;
    @FXML private Label userThreeNameLabel;
    @FXML private Label userFourNameLabel;
    @FXML private Label userFiveNameLabel;
    @FXML private Button createProfileButton;
    private boolean deleteMode;


    public void setApp(GUIController app) {
        this.app = app;
    }


    /**
     * Method to initialize the user images and other objects on the screen.
     */
    public void setUpScene() {
        resetButtons();
        deleteMode = false;
        disableButtons();
        ObservableList<String> userNames = FXCollections.observableArrayList();
        ArrayList<UserProfile> users = app.getUsers();
        for (int i = 0; i < users.size(); i++) {
            UserProfile user = app.getUsers().get(i);
            setButtonProperties(i, user);
            userNames.add(user.getName()); // Delete When Finished
        }
        userOneImage.setVisible(true);
        userTwoImage.setVisible(true);
        userThreeImage.setVisible(true);
        userFourImage.setVisible(true);
        userFiveImage.setVisible(true);
        if (app.getUsers().size() == 5) {
            createProfileButton.setDisable(true);
        }
    }


    /**
     *
     * @param index
     * @param user
     */
    private void setButtonProperties(int index, UserProfile user)
    {
        try {
            switch (index) {
                case 0:
                    // Set image
                    userOneImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userOneNameLabel.setText(user.getName());
                    // Set Enabled
                    userOneButton.setDisable(false);
                    break;
                case 1:
                    // Set image
                    userTwoImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userTwoNameLabel.setText(user.getName());
                    // Set Enabled
                    userTwoButton.setDisable(false);
                    break;
                case 2:
                    // Set image
                    userThreeImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userThreeNameLabel.setText(user.getName());
                    // Set Enabled
                    userThreeButton.setDisable(false);
                    break;
                case 3:
                    // Set image
                    userFourImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userFourNameLabel.setText(user.getName());
                    // Set Enabled
                    userFourButton.setDisable(false);
                    break;
                case 4:
                    // Set image
                    userFiveImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userFiveNameLabel.setText(user.getName());
                    // Set Enabled
                    userFiveButton.setDisable(false);
                    break;
            }
        } catch (IllegalArgumentException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
        }
    }


    private void disableButtons()
    {
        userOneButton.setDisable(true);
        userTwoButton.setDisable(true);
        userThreeButton.setDisable(true);
        userFourButton.setDisable(true);
        userFiveButton.setDisable(true);
    }


    @FXML public void userButtonOne()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "You sure brah", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
            System.out.println(option.length());
            if (option.length() == 2) {
                if (app.getUsers().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                app.getDataWriter().deleteProfile(app.getUsers().get(0).getName());
                app.getUsers().remove(0);
                deleteProfile();
                setUpScene();
                if (app.getUsers().size() == 0) {
                    app.launchCreateProfileScene();
                }
            }
        } else {
            app.setCurrentProfile(app.getUsers().get(0));
            app.launchProfileScene();
        }

    }


    @FXML public void userButtonTwo()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "You sure brah", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
            if (option.length() == 2) {
                if (app.getUsers().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                app.getDataWriter().deleteProfile(app.getUsers().get(1).getName());
                app.getUsers().remove(1);
                deleteProfile();
                setUpScene();
            }
        } else {
            app.setCurrentProfile(app.getUsers().get(1));
            app.launchProfileScene();
        }
    }


    @FXML public void userButtonThree()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "You sure brah", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
            if (option.length() == 2) {
                if (app.getUsers().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                app.getDataWriter().deleteProfile(app.getUsers().get(2).getName());
                app.getUsers().remove(2);
                deleteProfile();
                setUpScene();
            }
        } else {
            app.setCurrentProfile(app.getUsers().get(2));
            app.launchProfileScene();
        }
    }


    @FXML public void userButtonFour()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "You sure brah", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
            if (option.length() == 2) {
                if (app.getUsers().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                app.getDataWriter().deleteProfile(app.getUsers().get(3).getName());
                app.getUsers().remove(3);
                deleteProfile();
                setUpScene();
            }
        } else {
            app.setCurrentProfile(app.getUsers().get(3));
            app.launchProfileScene();
        }
    }


    @FXML public void userButtonFive()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "You sure brah", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
            if (option.length() == 2) {
                if (app.getUsers().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                app.getDataWriter().deleteProfile(app.getUsers().get(4).getName());
                app.getUsers().remove(4);
                deleteProfile();
                setUpScene();
            }
        } else {
            app.setCurrentProfile(app.getUsers().get(4));
            app.launchProfileScene();
        }
    }


    @FXML
    public void createProfile() throws Exception {
        setUpScene();
        app.launchCreateProfileScene();
    }


    @FXML
    public void deleteProfile()
    {
        if(deleteMode) {
            deleteMode = false;
            toggleRedBorders();
        } else {
            deleteMode = true;
            toggleRedBorders();
        }
    }


    public void toggleRedBorders()
    {
        if (userOneButton.getStyle().length() == 0) {
            userOneButton.setStyle("-fx-border-color: red");
            userTwoButton.setStyle("-fx-border-color: red");
            userThreeButton.setStyle("-fx-border-color: red");
            userFourButton.setStyle("-fx-border-color: red");
            userFiveButton.setStyle("-fx-border-color: red");
        } else {
            userOneButton.setStyle(null);
            userTwoButton.setStyle(null);
            userThreeButton.setStyle(null);
            userFourButton.setStyle(null);
            userFiveButton.setStyle(null);
        }
    }


    private void resetButtons()
    {
        userOneImage.setImage(new Image("Images/unknown.png"));
        userTwoImage.setImage(new Image("Images/unknown.png"));
        userThreeImage.setImage(new Image("Images/unknown.png"));
        userFourImage.setImage(new Image("Images/unknown.png"));
        userFiveImage.setImage(new Image("Images/unknown.png"));
        userOneNameLabel.setText(null);
        userTwoNameLabel.setText(null);
        userThreeNameLabel.setText(null);
        userFourNameLabel.setText(null);
        userFiveNameLabel.setText(null);
    }
}
