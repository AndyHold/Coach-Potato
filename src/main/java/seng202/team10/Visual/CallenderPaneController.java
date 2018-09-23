package seng202.team10.Visual;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import seng202.team10.Control.GUIController;
import seng202.team10.Model.ActivitiesData.Activity;
import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

/**
 * CallenderPaneController Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class CallenderPaneController {

    private ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(42);
    private VBox view;
    private Label calendarTitle;
    private YearMonth currentYearMonth;
    private GUIController app;
    private ProfileController profileController;


    /**
     * Setter method to set the GUI controller for this Scene
     * @param app GUIController
     */
    public void setApp(GUIController app)
    {
        this.app = app;
    }


    /**
     * Setter method to set the profile controller for this Scene
     * @param profileController profileController
     */
    public void setProfileController(ProfileController profileController)
    {
        this.profileController = profileController;
    }


    /**
     * Method to create a calendar view
     * @param (yearMonth, app, profileController): (year month to create the calendar of, GuiController, ProfileController)
     */
    public CallenderPaneController(YearMonth yearMonth, GUIController app, ProfileController profileController)
    {
        setApp(app);
        setProfileController(profileController);
        currentYearMonth = yearMonth;

        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setStyle("-fx-background-color: #f48fb1");
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
        dayLabels.setStyle("-fx-background-color: #f48fb1");
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

        // Create calendarTitle and buttons to change current month
        calendarTitle = new Label();
        calendarTitle.setStyle("-fx-background-color: #f48fb1");
        calendarTitle.setTextFill(Color.WHITE);
        calendarTitle.setPadding(new Insets(5, 5, 5, 5));
        calendarTitle.setMinSize(210, 30);
        calendarTitle.setMaxSize(210, 30);
        calendarTitle.setPrefSize(210, 30);
        calendarTitle.setTextAlignment(TextAlignment.CENTER);

        Button previousMonth = new Button("<<");
        previousMonth.setTextFill(Color.WHITE);
        previousMonth.setStyle("-fx-background-color: #f48fb1");
        previousMonth.setPadding(new Insets(5, 5, 5, 5));
        previousMonth.setMinSize(35, 30);
        previousMonth.setMaxSize(35, 30);
        previousMonth.setPrefSize(35, 30);
        previousMonth.setOnAction(e -> previousMonth());

        Button nextMonth = new Button(">>");
        nextMonth.setStyle("-fx-background-color: #f48fb1");
        nextMonth.setTextFill(Color.WHITE);
        nextMonth.setPadding(new Insets(5, 5, 5, 5));
        nextMonth.setMinSize(35, 30);
        nextMonth.setMaxSize(35, 30);
        nextMonth.setPrefSize(35, 30);
        nextMonth.setOnAction(e -> nextMonth());
        HBox titleBar = new HBox(previousMonth, calendarTitle, nextMonth);
        titleBar.setAlignment(Pos.CENTER);

        // Populate calendar with the appropriate day numbers
        populateCalendar(yearMonth);
        // Create the calendar view
        view = new VBox(titleBar, dayLabels, calendar);
    }


    /**
     * Set the days of the calendar to correspond to the appropriate date
     * @param yearMonth year and month of month to render
     */
    public void populateCalendar(YearMonth yearMonth) {
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
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
            txt.setFill(Color.BLACK);
            txt.setTextAlignment(TextAlignment.CENTER);
            ap.setDate(calendarDate);
            ap.setCurrentUser(app.getCurrentProfile());
            ap.setProfileController(profileController);
            ap.setTopAnchor(txt, 10.0);
            ap.setLeftAnchor(txt, 10.0);
            ap.setOnMouseClicked(e -> ap.onMouseClicked());

            if (app.getCurrentProfile().getActivities() != null) {
                ArrayList<Activity> userActivities = app.getCurrentProfile().getActivities();
                ArrayList<Activity> todayActivities = new ArrayList<>();
                for (Activity activity: userActivities) {
                    LocalDate date = ap.getDate();
                    if (activity.getStartDateTime().getDateAsString().equals((new DateTime(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), 0, 0, 0)).getDateAsString())) {
                        todayActivities.add(activity);
                        txt.setText(txt.getText() + "\n Activity");

                    }
                }
                ap.setActivities(todayActivities);
            }

            if (calendarDate.getMonth() == yearMonth.getMonth()) {
                txt.setFill(Color.WHITE);
                ap.getChildren().add(txt);
            } else {
                ap.getChildren().add(txt);
            }
            calendarDate = calendarDate.plusDays(1);
        }

        // Change the title of the calendar
        calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));
    }


    /**
     * Move the month back by one. Repopulate the calendar with the correct dates.
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        populateCalendar(currentYearMonth);
    }


    /**
     * Move the month forward by one. Repopulate the calendar with the correct dates.
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
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


    public ArrayList<AnchorPaneNode> getAllCalendarDays()
    {
        return allCalendarDays;
    }

    public void setAllCalendarDays(ArrayList<AnchorPaneNode> allCalendarDays)
    {
        this.allCalendarDays = allCalendarDays;
    }
}
