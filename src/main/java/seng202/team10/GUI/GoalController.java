package seng202.team10.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import seng202.team10.Control.GUIController;
import seng202.team10.Control.inputValidator;
import seng202.team10.Model.*;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.FileOperations.Parser;

import java.util.ArrayList;

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
        boolean validInput = true;
        Goals goalsInstance = app.getGoalsInstance();
        inputValidator input = new inputValidator(); //is this the best way to interact with the input validator class??

        String type = goalTypeCombo.getValue().toString();
        if (type == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not a valid goal type");
            alert.setContentText("Please choose a goal type");
            alert.showAndWait();
            validInput = false;
        }
        String name = goalNameEntry.getText();
        if (!input.validGoalName(name)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not a valid goal name");
            alert.setContentText("Name must be between 2 and 10 characters long");
            alert.showAndWait();
            validInput = false;
        }

        int target = Integer.valueOf(targetValueEntry.getText()); //TODO write a valid checking func in inputValidator and call that method from here


        int startYear = startDatePicker.getValue().getYear();
        int startMonth = startDatePicker.getValue().getMonthValue();
        int startDay = startDatePicker.getValue().getDayOfMonth();
        DateTime startDate = new DateTime(startYear, startMonth, startDay, 0, 0,0);
        if (!input.validGoalStartDate(startDate)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not a valid starting date");
            alert.setContentText("Start date must be during this year or next year and cannot be in the past.");
            alert.showAndWait();
            validInput = false;
        }

        int targetYear = targetDatePicker.getValue().getYear();
        int targetMonth = targetDatePicker.getValue().getMonthValue();
        int targetDay = targetDatePicker.getValue().getDayOfMonth();
        DateTime targetDate = new DateTime(targetYear, targetMonth, targetDay, 0, 0,0);
        if (!input.validGoalTargetDate(targetDate)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not a valid target date");
            alert.setContentText("Target date must be in the next 5 years and cannot be in the past.");
            alert.showAndWait();
            validInput = false;
        }


//        String startDateStr = startDatePicker.getValue().toString();
//        String[] startDateArray = startDateStr.split("-");
//        int startYear = Integer.valueOf(startDateArray[0]);
//        int startMonth = Integer.valueOf(startDateArray[1]);
//        int startDay = Integer.valueOf(startDateArray[2]);
//        DateTime startDate = new DateTime(startYear, startMonth, startDay, 0, 0,0);

        //TODO add an if-statement to check if validInput == true
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
