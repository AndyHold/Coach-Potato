package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Control.InputValidator;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Goals.*;

/**
 * Controller class for the goals screen, which is where goals are viewed, created and managed.
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class GoalController implements Controllable {


    private GUIController app;
    private String currentHelpText;
    private String futureHelpText;
    private String pastHelpText;
    private String createHelpText;


    @FXML private ComboBox goalTypeCombo;
    @FXML private TextField goalNameEntry;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker targetDatePicker;
    @FXML private TextField targetValueEntry;
    @FXML private Button createButton;
    @FXML private ListView currentGoalsListView;
    @FXML private ListView achievedListView;
    @FXML private ListView failedListView;
    @FXML private ListView futureGoalsListView;
    @FXML private TextField currentTypeTextField;
    @FXML private TextField currentStartDateTextField;
    @FXML private TextArea currentGoalTextArea;
    @FXML private TextField achievedTypeTextField;
    @FXML private TextField achievedStartDateTextField;
    @FXML private TextArea achievedGoalTextArea;
    @FXML private TextField failedTypeTextField;
    @FXML private TextField failedStartDateTextField;
    @FXML private TextArea failedGoalTextArea;
    @FXML private TextField futureTypeTextField;
    @FXML private TextField futureDateTextField;
    @FXML private TextArea futureGoalTextArea;
    @FXML private Label unitsLabel;
    @FXML private Label deleteModeLabel;
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    @FXML private Tab currentTab;
    @FXML private Tab futureTab;
    @FXML private Tab pastTab;
    @FXML private Tab createTab;
    private boolean deleteMode = false;


    /**
     * Setter method to pass the GUIController into this controller.
     * @param guiController <b>GUIController:</b> The main controller.
     */
    public void setApp(GUIController guiController)
    {
        this.app = guiController;
    }


    /**
     * Method to set up objects that require it prior to showing the scene.
     */
    public void setUpScene() {
        // Set tool tips
        setUpToolTips();
        // Set up help text areas
        setUpHelpTexts();
        helpTextArea.setVisible(false);
        helpTextArea.setWrapText(true);


        achievedTypeTextField.setVisible(false);
        achievedStartDateTextField.setVisible(false);
        achievedGoalTextArea.setVisible(false);

        failedTypeTextField.setVisible(false);
        failedStartDateTextField.setVisible(false);
        failedGoalTextArea.setVisible(false);

        futureTypeTextField.setVisible(false);
        futureDateTextField.setVisible(false);
        futureGoalTextArea.setVisible(false);

        // Hide the current help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    /**
     * Set up method for the tool tips.
     */
    private void setUpToolTips()
    {
        // Set up tool tips for current
        helpButton.setTooltip(new Tooltip("Need Help?"));
        // Current Tab
        currentGoalsListView.setTooltip(new Tooltip("Click here to select the current goal you would like to either view or remove."));
        currentTypeTextField.setTooltip(new Tooltip("This is where the goal type is displayed."));
        currentStartDateTextField.setTooltip(new Tooltip("This is where the start date of the goal is displayed."));
        currentGoalTextArea.setTooltip(new Tooltip("This is where the description of the selected failed goal is displayed."));

        // Past Tab
        achievedListView.setTooltip(new Tooltip("This is a list of your past goals that were achieved.\n" +
                                                "Click on a goal to review it."));
        achievedTypeTextField.setTooltip(new Tooltip("This is where the goal type is displayed."));
        achievedStartDateTextField.setTooltip(new Tooltip("This is where the start date of the goal is displayed."));
        achievedGoalTextArea.setTooltip(new Tooltip("This is where the description of the selected achieved goal is displayed."));
        failedListView.setTooltip(new Tooltip("This is a list of your past goals that were failed.\n" +
                                              "Click on a goal to review it."));
        failedTypeTextField.setTooltip(new Tooltip("This is where the goal type is displayed."));
        failedStartDateTextField.setTooltip(new Tooltip("This is where the start date of the goal is displayed."));
        failedGoalTextArea.setTooltip(new Tooltip("This is where the description of the selected failed goal is displayed."));
        // Future Tab
        futureGoalsListView.setTooltip(new Tooltip("This is a list of your future goals.\n" +
                                                   "Click on a goal to review it."));
        futureTypeTextField.setTooltip(new Tooltip("This is where the goal type is displayed."));
        futureTypeTextField.setTooltip(new Tooltip("This is where the start date of the goal is displayed."));
        futureGoalTextArea.setTooltip(new Tooltip("This is where the description of the selected future goal is displayed."));
        // Create Tab
        goalTypeCombo.setTooltip(new Tooltip("Click here to select a goal type to create."));
        startDatePicker.setTooltip(new Tooltip("Click here to select a date to start your goal on.\n" +
                                               "Note: Goals cannot be started in the past."));
        targetValueEntry.setTooltip(new Tooltip("Please enter a target value for your goal."));
        goalNameEntry.setTooltip(new Tooltip("Please enter a unique name for your goal."));
        targetDatePicker.setTooltip(new Tooltip("Click here to select a target date for your goal.\n" +
                                                "Note: Your target date cannot be before your start date."));
        createButton.setTooltip(new Tooltip("Click here to create your goal!\n" +
                                            "If you have invalid or empty data fields a pop up will notify you what you need to fix."));
    }


    /**
     * Set up method for the help text area.
     */
    private void setUpHelpTexts()
    {
        currentHelpText = "Welcome to the Goals Screen!\n\n" +
                "You are currently on the Current Goals Tab.\n\n" +
                "On this tab you can view your current goals that are in progress, remove your current goals that are in progress or navigate to another tab.\n" +
                "- To view your current goals:\n" +
                "\t- Select your goal from the drop down menu.\n" +
                "\t- Click the Review Progress Button.\n" +
                "\t- A description of your goal and what you need to\n" +
                "\t  achieve it will be displayed in the Description\n" +
                "\t  Window.\n" +
                "- To delete your current goals that are in progress:\n" +
                "\t- Select the goal you would like to delete from the\n" +
                "\t  drop down menu.\n" +
                "\t- Click the Remove Goal button.\n" +
                "\t- A pop up will notify you when your goal is\n" +
                "\t  successfully removed from your profile.\n" +
                "- To navigate to another tab simply click on the tab you\n" +
                "  wish to see at the top of the screen.\n\n" +
                "Hover over each item to see a brief description of what it does.";
        pastHelpText = "Welcome to the Goals Screen!\n\n" +
                "You are currently on the Past Goals Tab.\n\n" +
                "On this tab you can review your achieved goals, review your failed goals and navigate to another tab.\n" +
                "- To review your achieved goals:\n" +
                "\t- Select the goal you wish to review from the\n" +
                "\t  Achieved Goals list.\n" +
                "\t- Description fields will now appear with the details\n" +
                "\t  of your selected goal.\n" +
                "- To review your failed goals:\n" +
                "\t- Select the goal you wish to review from the Failed\n" +
                "\t  Goals list.\n" +
                "\t- Description fields will now appear with the details\n" +
                "\t  of your selected goal.\n" +
                "- To navigate to another tab simply click on the tab you\n" +
                "  wish to see at the top of the screen.\n\n" +
                "Hover over each item to see a brief description of what it does.";
        futureHelpText = "Welcome to the Goals Screen!\n\n" +
                "You are currently on the Future Goals Tab.\n\n" +
                "On this tab you can review your future goals and navigate to another tab.\n" +
                "- To review your future goals:\n" +
                "\t- Select the goal you wish to review from the\n" +
                "\t  Future Goals list.\n" +
                "\t- Description fields will now appear with the details\n" +
                "\t  of your selected goal.\n" +
                "- To navigate to another tab simply click on the tab you\n" +
                "  wish to see at the top of the screen.\n\n" +
                "Hover over each item to see a brief description of what it does.";
        createHelpText = "Welcome to the Goals Screen!\n\n" +
                "You are currently on the Create Goals Tab.\n\n" +
                "On this tab you can create a new goal or navigate to a different tab.\n" +
                "- To Create a new goal:\n" +
                "\t- Click on the Goal Type drop down list and select a\n" +
                "\t  goal type from the options.\n" +
                "\t- Enter a name for your goal in the Enter Name text\n" +
                "\t  box.\n" +
                "\t- Name must be a unique goal name between 2 - 10\n" +
                "\t  characters long.\n" +
                "\t- Click on the Goal Start date picker and select a\n" +
                "\t  date to start your goal on.\n" +
                "\t- You cannot start a goal in the past.\n" +
                "\t- Click on the Goal Target date picker and select a\n" +
                "\t  target date for your goal to be achieved by.\n" +
                "\t- You cannot select a target date before the start\n" +
                "\t  date.\n" +
                "\t- Enter a target value for your chosen goal type.\n" +
                "\t- You cannot choose a target value that has already\n" +
                "\t  been achieved.\n" +
                "\t- Click on the Create button.\n" +
                "\tYour new goal will be created and added to your\n" +
                "\tprofile. you can review your created goals by\n" +
                "\tnavigating to the current or future goals tabs.\n" +
                "- To navigate to another tab simply click on the tab you\n" +
                "  wish to see at the top of the screen.\n\n" +
                "Hover over each item to see a brief description of what it does.";
    }


    /**
     * Method called when help button is clicked on.
     * Sets dimensions and text for help area depending on which tab is currently displayed.
     */
    @FXML private void displayHelp()
    {
        helpTextArea.setVisible(true);
        helpTextArea.requestFocus();
        if (currentTab.isSelected()) {
            setHelpTextArea(currentHelpText, 270, 400);
        } else if (futureTab.isSelected()) {
            setHelpTextArea(futureHelpText,400, 270);
        } else if (createTab.isSelected()) {
            setHelpTextArea(createHelpText, 140, 530);
        } else if (pastTab.isSelected()) {
            setHelpTextArea(pastHelpText,320, 350);
        }
    }


    /**
     * Method called when the help button is pushed.
     * Displays the help text area.
     */
    private void setHelpTextArea(String text, double yCoOrdinate, double height)
    {
        helpTextArea.setText(text);
        helpTextArea.setLayoutY(yCoOrdinate);
        helpTextArea.setPrefHeight(height);
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
     * Method to update the achieved goal list view.
     * TODO reset all text fields to display nothing
     */
    @FXML public void updateCurrentListView()
    {
        // Reset text fields
//        resetTextCurrent();
        // If delete mode activated:
        if (deleteMode) {
            deleteAGoal();
        } else {
            viewGoalDetails();
        }
    }

    /**
     * Method for when the user is in delete mode, deletes a goal with a confirmation message.
     */
    private void deleteAGoal() {
        // If there is a goal selected
        if (currentGoalsListView.getSelectionModel().getSelectedItem() != null) {
            // Get the name of the selected goal
            String item = currentGoalsListView.getSelectionModel().getSelectedItem().toString();
            // Ask the user if they are sure they want to delete the goal
            String option = app.createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + item + "\" goal?");
            // If they say yes
            if (option.equals("OK")) {
                //delete the goal and set deletemode off again
                app.getTitleBar().getCurrentProfile().getGoals().removeCurrentGoal(item);
                toggleDeleteMode();
            }
        }
        addGoalsToTable();
    }

    /*
    *Displays details of a goal that's selected.
     */
    private void viewGoalDetails() {
        // If there is a goal selected
        if (currentGoalsListView.getSelectionModel().getSelectedItem() != null) {
            String item = currentGoalsListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : app.getTitleBar().getCurrentProfile().getGoals().getCurrentGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                String status = app.getTitleBar().getCurrentProfile().getGoals().checkGoal(goal.getGoalName());
                switch (status) {
                    case "inprogress":
                        printGoalsReview(goal, currentTypeTextField, currentStartDateTextField, currentGoalTextArea);
                        break;
                    case "achieved":
                        currentGoalTextArea.setText("Congratulations!!!\nThat goal has been achieved and has been moved to the past goals tab.");
                        break;
                    case "failed":
                        currentGoalTextArea.setText("Oh No!!!\nThat goal has been failed and has been moved to the past goals tab.");
                        break;
                }
                addGoalsToTable();
            }
        }
    }


    /**
     * Method to initialise the goal tables each time the user logs in, enters goals screen or switches tabs within goals.
     */
    public void addGoalsToTable() {
        app.getTitleBar().getCurrentProfile().getGoals().refreshGoals();
        if (app.getTitleBar().getCurrentProfile().getGoals() != null) {
            ObservableList<String> currentGoals = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getGoals().getCurrentGoalNames());
            currentGoalsListView.setItems(currentGoals);
            ObservableList<String> achievedGoalNames = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getGoals().getAchievedGoalNames());
            achievedListView.setItems(achievedGoalNames);
            ObservableList<String> failedGoalNames = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getGoals().getFailedGoalNames());
            failedListView.setItems(failedGoalNames);
            ObservableList<String> futureGoalNames = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getGoals().getFutureGoalNames());
            futureGoalsListView.setItems(futureGoalNames);

        }
        ObservableList<String> goalTypes = FXCollections.observableArrayList("Weight", "Distance", "Frequency", "BMI", "Time");
        goalTypeCombo.setItems(goalTypes);
        goalTypeCombo.setVisibleRowCount(5);
    }


    /**
     * Creates a new goal with the information entered by the user.
     */
    @FXML
    public void createGoal()
    {
        boolean validInput = true;
        Goals goalsInstance = app.getTitleBar().getCurrentProfile().getGoals();
        InputValidator input = new InputValidator();

        String type = goalTypeCombo.getValue().toString();
        String name = goalNameEntry.getText();
        int target = 0;
        double doubleTarget = 0.0;
        int startYear = startDatePicker.getValue().getYear();
        int startMonth = startDatePicker.getValue().getMonthValue();
        int startDay = startDatePicker.getValue().getDayOfMonth();
        DateTime startDate = new DateTime(startYear, startMonth, startDay, 0, 0,0);
        int targetYear = targetDatePicker.getValue().getYear();
        int targetMonth = targetDatePicker.getValue().getMonthValue();
        int targetDay = targetDatePicker.getValue().getDayOfMonth();
        DateTime targetDate = new DateTime(targetYear, targetMonth, targetDay, 0, 0,0);
        if (type == null) {
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Goal Type", "Please choose a goal type");
            validInput = false;
        } else if (!input.validGoalName(name, goalsInstance)) {
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Goal Name", "Name must be between 2 and 10 characters long and cannot be the same name as another goal");
            validInput = false;
        } else if (!input.validGoalStartDate(startDate)){
            app.createPopUp(Alert.AlertType.ERROR, "Invalid start date", "Start date must be during this year or next year and cannot be in the past.");
            validInput = false;
        } else if (!input.validGoalTargetDate(targetDate)){
            app.createPopUp(Alert.AlertType.ERROR, "Invalid target date", "Target date must be in the next 5 years and cannot be in the past.");
            validInput = false;
        } else if (!input.checkStartVsTargetDates(startDate, targetDate)) {
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Dates", "Target date must be after the start date.");
            validInput = false;
        } else {
            try {
                String target1 = targetValueEntry.getText();
                if (type.equals("Frequency")) {
                    target = Integer.parseInt(target1);
                    if (!input.isValidIntTargetValue(target)) {
                        app.createPopUp(Alert.AlertType.ERROR, "Invalid target", "Please choose a numeric and realistic target value that you have not already achieved");
                        validInput = false;
                    }
                } else {
                    doubleTarget = Double.valueOf(target1);
                    if (!input.isValidTargetValue(type, doubleTarget, app.getTitleBar().getCurrentProfile())) {
                        app.createPopUp(Alert.AlertType.ERROR, "Invalid target", "Please choose a numeric and realistic target value that you have not already achieved");
                        validInput = false;
                    }
                }
            } catch (NumberFormatException e) {
                app.createPopUp(Alert.AlertType.ERROR, "Invalid target", "Please choose a realistic target value that you have not already achieved");
                validInput = false;
            }
        }
        if (validInput) {
            switch (type) {
                case "Weight":
                    goalsInstance.createGoal(name, startDate, targetDate, type, doubleTarget);
                    break;
                case "Frequency":
                    goalsInstance.createGoal(name, startDate, targetDate, target);
                    break;
                case "Distance":
                    goalsInstance.createGoal(name, startDate, targetDate, type, doubleTarget);
                    break;
                case "BMI":
                    goalsInstance.createGoal(name, startDate, targetDate, type, doubleTarget);
                    break;
                default:  //goal must be of type Time
                    goalsInstance.createGoal(name, startDate, targetDate, type, doubleTarget);
                    break;
            }
            app.createPopUp(Alert.AlertType.INFORMATION, "Information", "Goal successfully created!");
            //reset the entry values, ready for a new goal to be created
            goalNameEntry.setText("");
            targetValueEntry.setText("");
        }
    }


    /**
     * Method called when the remove goal button is pushed.
     * Toggles delete mode and red border around list view.
     */
    @FXML
    public void toggleDeleteMode()
    {
        if(deleteMode) {
            deleteMode = false;
            deleteModeLabel.setVisible(false);
            currentGoalsListView.setStyle(null);

        } else {
            deleteMode = true;
            deleteModeLabel.setVisible(true);
            currentGoalsListView.setStyle("-fx-border-color: indigo; " +
            "-fx-border-width: 5px;");
        }
    }


    /**
     * Method to update the achieved goal list view.
     */
    @FXML public void updateAchievedListView() {
        if (achievedListView.getSelectionModel().getSelectedItem() != null && !app.getTitleBar().getCurrentProfile().getGoals().getAchievedGoals().isEmpty()) {
            String item = achievedListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : app.getTitleBar().getCurrentProfile().getGoals().getAchievedGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                printGoalsReview(goal, achievedTypeTextField, achievedStartDateTextField, achievedGoalTextArea);
            }
        }
    }


    /**
     * Method to update the failed goal list view.
     */
    @FXML public void updateFailedListView() {
        if (failedListView.getSelectionModel().getSelectedItem() != null && !app.getTitleBar().getCurrentProfile().getGoals().getFailedGoals().isEmpty()) {
            String item = failedListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : app.getTitleBar().getCurrentProfile().getGoals().getFailedGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                printGoalsReview(goal, failedTypeTextField, failedStartDateTextField, failedGoalTextArea);
            }
        }
    }


    /**
     * Method to update the future goal list view.
     */
    @FXML public void updateFutureListView() {
        if (futureGoalsListView.getSelectionModel().getSelectedItem() != null && !app.getTitleBar().getCurrentProfile().getGoals().getFutureGoals().isEmpty()) {
            String item = futureGoalsListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : app.getTitleBar().getCurrentProfile().getGoals().getFutureGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                printGoalsReview(goal, futureTypeTextField, futureDateTextField, futureGoalTextArea);
            }
        }
    }


    /**
     * Method to display the details of a goal in given text fields and a text area.
     * @param goal <b>Goal</b> to be reviewed.
     * @param typeText <b>TextField</b> for the type of goal.
     * @param startDateText <b>TextField</b> for the start date of the goal.
     * @param goalText <b>TextArea</b> for the description of the goal.
     */
    private void printGoalsReview(Goal goal, TextField typeText, TextField startDateText, TextArea goalText) {
        String type = goal.getGoalType();
        typeText.setVisible(true);
        startDateText.setVisible(true);
        goalText.setVisible(true);
        switch (type) {
            case "Weight":
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
                goalText.setText("To weigh " + ((WeightGoal) goal).getGoalWeight() + " kgs or less by " + goal.getGoalTargetDate());
                break;
            case "Frequency":
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
                goalText.setText("To participate in " + ((FrequencyGoal) goal).getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
                break;
            case "Distance":
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
                goalText.setText("To cover " + ((DistanceGoal) goal).getGoalDistance() + " metres by " + goal.getGoalTargetDate());
                break;
            case "BMI":
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
                goalText.setText("To have a BMI of " + ((BmiGoal) goal).getGoalBmi() + " or less by " + goal.getGoalTargetDate());
                break;
            default:  //goal must be of type Time
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
                goalText.setText("To spend " + ((TimeGoal) goal).getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate());
                break;
        }
    }


    /**
     * Method to display units in the units label.
     */
    @FXML public void displayUnits() {
        if (goalTypeCombo.getValue() != null) {
            String type = goalTypeCombo.getValue().toString();
            switch (type) {
                case "Weight":
                    unitsLabel.setText("kgs");
                    break;
                case "Frequency":
                    unitsLabel.setText("activities");
                    break;
                case "Distance":
                    unitsLabel.setText("metres");
                    break;
                case "BMI":
                    unitsLabel.setText("BMI");
                    break;
                case "Time":
                    unitsLabel.setText("minutes");
                    break;
            }
        }
    }
}