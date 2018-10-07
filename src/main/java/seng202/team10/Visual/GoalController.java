package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.BadGoalNameException;
import seng202.team10.Model.Exceptions.InvalidGoalDateException;
import seng202.team10.Model.Exceptions.InvalidGoalTargetException;
import seng202.team10.Model.Exceptions.NoTypeSelectedException;
import seng202.team10.Model.Goals.*;
import seng202.team10.Model.UserProfile;

<<<<<<< HEAD
<<<<<<< HEAD
=======
/**
 * Controller class for the goals screen, which is where goals are viewed, created and managed.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
public class GoalController implements Controllable {
=======
public class GoalController implements Controllable{
>>>>>>> ef5ea113... Implemented the main Screen and merged all screens together, got the Navigation/Menu bar working properly for each slide in/out.


    private MainController mainController ;
    private String existingHelpText;
    private String pastHelpText;


    @FXML private ComboBox goalTypeCombo;
    @FXML private TextField goalNameEntry;
    @FXML private DatePicker startDatePicker;
    @FXML private DatePicker targetDatePicker;
    @FXML private TextField targetValueEntry;
    @FXML private Button createButton;
    @FXML private Button removeGoalButton;
    @FXML private ListView currentGoalsListView;
    @FXML private ListView achievedListView;
    @FXML private ListView failedListView;
    @FXML private ListView futureGoalsListView;
    @FXML private TextArea currentGoalTextArea;
    @FXML private TextArea achievedGoalTextArea;
    @FXML private TextArea failedGoalTextArea;
    @FXML private TextArea futureGoalTextArea;
    @FXML private Label unitsLabel;
    @FXML private TextArea helpTextArea;
    @FXML private Button helpButton;
    @FXML private Tab existingTab;
    @FXML private Tab pastTab;
    @FXML private Label currentDescriptionLabel;
    @FXML private Label futureDescriptionLabel;
    @FXML private Label failedDescriptionLabel;
    @FXML private Label achievedDescriptionLabel;
<<<<<<< HEAD
    private UserProfile currentUser;
=======
    @FXML private Button removeCurrentGoalButton;
    @FXML private Button removeFutureGoalButton;
>>>>>>> 6dc565ab... Updated a bunch of tool tips


    /**
<<<<<<< HEAD
     * sets this scene to be the active one
     * @param app
     */
    public void setApp(GUIController app){
        this.app = app;
=======
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setMainController(MainController mainController)
    {
<<<<<<< HEAD
        this.app = mainController;
>>>>>>> 86ffe4b1... Refactored GUIController to be called MainController
=======
        this.mainController = mainController;
>>>>>>> be0346c6... Refactored "app" to "mainController"
    }


    /**
     * sets up the scene with all the fields and help things
     */
    public void setUpScene()
    {
        // Set tool tips
        setUpToolTips();
        // Set up help text areas
        setUpHelpTexts();
        helpTextArea.setVisible(false);
        helpTextArea.setWrapText(true);

        // Hide the current help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    /**
<<<<<<< HEAD
<<<<<<< HEAD
     * Set up method for the tool tips
=======
=======
     * Setter method for the current user logged in to the profile.
     */
    public void setCurrentUser(UserProfile userProfile)
    {
        currentUser = userProfile;
    }


    /**
>>>>>>> 86a7b54b... Fixed issue with userprofile in goal controller
     * Method to set selected item to null for existing goals pane when clicked away from the list view.
     * Called when clicked on the existing goals pane.
     */
    @FXML private void resetExistingSelect()
    {
        currentGoalsListView.getSelectionModel().select(null);
        futureGoalsListView.getSelectionModel().select(null);
    }


    /**
     * Method to set selected item to null for past goals pane when clicked away from the list view.
     * Called when clicked on the past goals pane.
     */
    @FXML private void resetPastSelect()
    {
        achievedListView.getSelectionModel().select(null);
        failedListView.getSelectionModel().select(null);
    }


    /**
     * Set up method for the tool tips.
>>>>>>> 0a21ee39... Refactored Goal Screen so that all labels can be seen properly, text fields empty when required and future goals can be deleted. Got rid of delete mode and opted for list selected delete function instead. Also updated help text to reflect the new layout.
     */
    private void setUpToolTips()
    {
        // Set up tool tips for current
        helpButton.setTooltip(new Tooltip("Need Help?"));
        // Current Tab
        currentGoalsListView.setTooltip(new Tooltip("Click here to select the current goal you would like to either view or remove."));
        currentGoalTextArea.setTooltip(new Tooltip("This is where the description of the selected failed goal is displayed."));

        // Past Tab
        achievedListView.setTooltip(new Tooltip("This is a list of your past goals that were achieved.\n" +
                                                "Click on a goal to review it."));
        achievedGoalTextArea.setTooltip(new Tooltip("This is where the description of the selected achieved goal is displayed."));
        failedListView.setTooltip(new Tooltip("This is a list of your past goals that were failed.\n" +
                                              "Click on a goal to review it."));
        failedGoalTextArea.setTooltip(new Tooltip("This is where the description of the selected failed goal is displayed."));
        // Future Tab
        futureGoalsListView.setTooltip(new Tooltip("This is a list of your future goals.\n" +
                                                   "Click on a goal to review it."));
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
<<<<<<< HEAD
                "If you have invalid or empty data fields a pop up will notify you what you need to fix."));
        // Set up help text areas
        setHelpTexts();
        helpTextArea.setVisible(false);
        helpTextArea.setWrapText(true);


        achievedTypeTextField.setVisible(false);
        achievedStartDateTextField.setVisible(false);
        achievedGoalTextArea.setVisible(false);

        failedTypeTextField.setVisible(false);
        failedStartDateTextField.setVisible(false);
        failedGoalTextArea.setVisible(false);

<<<<<<< HEAD
//        String item = achievedListView.getSelectionModel().getSelectedItem().toString();
//        achievedTextArea.setText("Goal :  " + item);

//        nameColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("name"));
//        typeColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("type"));
//        targetColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("target"));
//        startDateColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("startDate"));
//        endDateColumn.setCellValueFactory(new PropertyValueFactory<Goal, String>("endDate"));
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    }

    private void populateTable(ObservableList<Goal> entries) {
        entriesTableView.setItems(entries);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        targetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        startDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        endDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

=======
    }

    private void populateTable(ObservableList<Goal> entries) {
        entriesTableView.setItems(entries);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        targetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        startDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        endDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

>>>>>>> 888cf8cc... Added table to future goals tab. Wrote a populate table function, however at the moment it is unused. Wrote more JavaDoc in userProfile and Goals classes

    public void updateGoals() {
        Goals goalsInstance = app.getCurrentProfile().getGoals();

        if (goalsInstance != null) {
            ObservableList<String> currentGoals = FXCollections.observableArrayList(goalsInstance.getCurrentGoalNames());
=======
//
//
//        entriesTableView.setItems(getEntries());
//        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        targetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        startDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        endDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

=======
//
//
//        entriesTableView.setItems(getEntries());
//        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        typeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        targetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        startDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        endDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

>>>>>>> 03dfdb44... Now call addGoalsToTable when profile is set. Added text fields and areas for achieved and failed goals. Implemented addGoalsToTable, updateAchievedListView, updateFailedListView, and printPastGoalsReview functions in GoalController. In review goal methods, now compares current time to target date to see if you have failed your goal. Added achievedGoalNames, failedGoalNames and futureGoalNames ArrayLists to Goals.
//    public ObservableList<Goal> getEntries() {
//        this.entries = FXCollections.observableArrayList();
//        return entries;
//    }
=======
        futureTypeTextField.setVisible(false);
        futureDateTextField.setVisible(false);
        futureGoalTextArea.setVisible(false);
>>>>>>> f118f66c... Implemented checkStartVsTargetDates method in inputValidator class, changed createGoal method to void return type, changed getActivitiesTime method to return minutes instead of seconds, and as a double instead on int. Implemented updateFutureListView func in Goal Controller and changed error messages to be consistent with Andy's. Wrote tests for Goal class.

        // Hide the current help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
=======
                                            "If you have invalid or empty data fields a pop up will notify you what you need to fix."));
<<<<<<< HEAD
>>>>>>> 517b3e8c... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.
=======
        removeCurrentGoalButton.setTooltip(new Tooltip("Click here to delete the selected current goal.\n" +
                                                       "BEWARE! Once a goal is deleted it cannot be restored."));
        removeFutureGoalButton.setTooltip(new Tooltip("Click here to delete the selected future goal.\n" +
                                                      "BEWARE! Once a goal is deleted it cannot be restored."));
>>>>>>> edb50d1a... Implemented remaining tool tips for new elements.
    }


    /**
     * Set up method for the help text area
     */
    private void setUpHelpTexts()
    {
        existingHelpText = "Welcome to the Goals Screen!\n\n" +
                           "You are currently on the Existing Goals Tab.\n\n" +
                           "On this tab you can create new goals, view your current or future goals, remove your current goals or navigate to another tab.\n" +
                           "- To create new goals:\n" +
                           "\t- Locate the Create a new goal panel at the top of\n" +
                           "\t  the screen.\n" +
                           "\t- Enter your name into the text box on the top left.\n" +
                           "\t- Choose a type for your goal in the top middle\n" +
                           "\t  drop-down list.\n" +
                           "\t- Enter a target value for your goal in the text box\n" +
                           "\t  on the top right.\n" +
                           "\t- You cannot choose a target value that has\n" +
                           "\t  already been achieved.\n" +
                           "\t- Choose a start date in the date picker, this\n" +
                           "\t  cannot be in the past.\n" +
                           "\t- Choose a target date you wish to achieve your\n" +
                           "\t  goal by, this cannot be before the start date.\n" +
                           "\t- Click on the Create button and your goal will be\n" +
                           "\t  created and displayed in one of the lists below.\n" +
                           "- To view your current goals:\n" +
                           "\t- Select your goal from the Current Goals list on\n" +
                           "\t  the left.\n" +
                           "\t- Click the Review Progress Button.\n" +
                           "\t- A description of your goal and what you need to\n" +
                           "\t  achieve it will be displayed in the Description\n" +
                           "\t  Window.\n" +
                           "- To delete your current goals that are in progress:\n" +
                           "\t- Select the goal you would like to delete from the\n" +
                           "\t  Current Goals or Future Goals list.\n" +
                           "\t- Click the Remove Goal button underneath that\n" +
                           "\t  goal list.\n" +
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
    }


    /**
     * Method called when help button is clicked on
     * Sets dimensions and text for help area depending on which tab is currently displayed.
     */
    @FXML private void displayHelp()
    {
        helpTextArea.setVisible(true);
        helpTextArea.requestFocus();
        if (existingTab.isSelected()) {
            setHelpTextArea(existingHelpText, 50, 620);
        } else if (pastTab.isSelected()) {
            setHelpTextArea(pastHelpText,305, 365);
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
<<<<<<< HEAD
<<<<<<< HEAD
     * Method to update the achieved goal list view
=======
     * Method to update the current goal list view.
<<<<<<< HEAD
>>>>>>> 24bc09d6... Refactored Goals screen to make it look nicer, and to use up free real estate
     * TODO reset all text fields to display nothing
     */
    @FXML public void updateCurrentListView()
    {
        // Reset text fields
//        resetTextCurrent();
        // If delete mode activated:
        if (deleteMode) {
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
=======
     */
    @FXML public void updateCurrentListView()
    {
            viewGoalDetails();
    }


    /**
=======
>>>>>>> f070a7b8... Fixed a bug with the current goals not being displayed properly.
     * Method to delete a current goal
     * Called when the remove goal button is selected under current goals.
     */
    @FXML public void removeCurrent()
    {
        deleteAGoal(currentGoalsListView, false);
    }


    /**
     * Method to delete a future goal
     * Called when the remove goal button is selected under future goals.
     */
    @FXML public void removeFuture()
    {
        deleteAGoal(futureGoalsListView, true);
    }


    /**
     * Method to delete a goal with a confirmation message.
     */
    private void deleteAGoal(ListView list, boolean future) {
        // If there is a goal selected
        if (list.getSelectionModel().getSelectedItem() != null) {
            // Get the name of the selected goal
            String item = list.getSelectionModel().getSelectedItem().toString();
            // Ask the user if they are sure they want to delete the goal
            String option = mainController .createPopUp(Alert.AlertType.CONFIRMATION, "Warning", "Are you sure you want to delete \"" + item + "\" goal?");
            // If they say yes
            if (option.equals("OK")) {
                //delete the goal
                if (future) {
                    currentUser.getGoals().removeFutureGoal(item);
                } else {
                    currentUser.getGoals().removeCurrentGoal(item);
                }
            }
            addGoalsToTable();
            resetTextFields();
        } else {
            mainController .createPopUp(Alert.AlertType.ERROR, "Error", "You have not selected a goal to remove.");
        }
    }


    /**
     * Method to display details of a goal that's selected.
     * Called when a goal is selected in the Current Goals List View
     */
    @FXML private void updateCurrentListView() {
        // If there is a goal selected
        if (currentGoalsListView.getSelectionModel().getSelectedItem() != null) {
            String item = currentGoalsListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : currentUser.getGoals().getCurrentGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
>>>>>>> 0a21ee39... Refactored Goal Screen so that all labels can be seen properly, text fields empty when required and future goals can be deleted. Got rid of delete mode and opted for list selected delete function instead. Also updated help text to reflect the new layout.
                }
            }
<<<<<<< HEAD
            addGoalsToTable();
        } else {
            // If there is a goal selected
            if (currentGoalsListView.getSelectionModel().getSelectedItem() != null) {
                String item = currentGoalsListView.getSelectionModel().getSelectedItem().toString();
                Goal goal = null;
                for (Goal selectedGoal : app.getTitleBar().getCurrentProfile().getGoals().getCurrentGoals()) {
                    if (selectedGoal.getGoalName().equals(item)) {
                        goal = selectedGoal;
=======
            if (goal != null) {
                String status = currentUser.getGoals().checkGoal(goal.getGoalName());
                currentGoalTextArea.setVisible(true);
                System.out.println(status);
                switch (status) {
                    case "in progress":
                        printGoalsReview(goal, currentGoalTextArea, currentDescriptionLabel);
                        break;

                    case "achieved":
                        currentGoalTextArea.setText("Congratulations!!!\n" +
                                                    "That goal has been achieved and has been moved to the past goals tab.");
                        break;

                    case "failed":
                        currentGoalTextArea.setText("Oh No!!!\nThat goal has been failed and has been moved to the past goals tab.");
>>>>>>> fc6a87cc... Refactored Goals screen GUI to make it look better.
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
<<<<<<< HEAD
=======
                addGoalsToTable();
<<<<<<< HEAD
<<<<<<< HEAD
                app.getDataWriter().saveProfile(app.getTitleBar().getCurrentProfile());
>>>>>>> ade3c4f0... Fixed bug with Goal Creation where no type selected error was never thrown. Also any null value caused an uncaught error.
=======
                mainController .getDataWriter().saveProfile (mainController. getTitleBar().getCurrentProfile());
>>>>>>> be0346c6... Refactored "app" to "mainController"
=======
                mainController .getDataWriter().saveProfile (currentUser);
>>>>>>> 15ba377d... made UserProfile a field in every controller necessary
            }
        }
    }


    /**
     * Method to initialise the goal tables each time the user logs in, enters goals screen or switches tabs within goals.
     */
    public void addGoalsToTable() {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        app.getCurrentProfile().getGoals().refreshGoals();
        if (app.getCurrentProfile().getGoals() != null) {
            ObservableList<String> currentGoals = FXCollections.observableArrayList(app.getCurrentProfile().getGoals().getCurrentGoalNames());
<<<<<<< HEAD
>>>>>>> 3e145f3c... Now call addGoalsToTable when profile is set. Added text fields and areas for achieved and failed goals. Implemented addGoalsToTable, updateAchievedListView, updateFailedListView, and printPastGoalsReview functions in GoalController. In review goal methods, now compares current time to target date to see if you have failed your goal. Added achievedGoalNames, failedGoalNames and futureGoalNames ArrayLists to Goals.
=======
>>>>>>> 03dfdb44... Now call addGoalsToTable when profile is set. Added text fields and areas for achieved and failed goals. Implemented addGoalsToTable, updateAchievedListView, updateFailedListView, and printPastGoalsReview functions in GoalController. In review goal methods, now compares current time to target date to see if you have failed your goal. Added achievedGoalNames, failedGoalNames and futureGoalNames ArrayLists to Goals.
=======
        app.getTitleBar().getCurrentProfile().getGoals().refreshGoals();
        if (app.getTitleBar().getCurrentProfile().getGoals() != null) {
            ObservableList<String> currentGoals = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getGoals().getCurrentGoalNames());
<<<<<<< HEAD
>>>>>>> e7a69fc0... Worked extensively on the GUI. now have a working custom title bar, a new colour theme which has been implemented on login, profile, and createprofile screens.
            currentGoalsCombo.setItems(currentGoals);
            currentGoalsCombo.setVisibleRowCount(5);

=======
            currentGoalsListView.setItems(currentGoals);
>>>>>>> 3cc29b5c... Worked even further on GUI redesign. Now all tableviews are done. Only Goal screens, Analysis screen and map screen are left.
            ObservableList<String> achievedGoalNames = FXCollections.observableArrayList(app.getTitleBar().getCurrentProfile().getGoals().getAchievedGoalNames());
=======
        mainController .getTitleBar().getCurrentProfile().getGoals().refreshGoals();
        if  (mainController. getTitleBar().getCurrentProfile().getGoals() != null) {
            ObservableList<String> currentGoals = FXCollections.observableArrayList (mainController. getTitleBar().getCurrentProfile().getGoals().getCurrentGoalNames());
            currentGoalsListView.setItems(currentGoals);
            ObservableList<String> achievedGoalNames = FXCollections.observableArrayList (mainController. getTitleBar().getCurrentProfile().getGoals().getAchievedGoalNames());
>>>>>>> be0346c6... Refactored "app" to "mainController"
=======
        currentUser.getGoals().refreshGoals();
        if  (currentUser.getGoals() != null) {
            ObservableList<String> currentGoals = FXCollections.observableArrayList (currentUser.getGoals().getCurrentGoalNames());
            currentGoalsListView.setItems(currentGoals);
            ObservableList<String> achievedGoalNames = FXCollections.observableArrayList (currentUser.getGoals().getAchievedGoalNames());
>>>>>>> 15ba377d... made UserProfile a field in every controller necessary
            achievedListView.setItems(achievedGoalNames);
            ObservableList<String> failedGoalNames = FXCollections.observableArrayList (currentUser.getGoals().getFailedGoalNames());
            failedListView.setItems(failedGoalNames);
            ObservableList<String> futureGoalNames = FXCollections.observableArrayList (currentUser.getGoals().getFutureGoalNames());
            futureGoalsListView.setItems(futureGoalNames);
        }
        ObservableList<GoalType> goalTypes = FXCollections.observableArrayList(GoalType.WEIGHT, GoalType.DISTANCE, GoalType.FREQUENCY, GoalType.BMI, GoalType.TIME);
        goalTypeCombo.setItems(goalTypes);
        goalTypeCombo.setVisibleRowCount(5);
    }


    /**
<<<<<<< HEAD
     * creates a new goal
=======
     * Method to reset all text areas to null and hidden
     */
    public void resetTextFields()
    {
        currentGoalTextArea.setText("");
        futureGoalTextArea.setText("");
        achievedGoalTextArea.setText("");
        failedGoalTextArea.setText("");
        currentGoalTextArea.setVisible(false);
        futureGoalTextArea.setVisible(false);
        achievedGoalTextArea.setVisible(false);
        failedGoalTextArea.setVisible(false);
        currentDescriptionLabel.setVisible(false);
        futureDescriptionLabel.setVisible(false);
        achievedDescriptionLabel.setVisible(false);
        failedDescriptionLabel.setVisible(false);
    }


    /**
     * Creates a new goal with the information entered by the user.
>>>>>>> 0a21ee39... Refactored Goal Screen so that all labels can be seen properly, text fields empty when required and future goals can be deleted. Got rid of delete mode and opted for list selected delete function instead. Also updated help text to reflect the new layout.
     */
    @FXML
    public void createGoal()
    {
        try {
            Goals goalsInstance = mainController .getTitleBar().getCurrentProfile().getGoals();

            GoalType type = (GoalType) goalTypeCombo.getValue();
            String name = goalNameEntry.getText();
            //name = name.replaceAll("//s", "");
            int target;
            double doubleTarget;
            int startYear = startDatePicker.getValue().getYear();
            int startMonth = startDatePicker.getValue().getMonthValue();
            int startDay = startDatePicker.getValue().getDayOfMonth();
            DateTime startDate = new DateTime(startYear, startMonth, startDay, 0, 0,0);
            int targetYear = targetDatePicker.getValue().getYear();
            int targetMonth = targetDatePicker.getValue().getMonthValue();
            int targetDay = targetDatePicker.getValue().getDayOfMonth();
            DateTime targetDate = new DateTime(targetYear, targetMonth, targetDay, 23, 59,59);

            String target1 = targetValueEntry.getText();
            doubleTarget = Double.valueOf(target1);
            switch (type) {
                case WEIGHT:
                    goalsInstance.createGoal(name, startDate, targetDate, type.toString(), doubleTarget, mainController .getTitleBar().getCurrentProfile());
                    break;
                case FREQUENCY:
                    target = Integer.parseInt(target1);
                    goalsInstance.createGoal(name, startDate, targetDate, target, type.toString());
                    break;
                case DISTANCE:
                    goalsInstance.createGoal(name, startDate, targetDate, type.toString(), doubleTarget, mainController .getTitleBar().getCurrentProfile());
                    break;
                case BMI:
                    goalsInstance.createGoal(name, startDate, targetDate, type.toString(), doubleTarget, mainController .getTitleBar().getCurrentProfile());
                    break;
                case TIME:  //goal must be of type Time
                    goalsInstance.createGoal(name, startDate, targetDate, type.toString(), doubleTarget, mainController .getTitleBar().getCurrentProfile());
                    break;
            }
            mainController .createPopUp(Alert.AlertType.INFORMATION, "Information", "Goal successfully created!");
            //reset the entry values, ready for a new goal to be created
            goalNameEntry.setText("");
            targetValueEntry.setText("");
<<<<<<< HEAD
<<<<<<< HEAD
=======
            startDatePicker.getEditor().clear();
            targetDatePicker.getEditor().clear();
            goalTypeCombo.getSelectionModel().select(null);
            this.addGoalsToTable();
<<<<<<< HEAD
<<<<<<< HEAD
            app.getDataWriter().saveProfile(app.getTitleBar().getCurrentProfile());
<<<<<<< HEAD
>>>>>>> f070a7b8... Fixed a bug with the current goals not being displayed properly.
        } catch (InvalidGoalDateException | BadGoalNameException | InvalidGoalTargetException | NoTypeSelectedException exception) {
            app.createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
        } catch (NumberFormatException exception) {
            app.createPopUp(Alert.AlertType.ERROR, "Error", "Please enter a valid number for target value");
=======
            this.addGoalsToTable();
>>>>>>> 24bc09d6... Refactored Goals screen to make it look nicer, and to use up free real estate
=======
=======
            mainController .getDataWriter().saveProfile (mainController. getTitleBar().getCurrentProfile());
>>>>>>> be0346c6... Refactored "app" to "mainController"
=======
            mainController .getDataWriter().saveProfile (currentUser);
>>>>>>> 15ba377d... made UserProfile a field in every controller necessary
        } catch (InvalidGoalDateException | BadGoalNameException | InvalidGoalTargetException exception) {
            mainController .createPopUp(Alert.AlertType.ERROR, "Error", exception.getMessage());
        } catch (NumberFormatException exception) {
            mainController .createPopUp(Alert.AlertType.ERROR, "Error", "Please enter a valid number for target value.");
        } catch (NullPointerException exception) {
<<<<<<< HEAD
            app.createPopUp(Alert.AlertType.ERROR, "Error", "One or more fields has been left empty.");
>>>>>>> ade3c4f0... Fixed bug with Goal Creation where no type selected error was never thrown. Also any null value caused an uncaught error.
=======
            mainController .createPopUp(Alert.AlertType.ERROR, "Error", "One or more fields has been left empty.");
>>>>>>> be0346c6... Refactored "app" to "mainController"
        }

    }


    /**
<<<<<<< HEAD
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
     * Method to update the achieved goal list view
     * TODO these methods can be refactored
=======
     * Method to update the achieved goal list view.
>>>>>>> 0a21ee39... Refactored Goal Screen so that all labels can be seen properly, text fields empty when required and future goals can be deleted. Got rid of delete mode and opted for list selected delete function instead. Also updated help text to reflect the new layout.
     */
    @FXML public void updateAchievedListView() {
        if (achievedListView.getSelectionModel().getSelectedItem() != null && !mainController.getTitleBar().getCurrentProfile().getGoals().getAchievedGoals().isEmpty()) {
            String item = achievedListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : mainController .getTitleBar().getCurrentProfile().getGoals().getAchievedGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                printGoalsReview(goal, achievedGoalTextArea, achievedDescriptionLabel);
            }
        }
    }


    /**
     * Method to update the failed goal list view
     */
    @FXML public void updateFailedListView() {
        if (failedListView.getSelectionModel().getSelectedItem() != null && !mainController.getTitleBar().getCurrentProfile().getGoals().getFailedGoals().isEmpty()) {
            String item = failedListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : mainController .getTitleBar().getCurrentProfile().getGoals().getFailedGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                printGoalsReview(goal, failedGoalTextArea, failedDescriptionLabel);
            }
        }
    }


    /**
     * Method to update the future goal list view
     */
    @FXML public void updateFutureListView() {
        if (futureGoalsListView.getSelectionModel().getSelectedItem() != null && !mainController.getTitleBar().getCurrentProfile().getGoals().getFutureGoals().isEmpty()) {
            String item = futureGoalsListView.getSelectionModel().getSelectedItem().toString();
            Goal goal = null;
            for (Goal selectedGoal : mainController .getTitleBar().getCurrentProfile().getGoals().getFutureGoals()) {
                if (selectedGoal.getGoalName().equals(item)) {
                    goal = selectedGoal;
                    break;
                }
            }
            if (goal != null) {
                printGoalsReview(goal, futureGoalTextArea, futureDescriptionLabel);
            }
        }
    }


    /**
<<<<<<< HEAD
     * Method to display the details of a goal in given text fields and a text area
     * @param goal Goal: goal to be reviewed
     * @param typeText TextField: text field for the type of goal
     * @param startDateText TextField: text field for the start date of the goal
     * @param goalText Text Area: text area for the description of the goal.
=======
     * Method to display the details of a goal in given text fields and a text area.
     * @param goal <b>Goal</b> to be reviewed.
     * @param goalText <b>TextArea</b> for the description of the goal.
>>>>>>> fc6a87cc... Refactored Goals screen GUI to make it look better.
     */
    private void printGoalsReview(Goal goal, TextArea goalText, Label description) {
        String type = goal.getGoalType();
        goalText.setVisible(true);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        if (type.equals("Weight")) {
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To weigh " + ((WeightGoal) goal).getGoalWeight() + " kgs or less by " + goal.getGoalTargetDate());
        } else if (type.equals("Frequency")) {
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To participate in " + ((FrequencyGoal) goal).getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
        } else if (type.equals("Distance")) {
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To cover " + ((DistanceGoal) goal).getGoalDistance() + " metres by " + goal.getGoalTargetDate());
        } else if (type.equals("BMI")) {
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To have a BMI of " + ((BmiGoal) goal).getGoalBmi() + " or less by " + goal.getGoalTargetDate());
        } else { //goal must be of type Time
            typeText.setText(type);
            startDateText.setText(goal.getGoalStartDate().toString());
            goalText.setText("To spend " + ((TimeGoal) goal).getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate());
=======
=======
>>>>>>> 517b3e8c... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.
        switch (type) {
            case "Weight":
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
<<<<<<< HEAD
                goalText.setText("To weigh " + goal.getGoalWeight() + " kgs or less by " + goal.getGoalTargetDate());
=======
                goalText.setText("To weigh " + ((WeightGoal) goal).getGoalWeight() + " kgs or less by " + goal.getGoalTargetDate());
>>>>>>> 517b3e8c... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.
                break;
            case "Frequency":
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
<<<<<<< HEAD
                goalText.setText("To participate in " + goal.getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
=======
=======
        description.setVisible(true);
        switch (type) {
            case "Weight":
                goalText.setText("Type: " + type + "\n\nStart Date: " + goal.getGoalStartDate().getDateAsString() +
                        "\n\nTarget Date: " + goal.getGoalTargetDate().getDateAsString() + "\n\nGoal to achieve: " +
                        "To weigh " + ((WeightGoal) goal).getGoalWeight() + " kgs or less by " + goal.getGoalTargetDate().getDateAsString());
                break;

            case "Frequency":
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> fc6a87cc... Refactored Goals screen GUI to make it look better.
                goalText.setText("To participate in " + ((FrequencyGoal) goal).getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
>>>>>>> 517b3e8c... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.
                break;
            case "Distance":
<<<<<<< HEAD
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
<<<<<<< HEAD
                goalText.setText("To cover " + goal.getGoalDistance() + " metres by " + goal.getGoalTargetDate());
=======
=======
>>>>>>> fc6a87cc... Refactored Goals screen GUI to make it look better.
                goalText.setText("To cover " + ((DistanceGoal) goal).getGoalDistance() + " metres by " + goal.getGoalTargetDate());
>>>>>>> 517b3e8c... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.
                break;
            case "BMI":
<<<<<<< HEAD
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
<<<<<<< HEAD
                goalText.setText("To have a BMI of " + goal.getGoalBmi() + " or less by " + goal.getGoalTargetDate());
=======
=======
>>>>>>> fc6a87cc... Refactored Goals screen GUI to make it look better.
                goalText.setText("To have a BMI of " + ((BmiGoal) goal).getGoalBmi() + " or less by " + goal.getGoalTargetDate());
>>>>>>> 517b3e8c... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.
                break;
            default:  //goal must be of type Time
<<<<<<< HEAD
                typeText.setText(type);
                startDateText.setText(goal.getGoalStartDate().toString());
<<<<<<< HEAD
                goalText.setText("To spend " + goal.getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate());
                break;
>>>>>>> b24b217c... Finished implementing help buttons and tool tips in the goals Screen.
=======
=======
>>>>>>> fc6a87cc... Refactored Goals screen GUI to make it look better.
                goalText.setText("To spend " + ((TimeGoal) goal).getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate());
=======
                goalText.setText("Type: " + type + "\n\nStart Date: " + goal.getGoalStartDate().toString() +
                        "\n\nTarget Date: " + goal.getGoalTargetDate().toString() + "\n\nGoal to achieve: " +
                        "To participate in " + ((FrequencyGoal) goal).getGoalFrequency() + " activities by " + goal.getGoalTargetDate());
=======
                goalText.setText("Type: " + type + "\n\nStart Date: " + goal.getGoalStartDate().getDateAsString() +
                        "\n\nTarget Date: " + goal.getGoalTargetDate().getDateAsString() + "\n\nGoal to achieve: " +
                        "To participate in " + ((FrequencyGoal) goal).getGoalFrequency() + " activities by " + goal.getGoalTargetDate().getDateAsString());
>>>>>>> 0a21ee39... Refactored Goal Screen so that all labels can be seen properly, text fields empty when required and future goals can be deleted. Got rid of delete mode and opted for list selected delete function instead. Also updated help text to reflect the new layout.
                break;

            case "Distance":
                goalText.setText("Type: " + type + "\n\nStart Date: " + goal.getGoalStartDate().getDateAsString() +
                        "\n\nTarget Date: " + goal.getGoalTargetDate().getDateAsString() + "\n\nGoal to achieve: " +
                        "To cover " + ((DistanceGoal) goal).getGoalDistance() + " metres by " + goal.getGoalTargetDate().getDateAsString());
                break;

            case "BMI":
                goalText.setText("Type: " + type + "\n\nStart Date: " + goal.getGoalStartDate().getDateAsString() +
                        "\n\nTarget Date: " + goal.getGoalTargetDate().getDateAsString() + "\n\nGoal to achieve: " +
                        "To have a BMI of " + ((BmiGoal) goal).getGoalBmi() + " or less by " + goal.getGoalTargetDate().getDateAsString());
                break;

            default:  //goal must be of type Time
<<<<<<< HEAD
                goalText.setText("Type: " + type + "\n\nStart Date: " + goal.getGoalStartDate().toString() +
                        "\n\nTarget Date: " + goal.getGoalTargetDate().toString() + "\n\nGoal to achieve: " +
                        "To spend " + ((TimeGoal) goal).getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate());
>>>>>>> c51a4395... Goals screen refactoring continued
=======
                goalText.setText("Type: " + type + "\n\nStart Date: " + goal.getGoalStartDate().getDateAsString() +
                        "\n\nTarget Date: " + goal.getGoalTargetDate().getDateAsString() + "\n\nGoal to achieve: " +
                        "To spend " + ((TimeGoal) goal).getGoalTime() + " minutes exercising by " + goal.getGoalTargetDate().getDateAsString());
>>>>>>> 0a21ee39... Refactored Goal Screen so that all labels can be seen properly, text fields empty when required and future goals can be deleted. Got rid of delete mode and opted for list selected delete function instead. Also updated help text to reflect the new layout.
                break;
>>>>>>> 517b3e8c... Refactored Classes in the Visual, Exceptions and ActivitiesData packages to meet style guidlines and java doc specs. Also refactored some methods that were particularly large. Also dealt with some warnings and refactored a bit because of it.
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