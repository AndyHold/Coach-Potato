package seng202.team10.Visual;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
=======
import javafx.scene.control.*;
>>>>>>> 0701339c... Added Help Button functionality to Login screen
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
    @FXML private Label deleteModeLabel;
    @FXML private Button createProfileButton;
    @FXML private Button deleteProfileButton;
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    private String userButtonStyle;
    private String userButtonBorderStyle;
    private boolean deleteMode;



    /**
     * Setter method for the GUIController
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * Method to initialize the user images and other objects on the screen.
     */
    public void setUpScene() {
        // Set user button style string
        setUserButtonStyle();
        // Set up Button tool tips
        setUpToolTips();
        // Set help text
        setUpHelpText();
        // Reset buttons to default images etc
        resetButtons();
        // Set delete mode to false
        deleteMode = false;
        // Disable the user buttons
        disableButtons();
        // Set up user buttons
        setUpUserButtons();
        // Disable the create profile button if we have maximum users
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



    @FXML public void titleClicked()
    {
//        app.titleClicked();
    }



    @FXML public void titleReleased()
    {
//        app.titleReleased();
    }


    /**
     * Method called when the close button is selected.
     * closes the application.
     */
    @FXML public void close()
    {
        Platform.exit();
    }


    /**
     * Set the css style for the User Buttons as a string
     */
    private void setUserButtonStyle()
    {
        userButtonStyle = "-fx-background-radius: 8em; " +
                          "-fx-max-height: 200px; " +
                          "-fx-max-width: 200px; " +
                          "-fx-min-height: 200px; " +
                          "-fx-min-width: 200px; " +
                          "-fx-background-color: blueviolet;";
        userButtonBorderStyle = "-fx-border-color: indigo; " +
                                "-fx-border-radius: 8em; " +
                                "-fx-border-width: 4px; ";
    }


    /**
     * Set up Method for the tool tips
     */
    private void setUpToolTips()
    {
        userOneButton.setTooltip(new Tooltip("Select Create New Profile to add a new user here"));
        createProfileButton.setTooltip(new Tooltip("Navigates to the Create Profile Screen"));
        deleteProfileButton.setTooltip(new Tooltip("Toggles delete mode.\nOnce delete mode is activated the profiles you click on will be deleted"));
        helpButton.setTooltip(new Tooltip("Need Help?"));
    }


    /**
     * Set up method for the help text field
     */
    private void setUpHelpText()
    {
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
    }


    /**
     * Set up method for user buttons.
     * Only sets up enough buttons for the amount of users we have.
     */
    private void setUpUserButtons()
    {
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
    }


    /**
     * Setter method for the user buttons. Sets the user to a button depending on the index in the list of users.
     * @param index int: index of the uwser to be set up
     * @param user UserProfile: profile of the user to be associated with a button.
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


    /**
     * Method called when the help button is pushed.
     * Displays the help text area.
     */
    @FXML private void displayHelp()
    {
        helpTextArea.setVisible(true);
        helpTextArea.requestFocus();
    }


    /**
     * Method called when focus to the help text area is lost or when the pane is clicked on.
     * Hides the help text area.
     */
    @FXML public void hideHelpTextArea()
    {
        helpTextArea.setVisible(false);
        helpButton.requestFocus();
    }


    /**
     * Method to disable all the user buttons.
     */
    private void disableButtons()
    {
        userOneButton.setDisable(true);
        userTwoButton.setDisable(true);
        userThreeButton.setDisable(true);
        userFourButton.setDisable(true);
        userFiveButton.setDisable(true);
    }


    /**
     * Method called when user button one is pushed.
     * If in delete mode, prompts the user to delete this profile.
     * If not logs in with this profile.
     */
    @FXML public void userButtonOne()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(0).getName() + "\"");
            if (option.equals("OK")) {
                if (app.getUsers().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                app.getDataWriter().deleteProfile(app.getUsers().get(0).getName());
                app.getUsers().remove(0);
                deleteProfile();
                setUpScene();
                if (app.getUsers().size() == 0) {
                    app.getTitleBar().openCreateProfile();
                }
            }
        } else {
            app.getTitleBar().setCurrentProfile(app.getUsers().get(0));
            app.getTitleBar().openViewProfile();
        }

    }


    /**
     * Method called when user button two is pushed.
     * If in delete mode, prompts the user to delete this profile.
     * If not logs in with this profile.
     */
    @FXML public void userButtonTwo()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(1).getName() + "\"");
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
            app.getTitleBar().openViewProfile();
        }
    }


    /**
     * Method called when user button three is pushed.
     * If in delete mode, prompts the user to delete this profile.
     * If not logs in with this profile.
     */
    @FXML public void userButtonThree()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(2).getName() + "\"");
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
            app.getTitleBar().openViewProfile();
        }
    }


    /**
     * Method called when user button four is pushed.
     * If in delete mode, prompts the user to delete this profile.
     * If not logs in with this profile.
     */
    @FXML public void userButtonFour()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(3).getName() + "\"");
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
            app.getTitleBar().openViewProfile();
        }
    }


    /**
     * Method called when user button five is pushed.
     * If in delete mode, prompts the user to delete this profile.
     * If not logs in with this profile.
     */
    @FXML public void userButtonFive()
    {
        if (deleteMode) {
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + app.getUsers().get(4).getName() + "\"");
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
            app.getTitleBar().openViewProfile();
        }
    }


    /**
     * Method called when create profile button is pushed.
     * Opens the Create Profile Screen
     */
    @FXML
    public void createProfile()
    {
        setUpScene();
        app.getTitleBar().openCreateProfile();
    }


    /**
     * Method called when the delete profile button is pushed.
     * Toggles delete mode and red borders around user buttons.
     */
    @FXML
    public void deleteProfile()
    {
        if(deleteMode) {
            deleteMode = false;
            deleteModeLabel.setVisible(false);
            setUpUserButtons();
            toggleDeleteButtons();

        } else {
            deleteMode = true;
            deleteModeLabel.setVisible(true);
            setUpUserButtons();
            toggleDeleteButtons();
        }
    }


    /**
     * Method to toggle red borders around user buttons
     */
    public void toggleDeleteButtons()
    {
        if (userOneButton.getStyle().equals("")) {
            userOneButton.setStyle(userButtonBorderStyle + userButtonStyle);
            userTwoButton.setStyle(userButtonBorderStyle + userButtonStyle);
            userThreeButton.setStyle(userButtonBorderStyle + userButtonStyle);
            userFourButton.setStyle(userButtonBorderStyle + userButtonStyle);
            userFiveButton.setStyle(userButtonBorderStyle + userButtonStyle);
        } else {
            userOneButton.setStyle(null);
            userTwoButton.setStyle(null);
            userThreeButton.setStyle(null);
            userFourButton.setStyle(null);
            userFiveButton.setStyle(null);
        }
    }


    /**
     * Method to reset user buttons and name labels to default values
     */
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
