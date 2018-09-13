package seng202.team10.GUI;

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

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;


public class FullCalendarView {


    private ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(42);
    private VBox view;
    private Label calendarTitle;
    private YearMonth currentYearMonth;

    /**
     * Create a calendar view
     * @param yearMonth year month to create the calendar of
     */
    public FullCalendarView(YearMonth yearMonth) {
        currentYearMonth = yearMonth;
        // Create the calendar grid pane
        GridPane calendar = new GridPane();
        calendar.setStyle("-fx-background-color: #F06292");
        calendar.setPrefSize(280, 240);
        calendar.setMaxSize(280, 240);
        calendar.setMinSize(280, 240);
        calendar.setGridLinesVisible(true);
        // Create rows and columns with anchor panes for the calendar
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                AnchorPaneNode ap = new AnchorPaneNode();
                ap.setPrefSize(40, 40);
                ap.setMaxSize(40, 40);
                ap.setMinSize(40, 40);
                calendar.add(ap,j,i);
                allCalendarDays.add(ap);
            }
        }
        // Days of the week labels
        Text[] dayNames = new Text[]{ new Text(" Sun"), new Text(" Mon"), new Text(" Tue"),
                                        new Text(" Wed"), new Text(" Thu"), new Text(" Fri"),
                                        new Text(" Sat") };
        GridPane dayLabels = new GridPane();
        dayLabels.setStyle("-fx-background-color: #F06292");
        dayLabels.setPrefWidth(280);
        dayLabels.setMaxWidth(280);
        dayLabels.setMinWidth(280);
        dayLabels.setGridLinesVisible(true);
        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(40, 20);
            ap.setMaxSize(40, 20);
            ap.setMinSize(40, 20);
            txt.setTextAlignment(TextAlignment.CENTER);
            ap.setTopAnchor(txt, 0.0);
            ap.setLeftAnchor(txt, 0.0);
            ap.getChildren().add(txt);
            dayLabels.add(ap, col++, 0);
        }
        // Create calendarTitle and buttons to change current month
        calendarTitle = new Label();
        calendarTitle.setStyle("-fx-background-color: #C2185B");
        calendarTitle.setTextFill(Color.WHITE);
        calendarTitle.setPadding(new Insets(5, 5, 5, 5));
        calendarTitle.setMinSize(210, 30);
        calendarTitle.setMaxSize(210, 30);
        calendarTitle.setPrefSize(210, 30);
        calendarTitle.setTextAlignment(TextAlignment.CENTER);
        Button previousMonth = new Button("<<");
        previousMonth.setTextFill(Color.WHITE);
        previousMonth.setStyle("-fx-background-color: #C2185B");
        previousMonth.setPadding(new Insets(5, 5, 5, 5));
        previousMonth.setMinSize(35, 30);
        previousMonth.setMaxSize(35, 30);
        previousMonth.setPrefSize(35, 30);
        previousMonth.setOnAction(e -> previousMonth());
        Button nextMonth = new Button(">>");
        nextMonth.setStyle("-fx-background-color: #C2185B");
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
            ap.setTopAnchor(txt, 10.0);
            ap.setLeftAnchor(txt, 10.0);

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

    public VBox getView() {
        return view;
    }

    public ArrayList<AnchorPaneNode> getAllCalendarDays() {
        return allCalendarDays;
    }

    public void setAllCalendarDays(ArrayList<AnchorPaneNode> allCalendarDays) {
        this.allCalendarDays = allCalendarDays;
    }
}
