package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Control.InputValidator;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Goal;
import seng202.team10.Model.Goals;

public class GoalController implements Controllable {

    private GUIController app;

    @FXML
    private ComboBox goalTypeCombo;

    @FXML
    private ComboBox currentGoalsCombo;

    @FXML
    private TextField goalNameEntry;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker targetDatePicker;

    @FXML
    private TextField targetValueEntry;

    @FXML
    private Button createButton;

    @FXML
    private Button removeGoalButton;

    @FXML
    private Button reviewButton;

    @FXML
    private ListView achievedListView;

    @FXML
    private ListView failedListView;

    @FXML
    private TextArea progressText;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField startDateTextField;

    @FXML
    private TextArea goalTextArea;

    @FXML
    private TextField typeTextField2;

    @FXML
    private TextField startDateTextField2;

    @FXML
    private TextArea goalTextArea2;

    @FXML
    private ListView futureGoalsListView;

    @FXML
    private TextField futureTypeTextField;

    @FXML
    private TextField futureDateTextField;

    @FXML
    private TextArea futureGoalTextArea;

    @FXML
    private Label unitsLabel;

    @FXML private VBox drawer;



    public void setApp(GUIController app){
        this.app = app;
    }


    public void setUpScene() {

        typeTextField.setVisible(false);
        startDateTextField.setVisible(false);
        goalTextArea.setVisible(false);

        typeTextField2.setVisible(false);
        startDateTextField2.setVisible(false);
        goalTextArea2.setVisible(false);

        futureTypeTextField.setVisible(false);
        futureDateTextField.setVisible(false);
        futureGoalTextArea.setVisible(false);

    }

    /**
     * Method to initialise the goal tables each time the user logs in, enters goals screen or switches tabs within goals.
     */
    public void addGoalsToTable() {
        app.getCurrentProfile().getGoals().refreshGoals();
        if (app.getCurrentProfile().getGoals() != null) {
            ObservableList<String> currentGoals = FXCollections.observableArrayList(app.getCurrentProfile().getGoals().getCurrentGoalNames());
            currentGoalsCombo.setItems(currentGoals);
            currentGoalsCombo.setVisibleRowCount(5);

            ObservableList<String> achievedGoalNames = FXCollections.observableArrayList(app.getCurrentProfile().getGoals().getAchievedGoalNames());
            achievedListView.setItems(achievedGoalNames);
            ObservableList<String> failedGoalNames = FXCollections.observableArrayList(app.getCurrentProfile().getGoals().getFailedGoalNames());
            failedListView.setItems(failedGoalNames);
            ObservableList<String> futureGoalNames = FXCollections.observableArrayList(app.getCurrentProfile().getGoals().getFutureGoalNames());
            futureGoalsListView.setItems(futureGoalNames);

        }
        ObservableList<String> goalTypes = FXCollections.observableArrayList("Weight", "Distance", "Frequency", "BMI", "Time");
        goalTypeCombo.setItems(goalTypes);
        goalTypeCombo.setVisibleRowCount(5);
        progressText.setText("");
    }





