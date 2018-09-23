package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import javafx.scene.layout.HBox;
>>>>>>> 5997e6c... Finished Implementing new Login Screen Layout.
import org.apache.commons.lang3.ObjectUtils;
=======
=======
>>>>>>> 4d39bd8... Wrote some more tests for Activity, Entry, Position classes and JavaDocs for those classes.
import javafx.scene.layout.VBox;
>>>>>>> 472482d... Now the cursor is not focused on the name field on create profile screen.
=======
>>>>>>> b7ca092... Refactored a large method into many small methods and javadocced
=======
import org.apache.commons.lang3.StringUtils;
>>>>>>> 571a3a4... Added Help Button functionality to Create Profile Screen
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.Goals.UserProfile;

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

<<<<<<< HEAD

<<<<<<< HEAD
=======
>>>>>>> 8a6e898... Wrote JavaDoc for the menu button and bar on most of the main controllers and also for few methods that were pending.
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
    @FXML private Button createProfileButton;
    @FXML private Button helpButton;
    @FXML private TextArea helpTextArea;


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
=======
    @FXML
    private VBox wholeProfileVBox;

>>>>>>> 472482d... Now the cursor is not focused on the name field on create profile screen.
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
        helpButton.requestFocus();
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
        //Set tool tips
        setToolTips();
        // Set up help text area
        setUpHelpTextArea();
        //Set up combo box's
        setUpDateComboBoxs();
        //Set gender toggle buttons
        setUpGenderToggles();
        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    /**
     * Set up method for the gender toggle buttons
     */
    private void setUpGenderToggles()
    {
        toggleGroup = new ToggleGroup();
        femaleRad.setToggleGroup(toggleGroup);
        maleRad.setToggleGroup(toggleGroup);
        notSpecifiedRad.setToggleGroup(toggleGroup);
    }


    /**
     * Set up method for the date combo boxs
     */
    private void setUpDateComboBoxs()
    {
        // Set up days comboBox
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
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        nameEntry.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
            if(newValue && firstTime.get()){
                wholeProfileVBox.requestFocus(); // Delegate the focus to container
                firstTime.setValue(false); // Variable value changed for future references
            }
        });

=======
>>>>>>> 8a6e898... Wrote JavaDoc for the menu button and bar on most of the main controllers and also for few methods that were pending.
=======
        //Set gender toggle buttons
>>>>>>> b7ca092... Refactored a large method into many small methods and javadocced
        toggleGroup = new ToggleGroup();
        femaleRad.setToggleGroup(toggleGroup);
        maleRad.setToggleGroup(toggleGroup);
        notSpecifiedRad.setToggleGroup(toggleGroup);
