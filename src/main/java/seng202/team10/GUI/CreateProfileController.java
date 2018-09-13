package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.UserProfile;

public class CreateProfileController implements Controllable
{

    private GUIController app;
    ToggleGroup toggleGroup;

    @FXML
    private Button createProfileButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameEntry;

    @FXML
    private TextField weightEntry;

    @FXML
    private TextField heightEntry;

    @FXML
    private ComboBox dayEntry;

    @FXML
    private ComboBox monthEntry;

    @FXML
    private ComboBox yearEntry;

    @FXML
    private Label dateErrorLabel;

    @FXML
    private Label nameErrorLabel;

    @FXML
    private Label weightErrorLabel;

    @FXML
    private Label heightErrorLabel;

    @FXML
    private RadioButton femaleRad;

    @FXML
    private RadioButton maleRad;

    @FXML
    private RadioButton notSpecifiedRad;

    @FXML
    private Label genderWarning;

    public void setApp(GUIController app)
    {
        this.app = app;
    }

    public void setUpScene()
    {
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

        toggleGroup = new ToggleGroup();
        femaleRad.setToggleGroup(toggleGroup);
        maleRad.setToggleGroup(toggleGroup);
        notSpecifiedRad.setToggleGroup(toggleGroup);
    }

    @FXML
    public void back() throws Exception
    {
        app.launchLoginScene();
    }

    @FXML
    public void createProfile() throws Exception
    {
        boolean invalidInput = false;
        dateErrorLabel.setVisible(false);
        nameErrorLabel.setVisible(false);
        weightErrorLabel.setVisible(false);
        heightErrorLabel.setVisible(false);
        genderWarning.setVisible(false);
        String nameString = nameEntry.getText();
        String heightString = heightEntry.getText();
        String weightString = weightEntry.getText();
        String genderString = getSelectedGender();

        if (dayEntry.getValue() == null || monthEntry.getValue() == null || yearEntry.getValue() == null) {
            dateErrorLabel.setVisible(true);
            invalidInput = true;
        }
        if (!checkNameStringValid(nameString)){
            nameErrorLabel.setVisible(true);
            invalidInput = true;
        }
        if (checkDoubleStringInvalid(heightString, 260, 50)){
            heightErrorLabel.setVisible(true);
            invalidInput = true;
        }
        if (checkDoubleStringInvalid(weightString, 180, 30)){
            weightErrorLabel.setVisible(true);
            invalidInput = true;
        }

        if (genderString == null) {
            genderWarning.setVisible(true);
            invalidInput = true;
        }
        if (!invalidInput) {

            String day = dayEntry.getValue().toString();
            String month = monthEntry.getValue().toString();
            String year = yearEntry.getValue().toString();

            int yearInt = Integer.valueOf(year);
            int monthInt = Integer.valueOf(month);
            int dayInt = Integer.valueOf(day);
            DateTime dateOfBirth = new DateTime(yearInt, monthInt, dayInt, 0, 0, 0);
            UserProfile userProfile = new UserProfile();
            userProfile.setName(nameString);
            userProfile.setGender(genderString);
            userProfile.setBirthdate(dateOfBirth);
            userProfile.setMaxHeartrate(220 - (java.util.Calendar.getInstance().get(java.util.Calendar.YEAR) - dateOfBirth.getYear()));
            userProfile.setWeight(Double.valueOf(weightString));
            userProfile.setHeight(Double.valueOf(heightString));
            app.createUser(userProfile);
            app.launchLoginScene();
        }
    }

    private String getSelectedGender() {
        try {
            if (toggleGroup.getSelectedToggle().equals(femaleRad)) {
                return "Female";
            } else if (toggleGroup.getSelectedToggle().equals(maleRad)) {
                return "Male";
            } else {
                return "Other";
            }
        } catch (NullPointerException e) {
            return null;
        }
    }

    private boolean checkNameStringValid(String name)
    {
        return !(name.length() > 50 || !name.matches("[a-zA-Z0-9]+ ?[a-zA-Z0-9]+"));
    }

    private boolean checkDoubleStringInvalid(String doubString, double max, double min)
    {
        if (doubString.length() < 1) {
            return true;
        }
        try {
            double doubDouble = Double.parseDouble(doubString);
            return (doubDouble > max || doubDouble < min);
        } catch (NumberFormatException e) {
            return true;
        }

    }
}