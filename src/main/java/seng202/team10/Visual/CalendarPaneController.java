package seng202.team10.Visual;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import seng202.team10.Control.MainController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Goals.Goal;
import seng202.team10.Model.UserProfile;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;

/**
 * Controller for the Calendar pane in the profile screen, which shows dates of activities and goals.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class CalendarPaneController {

    private ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(42);
    private VBox view;
    private YearMonth currentYearMonth;
    private MainController mainController ;
    private ProfileController profileController;
    private ObservableList<String> months;
    private ObservableList<String> years;
    private ComboBox monthsComboBox = new ComboBox();
    private ComboBox yearsComboBox = new ComboBox();
    private UserProfile currentUser;


    /**
     * Setter method to pass the MainController into this controller.
     * @param mainController <b>MainController:</b> The main controller.
     */
    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }


    /**
     * Setter method to set the profile controller for this Scene
     * @param profileController profileController
     */
    private void setProfileController(ProfileController profileController)
    {
        this.profileController = profileController;
    }

    /**
     * Method to create the months list for the months combo box
     */
    private void createMonthsList()
    {
        months = FXCollections.observableArrayList();
        for (int i = 1; i < 13; i++) {
            LocalDate date = LocalDate.of(2000, i, 1);
            months.add(date.getMonth().toString());
        }
    }

    /**
     * Method to create the years list for the years combo box
     */
    private void createYearsList()
    {
        years = FXCollections.observableArrayList();
        for (int i = 1900; i <= 2100; i++) {
            years.add(String.valueOf(i));
        }
    }

    /**
     * Method to create a calendar view
     * @param yearMonth year month to create the calendar of
     * @param mainController  The MainController that controls the controllers.
     * @param profileController  The profile controller that controls the profile screen
     *
     */
    CalendarPaneController(YearMonth yearMonth, MainController mainController , ProfileController profileController)
    {
        setMainController(mainController);
        setProfileController(profileController);
        currentUser = mainController.getTitleBar().getCurrentProfile();
        currentYearMonth = yearMonth;

        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setStyle("-fx-background-color: #4DD0E1");
        calendar.setPrefSize(490, 420);
        calendar.setMaxSize(490, 420);
        calendar.setMinSize(490, 420);
        calendar.setGridLinesVisible(true);

        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                AnchorPaneNode ap = new AnchorPaneNode();
                ap.setPrefSize(70, 70);
                ap.setMaxSize(70, 70);
                ap.setMinSize(70, 70);
                calendar.add(ap,j,i);
                allCalendarDays.add(ap);
            }
        }

        // Days of the week labels
        Text[] dayNames = new Text[]{ new Text(" Sun"), new Text(" Mon"), new Text(" Tue"),
                                        new Text(" Wed"), new Text(" Thu"), new Text(" Fri"),
                                        new Text(" Sat") };
        GridPane dayLabels = new GridPane();
        dayLabels.setStyle("-fx-background-color: #4DD0E1");
        dayLabels.setPrefWidth(490);
        dayLabels.setMaxWidth(490);
        dayLabels.setMinWidth(490);
        dayLabels.setGridLinesVisible(true);
        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(70, 20);
            ap.setMaxSize(70, 20);
            ap.setMinSize(70, 20);
            txt.setTextAlignment(TextAlignment.CENTER);
            ap.setTopAnchor(txt, 0.0);
            ap.setLeftAnchor(txt, 0.0);
            ap.getChildren().add(txt);
            dayLabels.add(ap, col++, 0);
        }

        //Populate month and year combo boxes
        createMonthsList();
        createYearsList();
        monthsComboBox.setItems(months);
        yearsComboBox.setItems(years);

        monthsComboBox.setStyle("-fx-border-color: #4DD0E1; " +
                                "-fx-background-color: #0097A7; " +
                                "-fx-background-radius: 1em 0 0 0; " +
                                "-fx-border-radius: 1em 0 0 0;");
        monthsComboBox.setVisibleRowCount(12);
        monthsComboBox.setMinSize(120, 30);
        monthsComboBox.setMaxSize(120, 30);
        monthsComboBox.setPrefSize(120, 30);
        monthsComboBox.setValue(currentYearMonth.getMonth());

        yearsComboBox.setStyle("-fx-border-color: #4DD0E1; " +
                               "-fx-background-color: #0097A7; " +
                               "-fx-background-radius: 0 1em 0 0; " +
                               "-fx-border-radius: 0 1em 0 0;");
        yearsComboBox.setVisibleRowCount(12);
        yearsComboBox.setMinSize(80, 30);
        yearsComboBox.setMaxSize(80, 30);
        yearsComboBox.setPrefSize(80, 30);
        yearsComboBox.setValue(currentYearMonth.getYear());
        yearsComboBox.setId("yearsComboBox");

        monthsComboBox.setOnAction(e -> changeMonthYear());
        yearsComboBox.setOnAction(e -> changeMonthYear());

        HBox comboBar = new HBox(monthsComboBox, yearsComboBox);
        comboBar.setAlignment(Pos.CENTER);
        // Populate calendar with the appropriate day numbers
        populateCalendar(yearMonth);
        // Create the calendar view
        view = new VBox(comboBar, dayLabels, calendar);
    }


    /**
     * Set the days of the calendar to correspond to the appropriate date
     * @param yearMonth year and month of month to render
     */
    private void populateCalendar(YearMonth yearMonth) {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        for (AnchorPaneNode ap : allCalendarDays) {
            if (ap.getChildren().size() != 0) {
                ap.getChildren().remove(0);
            }
            String style = null;
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
            txt.setFill(Color.WHITE);
            txt.setTextAlignment(TextAlignment.CENTER);
            ap.setDate(calendarDate);
            ap.setCurrentUser (currentUser);
            ap.setProfileController(profileController);
            ap.setTopAnchor(txt, 10.0);
            ap.setLeftAnchor(txt, 10.0);
            ap.setOnMouseClicked(e -> ap.onMouseClicked());

            if  (currentUser.getActivities() != null) {
                ArrayList<Activity> userActivities = currentUser.getActivities();
                ArrayList<Activity> todayActivities = new ArrayList<>();
                int count = 0;
                for (Activity activity: userActivities) {
                    LocalDate date = ap.getDate();
                    if (activity.getStartDateTime().getDateAsString().equals((new DateTime(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), 0, 0, 0)).getDateAsString())) {
                        todayActivities.add(activity);
                        count++;
                    }
                }
                if (count != 0) {
                    txt.setText(txt.getText() + String.format("\n %d A", count));
                    style = "-fx-background-color: #66a3ff;";
                }
                ap.setActivities(todayActivities);
            }

            if  (currentUser.getGoals().getCreatedGoals() != null) {
                ArrayList<Goal> userGoals = currentUser.getGoals().getCreatedGoals();
                ArrayList<Goal> todayGoals = new ArrayList<>();
                int countGoals = 0;
                for (Goal goal: userGoals) {
                    LocalDate date = ap.getDate();
                    if (goal.getGoalTargetDate().getDateAsString().equals((new DateTime(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), 0, 0, 0)).getDateAsString())) {
                        todayGoals.add(goal);
                        countGoals++;
                    }
                }
                if (countGoals != 0) {
                    txt.setText(txt.getText() + String.format("\n %d G", countGoals));
                    if (style != null) {
                        style = "-fx-background-color: linear-gradient(#66a3ff 0%, #71da71 100%);";
                    } else style = "-fx-background-color: #71da71;";
                }
                ap.setTodayGoals(todayGoals);
            }

            if (calendarDate.getMonth() == yearMonth.getMonth()) {
                txt.setFill(Color.BLACK);
                ap.getChildren().add(txt);
                ap.setStyle(style);
            } else {
                ap.getChildren().add(txt);
            }
            calendarDate = calendarDate.plusDays(1);
        }

        // Change the title of the calendar
        //calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));
    }


    /**
     * Method to move the month back by one. Repopulate the calendar with the correct dates.
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        populateCalendar(currentYearMonth);
    }


    /**
     * Method to move the month forward by one. Repopulate the calendar with the correct dates.
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        populateCalendar(currentYearMonth);
    }


    /**
     * Method to change the month and year. Repopulate the calendar with the correct dates.
     */
    private void changeMonthYear() {
        int month = (Month.valueOf(monthsComboBox.getValue().toString())).getValue();
        int year = Integer.valueOf(yearsComboBox.getValue().toString());
        currentYearMonth = YearMonth.of(year, month);
        populateCalendar(currentYearMonth);
    }

    /**
     * Method to return the view of the VBox.
     * @return  The view of the vBox
     */
    public VBox getView()
    {
        return view;
    }

}
