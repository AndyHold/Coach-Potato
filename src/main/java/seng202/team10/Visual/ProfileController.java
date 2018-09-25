package seng202.team10.Visual;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import seng202.team10.Control.DataAnalysis;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Exceptions.InvalidHeightException;
import seng202.team10.Model.Exceptions.InvalidWeightException;
import seng202.team10.Model.Exceptions.UniqueNameException;
import seng202.team10.Model.Exceptions.UserNameException;

import java.text.DecimalFormat;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

public class ProfileController {

    private GUIController app;
    private DataAnalysis dataAnalysis = new DataAnalysis();
    private List<String> quotes;

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
    @FXML private Button logoutButton;
    @FXML private Button quoteButton;
    @FXML private Label recentActivitiesLabel;
    @FXML public HBox activity1HBox;
    @FXML public HBox activity2HBox;
    @FXML public HBox activity3HBox;
    @FXML public Text activity1Text;
    @FXML public Text activity2Text;
    @FXML public Text activity3Text;
    @FXML private HBox distanceHBox;
    @FXML private HBox velocityHBox;
    @FXML private HBox heartRateHBox;
    @FXML private Text distanceText;
    @FXML private Text velocityText;
    @FXML private Text heartRateText;
    @FXML private VBox drawer;
    @FXML private VBox wholeProfileVBox;
    @FXML private TextArea helpTextArea;


