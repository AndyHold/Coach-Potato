package seng202.team10.Visual;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import org.apache.commons.lang3.ObjectUtils;
import javafx.scene.layout.VBox;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.UserProfile;

import javax.naming.InvalidNameException;
import java.util.Calendar;

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
    @FXML private VBox wholeProfileVBox;
    @FXML private Button backButton;


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


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
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene()
    {
        final BooleanProperty firstTime = new SimpleBooleanProperty(true);
        ObservableList<Integer> days = FXCollections.observableArrayList();
        for (int i = 1; i <= 31; i ++) {
            days.add(i);
        }
        dayEntry.setItems(days);
        dayEntry.setVisibleRowCount(5);

        ObservableList<Integer> months = FXCollections.observableArrayList();
        for (int i = 1; i <= 12; i ++) {
            months.add(i);
        }
        monthEntry.setItems(months);
        monthEntry.setVisibleRowCount(5);

        ObservableList<Integer> years = FXCollections.observableArrayList();
        for (int i = 1900; i <= 2010; i ++) {
            years.add(i);
        }
        yearEntry.setItems(years);
        yearEntry.setVisibleRowCount(5);

//        nameEntry.focusedProperty().addListener((observable,  oldValue,  newValue) -> {
//            if(newValue && firstTime.get()){
//                wholeProfileVBox.requestFocus(); // Delegate the focus to container
//                firstTime.setValue(false); // Variable value changed for future references
//            }
//        });

        toggleGroup = new ToggleGroup();
        femaleRad.setToggleGroup(toggleGroup);
        maleRad.setToggleGroup(toggleGroup);
        notSpecifiedRad.setToggleGroup(toggleGroup);
    }


    /**
     * Method to set all Error Labels to Invisible
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
     * Method to return to the login screen
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
     * Method to create a profile from the given information.
     */
    @FXML public void createProfile()
    {
        // Set error labels invisible
        setErrorsInvisible();

        // Create new User Profile
        UserProfile userProfile = new UserProfile();

        // Set Name and handle Exceptions
        try {
            String nameString =  getTextFieldString(nameEntry);
            this.app.checkUniqueName(nameString);
            userProfile.setName(nameString);
        } catch (UserNameException | IllegalArgumentException exception) {
            nameErrorLabel.setVisible(true);
        }

        // Set weight and handle exceptions
        try {
            String weightString = getTextFieldString(weightEntry);
            userProfile.setWeight(Double.valueOf(weightString));
        }  catch (InvalidWeightException | IllegalArgumentException exception) {
            weightErrorLabel.setVisible(true);
        }

        // Set height and handle Exceptions
        try {
            String heightString = getTextFieldString(heightEntry);
            userProfile.setHeight(Double.valueOf(heightString));
        } catch (InvalidHeightException | IllegalArgumentException exception) {
            heightErrorLabel.setVisible(true);
        }

        // Set Date of Birth and handle exceptions
        try {
            String day = dayEntry.getValue().toString();
            String month = monthEntry.getValue().toString();
            String year = yearEntry.getValue().toString();

            int yearInt = Integer.valueOf(year);
            int monthInt = Integer.valueOf(month);
            int dayInt = Integer.valueOf(day);
            DateTime dateOfBirth = new DateTime(yearInt, monthInt, dayInt, 0, 0, 0);
            userProfile.setBirthdate(dateOfBirth);
        } catch (NullPointerException | IllegalArgumentException exception) {
            dateErrorLabel.setVisible(true);
        }

        // Set gender and handle Exceptions
        try {
            String genderString = getSelectedGender();
            userProfile.setGender(genderString);
        } catch (NullPointerException exception) {
            genderErrorLabel.setVisible(true);
        } catch (IllegalArgumentException exception) {
            this.app.createPopUp(Alert.AlertType.ERROR, "Error", "Could not find image");
        }

        // Set Max Heart Rate
        try {
            userProfile.setMaxHeartRate(220 - (Calendar.getInstance().get(Calendar.YEAR) - userProfile.getBirthDate().getYear()));
        } catch (NullPointerException exception) { }

        // Add the user to the Controller
        try {
            app.createUser(userProfile);
            setErrorsInvisible();
            setInputsToNull();
            this.app.getDataWriter().saveProfile(userProfile);
            app.launchLoginScene();
        } catch (InvalidUserException exception) { }
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