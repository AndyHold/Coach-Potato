package seng202.team10.Model.ActivitiesData;


import java.sql.Time;
import java.util.ArrayList;


/**
 * Activity Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Activity {


//    private Date date;
    private Double averageVelocity;
    private Double averageHeartRate;
    private Double totalDistance;
    private String name;
    private ArrayList<Entry> entries;
    private Time startTime;
    private Double totalTime;
    private ActivityIntensity intensity;


//    /**
//     * Setter method for the date the activity was started on
//     * @param day: Day
//     * @param month: Month
//     * @param year: Year
//     */
//    public void setDate(int day, int month, int year) {
//        try {
//            this.date = new Date(day, month, year);
//        } catch (IllegalArgumentException ex) {
//            System.out.print(ex);
//        }
//    }


    /**
     * addEntry Method to add an Entry to the arrayList entries
     * @param newEntry: Entry to be added.
     */
    public void addEntry(Entry newEntry) {
        entries.add(newEntry);
    }


//    /**
//     * Getter method for the date the activity was started on
//     * @return Date
//     */
//    public Date getDate() {
//        return this.date;
//    }


    /**
     * Method to calculate and set the average velocity during the activity
     */
    public void calculateAverageVelocity() {
        this.averageVelocity = this.totalDistance / this.totalTime;
    }


//    /**
//     * Method to calculate and set the average heart rate during the activity
//     */
//    public void calculateAverageHeartRate() {
//        Double totalHeartRate = 0.0;
//        int count = 0;
//        for(Entry entry: this.entries) {
//            totalHeartRate += entry.getHeartRate();
//            count++;
//        }
//        this.averageHeartRate = totalHeartRate / count;
//    }
//
//
//    /**
//     * method to calculate and set the total distance of the activity
//     */
//    public void calculateTotalDistance() {
//        for(int i = 1; i < this.entries.size(); i++) {
//            this.totalDistance += (this.entries.get(i).getPosition() - this.entries.get(i - 1).getPosition());
//        }
//    }


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


//    /**
//     * Setter method for the start time of the activity
//     */
//    public void setStartTime() { this.startTime = this.entries.get(0).getTime(); }
//
//
//    /**
//     * Method to calculate and set the total time taken during the activity
//     */
//    public void calculateTotalTime() { this.totalTime = this.entries.get(-1).getTime() - this.startTime; }


    /**
     * Getter method for the total time taken during the activity
     * @return Double
     */
    public Double getTotalTime() {
        return this.totalTime;
    }


    /**
     * Getter method for the start time of the activity
     * @return Time
     */
    public Time getStartTime() {
        return this.startTime;
    }


    /**
     * Setter method for the intensity of the activity
     * @param newIntensity: ActivityIntensity
     */
    public void setIntensity(ActivityIntensity newIntensity) {
        this.intensity = newIntensity;
    }
}
