package seng202.team10.Model.ActivitiesData;


import seng202.team10.Model.UserProfile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;


/**
 * Class that contains lists of entries and activity details. Represents an instance of an activity, workout or exercise session.
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
>>>>>>> f5a854f6... Fixing Calculation of total distance and total duration
=======
<<<<<<< HEAD
    private int averageHeartRate;
>>>>>>> c3a876d4... Implemented a try catch block for no internet access and a pop up to display the error.
=======
>>>>>>> dc93099... Fixing Calculation of total distance and total duration
=======
>>>>>>> f5a854f... Fixing Calculation of total distance and total duration
=======
    private int averageHeartRate;
>>>>>>> a5835c2... Implemented a try catch block for no internet access and a pop up to display the error.
>>>>>>> 862d9088... Implemented a try catch block for no internet access and a pop up to display the error.
    private Double totalDistance = 0.0;
    private ArrayList<Entry> entries = new ArrayList<>();
    private int totalDuration;
    private ActivityType type;
    private DateTime endDateTime;
    private ArrayList<HealthWarning> healthWarnings = new ArrayList<>();



    /**
     * Constructor method for the Activity Class.
     * @param newName A <b>String</b> of the name of the activity.
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
<<<<<<< HEAD
     * @return  A string in the format HH:MM:SS that describes the time. Null if hours > 23
=======
     * @return  A <b>String</b> in the format HH:MM:SS that describes the time. Null if hours &gt; 23.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
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
     * @param newName A <b>String</b> of the name of the activity.
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
     * Setter method for the date and time the activity was started on.
     */
    private void setStartDateTime()
    {
            this.startDateTime = entries.get(0).getTime();
    }


    /**
     * Setter method for the date and time the activity was finished on.
     */
    private void setEndDateTime()
    {
        this.endDateTime = this.entries.get(this.entries.size() - 1).getTime();
    }


    /**
     * Setter method for the type of the activity.
     * @param newType A <b>String</b> of the type of activity.
     */
    public void setType(ActivityType newType)
    {
        this.type = newType;
    }


    /**
<<<<<<< HEAD
     * Setter method for a list of activities
     * @param newEntries ArrayList<Entry>
     *                   TODO speak to Cam about this, is this really the best way to do this? - Andy
=======
     * Setter method for a list of activities.
     * @param newEntries An <b>ArrayList&lt;Entry&lt;</b> of entries being set.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    public void setEntries(ArrayList<Entry> newEntries)
    {
        this.entries = newEntries;
    }


    /**
     * Method to calculate and set the total distance of the activity.
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
     * Method to calculate and set the total time taken during the activity.
     */
    protected void calculateTotalDuration()
    {
        this.totalDuration = this.entries.get(this.entries.size() - 1).getTime().subtract(this.startDateTime);
    }


    /**
     * Method to calculate and set the average velocity during the activity.
     */
    protected void calculateAverageVelocity()
    {
        this.averageVelocity = this.totalDistance / this.totalDuration;
    }


    /**
     * Method to calculate and set the average heart rate during the activity.
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
     * Method to add an entry to the list of entries.
     * @param newEntry The <b>Entry</b> to be added.
     */
    public void addEntry(Entry newEntry)
    {
        entries.add(newEntry);
    }


    /**
<<<<<<< HEAD
     * Setter method for after Entries have been loaded to the Activity
     *
=======
     * Method to calculate activity statistics after the entries have been loaded.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
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
     * @param user The <b>UserProfile</b> being checked for health warnings.
     */
    public void checkEntriesForWarnings(UserProfile user)
    {
        Set<HealthWarningType> warnings = new HashSet<>();
        for (Entry entry: entries) {
            if (warnings.size() < 3) {
                Set<HealthWarningType> newHealthWarningTypes = HealthWarning.addWarning(this.getType(), entry.isFirstEntry(), entry.getHeartRate(), user.calculateAge());
                warnings.addAll(newHealthWarningTypes);
            }
        }
        warnings.iterator().forEachRemaining(new Consumer<HealthWarningType>() {
            @Override
            public void accept(HealthWarningType healthWarningType) {
                HealthWarning warning = new HealthWarning(healthWarningType, getName(), getStartDateTime());
                healthWarnings.add(warning);
            }
        });
    }


    /**
     * Getter method for the health warnings associated with this activity.
     * @return An <b>ArrayList&lt;HealthWarning&gt;</b> of health warning types.
     */
    public ArrayList<HealthWarning> getHealthWarnings()
    {
        return healthWarnings;
    }


    /**
     * Getter method for the name of the activity
     * @return A <b>String</b> of the name of the activity.
     */
    public String getName()
    {
        return this.name;
    }


    /**
     * Getter method for the date and time the activity was started.
     * @return A <b>DateTime</b> of the start date of the activity.
     */
    public DateTime getStartDateTime()
    {
        return this.startDateTime;
    }


    /**
     * Getter method for the date and time the activity was ended.
     * @return A <b>DateTime</b> of the end date of the activity.
     */
    public DateTime getEndDateTime()
    {
        return this.endDateTime;
    }


    /**
     * Setter method for the velocity at each entry in the activity.
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
     * @return A <b>Double</b> of the total distance.
     */
    public Double getTotalDistance()
    {
        return this.totalDistance;
    }


    /**
     * Getter method for the total time taken during the activity in seconds
     * @return A <b>Double</b> of the total duration.
     */
    public int getTotalDuration()
    {
        return this.totalDuration;
    }


    /**
     * Getter method for the average velocity over the activity
     * @return A <b>Double</b> of the average velocity.
     */
    public Double getAverageVelocity()
    {
        return this.averageVelocity;
    }


    /**
<<<<<<< HEAD
     * Getter method for the average heart rate during the activity
<<<<<<< HEAD
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
>>>>>>> f5a854f6... Fixing Calculation of total distance and total duration
     * @return Double
=======
     * Getter method for the Duration as a String, in minutes
     * @return String
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
=======
     * @return A <b>Double</b> of the average heart rate.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    public double getAverageHeartRate()
    {
<<<<<<< HEAD
        return this.averageHeartRate;
=======
        return String.format("%.2f", (this.totalDuration / 60.0));
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
    }


    /**
<<<<<<< HEAD
<<<<<<< HEAD
     * Getter method for the ArrayList<Entry> entries
<<<<<<< HEAD
     * @return ArrayList<Entry>
=======
     * Getter method for the Average Speed as a String, in KM/h
     * @return String
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
=======
     * @return ArrayList&gtEntry&lt
>>>>>>> 3b88f7f9... Fixed Javadoc
=======
     * Getter method for the ArrayList&lt;Entry&gt;entries
     * @return An <b>ArrayList&lt;Entry&gt;</b> of entries.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    public ArrayList<Entry> getEntries()
    {
<<<<<<< HEAD
        return this.entries;
=======
        return String.format("%.2f", (this.averageVelocity * 3.6));
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
    }


    /**
<<<<<<< HEAD
<<<<<<< HEAD
     * getter method for the type of the activity
     * @return String of the type of the activity
=======
     * Getter method for the Distance as a String, in Km
     * @return String
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
=======
     * Getter method for the type of the activity.
     * @return A <b>String</b> of the type of activity.
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
     */
    public ActivityType getType()
    {
<<<<<<< HEAD
        return this.type;
=======
        return String.format("%.2f", (this.totalDistance / 1000.0));
<<<<<<< HEAD
>>>>>>> 5134d2c1... making units on activityviewer better by changing toString methods, and appropriate tests
=======
>>>>>>> 92da298... making units on activityviewer better by changing toString methods, and appropriate tests
>>>>>>> 7a3f71e2... making units on activityviewer better by changing toString methods, and appropriate tests
    }


    /**
     * Getter method for the start time and date of the activity.
     * @return A <b>String</b> of the start time/date.
     */
    public String getTimeString()
    {
<<<<<<< HEAD
        return this.startDateTime.toString();
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
=======
=======
=======
>>>>>>> e87c3ef4... fixing display on viewActivities (why was this changed?)
    }


    /**
     * Getter method for the duration of the activity, in minutes to 2DP.
     * @return A <b>Double</b> of the duration of the activity.
     */
    public double getDurationMins()
    {
        return Math.round((this.totalDuration / 60.0) * 100.0) / 100.0;
        //return String.format("%.2f", );
    }


    /**
     * Getter method for the average speed of the activity in KM/h to 2DP.
     * @return A <b>Double</b> of the average speed of the activity.
     */
    public Double getSpeedKMH()
    {
        return Math.round(this.averageVelocity * 360.0) / 100.0;
    }


    /**
     * Getter method for the distance of the activity as a string, in Km to 2DP
     * @return A <b>Double</b> of the distance of the activity.
     */
    public Double getDistanceKM()
    {
        return Math.round(this.totalDistance / 10.0) / 100.0;
    }


    /**
     * Getter method for the average heart rate of the activity as a string.
     * @return A <b>String</b> of the average heart rate.
     */
    public String getHeartString()
    {
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 41aa902e... fixing display on viewActivities (why was this changed?)
=======
>>>>>>> 4ae853f... fixing display on viewActivities (why was this changed?)
>>>>>>> e87c3ef4... fixing display on viewActivities (why was this changed?)
        return String.format("%.0f", this.averageHeartRate);
<<<<<<< HEAD
>>>>>>> a30807bb... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
=======
>>>>>>> ff79906... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
>>>>>>> 9bd0c9a0... 1) Changed getHeartString so it displays an int. 2) Added getActivitiesSpeed method to UserProfile. 3) Updated the way recent activities are displayed on profile screen. 4) Fixed the failing tests so that the pipeline works.
=======
        return String.valueOf(this.averageHeartRate);
>>>>>>> b8dfa7d7... Fixed average heart rate error on Profile screen and added a new method for that in UserProfile.
    }


    /**
     * Getter method for the number of entries as a string.
     * @return A <b>String</b> of the number of entries.
     */
    public int getEntryno()
    {
        return this.entries.size();
    }


    /**
     * Getter method for the type of the activity as a string.
     * @return A <b>String</b> of the type of activity.
     */
    public String getTypeString()
    {
        return this.type.toString();
    }
}
