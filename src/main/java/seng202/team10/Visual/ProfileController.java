package seng202.team10.Visual;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
<<<<<<< HEAD
import seng202.team10.Model.Exceptions.InvalidHeightException;
import seng202.team10.Model.Exceptions.InvalidWeightException;
import seng202.team10.Model.Exceptions.UniqueNameException;
import seng202.team10.Model.Exceptions.UserNameException;
=======
import seng202.team10.Model.Exceptions.*;
import seng202.team10.Model.Goals.Goal;
import seng202.team10.Model.UserProfile;
>>>>>>> 4f1b7d76... Fixed tests so that new format of error exceptions does not break the pipeline.

import java.text.DecimalFormat;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

<<<<<<< HEAD
=======
/**
 * Controller class for the profile screen, where user information and activity summaries are displayed.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
public class ProfileController {

<<<<<<< HEAD
<<<<<<< HEAD
    private GUIController app;
    private DataAnalysis dataAnalysis = new DataAnalysis();
=======
    private MainController app;
>>>>>>> 86ffe4b1... Refactored GUIController to be called MainController
=======
    private MainController mainController ;
>>>>>>> be0346c6... Refactored "app" to "mainController"
    private List<String> quotes;
    private UserProfile currentUser;
    private boolean firstQuote;

    @FXML Pane calendarPane;
    @FXML private Label welcomeProfileLabel;
    @FXML private Label quotesLabel;
    @FXML public Label dailyStatsLabel;
    @FXML private TextField usernameTA;
    @FXML private TextField dobTA;
    @FXML private TextField genderTA;
    @FXML private TextField weightValueTA;
    @FXML private TextField heightValueTA;
    @FXML private TextField bmiValueTA;
    @FXML private Button editProfileButton;
    @FXML private Button confirmButton;
    @FXML private Button quoteButton;
    @FXML private Label recentActivitiesLabel;
    @FXML public HBox activity1HBox;
    @FXML public HBox activity2HBox;
    @FXML public HBox activity3HBox;
    @FXML public Text activity1Text;
    @FXML public Text activity2Text;
    @FXML public Text activity3Text;
    @FXML public Text goalNameText;
    @FXML public Text goalStatusText;
    @FXML public Text goalTypeText;
    @FXML private HBox distanceHBox;
    @FXML private HBox velocityHBox;
    @FXML private HBox heartRateHBox;
    @FXML private Text distanceText;
    @FXML private Text velocityText;
    @FXML private Text heartRateText;
    @FXML private VBox wholeProfileVBox;
    @FXML private TextArea helpTextArea;
    @FXML public ListView activitiesListView;
    @FXML public ListView goalsListView;
    @FXML public Label activitiesListLabel;
    @FXML public Label goalsListLabel;
    @FXML public Label goalsListClickLabel;
    @FXML public Label activitiesListClickLabel;
    @FXML public Label statsClickLabel;
    @FXML public Label activitiesClickLabel;
    @FXML public Label goalsClickLabel;
    @FXML public HBox goalStats1HBox;
    @FXML public HBox goalStats2HBox;
    @FXML public HBox goalStats3HBox;
    @FXML public HBox activityStats1HBox;
    @FXML public HBox activityStats2HBox;
    @FXML public HBox activityStats3HBox;
    @FXML public Text activityNameText;
    @FXML public Text activityTypeText;
    @FXML public Text activityDurationText;
    @FXML private Label goalDescriptionLabel;
    @FXML private Label activityDescriptionLabel;

    /**
<<<<<<< HEAD
<<<<<<< HEAD
     * List of Motivational quotes.
     */
    private void setQuotes()
    {
        quotes = Arrays.asList(
                "To not prepare is to prepare to fail.",
                "Exercise instead of extra fries.",
                "It starts in the kitchen and continues on the pavement.",
                "People say nothing is impossible, but I do nothing everyday.",
                "If you cannot do great things, do small things in a great way.",
                "You are what you repeatedly do.",
                "It is our choices that show what we truly are, far more than our abilities.",
                "People often say that motivation doesn't last. Well, neither does bathing - that's why we recommend it daily.",
                "I didn't get there by wishing for it or hoping for it, but by working for it.",
                "Be patient with yourself. Self-growth is tender; it’s holy ground. There’s no greater investment.",
                "You can waste your life drawing lines. Or you can live your life crossing them.",
                "Action is the foundational key to all success.",
                "Obstacles are those frightful things you see when you take your eyes off your goal.",
                "Someday is not a day of the week.",
                "Challenges are what make life interesting and overcoming them is what makes life meaningful.",
                "I already know what giving up feels like, I want to see what happens if i don't.",
                "Some days it's hard to find motivation, some days motivation finds you!",
                "Yesterday you said tomorrow, so just do it!"
        );
    }


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
=======
     * Setter method to pass the GUIController into this controller.
     * @param guiController <b>GUIController:</b> The main controller.
