package seng202.team10.Control;

import seng202.team10.Model.ActivitiesData.DateTime;

import java.time.LocalDateTime;

public class inputValidator {

    public boolean validGoalName(String name) {
        if (name.length() <= 10 && name.length() >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validGoalStartDate(DateTime startDate) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0,0,0);
        if (startDate.isBefore(today) || (startDate.getYear() > (today.getYear() + 1))) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validGoalTargetDate(DateTime targetDate) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0,0,0);
        if (targetDate.isBefore(today) || (targetDate.getYear() > (today.getYear() + 5))) {
            return false;
        } else {
            return true;
        }
    }
}
