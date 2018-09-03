package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.*;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.FileOperations.Parser;

import java.util.ArrayList;

public class GoalController {

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
    private TextArea progressText;



    public void setApp(GUIController app){
        this.app = app;
    }


    public void setUpScene() {

        Goals goalsInstance = app.getGoalsInstance();


        ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
        currentGoalsCombo.setItems(currentGoals);
        currentGoalsCombo.setVisibleRowCount(5);

        ObservableList<String> goalTypes = FXCollections.observableArrayList("Weight", "Distance", "Frequency", "BMI", "Time");
        goalTypeCombo.setItems(goalTypes);
        goalTypeCombo.setVisibleRowCount(5);

    }

    @FXML
    public void createGoal() throws Exception {
        Goals goalsInstance = app.getGoalsInstance();

        String type = goalTypeCombo.getValue().toString();
        String name = goalNameEntry.getText();
        int target = Integer.valueOf(targetValueEntry.getText());


        int startYear = startDatePicker.getValue().getYear();
        int startMonth = startDatePicker.getValue().getMonthValue();
        int startDay = startDatePicker.getValue().getDayOfMonth();
        DateTime startDate = new DateTime(startYear, startMonth, startDay, 0, 0,0);

        int targetYear = targetDatePicker.getValue().getYear();
        int targetMonth = targetDatePicker.getValue().getMonthValue();
        int targetDay = targetDatePicker.getValue().getDayOfMonth();
        DateTime targetDate = new DateTime(targetYear, targetMonth, targetDay, 0, 0,0);

//        String startDateStr = startDatePicker.getValue().toString();
//        String[] startDateArray = startDateStr.split("-");
//        int startYear = Integer.valueOf(startDateArray[0]);
//        int startMonth = Integer.valueOf(startDateArray[1]);
//        int startDay = Integer.valueOf(startDateArray[2]);
//        DateTime startDate = new DateTime(startYear, startMonth, startDay, 0, 0,0);

        if (type == "Weight") {
            goalsInstance.createGoal(name, startDate, targetDate, type, false, 0,0, target, 0,0);
        } else if (type == "Frequency") {
            goalsInstance.createGoal(name, startDate, targetDate, type, false, target,0, 0, 0,0);
        } else if (type == "Distance") {
            goalsInstance.createGoal(name, startDate, targetDate, type, false, 0,0, 0, target,0);
        } else if (type == "BMI") {
            goalsInstance.createGoal(name, startDate, targetDate, type, false, 0,0, 0, 0, target);
        } else { //goal must be of type Time
            goalsInstance.createGoal(name, startDate, targetDate, type, false, 0, target, 0, 0,0);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Goal successfully created!");
//        alert.setContentText("Select 'Add Goal' to add it to your current goals.");
        alert.showAndWait();

        //updates the current goals combo box
        ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
        currentGoalsCombo.setItems(currentGoals);
        System.out.println(goalsInstance.getCurrentGoalNames());
        System.out.println(goalsInstance.getCreatedGoalNames());

    }

    @FXML
    public void removeGoal() throws Exception {
        if (currentGoalsCombo.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You have not selected a goal");
            alert.setContentText("Please choose a goal to remove");
            alert.showAndWait();
        } else {
            Goals goalsInstance = app.getGoalsInstance();
            String name = currentGoalsCombo.getValue().toString();
            //Goal goalObject = goalsInstance.getGoalObject(name);
            goalsInstance.removeCurrentGoal(name);
            ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
            currentGoalsCombo.setItems(currentGoals);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Goal successfully removed");
            alert.showAndWait();
        }

    }

    @FXML
    public void reviewGoal() throws Exception {
        if (currentGoalsCombo.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You have not selected a goal");
            alert.setContentText("Please choose a goal to review");
            alert.showAndWait();
        } else {
            Goals goalsInstance = app.getGoalsInstance();
            String goalName = currentGoalsCombo.getValue().toString();
            progressText.setText(goalsInstance.checkGoal(goalName));
//            goalsInstance.checkGoal(goalName);
            ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
            currentGoalsCombo.setItems(currentGoals);
        }
    }

}
