package seng202.team10.Control;

import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Goals.Goals;
import seng202.team10.Model.UserProfile;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Input Validator Class for Coach Potato SENG202 2018S2
 */
public class InputValidator {


    /**
     * checks if an int value is between two set bounds
     * @param value  The value being checked
     * @param lowerBound  What the value must be above.
     * @param upperBound  What the value must be below
     * @return true if valid, false if not
     */
    public boolean intValueInRange(String value, int lowerBound, int upperBound) {
        try {
            return Integer.valueOf(value) >= lowerBound && Integer.valueOf(value) <= upperBound;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * checks if a float value is between two set bounds
     * @param value  The value being checked
     * @param lowerBound  What the value must be above.
     * @param upperBound  What the value must be below
     * @return true if valid, false if not
     */
    public boolean floatValueInRange(String value, float lowerBound, float upperBound) {
        try {
            return Float.valueOf(value) >= lowerBound && Float.valueOf(value) <= upperBound;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * checks if the name of an activity is valid
     * @param activityName The activity name being checked
     * @return true if valid, false if not
     */
    public boolean isValidActivityName(String activityName) {
        return ((activityName.length() <= 50) && (activityName.matches("[a-zA-Z0-9]+[a-zA-Z0-9 ]*")));
    }

    /**
     * checks if a date string is valid
     * @param date The date being checked
     * @return true if valid, false if not
     */
    public boolean isValidDateString(String date) {
        if (date.matches("[0-3][0-9]/[0-1][0-9]/[0-9]{4}")) {
            String[] dateArray = (date.split("/"));
            int day = Integer.valueOf(dateArray[0]);
            int month = Integer.valueOf(dateArray[1]);
            int year = Integer.valueOf(dateArray[2]);
            try {
                DateTime dateTime = new DateTime(year, month, day, 0, 0,0);
            } catch (IllegalArgumentException e){
                return false;
            }
            return true;
        } else {
            return  false;
        }
    }

    /**
     * checks if a time string is valid to be converted to datetime
     * @param time The time being checked
     * @return true if valid, false if not
     */
    public boolean isValidTimeString(String time) {
        if (time.matches("[0-2][0-9]:[0-6][0-9]:[0-6][0-9]")) {
            String[] dateArray = (time.split(":"));
            int hour = Integer.valueOf(dateArray[0]);
            int minute = Integer.valueOf(dateArray[1]);
            int second = Integer.valueOf(dateArray[2]);
            try {
                DateTime dateTime = new DateTime(2000, 1, 1, hour, minute, second);
            } catch (IllegalArgumentException e){
                return false;
            }
            return true;
        } else {
            return  false;
        }
    }

    /**
     * checks if the header line of an activity is of a valid format
     * @param header The header line being checked
     * @return true if valid, false if not
     */
    public boolean validActivityHeader(ArrayList<String> header) {
        if (header.size() >= 2) {
            if (header.get(0).equals("#start")) {
                return isValidActivityName(header.get(1));
            }
        }
        return false;
    }

    /**
     * checks if a line of input is a valid entry
     * @param entryLine The entry line being checked
     * @return true if valid, false if not
     */
    public boolean isValidEntryLine(ArrayList<String> entryLine) {
        if (entryLine.size() == 6) {
            for (String point : entryLine) {
                if (point.matches("[a-zA-Z]+")) {
                    return false;
                }
            }
            if (!this.isValidDateString(entryLine.get(0))) {
                return false;
            }
            if (!this.isValidTimeString(entryLine.get(1))) {
                return false;
            }
            if (!this.intValueInRange(entryLine.get(2), 25, 250)) {
                return false;
            }
            if (!this.floatValueInRange(entryLine.get(3), -90, 90)) {
                return false;
            }
            if (!this.floatValueInRange(entryLine.get(4), -180, 180)) {
                return false;
            }
            return this.floatValueInRange(entryLine.get(5), -500, 5000);
        }
        return false;
    }
}
