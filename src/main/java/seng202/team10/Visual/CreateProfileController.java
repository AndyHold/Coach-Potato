package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.UserProfile;

import java.util.Calendar;

/**
 * CreateProfileController Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class CreateProfileController implements Controllable
{

    private GUIController app;
    ToggleGroup toggleGroup;

    @FXML private TextField nameEntry;
    @FXML private TextField weightEntry;
    @FXML private TextField heightEntry;
    @FXML private ComboBox dayEntry;
    @FXML private ComboBox monthEntry;
    @FXML private ComboBox yearEntry;
    @FXML private Label dateErrorLabel;
    @FXML private Label nameErrorLabel;
    @FXML private Label weightErrorLabel;
    @FXML private Label heightErrorLabel;
    @FXML private Label genderErrorLabel;
    @FXML private RadioButton femaleRad;
    @FXML private RadioButton maleRad;
    @FXML private RadioButton notSpecifiedRad;
    @FXML private Button backButton;


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * Method to toggle whether the back button on this page is visible or not. If the back button is visible, calling
     * this function makes it invisible, and if it is invisible, this function makes it visible.
     */
    public void toggleBackButton()
    {
        backButton.requestFocus();
        if (this.app.getUsers().size() == 0) {
            backButton.setDisable(true);
        } else {
            backButton.setDisable(false);
        }
    }


    /**
     * Method to initialize the date of birth combo boxes and the gender toggle group on the screen.
     */
    public void setUpScene()
    {
        //Set up days comboBox
        ObservableList<Integer> days = FXCollections.observableArrayList();
        for (int i = 1; i <= 31; i ++) {
            days.add(i);
        }
        dayEntry.setItems(days);
        dayEntry.setVisibleRowCount(5);

        //Set up months comboBox
        ObservableList<Integer> months = FXCollections.observableArrayList();
        for (int i = 1; i <= 12; i ++) {
            months.add(i);
        }
        monthEntry.setItems(months);
        monthEntry.setVisibleRowCount(5);

        //Set up years comboBox
        ObservableList<Integer> years = FXCollections.observableArrayList();
        for (int i = 1900; i <= 2010; i ++) {
            years.add(i);
        }
        yearEntry.setItems(years);
        yearEntry.setVisibleRowCount(5);

        //Set gender toggle buttons
        toggleGroup = new ToggleGroup();
        femaleRad.setToggleGroup(toggleGroup);
        maleRad.setToggleGroup(toggleGroup);
        notSpecifiedRad.setToggleGroup(toggleGroup);
    }


    /**
     * Method to set all error labels to invisible
     */
    private void setErrorsInvisible()
    {
        dateErrorLabel.setVisible(false);
        nameErrorLabel.setVisible(false);
        weightErrorLabel.setVisible(false);
        heightErrorLabel.setVisible(false);
        genderErrorLabel.setVisible(false);
    }


    /**
     * Method to set all input fields to blank values ready for the next user to be created.
     */
    private void setInputsToNull()
    {
        nameEntry.setText(null);
        weightEntry.setText(null);
        heightEntry.setText(null);
        dayEntry.setValue(null);
        monthEntry.setValue(null);
        yearEntry.setValue(null);
        femaleRad.setSelected(false);
        maleRad.setSelected(false);
        notSpecifiedRad.setSelected(false);
    }


    /**
     * Method to return to the login screen. This is triggered by the 'back' button being pushed
     */
    @FXML public void back()
    {
        // Set all error labels to invisible
        setErrorsInvisible();

        // Set all Text fields etc to null
        setInputsToNull();

        // Launch login screen
        app.launchLoginScene();
    }


    /**
     * Method to create a profile from the given information. Information is taken from each field on the screen, and
     * multiple methods are called to set the information of the user.
     */
    @FXML public void createProfile()
    {
        // Set error labels invisible
        setErrorsInvisible();

        // Create new User Profile
        UserProfile userProfile = new UserProfile();

        // Set Name and handle Exceptions
        this.setUserName(userProfile);

        // Set weight and handle exceptions
        this.setUserWeight(userProfile);

        // Set height and handle Exceptions
        this.setUserHeight(userProfile);

        // Set Date of Birth and handle exceptions
        this.setUserDOB(userProfile);

        // Set gender and handle Exceptions
        this.setUserGender(userProfile);

        // Set Max Heart Rate
        this.setUserMaxHeartRate(userProfile);

        // Add the user to the Controller
        this.saveUserProfile(userProfile);
    }

    /**
     * Method to save the user profile. This serializes the profile and adds it to the list of users in the main controller.
     * @param userProfile A UserProfile with the entered information of the user in it.
     */
    private void saveUserProfile(UserProfile userProfile) {
        try {
            app.createUser(userProfile);
            setErrorsInvisible();
            setInputsToNull();
            this.app.getDataWriter().saveProfile(userProfile);
            app.launchLoginScene();
        } catch (InvalidUserException exception) { }
    }

    /**
     * Method to set the max heart rate of the user. This is calculated from the user's birth date.
     * @param userProfile  A UserProfile that is being created.
     */
    private void setUserMaxHeartRate(UserProfile userProfile) {
        try {
            userProfile.setMaxHeartRate(220 - (Calendar.getInstance().get(Calendar.YEAR) - userProfile.getBirthDate().getYear()));
        } catch (NullPointerException exception) { }
    }

    /**
     * Method to set the gender of the user. This is taken from the currently selected toggle button.
     * @param userProfile  A UserProfile that is being created.
     */
    private void setUserGender(UserProfile userProfile) {
        try {
            String genderString = getSelectedGender();
            userProfile.setGender(genderString);
        } catch (NullPointerException exception) {
            genderErrorLabel.setVisible(true);
        } catch (IllegalArgumentException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
        }
    }

    /**
     * Method to set the date of birth of the user. This is taken from the values of the date combo boxes.
     * @param userProfile  A UserProfile that is being created.
     */
    private void setUserDOB(UserProfile userProfile) {
        try {
            String day = dayEntry.getValue().toString();
            String month = monthEntry.getValue().toString();
            String year = yearEntry.getValue().toString();

            int yearInt = Integer.valueOf(year);
            int monthInt = Integer.valueOf(month);
            int dayInt = Integer.valueOf(day);
            DateTime dateOfBirth = new DateTime(yearInt, monthInt, dayInt, 0, 0, 0);
            userProfile.setBirthDate(dateOfBirth);
        } catch (NullPointerException | IllegalArgumentException exception) {
            dateErrorLabel.setVisible(true);
        }
    }

    /**
     * Method to set the height of the user. This is taken from the relevant text field.
     * @param userProfile  A UserProfile that is being created.
     */
    private void setUserHeight(UserProfile userProfile) {
        try {
            String heightString = getTextFieldString(heightEntry);
            userProfile.setHeight(Double.valueOf(heightString));
        } catch (InvalidHeightException | IllegalArgumentException exception) {
            heightErrorLabel.setVisible(true);
        }
    }

    /**
     * Method to set the weight of the user. This is taken from the relevant text field.
     * @param userProfile  A UserProfile that is being created.
     */
    private void setUserWeight(UserProfile userProfile) {
        try {
            String weightString = getTextFieldString(weightEntry);
            userProfile.setWeight(Double.valueOf(weightString));
        }  catch (InvalidWeightException | IllegalArgumentException exception) {
            weightErrorLabel.setVisible(true);
        }
    }

    /**
     * Method to set the user name of the user. This is taken from the relevant text field.
     * @param userProfile  A UserProfile that is being created.
     */
    private void setUserName(UserProfile userProfile) {
        try {
            String nameString =  getTextFieldString(nameEntry);
            this.app.checkUniqueName(nameString);
            try {
                userProfile.setName(nameString);
            } catch (UserNameException | IllegalArgumentException exception) {
                nameErrorLabel.setVisible(true);
            }
        } catch (UniqueNameException | IllegalArgumentException exception) {
            nameErrorLabel.setText("This username already exists.");
            nameErrorLabel.setVisible(true);
        }
    }


    /**
     * Method to get a String from a TextField element
     * @param textField TextField: text field the String value is extracted from
     * @throws IllegalArgumentException when String is empty
     */
    private String getTextFieldString(TextField textField) throws IllegalArgumentException
    {
        String newString = textField.getText();
        if (newString == null) {
            throw new IllegalArgumentException();
        }
        return newString;
    }


    /**
     * Getter method for the selected Gender
     * @return String
     */
    private String getSelectedGender() throws NullPointerException
    {
        if (toggleGroup.getSelectedToggle().equals(femaleRad)) {
            return "Female";
        } else if (toggleGroup.getSelectedToggle().equals(maleRad)) {
            return "Male";
        } else {
            return "Other";
        }
    }
}