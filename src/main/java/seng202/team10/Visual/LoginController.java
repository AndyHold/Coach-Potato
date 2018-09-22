package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.UserProfile;

import java.util.ArrayList;

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
    @FXML private Button deleteProfileButton;
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    private boolean deleteMode;


    public void setApp(GUIController app) {
        this.app = app;
    }


    /**
     *
     */
    public void setUpScene() {
        // Set Button tool tips
        userOneButton.setTooltip(new Tooltip("Select Create New Profile to add a new user here"));
        createProfileButton.setTooltip(new Tooltip("Navigates to the Create Profile Screen"));
        deleteProfileButton.setTooltip(new Tooltip("Toggles delete mode.\nOnce delete mode is activated the profiles you click on will be deleted"));
        helpButton.setTooltip(new Tooltip("Need Help?"));

        // Set help text
        helpTextArea.setText("Welcome to the Login Screen!\n\n" +
                "On this screen you can choose a profile to login with, delete Profiles, or go to the Create Profile Screen.\n\n\t" +
                "- To login with an existing profile simply click the\n\t  " +
                "button above the Profile's name.\n\t" +
                "- To delete a profile, click the Delete Profile button to\n\t  " +
                "enter delete mode. The profile buttons should all\n\t  " +
                "have a red border now. If you now click a profile\n\t" +
                "  you will get a confirmation box to ask if you are\n\t" +
                "  sure you want to delete the profile.\n\t" +
                "- To create a new profile simply click the\n\t  " +
                "Create Profile Button and you will be taken to the\n\t  " +
                "Create Profile Screen.\n\n" +
                "Hover the mouse over each button to see a brief discription of what it does.");
        helpTextArea.setWrapText(true);
        helpTextArea.setVisible(false);
        // Reset buttons to default images etc
        resetButtons();
        // Set delete mode to false
        deleteMode = false;
        // Disable the user buttons
        disableButtons();
        // Set up user buttons
        setUpUserButtons();
        userOneImage.setVisible(true);
        userTwoImage.setVisible(true);
        userThreeImage.setVisible(true);
        userFourImage.setVisible(true);
        userFiveImage.setVisible(true);
        if (app.getUsers().size() == 5) {
            createProfileButton.setDisable(true);
        }

        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    private void setUpUserButtons()
    {
        ObservableList<String> userNames = FXCollections.observableArrayList();
        ArrayList<UserProfile> users = app.getUsers();
        for (int i = 0; i < users.size(); i++) {
            UserProfile user = app.getUsers().get(i);
            setButtonProperties(i, user);
            userNames.add(user.getName()); // Delete When Finished
        }
    }


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
                    // Set tool tip
                    if (deleteMode) {
                        userOneButton.setTooltip(new Tooltip("Delete user \"" + user.getName() + "\""));
                    } else {
                        userOneButton.setTooltip(new Tooltip("Login with user \"" + user.getName() + "\""));
                    }
                    break;
                case 1:
                    // Set image
                    userTwoImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userTwoNameLabel.setText(user.getName());
                    // Set Enabled
                    userTwoButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userTwoButton.setTooltip(new Tooltip("Delete user \"" + user.getName() + "\""));
                    } else {
                        userTwoButton.setTooltip(new Tooltip("Login with user \"" + user.getName() + "\""));
                    }
                    break;
                case 2:
                    // Set image
                    userThreeImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userThreeNameLabel.setText(user.getName());
                    // Set Enabled
                    userThreeButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userThreeButton.setTooltip(new Tooltip("Delete user \"" + user.getName() + "\""));
                    } else {
                        userThreeButton.setTooltip(new Tooltip("Login with user \"" + user.getName() + "\""));
                    }
                    break;
                case 3:
                    // Set image
                    userFourImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userFourNameLabel.setText(user.getName());
                    // Set Enabled
                    userFourButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userFourButton.setTooltip(new Tooltip("Delete user \"" + user.getName() + "\""));
                    } else {
                        userFourButton.setTooltip(new Tooltip("Login with user \"" + user.getName() + "\""));
                    }
                    break;
                case 4:
                    // Set image
                    userFiveImage.setImage(new Image("Images/" + user.getGender() + ".png"));
                    // Set name
                    userFiveNameLabel.setText(user.getName());
                    // Set Enabled
                    userFiveButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userFiveButton.setTooltip(new Tooltip("Delete user \"" + user.getName() + "\""));
                    } else {
                        userFiveButton.setTooltip(new Tooltip("Login with user \"" + user.getName() + "\""));
                    }
                    break;
            }
        } catch (IllegalArgumentException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
        }
    }


    @FXML private void displayHelp()
    {
        helpTextArea.setVisible(true);
        helpTextArea.requestFocus();
    }


    @FXML public void hideHelpTextArea()
    {
        helpTextArea.setVisible(false);
        helpButton.requestFocus();
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
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
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
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
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
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
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
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
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
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
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
            setUpUserButtons();
            toggleRedBorders();

        } else {
            deleteMode = true;
            setUpUserButtons();
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
        userOneButton.setTooltip(null);
        userTwoButton.setTooltip(null);
        userThreeButton.setTooltip(null);
        userFourButton.setTooltip(null);
        userFiveButton.setTooltip(null);
    }
}
