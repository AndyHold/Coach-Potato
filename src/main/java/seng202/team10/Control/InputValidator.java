package seng202.team10.Control;

import seng202.team10.Model.ActivitiesData.DateTime;
import seng202.team10.Model.Goals.Goals;
import seng202.team10.Model.UserProfile;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class InputValidator {

    /**
     * checks if a goal name is valid (length and duplicate)
     * @param name the name being checked
     * @param goalInst the existing goals
     * @return true if valid, false if not
     */
    public boolean validGoalName(String name, Goals goalInst) {
        if (goalInst.getCreatedGoalNames().contains(name)) {
            return false;
        } else {
            return name.length() <= 10 && name.length() >= 2;
        }
    }

    /**
     * checks if the startdate is valid
     * @param startDate
     * @return true if valid, false if not
     */
    public boolean validGoalStartDate(DateTime startDate) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0,0,0);
        return !startDate.isBefore(today) && (startDate.getYear() <= (today.getYear() + 1));
    }

    /**
     * checks if the end date of a goal is valid
     * @param targetDate
     * @return true if valid, false if not
     */
    public boolean validGoalTargetDate(DateTime targetDate) {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        DateTime today = new DateTime(year, month, day, 0,0,0);
        return !targetDate.isBefore(today) && (targetDate.getYear() <= (today.getYear() + 5));
    }

    /**
     * makes sure the start date isn't after the enddate
     * @param start
     * @param target
     * @return true if valid, false if not
     */
    public boolean checkStartVsTargetDates(DateTime start, DateTime target) {
        return (start.isBefore(target));
    }

    /**
     * checks if an int value is between two set bounds
     * @param value
     * @param lowerBound
     * @param upperBound
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
     * @param value
     * @param lowerBound
     * @param upperBound
     * @return true if valid, false if not
     */
    public boolean floatValueInRange(String value, float lowerBound, float upperBound) {
        try {
            return Float.valueOf(value) >= lowerBound && Float.valueOf(value) <= upperBound;
        } catch (NumberFormatException e) {
            return false;
        }
    }

//    /**
//     * Returns true if the argument can be parsed to a float, false otherwise
//     *
//     * @param floatString  The string being checked to be a float.
//     * @return  True if the string can be parsed to a float.
//     */
//    public boolean isValidFloat(String floatString) {
//        float parsedFloat;
//        try {
//            parsedFloat = Float.parseFloat(floatString);
//        } catch (NumberFormatException e){
//            return false;
//        }
//        return true;
//    }

    /**
     * checks if the name of an activity is valid
     * @param activityName
     * @return true if valid, false if not
     */
    public boolean isValidActivityName(String activityName) {
        return ((activityName.length() <= 50) && (activityName.matches("[a-zA-Z0-9]+[a-zA-Z0-9 ]*")));
    }

    /**
     * checks if a date string is valid
     * @param date
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
     * @param time
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
     * @param header
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
     * @param entryLine
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

    /**
     * checks if the target type of a goal is valid
     * @param type
     * @param target
     * @param user
     * @return true if valid, false if not
     */
    public boolean isValidTargetValue (String type, double target, UserProfile user) {
        if (type.equals("Weight")) {
            if (user.getWeight() <= target || target <= 30) {
                return false;
            }
        } else if (type.equals("Distance")) {
            if (target < 100) {
                return  false;
            }
        } else if (type.equals("BMI")) {
            if (user.calcBmi() <= target || target <= 10) {
                return false;
            }
        } else { //goal must be of type Time
            if (target <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * checks if an integer is a valid target value (0-10,000)
     * @param target
     * @return true if valid, false if not
     */
    public boolean isValidIntTargetValue (int target) {
        return (target >= 0 || target < 10000);
    }
}