>>>>>>> 4f1b7d76... Fixed tests so that new format of error exceptions does not break the pipeline.
     */
    public void setApp(GUIController app)
    {
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
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene()
    {
        firstQuote = true;
        // Set quotes list
        setQuotes();
        // Set tool tips
        setUpToolTips();
        // Set up help text area
        setUpHelpTextArea();
        //Reset visibility of labels, HBoxs and ListViews
        resetVisibility();
        // Hide buttons that are hidden
        confirmButton.setVisible(false);
        wholeProfileVBox.setVisible(false);
        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    /**
<<<<<<< HEAD
     * Set up method for the help text area
=======
     * Sets the list of motivational quotes.
     */
    private void setQuotes()
    {
        quotes = Arrays.asList(
                "To not prepare is to prepare to fail.",
                "Exercise instead of extra fries.",
                "It starts in the kitchen and continues on the pavement.",
                "People say nothing is impossible, but I do nothing everyday.",
                "If you cannot do great things, do small things in a great way.",
                "You are what you repeatedly do.",
                "It is our choices that show what we truly are, far more than our abilities.",
                "People often say that motivation doesn't last. Well, neither does bathing - that's why we recommend it daily.",
                "I didn't get there by wishing for it or hoping for it, but by working for it.",
                "Be patient with yourself. Self-growth is tender; it’s holy ground. There’s no greater investment.",
                "You can waste your life drawing lines. Or you can live your life crossing them.",
                "Action is the foundational key to all success.",
                "Obstacles are those frightful things you see when you take your eyes off your goal.",
                "Someday is not a day of the week.",
                "Challenges are what make life interesting and overcoming them is what makes life meaningful.",
                "I already know what giving up feels like, I want to see what happens if i don't.",
                "Some days it's hard to find motivation, some days motivation finds you!",
                "Yesterday you said tomorrow, so just do it!"
        );
    }


    /**
     * Setter method for the current user
     * @param currentUser UserProfile
     */
    public void setCurrentUser(UserProfile currentUser)
    {
        this.currentUser = currentUser;
    }


    @FXML private void setGoalLabels()
    {
        if (goalsListView.getSelectionModel().getSelectedItem() != null) {
            Goal goal = (Goal) goalsListView.getSelectionModel().getSelectedItem();
            goalNameText.setText("Goal Name: " + goal.getGoalName());
            goalTypeText.setText("Goal Type: " + goal.getGoalType());
            String status = null;
            if (goal.getGoalAchieved()) {
                status = "Achieved!";
            } else status = "In Progress";
            goalStatusText.setText("Goal Status: " + status);
            goalStats1HBox.setVisible(true);
            goalStats2HBox.setVisible(true);
            goalStats3HBox.setVisible(true);
            goalsClickLabel.setVisible(false);
        }
    }


    @FXML private void setActivityLabels()
    {
        if (activitiesListView.getSelectionModel().getSelectedItem() != null) {
            Activity activity = (Activity) activitiesListView.getSelectionModel().getSelectedItem();
            activityNameText.setText("Activity Name: " + activity.getName());
            activityTypeText.setText("Activity Type: " + activity.getType());
            activityDurationText.setText("Activity Duration: " + activity.getDurationMins() + " minutes");
            activityStats1HBox.setVisible(true);
            activityStats2HBox.setVisible(true);
            activityStats3HBox.setVisible(true);
            activitiesClickLabel.setVisible(false);
        }
    }


    /**
     * Set up method for the help text area.
>>>>>>> 4f1b7d76... Fixed tests so that new format of error exceptions does not break the pipeline.
     */
    private void setUpHelpTextArea()
    {
        helpTextArea.setText("Welcome to Profile View Screen!\n\n" +
                             "On this screen you can edit your profile details, view brief statistics, and view activities and goals in a calendar format.\n" +
                             "- To edit your profile:\n" +
                             "\t- Click on the Edit button\n" +
                             "\t- Click on the data field you wish to edit\n" +
                             "\t- Enter the new value\n" +
                             "\t- Click the Confirm Changes Button\n" +
                             "\tIf any invalid data is entered you will get a pop up\n" +
                             "\tand will need to try again.\n" +
                             "- Your total statistics are displayed in the\n" +
                             "  information box on the bottom left of the screen.\n" +
                             "- To view activities and goals in the calendar:\n" +
                             "\t- Navigate to the month and year of your desired\n" +
                             "\t  activity or goal using the controls at the top\n" +
                             "\t  of the calendar.\n" +
                             "\t- Dates with activities will have an A in them\n" +
                             "\t  and will be highlighted blue.\n" +
                             "\t- Dates with goals will have an G in them\n" +
                             "\t  and will be highlighted green.\n" +
                             "\t- Click on the date you wish to see.\n" +
                             "\t- Your activities and goals for that day will now be\n" +
                             "\t  displayed in the lists to the right of the calendar.\n" +
                             "\t  Your daily statistics will be updated for that day.\n" +
                             "\t- Click on the goal you wish to see more details\n" +
                             "\t  about and it will be displayed in the information\n" +
                             "\t  box below the calendar\n" +
                             "Hover the mouse over each item to see what it does.");
        helpTextArea.setVisible(false);
        helpTextArea.setWrapText(true);
    }


    /**
     * Set up method for the tool tips
     */
    private void setUpToolTips()
    {
        editProfileButton.setTooltip(new Tooltip("Click here to enter edit mode."));
        confirmButton.setTooltip(new Tooltip("Click here to confirm changes and exit edit mode."));
        usernameTA.setTooltip(new Tooltip("User name is displayed here."));
        dobTA.setTooltip(new Tooltip("Date of birth is displayed here."));
        genderTA.setTooltip(new Tooltip("Gender is displayed here."));
        weightValueTA.setTooltip(new Tooltip("Weight is displayed here in kg's."));
        heightValueTA.setTooltip(new Tooltip("Height is displayed here in cm's."));
        bmiValueTA.setTooltip(new Tooltip("BMI value is displayed here."));
        quoteButton.setTooltip(new Tooltip("Motivation is key!\nClick here for new quote."));
        recentActivitiesLabel.setTooltip(new Tooltip("Here your total statistics are displayed"));
        activitiesListLabel.setTooltip(new Tooltip("Here is a list of activities for the calendar date selected."));
        goalsListLabel.setTooltip(new Tooltip("Here is a list of goals for the calendar date selected."));
        dailyStatsLabel.setTooltip(new Tooltip("Here is the daily statistics for the calendar date selected."));
        goalDescriptionLabel.setTooltip(new Tooltip("Here is the description for the goal selected."));
        activityDescriptionLabel.setTooltip(new Tooltip("Here is the description for the activity selected."));
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
    }


    /**
     * Method to sets a new random quote in the quotes label
     */
    @FXML public void setQuote()
    {
        if (firstQuote && currentUser.getBirthDate().getDateAsString().substring(0, 5).equals(DateTime.now().getDateAsString().substring(0, 5))) {
            quotesLabel.setText("Happy Birthday From Coach Potato!!!");
            firstQuote = false;
        } else {
            quotesLabel.setText(quotes.get((int) (Math.random() * (quotes.size()))));
            firstQuote = false;
        }
    }


    /**
     * Method to reset values of all GUI elements to default
     */
    public void resetVisibility()
    {
        activity1HBox.setVisible(false);
        activity2HBox.setVisible(false);
        activity3HBox.setVisible(false);
        goalStats1HBox.setVisible(false);
        goalStats2HBox.setVisible(false);
        goalStats3HBox.setVisible(false);
        activityStats1HBox.setVisible(false);
        activityStats2HBox.setVisible(false);
        activityStats3HBox.setVisible(false);
        activitiesClickLabel.setVisible(true);
        goalsClickLabel.setVisible(true);
        statsClickLabel.setVisible(true);
        activitiesListView.setVisible(true);
        goalsListView.setVisible(true);
        goalsListClickLabel.setVisible(true);
        activitiesListClickLabel.setVisible(true);
        goalsListClickLabel.setText("Click on a date to get more details");
        activitiesListClickLabel.setText("Click on a date to get more details");
        ObservableList<Goal> goalsList = FXCollections.observableArrayList();
        ObservableList<Activity> activitiesList = FXCollections.observableArrayList();
        goalsListView.setItems(goalsList);
        activitiesListView.setItems(activitiesList);
        dailyStatsLabel.setText("Daily Statistics");
    }


    /**
     * Method to correctly display all user related details for the view profile scene.
     */
    protected void setUserDetails()
    {
        DecimalFormat df2 = new DecimalFormat("#.##");
        setUpScene();

        wholeProfileVBox.setVisible(true);
<<<<<<< HEAD
        app.getTitleBar().getCurrentProfile();
        welcomeProfileLabel.setText("Welcome " + String.valueOf(app.getTitleBar().getCurrentProfile().getName()) + ", Let's do it!");
        usernameTA.setText(app.getTitleBar().getCurrentProfile().getName());
        genderTA.setText(app.getTitleBar().getCurrentProfile().getGender());
        dobTA.setText(app.getTitleBar().getCurrentProfile().getBirthDate().getDateAsString());
        weightValueTA.setText(df2.format((app.getTitleBar().getCurrentProfile().getWeight())));
        heightValueTA.setText(df2.format((app.getTitleBar().getCurrentProfile().getHeight())));
        bmiValueTA.setText(df2.format((app.getTitleBar().getCurrentProfile().calcBmi())) + " - " + app.getTitleBar().getCurrentProfile().getBmiCategory());
=======
        welcomeProfileLabel.setText("Welcome " + String.valueOf(currentUser.getName()) + ", Let's do it!");
        usernameTA.setText(currentUser.getName());
        genderTA.setText(currentUser.getGender());
        dobTA.setText(currentUser.getBirthDate().getDateAsString());
        weightValueTA.setText(df2.format((currentUser.getWeight())));
        heightValueTA.setText(df2.format((currentUser.getHeight())));
        bmiValueTA.setText(df2.format((currentUser.calcBmi())) + " - " + currentUser.getBmiCategory());
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 4f1b7d76... Fixed tests so that new format of error exceptions does not break the pipeline.
        calendarPane.getChildren().add(new CalenderPaneController(YearMonth.now(), app, this).getView());
=======
        calendarPane.getChildren().add(new CalendarPaneController(YearMonth.now(), app, this).getView());
>>>>>>> 7dae5bcb... changed miss spelt calendar
=======
        calendarPane.getChildren().add(new CalendarPaneController(YearMonth.now(), mainController , this).getView());
>>>>>>> be0346c6... Refactored "app" to "mainController"

        resetVisibility();

        // Sets up the calendar and other stats if the user has already uploaded the data to the app else all values are 0 initially.
        if (currentUser.getActivities().size() > 0) {

            distanceText.setText("Total Distance Covered: " + df2.format((currentUser.getActivitiesDistance(new DateTime(1900, 1,1,0,0,0), new DateTime(2019, 1,1,0,0,0)))/1000) + " km");
            velocityText.setText("Average Speed: " + df2.format(currentUser.getActivitiesSpeed(new DateTime(1900, 1,1,0,0,0), new DateTime(2019, 1,1,0,0,0))) + " km/h");
            heartRateText.setText("Average Heart Rate: " + String.valueOf(currentUser.getActivitiesHeartRate(new DateTime(1900, 1,1,0,0,0), new DateTime(2019, 1,1,0,0,0))) + " bpm");
            recentActivitiesLabel.setVisible(true);

        } else {
            distanceText.setText("Total Distance Covered: 0.00 km");
            velocityText.setText("Average Speed: 0.00 km/h");
            heartRateText.setText("Average Heart Rate: No Data");
        }
    }


    /**
     * Method to edit user's profile details. User can edit name, DOB, gender, weight and height.
     */
    @FXML private void editProfile()
    {
        editProfileButton.setVisible(false);
        confirmButton.setVisible(true);
        usernameTA.setEditable(true);
        usernameTA.setStyle(null);
        dobTA.setEditable(true);
        dobTA.setStyle(null);
        genderTA.setEditable(true);
        genderTA.setStyle(null);
        weightValueTA.setEditable(true);
        weightValueTA.setStyle("-fx-text-fill: black");
        heightValueTA.setEditable(true);
        heightValueTA.setStyle("-fx-text-fill: black");
    }


    /**
     * Method to save user's edited profile details. Saves the edited name, DOB, gender, weight and height if valid.
     */
    @FXML private void confirmEdit()
    {
        usernameTA.setEditable(false);
        usernameTA.setStyle("-fx-background-color: transparent");
        dobTA.setEditable(false);
        dobTA.setStyle("-fx-background-color: transparent");
        genderTA.setEditable(false);
        genderTA.setStyle("-fx-background-color: transparent");
        weightValueTA.setEditable(false);
        weightValueTA.setStyle("-fx-text-fill: black; " +
                "-fx-background-color: transparent");
        heightValueTA.setEditable(false);
        heightValueTA.setStyle("-fx-text-fill: black; " +
                "-fx-background-color: transparent");

        // Set Name and handle Exceptions
        String oldName = currentUser.getName();
        try {
            String nameString = usernameTA.getText();
            mainController .checkUniqueName(nameString);
            try {
                currentUser.setName(nameString);
            } catch (UserNameException | IllegalArgumentException exception) {
                mainController .createPopUp(Alert.AlertType.ERROR, "Invalid Username", "Please enter a valid username: It should be less than 50 characters and only contain alphanumeric characters." );
            }
        } catch (UniqueNameException | IllegalArgumentException exception) {
            mainController .createPopUp(Alert.AlertType.ERROR, "Invalid Username", "Please enter a valid username: This username already exists." );
        }
        String newName = currentUser.getName();
        if(!(oldName.equals(newName))) {
            mainController .getDataWriter().deleteProfile(oldName + " - " + currentUser.getGender());
            mainController .getDataWriter().saveProfile(currentUser);
        }
        // Set weight and handle exceptions
        double oldWeight = currentUser.getWeight();
        try {
            currentUser.setWeight(Double.valueOf(weightValueTA.getText()));
        }  catch (InvalidWeightException | IllegalArgumentException exception) {
            mainController .createPopUp(Alert.AlertType.ERROR, "Invalid Weight", "Please enter a valid weight: It should be greater than 30 kg and less than 500 kg." );
        }
        double newWeight = currentUser.getWeight();

        // If weight is successfully changed update last weight change
        if (!(String.format("%.2f", oldWeight).equals(String.format("%.2f", newWeight)))) {
            currentUser.setLastWeightUpdate(DateTime.now());
        }

        // Set height and handle Exceptions
        try {
            currentUser.setHeight(Double.valueOf(heightValueTA.getText()));
        } catch (InvalidHeightException | IllegalArgumentException exception) {
            mainController .createPopUp(Alert.AlertType.ERROR, "Invalid Height", "Please enter a valid height: It should be greater than 50 cm and less than 250 cm." );
        }

        // Set Date of Birth and handle exceptions
        try {
            String dob = dobTA.getText();
            int yearInt = Integer.valueOf(dob.substring(6));
            int monthInt = Integer.valueOf(dob.substring(3,5));
            int dayInt = Integer.valueOf(dob.substring(0,2));
            DateTime dateOfBirth = new DateTime(yearInt, monthInt, dayInt, 0, 0, 0);
<<<<<<< HEAD
            app.getUsers().get(app.getUsers().indexOf(app.getTitleBar().getCurrentProfile())).setBirthDate(dateOfBirth);
        } catch (NullPointerException | IllegalArgumentException exception) {
=======
            currentUser.setBirthDate(dateOfBirth);
        } catch (NullPointerException | IllegalArgumentException | InvalidDateException exception) {
<<<<<<< HEAD
>>>>>>> 83ff16b2... Fixed edit profile functionality
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Date of Birth", "Please enter a valid date: It should be in DD/MM/YYYY format." );
=======
            mainController .createPopUp(Alert.AlertType.ERROR, "Invalid Date of Birth", "Please enter a valid date: It should be in DD/MM/YYYY format." );
>>>>>>> be0346c6... Refactored "app" to "mainController"
        }
        firstQuote = true;
        setQuote();

        // Set gender and handle Exceptions
        List<String> genderList = Arrays.asList("Male", "Female", "Other");
        String oldGender = currentUser.getGender();
        String newGender = genderTA.getText();
        if (genderList.contains(newGender)) {
            currentUser.setGender(newGender);
        } else {
            mainController .createPopUp(Alert.AlertType.ERROR, "Invalid Gender", "Please enter a valid gender: It should be either \"Male\", \"Female\" or \"Other\"." );
        }
        if (!(oldGender.equals(currentUser.getGender()))) {
            mainController.getTitleBar().setProfileImage();
            mainController .getDataWriter().deleteProfile(currentUser.getName() + " - " + oldGender);
        }
        confirmButton.setVisible(false);
        editProfileButton.setVisible(true);
        mainController .getDataWriter() .saveProfile(currentUser);
        setUserDetails();
    }


    /**
     * Method to prompt the user if they are due to update their weight
     */
    public void checkLastWeightUpdate()
    {
        // If it has been longer than a week since last weight update
        if (DateTime.now().subtractDaysFromDateTime(currentUser.getLastWeightUpdate()) > 7) {
            // Prompt user to update weight
            mainController.createPopUp(Alert.AlertType.INFORMATION, "Weight Update Time!",
                                       "You have not updated your weight this week.\n" +
                                       "Please edit your proofile with your current weught.");
        }
    }
}
