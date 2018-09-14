package seng202.team10.GUI;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.UserProfile;

import java.text.DecimalFormat;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

public class ProfileController {

    private GUIController app;

    @FXML Pane calendarPane;
    @FXML private javafx.scene.control.Label welcomeProfileLabel;
    @FXML private javafx.scene.control.Label quotesLabel;
    @FXML private javafx.scene.control.Label weightValueLabel;
    @FXML private javafx.scene.control.Label heightValueLabel;
    @FXML private javafx.scene.control.Label bmiValueLabel;
    @FXML private Label recentActivitiesLabel;
    @FXML private HBox activity1HBox;
    @FXML private HBox activity2HBox;
    @FXML private HBox activity3HBox;
    @FXML private Text activity1Text;
    @FXML private Text activity2Text;
    @FXML private Text activity3Text;
    @FXML private HBox distanceHBox;
    @FXML private HBox velocityHBox;
    @FXML private HBox heartRateHBox;
    @FXML private Text distanceText;
    @FXML private Text velocityText;
    @FXML private Text heartRateText;
    @FXML private VBox drawer;
    @FXML private ComboBox userNameComboBox;
    private List<String> quotes = Arrays.asList(
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


    public void setApp(GUIController app){
        this.app = app;
    }

    public void setUpScene() {
        calendarPane.getChildren().add(new FullCalendarView(YearMonth.now()).getView());
        recentActivitiesLabel.setVisible(false);
        activity1HBox.setVisible(false);
        activity2HBox.setVisible(false);
        activity3HBox.setVisible(false);
        distanceHBox.setVisible(false);
        velocityHBox.setVisible(false);
        heartRateHBox.setVisible(false);
        quotesLabel.setText(quotes.get((int)(Math.random()*(quotes.size()))));
        ObservableList<String> usersList = FXCollections.observableArrayList();
        for (UserProfile user: app.getUsers()) {
            usersList.add(user.getName());
        }
        userNameComboBox.setItems(usersList);
    }


    public void setUserDetails() {
        DecimalFormat df2 = new DecimalFormat(".##");
        setUpScene();
        UserProfile currentUser = app.getCurrentProfile();
        userNameComboBox.setPromptText((currentUser.getName()).toString());
        welcomeProfileLabel.setText("Welcome " + String.valueOf(currentUser.getName()) + ", Let's do it!");
        weightValueLabel.setText(df2.format((currentUser.getWeight())));
        heightValueLabel.setText(df2.format((currentUser.getHeight())));
        bmiValueLabel.setText(df2.format((currentUser.calcBmi())) + " - " + currentUser.getBmiCategory());

        if (currentUser.getActivities().size() > 0) {
            activity1Text.setText(currentUser.getActivities().get(0).getName());
            distanceText.setText("Total Distance Covered: " + df2.format(currentUser.getActivities().get(0).getTotalDistance()/1000) + " km");
            velocityText.setText("Average Velocity: " + df2.format(currentUser.getActivities().get(0).getAverageVelocity()) + " m/s");
            heartRateText.setText("Average Heart Rate: " + String.valueOf((int)(currentUser.getActivities().get(0).getAverageHeartRate())) + " bpm");
            recentActivitiesLabel.setVisible(true);
            activity1HBox.setVisible(true);
            distanceHBox.setVisible(true);
            velocityHBox.setVisible(true);
            heartRateHBox.setVisible(true);

            if (currentUser.getActivities().size() > 1) {
                activity2HBox.setVisible(true);
                activity2Text.setText(currentUser.getActivities().get(1).getName());
                if (currentUser.getActivities().size() > 2) {
                    activity3HBox.setVisible(true);
                    activity3Text.setText(currentUser.getActivities().get(2).getName());
                }
            }
        }
    }

    @FXML private void drawerAction() {

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
