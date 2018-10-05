package seng202.team10.Model.ActivitiesData;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;


/**
 * Class that contains an instance in time.
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class DateTime implements Serializable {


    private int day = 1;
    private int month = 1;
    private int year = 1900;
    private int hour = 0;
    private int minute = 0;
    private int second = 0;
    private HashMap<Integer, Integer> daysInMonth;
    private HashMap<Integer, String> months;


    /**
     * Constructor method for Date Class
<<<<<<< HEAD
     * @param day int: day of the month
     * @param month int: month of the year
     * @param year: year between 2000 and 2100
=======
     * @param day An <b>int</b> of the day of the month.
     * @param month An <b>int</b> of the month of the year.
     * @param year An <b>int</b> of the year between 2000 and 2100.
     * @param hour An <b>int</b> of the hour between 0 and 23.
     * @param minute An <b>int</b> of the minute between 0 and 59.
     * @param second An <b>int</b> of the seconds between 0 and 59.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    public DateTime(int year, int month, int day, int hour, int minute, int second)
    {
        fillMonths();
        fillDaysInMonth();
        setYear(year);
        setMonth(month);
        setDay(day);
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }


    /**
     * Method to change the date once the DateTime has already been initiated.
     * @param year An <b>int</b> of the new year value.
     * @param month An <b>int</b> of the new month value.
     * @param day An <b>int</b> of the new month value.
     */
    public void changeDate(int year, int month, int day) throws IllegalArgumentException
    {
        int oldYear = this.year;
        int oldMonth = this.month;
        int oldDay = this.day;
        try {
            setYear(year);
            setMonth(month);
            setDay(day);
        } catch(IllegalArgumentException ex) {
            setYear(oldYear);
            setMonth(oldMonth);
            setDay(oldDay);
            throw new IllegalArgumentException("Invalid date, please select a correct date format DD/MM/YYYY in between 1900-2100");
        }
    }


    /**
     * Method to change the time once the DateTime has already been initiated.
     * @param hour An <b>int</b> of new hour value.
     * @param minute An <b>int</b> of new minute value.
     * @param second An <b>int</b> of new second value.
     * @throws IllegalArgumentException when the date entered is invalid.
     */
    public void changeTime(int hour, int minute, int second) throws IllegalArgumentException
    {
        int oldHour = this.hour;
        int oldMinute = this.minute;
        int oldSecond = this.second;
        try {
            setHour(hour);
            setMinute(minute);
            setSecond(second);
        } catch(IllegalArgumentException ex) {
            setHour(oldHour);
            setMinute(oldMinute);
            setSecond(oldSecond);
            throw new IllegalArgumentException("Invalid time, please select a correct time format HH:MM:SS");
        }
    }


    /**
     * Setter method for year.
     * @param newYear An <b>int</b> of the year parameter for the date.
     */
    private void setYear(int newYear)
    {
        if (1900 <= newYear && newYear <= 2100) {
            this.year = newYear;
        } else {
            throw new IllegalArgumentException("Year parameter not valid!\nvalue: " + String.valueOf(newYear) + " is not in range 1900 - 2100");
        }
    }


    /**
     * Setter method for month.
     * @param newMonth An <b>int</b> of the month parameter for the date.
     */
    private void setMonth(int newMonth)
    {
        if ((1 <= newMonth) && (newMonth <= 12)) {
            this.month = newMonth;
        } else {
            throw new IllegalArgumentException("Month parameter not valid!\nvalue: " + String.valueOf(newMonth) + " is not in range 1 - 12");
        }
    }


    /**
     * Setter method for day.
     * @param newDay An <b>int</b> of the day parameter for the date.
     */
    private void setDay(int newDay)
    {
        if ((this.month == 2) && ((this.year % 4) == 0)) {
            if ((1 <= newDay) && (newDay <= 29)) {
                this.day = newDay;
            } else {
                throw new IllegalArgumentException("Day parameter not valid!\nvalue: " + String.valueOf(newDay) + " is not in range 1 - 29");
            }
        } else if ((1 <= newDay) && (newDay <= this.daysInMonth.get(this.month))) {
            this.day = newDay;
        } else {
            throw new IllegalArgumentException("Day parameter not valid!\nvalue: " + String.valueOf(newDay) + " is not in range 1 - " + String.valueOf(this.daysInMonth.get(this.month)));
        }
    }


    /**
     * Setter method for hour.
     * @param newHour An <b>int</b> of the hour in 24 hour format.
     */
    private void setHour(int newHour)
    {
        if ((0 <= newHour) && newHour <= 23) {
            this.hour = newHour;
        } else {
            throw new IllegalArgumentException("Hour parameter not valid!\nvalue: " + String.valueOf(newHour) + " is not in range 1 - 23");
        }
    }


    /**
     * Setter method for minute.
     * @param newMinute An <b>int</b> of the minutes.
     */
    private void setMinute(int newMinute)
    {
        if ((0 <= newMinute) && (newMinute <= 59)) {
            this.minute = newMinute;
        } else {
            throw new IllegalArgumentException("Minute parameter not valid!\nvalue: " + String.valueOf(newMinute) + " is not in range 1 - 59");
        }
    }


    /**
     * Setter method for second.
     * @param newSecond An <b>int</b> of the seconds.
     */
    private void setSecond(int newSecond)
    {
        if ((0 <= newSecond) && (newSecond <= 59)) {
            this.second = newSecond;
        } else {
            throw new IllegalArgumentException("Second parameter not valid!\nvalue: " + String.valueOf(newSecond) + " is not in range 1 - 59");
        }
    }


    /**
     * Getter method for string of the date.
     * @return A <b>String</b> of the date.
     */
    public String getDateAsString()
    {
        return String.format("%02d", this.day) + "/" + String.format("%02d", this.month) + "/" + String.format("%04d", this.year);
    }


    /**
<<<<<<< HEAD
     * Getter method for string of the time
=======
     * Getter method for string of the time.
     * @return A <b>String</b> of the time.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    public String getTimeAsString()
    {
        return String.format("%02d", this.hour) + ":" + String.format("%02d", this.minute) + ":" + String.format("%02d", this.second);
    }


    /**
     * Getter method for year
     * @return An <b>int</b>: Year
     */
    public int getYear()
    {
        return this.year;
    }


    /**
     * Getter method for month
     * @return An <b>int</b>: Month
     */
    public int getMonth()
    {
        return this.month;
    }


    /**
     * Getter method for day
     * @return An <b>int</b>: Day
     */
    public int getDay()
    {
        return this.day;
    }


    /**
     * Getter method for hour
     * @return An <b>int</b>: Hour
     */
    public int getHour()
    {
        return this.hour;
    }


    /**
     * Getter method for minute
     * @return An <b>int</b>: Minute
     */
    public int getMinute()
    {
        return this.minute;
    }


    /**
     * Getter method for second
     * @return An <b>int</b>: Second
     */
    public int getSecond()
    {
        return this.second;
    }


    /**
     * Method to compare two DateTime objects, returns true if the called DateTime is after the parameter
     * @param otherDateTime DateTime: DateTime to be compared
     * @return boolean
     */
    public boolean isAfter(DateTime otherDateTime)
    {
        if (this.year > otherDateTime.getYear()) {
            return true;
        } else if (this.year < otherDateTime.getYear()) {
            return false;
        } else if (this.month > otherDateTime.getMonth()) {
            return true;
        } else if (this.month < otherDateTime.getMonth()) {
            return false;
        } else if (this.day > otherDateTime.getDay()) {
            return true;
        } else if (this.day < otherDateTime.getDay()) {
            return false;
        } else if (this.hour > otherDateTime.getHour()) {
            return true;
        } else if (this.hour < otherDateTime.getHour()) {
            return false;
        } else if (this.minute > otherDateTime.getMinute()) {
            return true;
        } else if (this.minute < otherDateTime.getMinute()) {
            return false;
        } else if (this.second > otherDateTime.getSecond()) {
            return true;
        } else if (this.second < otherDateTime.getSecond()) {
            return false;
        } else {
            return false;
        }
    }


    /**
     * Method to compare two DateTime objects, returns true if the called DateTime is before the parameter
     * @param otherDateTime DateTime: DateTime to be compared
     * @return boolean
     */
    public boolean isBefore(DateTime otherDateTime)
    {
        return !(this.isAfter(otherDateTime) || this.isEqual(otherDateTime));
    }


    /**
     * Method to compare two DateTime objects for equality
     * @param otherDateTime DateTime: DateTime to be compared
     * @return boolean
     */
    public boolean isEqual(DateTime otherDateTime)
    {
        return ((this.year == otherDateTime.getYear()) && (this.month == otherDateTime.getMonth()) &&
                (this.day == otherDateTime.getDay()) && (this.hour == otherDateTime.getHour()) &&
                (this.minute == otherDateTime.getMinute()) && (this.second == otherDateTime.getSecond()));
    }


    /**
     * Method to subtract another DateTime object from this DateTime object
     * @param otherDateTime DateTime: DateTime object to subtract
     * @return An <b>int</b>: the difference between the two objects in seconds
     */
    public int subtract(DateTime otherDateTime)
    {
        int seconds = this.second - otherDateTime.getSecond();
        seconds += ((this.minute - otherDateTime.getMinute()) * 60);
        seconds += ((this.hour - otherDateTime.getHour()) * 3600);

        int days = subtractDaysFromDateTime(otherDateTime);
        seconds += days * 86400;
        return seconds;
    }


    /**
     * Method to calculate how many days since the beginning of the year 2000
     * @param dateTime DateTime: the date to be calculated minus 2000 years
     * @return An <b>int</b>: The amount of days since the beginning of the year 2000
     */
    private int calculateDaysFrom1900(DateTime dateTime)
    {
        int days = 0;
        int index = 0;
        int years = dateTime.getYear() - 1900;
        for (; index < years; index++) {
            if ((index % 4) == 0) {
                days += 366;
            } else {
                days += 365;
            }
        }
        index = 1;
        for (; index < dateTime.getMonth(); index++) {
            if ((index == 2) && ((dateTime.getYear() % 4) == 0)) {
                days += 29;
            } else {
                days += this.daysInMonth.get(index);
            }
        }
        days += dateTime.getDay();
        return days;
    }


    /**
     * Method to calculate the difference in days between two DateTime objects
     * @param otherDateTime DateTime: DateTime to be subtracted from this DateTime
     * @return An <b>int</b>: number of days difference
     */
    public int subtractDaysFromDateTime(DateTime otherDateTime)
    {
        int daysThis = calculateDaysFrom1900(this);
        int daysOther = calculateDaysFrom1900(otherDateTime);
        return daysThis - daysOther;
    }


    /**
     * Method to calculate the years between two DateTimes. discards any extra months or days.
     * @param otherDateTime DateTime: The date time to be compared with.
     * @return An <b>int</b>: The difference in years.
     * TODO test this
     */
    public int subtractYearsFromDateTime(DateTime otherDateTime)
    {
        int years = this.getYear() - otherDateTime.getYear();
        if (this.getMonth() < otherDateTime.getMonth()) {
            years -= 1;
        } else if (this.getMonth() == otherDateTime.getMonth()) {
            if (this.getDay() < otherDateTime.getDay()) {
                years -= 1;
            }
        }
        return years;
    }


    /**
     * Method to get the current DateTime and return it as a new DateTime.
     * @return A <b>DateTime</b> of the current date and time.
     */
    public static DateTime now()
    {
        LocalDateTime current = LocalDateTime.now();
        int year = current.getYear();
        int month = current.getMonthValue();
        int day = current.getDayOfMonth();
        int hour = current.getHour();
        int minute = current.getMinute();
        int second = current.getSecond();
        return new DateTime(year, month, day, hour, minute, second);
    }


    /**
     * Method to fill the HashMap with month names.
     */
    private void fillMonths()
    {
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
     * Method to fill in the HashMap daysInMonth with the amount of days in each month (excluding leap years).
     */
    private void fillDaysInMonth()
    {
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

    /**
<<<<<<< HEAD
     * string representation of date and time
     * @return
=======
     * The ToString method for the class.
     * @return A <b>String</b> of the date and time.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    @Override
    public String toString()
    {
        String dayPostfix = "th";
        if (this.day != 11 && ((this.day % 10) == 1)) {
            dayPostfix = "st";
        } else if (this.day != 12 && ((this.day % 10) == 2)) {
            dayPostfix = "nd";
        } else if (this.day != 13 && ((this.day % 10) == 3)) {
            dayPostfix = "rd";
        }
        return String.valueOf(this.day) + dayPostfix + ", " + this.months.get(this.month) +
                ", " + String.valueOf(this.year) + " - " + String.format("%02d", this.hour) + ":" +
                String.format("%02d", this.minute) + ":" + String.format("%02d", this.second);
    }
}