    @FXML
    public void createGoal() throws Exception {
        boolean validInput = true;
        Goals goalsInstance = app.getCurrentProfile().getGoals();
        InputValidator input = new InputValidator();

        String type = goalTypeCombo.getValue().toString();
        String name = goalNameEntry.getText();
        int target = 0;
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
                target = Integer.parseInt(target1);
                if (!input.isValidTargetValue(type, target, app.getCurrentProfile())) {
                    app.createPopUp(Alert.AlertType.ERROR, "Invalid target", "Please choose a numeric and realistic target value that you have not already achieved");
                    validInput = false;
                }
            } catch (NumberFormatException e) {
                app.createPopUp(Alert.AlertType.ERROR, "Invalid target", "Please choose a realistic target value that you have not already achieved");
                validInput = false;
            }
        }

        if (validInput) {
            if (type.equals("Weight")) {
                goalsInstance.createGoal(name, startDate, targetDate, type, false, 0,0, target, 0,0);
            } else if (type.equals("Frequency")) {
                goalsInstance.createGoal(name, startDate, targetDate, type, false, target,0, 0, 0,0);
            } else if (type.equals("Distance")) {
                goalsInstance.createGoal(name, startDate, targetDate, type, false, 0,0, 0, target,0);
            } else if (type.equals("BMI")) {
                goalsInstance.createGoal(name, startDate, targetDate, type, false, 0,0, 0, 0, target);
            } else { //goal must be of type Time
                goalsInstance.createGoal(name, startDate, targetDate, type, false, 0, target, 0, 0,0);
            }

            app.createPopUp(Alert.AlertType.INFORMATION, "Information", "Goal successfully created!");
            //reset the entry values, ready for a new goal to be created
            goalNameEntry.setText("");
            targetValueEntry.setText("");
        }


    }

    @FXML
    public void removeGoal() {
        if (currentGoalsCombo.getValue() == null) {
            app.createPopUp(Alert.AlertType.ERROR, "You have not selected a goal", "Please choose a goal to remove");
        } else {
            Goals goalsInstance = app.getCurrentProfile().getGoals();
            String name = currentGoalsCombo.getValue().toString();
            goalsInstance.removeCurrentGoal(name);
            ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
            currentGoalsCombo.setItems(currentGoals);
            app.createPopUp(Alert.AlertType.INFORMATION, "Information", "Goal successfully removed");
            progressText.setText("");
        }

    }

    @FXML
    public void reviewGoal() {
        if (currentGoalsCombo.getValue() == null){
            app.createPopUp(Alert.AlertType.ERROR, "No goal selected", "Please choose a goal to review");
        } else {
            Goals goalsInstance = app.getCurrentProfile().getGoals();
            String goalName = currentGoalsCombo.getValue().toString();
            progressText.setText(goalsInstance.checkGoal(goalName));
            ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
            currentGoalsCombo.setItems(currentGoals);
        }
    }

    @FXML
    public void updateAchievedListView() {
        if (!app.getCurrentProfile().getGoals().getAchievedGoals().isEmpty()) {
            String item = achievedListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : app.getCurrentProfile().getGoals().getAchievedGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                printGoalsReview(goal, typeTextField, startDateTextField, goalTextArea);
            }
        }

    }

    @FXML
    public void updateFailedListView() {
        if (!app.getCurrentProfile().getGoals().getFailedGoals().isEmpty()) {
            String item = failedListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : app.getCurrentProfile().getGoals().getFailedGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                printGoalsReview(goal, typeTextField2, startDateTextField2, goalTextArea2);
            }
        }
    }

    @FXML
    public void updateFutureListView() {
        if (!app.getCurrentProfile().getGoals().getFutureGoals().isEmpty()) {
            String item = futureGoalsListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : app.getCurrentProfile().getGoals().getFutureGoals()) {
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

    private void printGoalsReview(Goal goal, TextField typeText, TextField startDateText, TextArea goalText) {
        String type = goal.getGoalType();
        typeText.setVisible(true);
        startDateText.setVisible(true);
        goalText.setVisible(true);
        if (type.equals("Weight")) {
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To weigh " + goal.getGoalWeight() + " kgs or less by " + goal.getGoalTargetDate());
        } else if (type.equals("Frequency")) {
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To participate in " + goal.getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
        } else if (type.equals("Distance")) {
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To cover " + goal.getGoalDistance() + " metres by " + goal.getGoalTargetDate());
        } else if (type.equals("BMI")) {
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To have a BMI of " + goal.getGoalBmi() + " or less by " + goal.getGoalTargetDate());
        } else { //goal must be of type Time
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To spend " + goal.getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate());
        }
    }

    @FXML
    public void displayUnits() {
        if (goalTypeCombo.getValue() != null) {
            String type = goalTypeCombo.getValue().toString();
            if (type.equals("Weight")) {
                unitsLabel.setText("kgs");
            } else if (type.equals("Frequency")) {
                unitsLabel.setText("activities");
            } else if (type.equals("Distance")) {
                unitsLabel.setText("metres");
            } else if (type.equals("BMI")) {
                unitsLabel.setText("BMI");
            } else if (type.equals("Time")){
                unitsLabel.setText("minutes");
            }
        }
    }

    /**
     * Method to draw the navigation drawer.
     */
    @FXML private void drawerAction()
    {
        TranslateTransition openNav = new TranslateTransition(new Duration(350), drawer);
        openNav.setToX(0);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        if (drawer.getTranslateX() != 0) {
            openNav.play();
        } else {
            closeNav.setToX(-(drawer.getWidth()));
            closeNav.play();
        }
    }
    /**
     * Method to launch the login scene.
     */
    @FXML public void openChooseProfile() throws Exception
    {
        moveDrawer();
        app.launchLoginScene();
    }

    /**
     * Method to launch the view profile scene.
     */
    @FXML public void openViewProfile() throws Exception
    {
        moveDrawer();
        app.launchProfileScene();
    }

    /**
     * Method to launch the upload data scene.
     */
    @FXML public void openUploadData() throws Exception
    {
        moveDrawer();
        app.launchUploadDataScene();
    }

    /**
     * Method to launch the view activities scene.
     */
    @FXML public void openViewActivities() throws Exception
    {
        moveDrawer();
        app.launchActivityViewerScene();
    }

    /**
     * Method to launch the goals scene.
     */
    @FXML public void openGoals() throws Exception
    {
        moveDrawer();
        app.launchGoalsScene();
    }

    /**
     * Method to launch the data analysis scene.
     */
    @FXML public void openAnalysis() throws Exception
    {
        moveDrawer();
        app.launchDataAnalysisScene();
    }

    /**
     * Method to move the navigation drawer as appropriate.
     */
    private void moveDrawer()
    {
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        closeNav.setToX(-(drawer.getWidth()));
        closeNav.play();
        setUpScene();
    }
}