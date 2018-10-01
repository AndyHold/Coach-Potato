package seng202.team10.Model.ActivitiesData;


import seng202.team10.Model.UserProfile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;


/**
 * Activity Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Activity implements Serializable {


    private String name;
    private DateTime startDateTime;
    private Double averageVelocity = 0.0;
    private int averageHeartRate;
    private Double totalDistance = 0.0;
    private ArrayList<Entry> entries = new ArrayList<>();
    private int totalDuration;
    private ActivityType type;
    private DateTime endDateTime;
    private ArrayList<HealthWarning> healthWarnings = new ArrayList<>();



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
     * @return  A string in the format HH:MM:SS that describes the time. Null if hours &lt; 23
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
    private void setStartDateTime()
    {
            this.startDateTime = entries.get(0).getTime();
    }


    /**
     * Setter method for the date and time the activity was finished on
     */
    private void setEndDateTime()
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
     * @param newEntries ArrayList&gt;Entry&lt;
     *                   TODO speak to Cam about this, is this really the best way to do this? - Andy
     */
    public void setEntries(ArrayList<Entry> newEntries)
    {
        this.entries = newEntries;
    }


    /**
     * method to calculate and set the total distance of the activity
     */
    protected void calculateTotalDistance()
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
    protected void calculateTotalDuration()
    {
        this.totalDuration = this.entries.get(this.entries.size() - 1).getTime().subtract(this.startDateTime);
    }


    /**
     * Method to calculate and set the average velocity during the activity
     */
    protected void calculateAverageVelocity()
    {
        this.averageVelocity = this.totalDistance / this.totalDuration;
    }


    /**
     * Method to calculate and set the average heart rate during the activity
     */
    protected void calculateAverageHeartRate()
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
        setFirst();
    }


    /**
     * Method to set the first entry field in all the activities entries.
     */
    private void setFirst()
    {
        for (Entry entry: entries) {
            entry.setFirstEntry(false);
        }
        entries.get(0).setFirstEntry(true);
    }


    /**
     * Method to check for health warnings and add them if detected.
     * @param user UserProfile: profile of the user.
     */
    public void checkEntriesForWarnings(UserProfile user)
    {
        Set<HealthWarningType> warnings = null;
        for (Entry entry: entries) {
            ArrayList<HealthWarningType> newHealthWarningTypes = (HealthWarning.addWarning(this, entry.isFirstEntry(), entry.getHeartRate(), user.calculateAge()));
            for (HealthWarningType healthWarningType: newHealthWarningTypes) {
                warnings.add(healthWarningType);
            }
        }
        for (HealthWarningType healthWarningType: warnings) {
            HealthWarning warning = new HealthWarning(healthWarningType, this.getName(), this.getStartDateTime());
            this.healthWarnings.add(warning);
        }

    }


    /**
     * Getter method for the health warnings ascociated with this activity.
     * @return ArrayList: list of health warning types.
     */
    public ArrayList<HealthWarning> getHealthWarnings()
    {
        return healthWarnings;
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
     */
    private void calculateEntriesVelocity()
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
     * Getter method for the average heart rate during the activity
     * @return Double
     */
    public double getAverageHeartRate()
    {
        return this.averageHeartRate;
    }


    /**
     * Getter method for the ArrayList&gt;Entry&lt; entries
     * @return ArrayList&gt;Entry&lt;
     */
    public ArrayList<Entry> getEntries()
    {
        return this.entries;
    }


    /**
     * getter method for the type of the activity
     * @return String of the type of the activity
     */
    public ActivityType getType()
    {
        return this.type;
    }


    /**
     * Getter method for the Time as a String
     * @return String
     */
    public String getTimeString()
    {
        return this.startDateTime.toString();
    }


    /**
     * Getter method for the Duration, in minutes to 2DP
     * @return String
     */
    protected double getDurationMins()
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
    protected Double getDistanceKM()
    {
        return Math.round(this.totalDistance / 10.0) / 100.0;
    }


    /**
     * Getter method for the Average Heart Rate as a String
     * @return String
     */
    protected String getHeartString()
    {
        return String.valueOf(this.averageHeartRate);
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
