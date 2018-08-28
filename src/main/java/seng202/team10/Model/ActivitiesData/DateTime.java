package seng202.team10.Model.ActivitiesData;


import java.util.HashMap;

/**
 * Date Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class DateTime {

    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private int second;
    private HashMap<Integer, Integer> daysInMonth;
    private HashMap<Integer, String> months;


    /**
     * Constructor method for Date Class
     * @param day int: day of the month
     * @param month int: month of the year
     * @param year: year between 2000 and 2100
     */
    DateTime(int day, int month, int year, int hour, int minute, int second) {
        setYear(year);
        setMonth(month);
        setDay(day);
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        fillMonths();
        fillDaysInMonth();
    }


    /**
     * Setter method for year
     * @param newYear int: year parameter for the date
     */
    private void setYear(int newYear) {
        if ((day <= 2100) && (day >= 2000)) {
            this.year = newYear;
        } else {
            throw new IllegalArgumentException("Year parameter not valid!");
        }
    }


    /**
     * Setter method for month
     * @param newMonth int: month parameter for the date
     */
    private void setMonth(int newMonth) {
        if ((day <= 12) && (day >= 1)) {
            this.month = newMonth;
        } else {
            throw new IllegalArgumentException("Month parameter not valid!");
        }
    }


    /**
     * Setter method for day
     * @param newDay int: day parameter for the date
     */
    private void setDay(int newDay) {
        if ((this.month == 2) && ((this.year % 4) == 0)) {
            if ((newDay <= 29) && (newDay >= 1)) {
                this.day = newDay;
            }
        } else if ((newDay <= this.daysInMonth.get(this.month)) && (newDay >= 1)) {
            this.day = newDay;
        } else {
            throw new IllegalArgumentException("Day parameter not valid!");
        }
    }


    /**
     * Setter method for hour
     * @param newHour int: hour in 24 hour format
     */
    private void setHour(int newHour) {
        if ((0 <= newHour) && newHour <= 23) {
            this.hour = newHour;
        } else {
            throw new IllegalArgumentException("Hour parameter not valid!");
        }
    }


    /**
     * Setter method for minute
     * @param newMinute int: minutes
     */
    private void setMinute(int newMinute) {
        if ((0 <= newMinute) && (newMinute <= 59)) {
            this.minute = newMinute;
        } else {
            throw new IllegalArgumentException("Minute parameter not valid!");
        }
    }


    /**
     * Setter method for second
     * @param newSecond int: seconds
     */
    private void setSecond(int newSecond) {
        if ((0 <= newSecond) && (newSecond <= 59)) {
            this.second = newSecond;
        } else {
            throw new IllegalArgumentException("Second parameter not valid!");
        }
    }


    /**
     * Getter method for year
     * @return int: Year
     */
    public int getYear() {
        return this.year;
    }


    /**
     * Getter method for month
     * @return int: Month
     */
    public int getMonth() {
        return this.month;
    }


    /**
     * Getter method for day
     * @return int: Day
     */
    public int getDay() {
        return this.day;
    }


    /**
     * Getter method for hour
     * @return int: Hour
     */
    public int getHour() {
        return this.hour;
    }


    /**
     * Getter method for minute
     * @return int: Minute
     */
    public int getMinute() {
        return this.minute;
    }


    /**
     * Getter method for second
     * @return int: Second
     */
    public int getSecond() {
        return this.second;
    }


    /**
     * Method to compare two DateTime objects, returns true if the called DateTime is before the parameter
     * @param otherDateTime DateTime: DateTime to be compared
     * @return boolean
     */
    public boolean isBefore(DateTime otherDateTime) {
        if (this.year < otherDateTime.getYear()) {
            return true;
        } else if (this.year == otherDateTime.getYear() && (this.month < otherDateTime.getMonth())) {
            return true;
        } else if ((this.month == otherDateTime.getMonth()) && (this.day < otherDateTime.getDay())) {
            return true;
        } else if ((this.day == otherDateTime.getDay()) && (this.hour < otherDateTime.getHour())) {
            return true;
        } else if ((this.hour == otherDateTime.getHour()) && (this.minute < otherDateTime.getMinute())) {
            return true;
        } else return (this.minute == otherDateTime.getMinute()) && (this.second < getSecond());
    }


    /**
     * Method to compare two DateTime objects, returns true if the called DateTime is after the parameter
     * @param otherDateTime DateTime: DateTime to be compared
     * @return boolean
     */
    public boolean isAfter(DateTime otherDateTime) {
        if (this.year > otherDateTime.getYear()) {
            return true;
        } else if (this.year == otherDateTime.getYear() && (this.month > otherDateTime.getMonth())) {
            return true;
        } else if ((this.month == otherDateTime.getMonth()) && (this.day > otherDateTime.getDay())) {
            return true;
        } else if ((this.day == otherDateTime.getDay()) && (this.hour > otherDateTime.getHour())) {
            return true;
        } else if ((this.hour == otherDateTime.getHour()) && (this.minute > otherDateTime.getMinute())) {
            return true;
        } else return (this.minute == otherDateTime.getMinute()) && (this.second > getSecond());
    }


    /**
     * Method to fill the HashMap with month names
     */
    private void fillMonths() {
        months = new HashMap<Integer, String>() {{
            put(1, "January");
            put(2, "February");
            put(3, "March");
            put(4, "April");
            put(5, "May");
            put(6, "June");
            put(7, "July");
            put(8, "August");
            put(9, "September");
            put(10, "October");
            put(11, "November");
            put(12, "December");
        }};
    }


    /**
     * Method to fill in the HashMap daysInMonth with the amount of days in each month (excluding leap years)
     */
    private void fillDaysInMonth() {
        daysInMonth = new HashMap<Integer, Integer>() {{
            put(1, 31);
            put(2, 28);
            put(3, 31);
            put(4, 30);
            put(5, 31);
            put(6, 30);
            put(7, 31);
            put(8, 31);
            put(9, 30);
            put(10, 31);
            put(11, 30);
            put(12, 31);
        }};
    }


    @Override
    public String toString() {
        String dayPostfix = "th";
        if (this.day != 11 && ((this.day % 10) == 1)) {
            dayPostfix = "st";
        } else if (this.day != 12 && ((this.day % 10) == 2)) {
            dayPostfix = "nd";
        } else if (this.day != 13 && ((this.day % 10) == 3)) {
            dayPostfix = "rd";
        }
        return String.valueOf(this.day) + dayPostfix + ", " + this.months.get(this.month) +
                ", " + String.valueOf(this.year) + " - " + String.valueOf(this.hour) + ":" +
                String.valueOf(this.minute) + ":" + String.valueOf(this.second);
    }
}