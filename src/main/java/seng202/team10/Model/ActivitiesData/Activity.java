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
    private Double totalDistance = 0.0;
    private ArrayList<Entry> entries = new ArrayList<>();
    private int totalDuration = 0;
    // private ActivityIntensity intensity;
    private String type;
    private DateTime endDateTime;
    private String nameString;
    private String timeString;
    private String durationString;
    private String speedString;
    private String distanceString;
    private String heartString;
    private String entrynoString;
    private String typeString;


    /**
     * Constructor method for Activity Class
     * @param newName String: Name of the activity
     * @param newStartDateTime DateTime: Start time and date of the activity
     */
    public Activity(String newName, DateTime newStartDateTime)
    {
        this.setName(newName);
        this.setStartDateTime(newStartDateTime);
        // this.intensity = newIntensity;
    }

    public void setStrings() {
        this.nameString = this.name;
        this.typeString = this.type;
        this.timeString = this.startDateTime.toString();
        this.durationString = String.valueOf(this.totalDuration);
        this.speedString = String.format("%.2f", this.averageVelocity);
        this.distanceString = String.format("%.2f", this.totalDistance);
        this.heartString = String.format("%.2f", this.averageHeartRate);
        this.entrynoString = String.valueOf(this.entries.size());
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
     * @param newDateTime DateTime: Start date and time for this activity
     */
    public void setStartDateTime(DateTime newDateTime)
    {
            this.startDateTime = newDateTime;
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
     * @param newtype String: the type of activity
     */
    public void setType(String newtype)
    {
        this.type = newtype;
    }


    /**
     * Setter method for after Entries have been loaded to the Activity
     * TODO add this method whenever Activities are modified.
     */
    public void postEntriesSetUp() {
        calculateTotalDistance();
        calculateTotalDuration();
        calculateAverageHeartRate();
        calculateAverageVelocity();
        determineType();
        setEndDateTime();
        setStrings();
    }


    /**
     * getter method for the type of the activity
     * @return String of the type of the activity
     */
    public String getType()
    {
        return this.type;
    }


    /**
     * determines and sets the type of the activity based on the name string.
     * possible types are walk, run, hike, cycle, swim, workout, other
     * */
    public void determineType()
    {
        //TODO switch this over to using Enum
        String lowername = this.name.toLowerCase();
        if(lowername.contains("walk")){
            this.type = "walk";
        } else if (lowername.contains("run") || lowername.contains("jog")){
            this.type = "run";
        } else if (lowername.contains("hike") || lowername.contains("hiking")){
            this.type = "hike";
        } else if (lowername.contains("cycle") || lowername.contains("cycling") || lowername.contains("bike") ||
                lowername.contains("biking")){
            this.type = "cycle";
        } else if (lowername.contains("swim")){
            this.type = "swim";
        } else if (lowername.contains("workout") || lowername.contains("work out") || lowername.contains("working out")){
            this.type = "workout";
        } else{
            this.type = "other";
        }
    }


    /**
     * method to calculate and set the total distance of the activity
     */
    public void calculateTotalDistance()
    {
        for(int i = 1; i < this.entries.size(); i++) {
            this.totalDistance += (this.entries.get(i).getPosition().subtract(this.entries.get(i - 1).getPosition()));
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
        this.averageHeartRate = (totalHeartRate / count);
    }


    /**
     * addEntry Method to add an Entry to the arrayList entries
     * @param newEntry: Entry to be added.
     */
    public void addEntry(Entry newEntry)
    {
        entries.add(newEntry);
    }


//    /**
//     * Setter method for the intensity of the activity
//     * @param newIntensity: ActivityIntensity
//     */
//    public void setIntensity(ActivityIntensity newIntensity) {
//        this.intensity = newIntensity;
//    }


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


    public DateTime getEndDateTime()
    {
        return this.endDateTime;
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
     * Getter method for the total time taken during the activity in seconds
>>>>>>> d8e4382... Fixing Calculation of total distance and total duration
     * @return Double
     */
    public double getAverageHeartRate()
    {
        return this.averageHeartRate;
    }


    /**
     * Getter method for the ArrayList<Entry> entries
     * @return ArrayList<Entry>
     */
    public ArrayList<Entry> getEntries()
    {
        return this.entries;
    }

    public void setEntries(ArrayList<Entry> newEntries)
    {
        this.entries = newEntries;
    }

    @Override
    public String toString()
    {
        return "Name= '" + name + '\'' +
                ", startDateTime=" + startDateTime +
                ", averageVelocity=" + averageVelocity +
                ", averageHeartRate=" + averageHeartRate +
                ", totalDistance=" + totalDistance +
                ", totalDuration=" + totalDuration;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public String getDurationString() {
        return durationString;
    }

    public void setDurationString(String durationString) {
        this.durationString = durationString;
    }

    public String getSpeedString() {
        return speedString;
    }

    public void setSpeedString(String speedString) {
        this.speedString = speedString;
    }

    public String getDistanceString() {
        return distanceString;
    }

    public void setDistanceString(String distanceString) {
        this.distanceString = distanceString;
    }

    public String getHeartString() {
        return heartString;
    }

    public void setHeartString(String heartString) {
        this.heartString = heartString;
    }

    public String getEntrynoString() {
        return entrynoString;
    }

    public void setEntrynoString(String entrynoString) {
        this.entrynoString = entrynoString;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }


//    /**
//     * Getter method for intensity of activity
//     * @return ActivityIntensity
//     */
//    public ActivityIntensity getIntensity() {
//        return this.intensity;
//    }
}
