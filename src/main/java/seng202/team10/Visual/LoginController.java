package seng202.team10.Visual;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import seng202.team10.Control.MainController;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Controller class for the login screen, which displays lists of users for logging in.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class LoginController implements Controllable{
    private MainController mainController ;


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
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setMainController(MainController mainController )
    {
        this.mainController = mainController ;
    }


    /**
     * Sets up objects that require it prior to showing the scene.
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
        if  (mainController. getUserNames().size() == 5) {
            createProfileButton.setDisable(true);
        }
        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    /**
     * Method called when the close button is selected.
     * Closes the application.
     */
    @FXML public void close()
    {
        Platform.exit();
    }


    /**
     * Set the css style for the User Buttons as a string.
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
     * Set up method for the tool tips.
     */
    private void setUpToolTips()
    {
        userOneButton.setTooltip(new Tooltip("Select Create New Profile to add a new user here"));
        userTwoButton.setTooltip(new Tooltip("Select Create New Profile to add a new user here"));
        userThreeButton.setTooltip(new Tooltip("Select Create New Profile to add a new user here"));
        userFourButton.setTooltip(new Tooltip("Select Create New Profile to add a new user here"));
        userFiveButton.setTooltip(new Tooltip("Select Create New Profile to add a new user here"));
        createProfileButton.setTooltip(new Tooltip("Navigates to the Create Profile Screen"));
        deleteProfileButton.setTooltip(new Tooltip("Toggles delete mode.\nOnce delete mode is activated the profiles you click on will be deleted"));
        helpButton.setTooltip(new Tooltip("Need Help?"));
    }


    /**
     * Set up method for the help text field.
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
        ArrayList<String> userNames = mainController .getUserNames();
        ArrayList<String> userGenders = mainController .getUserGenders();
        for (int i = 0; i < userNames.size(); i++) {
            setButtonProperties(i, userNames.get(i), userGenders.get(i));
        }
        userOneImage.setVisible(true);
        userTwoImage.setVisible(true);
        userThreeImage.setVisible(true);
        userFourImage.setVisible(true);
        userFiveImage.setVisible(true);
    }


    /**
     * Setter method for the user buttons. Sets the user to a button depending on the index in the list of users.
     * @param index An <b>Integer</b> index of the user list.
     * @param name A <b>String</b> name of the user to be associated with a button.
     * @param gender A <b>String</b> gender of the user to be associated with a button.
     */
    private void setButtonProperties(int index, String name, String gender)
    {
        try {
            switch (index) {
                case 0:
                    // Set image
                    userOneImage.setImage(new Image("Images/" + gender + ".png"));
                    // Set name
                    userOneNameLabel.setText(name);
                    // Set Enabled
                    userOneButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userOneButton.setTooltip(new Tooltip("Delete user \"" + name + "\""));
                    } else {
                        userOneButton.setTooltip(new Tooltip("Login with user \"" + name + "\""));
                    }
                    break;
                case 1:
                    // Set image
                    userTwoImage.setImage(new Image("Images/" + gender + ".png"));
                    // Set name
                    userTwoNameLabel.setText(name);
                    // Set Enabled
                    userTwoButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userTwoButton.setTooltip(new Tooltip("Delete user \"" + name + "\""));
                    } else {
                        userTwoButton.setTooltip(new Tooltip("Login with user \"" + name + "\""));
                    }
                    break;
                case 2:
                    // Set image
                    userThreeImage.setImage(new Image("Images/" + gender + ".png"));
                    // Set name
                    userThreeNameLabel.setText(name);
                    // Set Enabled
                    userThreeButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userThreeButton.setTooltip(new Tooltip("Delete user \"" + name + "\""));
                    } else {
                        userThreeButton.setTooltip(new Tooltip("Login with user \"" + name + "\""));
                    }
                    break;
                case 3:
                    // Set image
                    userFourImage.setImage(new Image("Images/" + gender + ".png"));
                    // Set name
                    userFourNameLabel.setText(name);
                    // Set Enabled
                    userFourButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userFourButton.setTooltip(new Tooltip("Delete user \"" + name + "\""));
                    } else {
                        userFourButton.setTooltip(new Tooltip("Login with user \"" + name + "\""));
                    }
                    break;
                case 4:
                    // Set image
                    userFiveImage.setImage(new Image("Images/" + gender + ".png"));
                    // Set name
                    userFiveNameLabel.setText(name);
                    // Set Enabled
                    userFiveButton.setDisable(false);
                    // Set tool tip
                    if (deleteMode) {
                        userFiveButton.setTooltip(new Tooltip("Delete user \"" + name + "\""));
                    } else {
                        userFiveButton.setTooltip(new Tooltip("Login with user \"" + name + "\""));
                    }
                    break;
            }
        } catch (IllegalArgumentException exception) {
            this.mainController.createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
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
    @FXML public void userButtonOne() {
        if (deleteMode) {
            String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + mainController .getUserNames().get(0) + "\"");
            if (option.equals("OK")) {
                if  (mainController. getUserNames().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                mainController .getDataWriter().deleteProfile (mainController. getUserNames().get(0) + " - " + mainController .getUserGenders().get(0));
                mainController .getUserNames().remove(0);
                mainController .getUserGenders().remove(0);
                deleteProfile();
                setUpScene();
                if  (mainController. getUserNames().size() == 0) {
                    mainController .getTitleBar().openCreateProfile();
                }
            }
        } else {
            try {
                mainController .setCurrentProfile (mainController. getDataReader().loadExistingProfile (mainController. getUserNames().get(0) + " - " + mainController .getUserGenders().get(0)));
                mainController .getTitleBar().openViewProfile();
            } catch (ClassNotFoundException | IOException exception) {
                String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Error", "Could not load profile: " + mainController .getUserNames().get(0) + "\nWould you like to delete it?");
                if (option.equals("OK")) {
                    mainController .getDataWriter().deleteProfile (mainController. getUserNames().get(0) + " - " + mainController .getUserGenders().get(0));
                    mainController .getUserNames().remove(0);
                    mainController .getUserGenders().remove(0);
                    setUpScene();
                    if  (mainController. getUserNames().size() == 0) {
                        mainController .getTitleBar().openCreateProfile();
                    }
                }
            }
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
            String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + mainController .getUserNames().get(1) + "\"");
            if (option.length() == 2) {
                if  (mainController. getUserNames().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                mainController .getDataWriter().deleteProfile (mainController. getUserNames().get(1) + " - " + mainController .getUserGenders().get(1));
                mainController .getUserNames().remove(1);
                mainController .getUserGenders().remove(1);
                deleteProfile();
                setUpScene();
            }
        } else {
            try {
                mainController .setCurrentProfile (mainController. getDataReader().loadExistingProfile (mainController. getUserNames().get(1) + " - " + mainController .getUserGenders().get(1)));
                mainController .getTitleBar().openViewProfile();
            } catch (IOException | ClassNotFoundException exception) {
                String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Error", "Could not load profile: " + mainController .getUserNames().get(1) + "\nWould you like to delete it?");
                if (option.equals("OK")) {
                    mainController .getDataWriter().deleteProfile (mainController. getUserNames().get(1) + " - " + mainController .getUserGenders().get(1));
                    mainController .getUserNames().remove(1);
                    mainController .getUserGenders().remove(1);
                    setUpScene();
                }
            }
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
            String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + mainController .getUserNames().get(2) + "\"");
            if (option.length() == 2) {
                if  (mainController. getUserNames().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                mainController .getDataWriter().deleteProfile (mainController. getUserNames().get(2) + " - " + mainController .getUserGenders().get(2));
                mainController .getUserNames().remove(2);
                mainController .getUserGenders().remove(2);
                deleteProfile();
                setUpScene();
            }
        } else {
            try {
                mainController .setCurrentProfile (mainController. getDataReader().loadExistingProfile (mainController. getUserNames().get(2) + " - " + mainController .getUserGenders().get(2)));
                mainController .getTitleBar().openViewProfile();
            } catch (IOException | ClassNotFoundException exception) {
                String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Error", "Could not load profile: " + mainController .getUserNames().get(2) + "\nWould you like to delete it?");
                if (option.equals("OK")) {
                    mainController .getDataWriter().deleteProfile (mainController. getUserNames().get(2) + " - " + mainController .getUserGenders().get(2));
                    mainController .getUserNames().remove(2);
                    mainController .getUserGenders().remove(2);
                    setUpScene();
                }
            }
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
            String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + mainController .getUserNames().get(3) + "\"");
            if (option.length() == 2) {
                if  (mainController. getUserNames().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                mainController .getDataWriter().deleteProfile (mainController. getUserNames().get(3) + " - " + mainController .getUserGenders().get(3));
                mainController .getUserNames().remove(3);
                mainController .getUserGenders().remove(3);
                deleteProfile();
                setUpScene();
            }
        } else {
            try {
                mainController .setCurrentProfile (mainController. getDataReader().loadExistingProfile (mainController. getUserNames().get(3) + " - " + mainController .getUserGenders().get(3)));
                mainController .getTitleBar().openViewProfile();
            } catch (IOException | ClassNotFoundException exception) {
                String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Error", "Could not load profile: " + mainController .getUserNames().get(3) + "\nWould you like to delete it?");
                if (option.equals("OK")) {
                    mainController .getDataWriter().deleteProfile (mainController. getUserNames().get(3) + " - " + mainController.getUserGenders().get(3));
                    mainController.getUserNames().remove(3);
                    mainController.getUserGenders().remove(3);
                    setUpScene();
                }
            }
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
            String option = mainController.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + mainController.getUserNames().get(4) + "\"");
            if (option.length() == 2) {
                if  (mainController. getUserNames().size() == 5) {
                    createProfileButton.setDisable(false);
                }
                mainController.getDataWriter().deleteProfile (mainController. getUserNames().get(4) + " - " + mainController.getUserGenders().get(4));
                mainController.getUserNames().remove(4);
                mainController.getUserGenders().remove(4);
                deleteProfile();
                setUpScene();
            }
        } else {
            try {
                mainController.setCurrentProfile (mainController. getDataReader().loadExistingProfile (mainController. getUserNames().get(4) + " - " + mainController.getUserGenders().get(4)));
                mainController.getTitleBar().openViewProfile();
            } catch (IOException | ClassNotFoundException exception) {
                String option = mainController.createPopUp(Alert.AlertType.CONFIRMATION, "Error", "Could not load profile: " + mainController.getUserNames().get(4) + "\nWould you like to delete it?");
                if (option.equals("OK")) {
                    mainController.getDataWriter().deleteProfile (mainController. getUserNames().get(4) + " - " + mainController.getUserGenders().get(4));
                    mainController.getUserNames().remove(4);
                    mainController.getUserGenders().remove(4);
                    setUpScene();
                }
            }
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
        mainController.getTitleBar().openCreateProfile();
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
    private void toggleDeleteButtons()
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
