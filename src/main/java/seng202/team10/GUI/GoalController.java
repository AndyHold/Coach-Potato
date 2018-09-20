package seng202.team10.GUI;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Control.InputValidator;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.ActivitiesData.Entry;
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

    @FXML private VBox drawer;






    @FXML private TableView<Goal> entriesTableView;
    @FXML private TableColumn<Goal, String> nameColumn;
    @FXML private TableColumn<Goal, String> typeColumn;
    @FXML private TableColumn<Goal, String> targetColumn;
    @FXML private TableColumn<Goal, String> startDateColumn;
    @FXML private TableColumn<Goal, String> endDateColumn;


    @FXML
    private ObservableList<Goal> entries;



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

//        String item = achievedListView.getSelectionModel().getSelectedItem().toString();
//        achievedTextArea.setText("Goal :  " + item);

//        nameColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("name"));
//        typeColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("type"));
//        targetColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("target"));
//        startDateColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("startDate"));
//        endDateColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("endDate"));
//
//
//        entriesTableView.setItems(getEntries());
//        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        targetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        startDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        endDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

//    public ObservableList<Goal> getEntries() {
//        this.entries = FXCollections.observableArrayList();
//        return entries;
//    }

//    public void addGoalsToTable() {
//        for (Goal goal : app.getCurrentProfile().getGoals().getCurrentGoals()) {
//            this.entries.add(goal);
//            entriesTableView.getItems().add(0, goal);
//        }
//        //entriesTableView.setItems(this.entries);
//    }

    public void addGoalsToTable() {
        app.getCurrentProfile().getGoals().refreshGoals();
        if (app.getCurrentProfile().getGoals() != null) {
            ObservableList<String> currentGoals = FXCollections.observableArrayList(app.getCurrentProfile().getGoals().getCurrentGoalNames());
            currentGoalsCombo.setItems(currentGoals);
            currentGoalsCombo.setVisibleRowCount(5);

            ObservableList<String> achievedGoalNames = FXCollections.observableArrayList(app.getCurrentProfile().getGoals().getAchievedGoalNames());
//            ObservableList<String> achievedGoalNames = FXCollections.observableArrayList();
//            for (String goalName : app.getCurrentProfile().getGoals().getAchievedGoalNames()) {
//                achievedGoalNames.add(goalName);
//            }
            achievedListView.setItems(achievedGoalNames);

            ObservableList<String> failedGoalNames = FXCollections.observableArrayList(app.getCurrentProfile().getGoals().getFailedGoalNames());
            failedListView.setItems(failedGoalNames);
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
        InputValidator input = new InputValidator(); //is this the best way to interact with the input validator class??

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

        if (validInput == true) {
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
            ObservableList<String> futureGoals = FXCollections.observableArrayList(goalsInstance.getFutureGoalNames());
            //failedListView.setItems(futureGoals); //TODO delete this line (put similar line here refering to future goals tab)
            System.out.println(goalsInstance.getCurrentGoalNames());

            //reset the entry values, ready for a new goal to be created
            goalNameEntry.setText("");
            targetValueEntry.setText("");
        }


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
            Goals goalsInstance = app.getCurrentProfile().getGoals();
            String name = currentGoalsCombo.getValue().toString();
            //Goal goalObject = goalsInstance.getGoalObject(name);
            goalsInstance.removeCurrentGoal(name);
            ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
            currentGoalsCombo.setItems(currentGoals);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Goal successfully removed");
            alert.showAndWait();

            progressText.setText("");
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
            Goals goalsInstance = app.getCurrentProfile().getGoals();
            String goalName = currentGoalsCombo.getValue().toString();
            progressText.setText(goalsInstance.checkGoal(goalName));
//            goalsInstance.checkGoal(goalName);
            ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
            currentGoalsCombo.setItems(currentGoals);
        }
    }

    @FXML
    public void updateAchievedListView() {
        String item = achievedListView.getSelectionModel().getSelectedItem().toString();
        Goal goal = null;
        for (Goal selectedGoal : app.getCurrentProfile().getGoals().getAchievedGoals()) {
            if (selectedGoal.getGoalName() == item) {
                goal = selectedGoal;
                break;
            }
        }
        if (goal != null) {
            String type = goal.getGoalType();
            System.out.println(type);
            typeTextField.setVisible(true);
            startDateTextField.setVisible(true);
            goalTextArea.setVisible(true);
            if (type.equals("Weight")) {
                typeTextField.setText(goal.getGoalType());
                startDateTextField.setText(goal.getGoalStartDate().toString());
                goalTextArea.setText("To weigh " + goal.getGoalWeight() + " kgs or less by " + goal.getGoalTargetDate());
            } else if (type.equals("Frequency")) {
                typeTextField.setText(goal.getGoalType());
                startDateTextField.setText(goal.getGoalStartDate().toString());
                goalTextArea.setText("To participate in " + goal.getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
            } else if (type.equals("Distance")) {
                typeTextField.setText(goal.getGoalType());
                startDateTextField.setText(goal.getGoalStartDate().toString());
                goalTextArea.setText("To cover " + goal.getGoalDistance() + " km by " + goal.getGoalTargetDate());
            } else if (type.equals("BMI")) {
                typeTextField.setText(goal.getGoalType());
                startDateTextField.setText(goal.getGoalStartDate().toString());
                goalTextArea.setText("To have a BMI of " + goal.getGoalBmi() + " or less by " + goal.getGoalTargetDate());
            } else { //goal must be of type Time
                typeTextField.setText(goal.getGoalType());
                startDateTextField.setText(goal.getGoalStartDate().toString());
                goalTextArea.setText("To spend " + goal.getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate());
            }
        }


    }

    @FXML
    public void updateFailedListView() {
        String item = failedListView.getSelectionModel().getSelectedItem().toString();
        Goal goal = null;
        for (Goal selectedGoal : app.getCurrentProfile().getGoals().getFutureGoals()) {
            if (selectedGoal.getGoalName() == item) {
                goal = selectedGoal;
                break;
            }
        }
        if (goal != null) {
            printPastGoalsReview(goal);
        }
    }

    public void printPastGoalsReview(Goal goal) {
        String type = goal.getGoalType();
        typeTextField2.setVisible(true);
        startDateTextField2.setVisible(true);
        goalTextArea2.setVisible(true);
        if (type.equals("Weight")) {
            typeTextField2.setText(type);
            startDateTextField2.setText(goal.getGoalStartDate().toString());
            goalTextArea2.setText("To weigh " + goal.getGoalWeight() + " kgs or less by " + goal.getGoalTargetDate());
        } else if (type.equals("Frequency")) {
            typeTextField2.setText(type);
            startDateTextField2.setText(goal.getGoalStartDate().toString());
            goalTextArea2.setText("To participate in " + goal.getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
        } else if (type.equals("Distance")) {
            typeTextField2.setText(type);
            startDateTextField2.setText(goal.getGoalStartDate().toString());
            goalTextArea2.setText("To cover " + goal.getGoalDistance() + " km by " + goal.getGoalTargetDate());
        } else if (type.equals("BMI")) {
            typeTextField2.setText(type);
            startDateTextField2.setText(goal.getGoalStartDate().toString());
            goalTextArea2.setText("To have a BMI of " + goal.getGoalBmi() + " or less by " + goal.getGoalTargetDate());
        } else { //goal must be of type Time
            typeTextField2.setText(type);
            startDateTextField2.setText(goal.getGoalStartDate().toString());
            goalTextArea2.setText("To spend " + goal.getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate());
        }
    }

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

    @FXML public void openChooseProfile() throws Exception {
        moveDrawer();
        app.launchLoginScene();
    }

    @FXML public void openViewProfile() throws Exception {
        moveDrawer();
        app.launchProfileScene();
    }

    @FXML public void openUploadData() throws Exception {
        moveDrawer();
        app.launchUploadDataScene();
    }

    @FXML public void openViewActivities() throws Exception {
        moveDrawer();
        app.launchActivityViewerScene();
    }

    @FXML public void openGoals() throws Exception {
        moveDrawer();
        app.launchGoalsScene();
    }

    @FXML public void openAnalysis() throws Exception {
        moveDrawer();
        app.launchDataAnalysisScene();
    }

    private void moveDrawer() {
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), drawer);
        closeNav.setToX(-(drawer.getWidth()));
        closeNav.play();
        setUpScene();
    }
}
