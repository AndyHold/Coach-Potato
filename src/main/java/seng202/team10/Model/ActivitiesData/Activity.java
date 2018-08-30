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
    private Double averageVelocity;
    private Double averageHeartRate;
    private Double totalDistance = 0.0;
    private ArrayList<Entry> entries = new ArrayList<>();
    private int totalDuration;
    // private ActivityIntensity intensity;


    /**
     * Constructor method for Activity Class
     * @param newName String: Name of the activity
     * @param newStartDateTime DateTime: Start time and date of the activity
     */
    public Activity(String newName, DateTime newStartDateTime) {
        this.name = newName;
        this.startDateTime = newStartDateTime;
        // this.intensity = newIntensity;
    }


    /**
     * Setter method for the date and time the activity was started on
     * @param newDateTime DateTime: Start date and time for this activity
     */
    public void setStartDateTime(DateTime newDateTime) {
            this.startDateTime = newDateTime;
    }


    /**
     * addEntry Method to add an Entry to the arrayList entries
     * @param newEntry: Entry to be added.
     */
    public void addEntry(Entry newEntry) {
        entries.add(newEntry);
    }


    /**
     * Getter method for the date the activity was started on
     * @return DateTime
     */
    public DateTime getStartDateTime() {
        return this.startDateTime;
    }


    /**
     * Method to calculate and set the average velocity during the activity
     */
    public void calculateAverageVelocity() {
        this.averageVelocity = this.totalDistance / this.totalDuration;
    }


    /**
     * Method to calculate and set the average heart rate during the activity
     */
    public void calculateAverageHeartRate() {
        Double totalHeartRate = 0.0;
        int count = 0;
        for(Entry entry: this.entries) {
            totalHeartRate += entry.getHeartRate();
            count++;
        }
        this.averageHeartRate = totalHeartRate / count;
    }


    /**
     * method to calculate and set the total distance of the activity
     */
    public void calculateTotalDistance() {
        for(int i = 1; i < this.entries.size(); i++) {
            this.totalDistance += (this.entries.get(i).getPosition().subtract(this.entries.get(i - 1).getPosition()));
        }
    }


    /**
     * Setter method for name of the activity
     * @param newName: String
     */
    public void setName(String newName) {
        this.name = newName;
    }


    /**
     * Getter method for the name of the activity
     * @return String
     */
    public String getName() {
        return this.name;
    }


    /**
     * Getter method for the total distance travelled in the activity
     * @return Double
     */
    public Double getTotalDistance() {
        return this.totalDistance;
    }


    /**
     * Getter method for the average heart rate during the activity
     * @return Double
     */
    public Double getAverageHeartRate() {
        return this.averageHeartRate;
    }


    /**
     * Getter method for the average velocity over the activity
     * @return Double
     */
    public Double getAverageVelocity() {
        return this.averageVelocity;
    }


    /**
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
     * @return Double
     */
    public int getTotalDuration() {
        return this.totalDuration;
    }


    /**
     * Getter method for the start time of the activity
     * @return Time
     */
    public DateTime getStartTime() {
        return this.startDateTime;
    }


//    /**
//     * Setter method for the intensity of the activity
//     * @param newIntensity: ActivityIntensity
//     */
//    public void setIntensity(ActivityIntensity newIntensity) {
//        this.intensity = newIntensity;
//    }
}
