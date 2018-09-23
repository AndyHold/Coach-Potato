package seng202.team10.Model.ActivitiesData;


import java.io.Serializable;
import java.util.ArrayList;


/**
 * Activity Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Activity implements Serializable {


    private String name;
    private DateTime startDateTime;
<<<<<<< HEAD
    private Double averageVelocity = 0.0;
<<<<<<< HEAD
    private Double averageHeartRate = 0.0;
=======
    private Double averageVelocity;
    private Double averageHeartRate;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> d8e4382... Fixing Calculation of total distance and total duration
=======
>>>>>>> 9b15fef... Fixing Calculation of total distance and total duration
=======
>>>>>>> dc93099... Fixing Calculation of total distance and total duration
=======
>>>>>>> f5a854f... Fixing Calculation of total distance and total duration
=======
    private int averageHeartRate;
>>>>>>> a5835c2... Implemented a try catch block for no internet access and a pop up to display the error.
    private Double totalDistance = 0.0;
    private ArrayList<Entry> entries = new ArrayList<>();
    private int totalDuration;
    private ActivityType type;
    private DateTime endDateTime;



    /**
     * Constructor method for Activity Class
     * @param newName String: Name of the activity
     */
    public Activity(String newName)
    {
        this.setName(newName);
        this.type = ActivityType.determineType(this.name);
    }


    /**
     * Method to convert a number of seconds to a string in the format HH:MM:SS. Returns null if the hours are greater than 23
     * or if seconds are negative.
     * @param seconds  The time in seconds to be converted.
     * @return  A string in the format HH:MM:SS that describes the time. Null if hours > 23
     */
    public String secondsToTime(int seconds) {
        if (seconds < 0) {
            return null;
        }
        int minutes = 0;
        int hours = 0;

        while (seconds > 59) {
            seconds = seconds - 60;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
        }
        String strSeconds = String.valueOf(seconds);
        String strMinutes = String.valueOf(minutes);
        String strHours = String.valueOf(hours);
        if (strSeconds.length() == 1) {
            strSeconds = "0" + strSeconds;
        }
        if (strMinutes.length() == 1) {
            strMinutes = "0" + strMinutes;
        }
        if (strHours.length() == 1) {
            strHours = "0" + strHours;
        }
        if (hours > 23) {
            return null;
        }
        return strHours + ":" + strMinutes + ":" + strSeconds;
    }


    /**
     * Setter method for name of the activity
     * @param newName: String
     */
    public void setName(String newName)
    {
        if ((newName.length() <= 30) && (newName.length() > 0)) {
            this.name = newName;
        } else {
            throw new IllegalArgumentException("Activity name invalid, either blank or too long. Please change to between 1 - 30 characters");
        }
    }


    /**
     * Setter method for the date and time the activity was started on
     */
    public void setStartDateTime()
    {
            this.startDateTime = entries.get(0).getTime();
    }


    /**
     * Setter method for the date and time the activity was finished on
     */
    public void setEndDateTime()
    {
        this.endDateTime = this.entries.get(this.entries.size() - 1).getTime();
    }


    /**
     * Setter method for the type of the activity
     * @param newType String: the type of activity
     */
    public void setType(ActivityType newType)
    {
        this.type = newType;
    }


    /**
     * Setter method for a list of activities
     * @param newEntries ArrayList<Entry>
     *                   TODO speak to Cam about this, is this really the best way to do this? - Andy
     */
    public void setEntries(ArrayList<Entry> newEntries)
    {
        this.entries = newEntries;
    }


    /**
     * method to calculate and set the total distance of the activity
     */
    public void calculateTotalDistance()
    {
        this.totalDistance = 0.0;
        for(int i = 1; i < this.entries.size(); i++) {
            this.entries.get(i).calculateDistance(this.entries.get(i - 1));
            this.totalDistance += this.entries.get(i).getDistance();
        }
    }


    /**
     * Method to calculate and set the total time taken during the activity
     */
    public void calculateTotalDuration()
    {
        this.totalDuration = this.entries.get(this.entries.size() - 1).getTime().subtract(this.startDateTime);
    }


    /**
     * Method to calculate and set the average velocity during the activity
     */
    public void calculateAverageVelocity()
    {
        this.averageVelocity = this.totalDistance / this.totalDuration;
    }


    /**
     * Method to calculate and set the average heart rate during the activity
     */
    public void calculateAverageHeartRate()
    {
        double totalHeartRate = 0.0;
        int count = 0;
        for(Entry entry: this.entries) {
            totalHeartRate += entry.getHeartRate();
            count++;
        }
        this.averageHeartRate = (int) Math.round(totalHeartRate / count);
    }


    /**
     * addEntry Method to add an Entry to the arrayList entries
     * @param newEntry: Entry to be added.
     */
    public void addEntry(Entry newEntry)
    {
        entries.add(newEntry);
    }


    /**
     * Setter method for after Entries have been loaded to the Activity
     *
     */
    public void postEntriesSetUp()
    {
        setStartDateTime();
        calculateTotalDistance();
        calculateTotalDuration();
        calculateAverageHeartRate();
        calculateAverageVelocity();
        this.type = ActivityType.determineType(this.name);
        setEndDateTime();
        calculateEntriesVelocity();
    }


    /**
     * Getter method for the name of the activity
     * @return String
     */
    public String getName()
    {
        return this.name;
    }


    /**
     * Getter method for the date the activity was started on
     * @return DateTime
     */
    public DateTime getStartDateTime()
    {
        return this.startDateTime;
    }


    /**
     * Getter method for the end DateTime
     * @return DateTime
     */
    public DateTime getEndDateTime()
    {
        return this.endDateTime;
    }


    /**
     * Setter method for the velocity at each Entry in the Activity
     * TODO test this method.
     */
    public void calculateEntriesVelocity()
    {
        entries.get(0).setFirstEntry(true);
        for (int i = 1; i < entries.size(); i++) {
                entries.get(i).calculateVelocity(entries.get(i - 1));
        }
    }


    /**
     * Getter method for the total distance travelled in the activity
     * @return Double
     */
    public Double getTotalDistance()
    {
        return this.totalDistance;
    }


    /**
     * Getter method for the total time taken during the activity in seconds
     * @return Double
     */
    public int getTotalDuration()
    {
        return this.totalDuration;
    }


    /**
     * Getter method for the average velocity over the activity
     * @return Double
     */
    public Double getAverageVelocity()
    {
        return this.averageVelocity;
    }


    /**
<<<<<<< HEAD
     * Getter method for the average heart rate during the activity
=======
     * Getter method for the ArrayList<Entry> entries
     * @return ArrayList<Entry>
     */
    public ArrayList<Entry> getEntries() {
        return this.entries;
    }


    /**
     * Setter method for the start time of the activity
     */
    public void setStartTime() {
        this.startDateTime = this.entries.get(0).getTime();
    }


    /**
     * Method to calculate and set the total time taken during the activity
     */
    public void calculateTotalDuration() {
        this.totalDuration = this.entries.get(this.entries.size()-1).getTime().subtract(this.startDateTime);
    }


    /**
<<<<<<< HEAD
     * Getter method for the total time taken during the activity in seconds
>>>>>>> d8e4382... Fixing Calculation of total distance and total duration
     * @return Double
=======
     * Getter method for the Duration as a String, in minutes
     * @return String
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
     */
    public double getAverageHeartRate()
    {
<<<<<<< HEAD
        return this.averageHeartRate;
=======
        return String.format("%.2f", (this.totalDuration / 60.0));
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
    }


    /**
<<<<<<< HEAD
     * Getter method for the ArrayList<Entry> entries
     * @return ArrayList<Entry>
=======
     * Getter method for the Average Speed as a String, in KM/h
     * @return String
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
     */
    public ArrayList<Entry> getEntries()
    {
<<<<<<< HEAD
        return this.entries;
=======
        return String.format("%.2f", (this.averageVelocity * 3.6));
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
    }


    /**
<<<<<<< HEAD
     * getter method for the type of the activity
     * @return String of the type of the activity
=======
     * Getter method for the Distance as a String, in Km
     * @return String
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
     */
    public ActivityType getType()
    {
<<<<<<< HEAD
        return this.type;
=======
        return String.format("%.2f", (this.totalDistance / 1000.0));
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
    }


    /**
     * Getter method for the Time as a String
     * @return String
     */
    public String getTimeString()
    {
<<<<<<< HEAD
        return this.startDateTime.toString();
<<<<<<< HEAD
=======
=======
    }


    /**
     * Getter method for the Duration, in minutes to 2DP
     * @return String
     */
    public double getDurationMins()
    {
        return Math.round((this.totalDuration / 60.0) * 100.0) / 100.0;
        //return String.format("%.2f", );
    }


    /**
     * Getter method for the Average Speed in KM/h to 2DP
     * @return String
     */
    public Double getSpeedKMH()
    {
        return Math.round(this.averageVelocity * 360.0) / 100.0;
    }


    /**
     * Getter method for the Distance as a String, in Km to 2DP
     * @return String
     */
    public Double getDistanceKM()
    {
        return Math.round(this.totalDistance / 10.0) / 100.0;
    }


    /**
     * Getter method for the Average Heart Rate as a String
     * @return String
     */
    public String getHeartString()
    {
<<<<<<< HEAD
>>>>>>> 4ae853f... fixing display on viewActivities (why was this changed?)
        return String.format("%.0f", this.averageHeartRate);
>>>>>>> ff79906... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
=======
        return String.valueOf(this.averageHeartRate);
>>>>>>> ace36df... Fixed average heart rate error on Profile screen and added a new method for that in UserProfile.
    }


    /**
     * Getter method for the Number of Entries as a String
     * @return String
     */
    public int getEntryno()
    {
        return this.entries.size();
    }


    /**
     * Getter method for the Type as a String
     * @return String
     */
    public String getTypeString()
    {
        return this.type.toString();
    }
}