    /**
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
                "It is our choices, Harry that show what we truly are, far more than our abilities.",
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
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * Sets up objects that require it prior to showing the scene
     */
    public void setUpScene()
    {
        // Set quotes list
        setQuotes();
        // Set tool tips
        setUpToolTips();
        // Set up help text area
        setUpHelpTextArea();
        // Hide buttons that are hidden
        confirmButton.setVisible(false);
        wholeProfileVBox.setVisible(false);
        //Set quotes
        setQuote();
        // Hide the help text field when focus is lost
        helpTextArea.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                helpTextArea.setVisible(false);
            }
        });
    }


    /**
     * Set up method for the help text area
     */
    private void setUpHelpTextArea()
    {
        helpTextArea.setText("Welcome to Profile View Screen!\n\n" +
                             "On this screen you can edit your profile details, view brief statistics, and view activities in a calender format.\n" +
                             "- To edit your profile:\n" +
                             "\t- Click on the Edit button\n" +
                             "\t- Click on the data field you wish to edit\n" +
                             "\t- Enter the new value\n" +
                             "\t- Click the Confirm Changes Button\n" +
                             "\tIf any invalid data is entered you will get a pop up\n" +
                             "\tand will need to try again.\n" +
                             "- Your brief statistics are displayed in the two information\n" +
                             "  boxes on the bottom of the screen.\n" +
                             "- To view activities in the calender:\n" +
                             "\t- Navigate to the month and year of your desired\n" +
                             "\t  activity using the controls at the top of the\n" +
                             "\t  calender.\n" +
                             "\t- Dates with activities in them will have an A in them.\n" +
                             "\t- Click on the date of your activity.\n" +
                             "\t- Your statistics for that day will now be displayed in\n" +
                             "\t  the information box below the calender.\n\n" +
                             "Hover the mouse over any field to see what it contains.");
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
        quotesLabel.setText(quotes.get((int)(Math.random()*(quotes.size()))));
    }


    /**
     * Method to correctly display all user related details for the view profile scene.
     */
    public void setUserDetails()
    {
        DecimalFormat df2 = new DecimalFormat("#.##");
        setUpScene();
        wholeProfileVBox.setVisible(true);
        app.getCurrentProfile();
        welcomeProfileLabel.setText("Welcome " + String.valueOf(app.getCurrentProfile().getName()) + ", Let's do it!");
        usernameTA.setText(app.getCurrentProfile().getName());
        genderTA.setText(app.getCurrentProfile().getGender());
        dobTA.setText(app.getCurrentProfile().getBirthDate().getDateAsString());
        weightValueTA.setText(df2.format((app.getCurrentProfile().getWeight())));
        heightValueTA.setText(df2.format((app.getCurrentProfile().getHeight())));
        bmiValueTA.setText(df2.format((app.getCurrentProfile().calcBmi())) + " - " + app.getCurrentProfile().getBmiCategory());
        calendarPane.getChildren().add(new CalenderPaneController(YearMonth.now(), app, this).getView());

        // Sets up the calendar and other stats if the user has already uploaded the data to the app else all values are 0 initially.
        if (app.getCurrentProfile().getActivities().size() > 0) {

            distanceText.setText("Total Distance Covered: " + df2.format((app.getCurrentProfile().getActivitiesDistance(new DateTime(1900, 1,1,0,0,0), new DateTime(2019, 1,1,0,0,0)))/1000) + " km");
            velocityText.setText("Average Speed: " + df2.format(app.getCurrentProfile().getActivitiesSpeed(new DateTime(1900, 1,1,0,0,0), new DateTime(2019, 1,1,0,0,0))) + " km/h");
            heartRateText.setText("Average Heart Rate: " + String.valueOf(app.getCurrentProfile().getActivitiesHeartRate(new DateTime(1900, 1,1,0,0,0), new DateTime(2019, 1,1,0,0,0))) + " bpm");
            recentActivitiesLabel.setVisible(true);
            distanceHBox.setVisible(true);
            velocityHBox.setVisible(true);
            heartRateHBox.setVisible(true);
        } else {
            distanceText.setText("Total Distance Covered: 0.00 km");
            velocityText.setText("Average Speed: 0.00 km/h");
            heartRateText.setText("Average Heart Rate: No Data");
        }
    }


    /**
     * Method called when the logout button is clicked
     * Returns to the Login Screen
     */
    @FXML private void logout()
    {
        app.launchLoginScene();
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
        try {
            String nameString = usernameTA.getText();
            app.checkUniqueName(nameString);
            try {
                app.getUsers().get(app.getUsers().indexOf(app.getCurrentProfile())).setName(nameString);
            } catch (UserNameException | IllegalArgumentException exception) {
                app.createPopUp(Alert.AlertType.ERROR, "Invalid Username", "Please enter a valid username: It should be less than 50 characters and only contain alphanumeric characters." );
            }
        } catch (UniqueNameException | IllegalArgumentException exception) {
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Username", "Please enter a valid username: This username already exists." );
        }
        // Set weight and handle exceptions
        try {
            app.getUsers().get(app.getUsers().indexOf(app.getCurrentProfile())).setWeight(Double.valueOf(weightValueTA.getText()));
        }  catch (InvalidWeightException | IllegalArgumentException exception) {
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Weight", "Please enter a valid weight: It should be greater than 30 kg and less than 500 kg." );
        }

        // Set height and handle Exceptions
        try {
            app.getUsers().get(app.getUsers().indexOf(app.getCurrentProfile())).setHeight(Double.valueOf(heightValueTA.getText()));
        } catch (InvalidHeightException | IllegalArgumentException exception) {
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Height", "Please enter a valid height: It should be greater than 50 cm and less than 250 cm." );
        }

        // Set Date of Birth and handle exceptions
        try {
            String dob = dobTA.getText();
            int yearInt = Integer.valueOf(dob.substring(6));
            int monthInt = Integer.valueOf(dob.substring(3,5));
            int dayInt = Integer.valueOf(dob.substring(0,2));
            DateTime dateOfBirth = new DateTime(yearInt, monthInt, dayInt, 0, 0, 0);
            app.getUsers().get(app.getUsers().indexOf(app.getCurrentProfile())).setBirthDate(dateOfBirth);
        } catch (NullPointerException | IllegalArgumentException exception) {
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Date of Birth", "Please enter a valid date: It should be in DD/MM/YYYY format." );
        }

        // Set gender and handle Exceptions
        List<String> genderList = Arrays.asList("Male", "Female", "Other");
        if (genderList.contains(genderTA.getText())) {
            app.getUsers().get(app.getUsers().indexOf(app.getCurrentProfile())).setGender(genderTA.getText());
        }
        else {
            app.createPopUp(Alert.AlertType.ERROR, "Invalid Gender", "Please enter a valid gender: It should be either \"Male\", \"Female\" or \"Other\"." );

        }
        confirmButton.setVisible(false);
        editProfileButton.setVisible(true);
        setUserDetails();
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
     * Method called when close button is selected.
     * Exits the application.
     */
    @FXML private void close()
    {
        Platform.exit();
    }


    /**
     * Method called when the minimise button is selected.
     * Minimises the application to the task bar.
     */
    @FXML private void minimise()
    {
        app.minimise();
    }


    /**
     * Method to launch the login scene.
     */
    @FXML public void openChooseProfile()
    {
        moveDrawer();
        app.launchLoginScene();
    }


    /**
     * Method to launch the view profile scene.
     */
    @FXML public void openViewProfile()
    {
        moveDrawer();
        app.launchProfileScene();
    }


    /**
     * Method to launch the upload data scene.
     */
    @FXML public void openUploadData()
    {
        moveDrawer();
        app.launchUploadDataScene();
    }


    /**
     * Method to launch the view activities scene.
     */
    @FXML public void openViewActivities()
    {
        moveDrawer();
        app.launchActivityViewerScene();
    }


    /**
     * Method to launch the goals scene.
     */
    @FXML public void openGoals()
    {
        moveDrawer();
        app.launchGoalsScene();
    }


    /**
     * Method to launch the data analysis scene.
     */
    @FXML public void openAnalysis()
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