=======
>>>>>>> f2314b3... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.

    /**
     * Set up method for the help text area
     */
    private void setUpHelpTextArea()
    {
        helpTextArea.setText("Welcome to the Create Profile Screen!\n\n" +
                             "On this screen you can create a new profile or navigate back to the Login Screen.\n\n" +
                             "To create a new profile:\n" +
                             "\t- Choose and input a new user name.\n" +
                             "\t- Select your date of birth from the drop down box's.\n" +
                             "\t- Enter your weight in kg's and your height in cm's.\n" +
                             "\t- Select your gender from the options displayed.\n" +
                             "\t- Click the Create Profile button\n" +
                             "Any missing fields or errors in the data you have input will then be displayed in red. " +
                             "Otherwise your profile will be created and you will be taken to the Login Screen.\n\n" +
                             "Hover the mouse over each item to see a brief description of what is required or what it does.");
        helpTextArea.setWrapText(true);
        helpTextArea.setVisible(false);
    }


    /**
     * Set up method for tool tips
     */
    private void setToolTips()
    {
        // Set tool tips for text fields and text fields
        nameEntry.setTooltip(new Tooltip("Please enter a user name.\n" +
                                         "User name must be between 1 to 15 characters long.\n" +
                                         "User name must be unique\n" +
                                         "User name is not case sensitive."));
        weightEntry.setTooltip(new Tooltip("Please enter your weight in kg's.\n" +
                                           "Weight must be between 30kg to 250kg.\n" +
                                           "You do not need to put kg at the end."));
        heightEntry.setTooltip(new Tooltip("Please enter your height in cm's\n" +
                                           "Height must be between 50cm to 260cm.\n" +
                                           "You do not need to put cm at the end."));
        // Set tool tip for Combo Box's
        dayEntry.setTooltip(new Tooltip("Please select a day of the month from the drop down list."));
        monthEntry.setTooltip(new Tooltip("Please select a month of the year from the drop down list."));
        yearEntry.setTooltip(new Tooltip("Please select a year from the drop down list."));
        // Set tool tips for radio buttons
        maleRad.setTooltip(new Tooltip("Please select a gender from these options."));
        femaleRad.setTooltip(new Tooltip("Please select a gender from these options."));
        notSpecifiedRad.setTooltip(new Tooltip("Please select a gender from these options."));
        // Set tool tips for buttons
        backButton.setTooltip(new Tooltip("Navigates back to Login Screen"));
        helpButton.setTooltip(new Tooltip("Need Help?"));
        createProfileButton.setTooltip(new Tooltip("Checks the input data and displays errors in red where necessary.\n" +
                                                   "Creates a new profile if all input data is valid and navigates to the login screen."));
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
<<<<<<< HEAD
        try {
            String nameString =  getTextFieldString(nameEntry);
            this.app.checkUniqueName(nameString);
<<<<<<< HEAD
            userProfile.setName(nameString);
<<<<<<< HEAD
<<<<<<< HEAD
        } catch (InvalidNameException | IllegalArgumentException exception) {
=======
        } catch (InvalidNameException | IllegalArgumentException | UserNameException excpetion) {
>>>>>>> 5997e6c... Finished Implementing new Login Screen Layout.
=======
        } catch (UserNameException | IllegalArgumentException exception) {
>>>>>>> 798a1f8... fixed invalidNameException bug
=======
            try {
                userProfile.setName(nameString);
            } catch (UserNameException | IllegalArgumentException exception) {
                nameErrorLabel.setVisible(true);
            }
        } catch (UniqueNameException | IllegalArgumentException exception) {
            nameErrorLabel.setText("This username already exists.");
>>>>>>> 31fa09e... Fixed up Unique name error and got it completely working so that it catches all errors on Create profile and edit profile.
            nameErrorLabel.setVisible(true);
        }
=======
        this.setUserName(userProfile);
<<<<<<< HEAD
>>>>>>> b7ca092... Refactored a large method into many small methods and javadocced

=======
>>>>>>> f2314b3... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.
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
    private void saveUserProfile(UserProfile userProfile)
    {
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
    private void setUserMaxHeartRate(UserProfile userProfile)
    {
        try {
            userProfile.setMaxHeartRate(220 - (Calendar.getInstance().get(Calendar.YEAR) - userProfile.getBirthDate().getYear()));
        } catch (NullPointerException exception) { }
    }


    /**
     * Method to set the gender of the user. This is taken from the currently selected toggle button.
     * @param userProfile  A UserProfile that is being created.
     */
    private void setUserGender(UserProfile userProfile)
    {
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
    private void setUserDOB(UserProfile userProfile)
    {
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
    private void setUserHeight(UserProfile userProfile)
    {
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
    private void setUserWeight(UserProfile userProfile)
    {
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
    private void setUserName(UserProfile userProfile)
    {
        try {
            String nameString = StringUtils.capitalize(getTextFieldString(nameEntry).toLowerCase());
            System.out.print(nameString);
            this.app.checkUniqueName(nameString);
            try {
                userProfile.setName(nameString);
            } catch (UserNameException | IllegalArgumentException exception) {
                nameErrorLabel.setText("Please enter a valid user name between 1 - 15 characters");
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