package seng202.team10.Model.ActivitiesData;


import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

/**
 * Entry Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Entry  implements Serializable {

    private boolean firstEntry;
    private DateTime time;
    private SimpleStringProperty timeString;
    private SimpleStringProperty dateString;
    private SimpleStringProperty heartRateString;
    private double heartRate;
    private Position position;
    private SimpleStringProperty longitudeString;
    private SimpleStringProperty latitudeString;
    private SimpleStringProperty elevationString;
    private double distance = 0;
    private double velocity = 0;
    //private Activity activity;

    /**
     * Constructor for the Entry.
//     * @param firstEntry: boolean True if first entry.
     * @param time: double Time field of the entry.
     * @param heartRate: double Heart rate field of the entry.
     * @param position: Position Position of the entry.
     * //@param activity: Activity Activity field of the entry.
     */
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
        this.firstEntry = firstEntry;
        this.time = time;
        this.heartRate = heartRate;
        this.position = position;
        setStrings();
        //this.activity = activity;
    }


    /**
     * Setter method for the string representations for the GUI Table View
     */
    private void setStrings()
    {
        this.dateString = this.time.getDate();
        this.timeString = this.time.getTime();
        this.heartRateString = new SimpleStringProperty(String.valueOf(this.heartRate));
        this.latitudeString = new SimpleStringProperty(String.format("%.8f", this.position.getLatitude()));
        this.longitudeString = new SimpleStringProperty(String.format("%.8f", this.position.getLongitude()));
        this.elevationString = new SimpleStringProperty(String.valueOf(this.position.getElevation()));
    }


    /**
     * Method to change the current date of the entry (for GUI purposes)
     * @param newDate String: String representation of a Date
     * @throws IllegalArgumentException if illegal arguments encountered
     */
    public void changeDate(String newDate) throws IllegalArgumentException
    {
        String[] dateArray = newDate.split("/");
        int day = Integer.valueOf(dateArray[0]);
        int month = Integer.valueOf(dateArray[1]);
        int year = Integer.valueOf(dateArray[2]);
        this.time.changeDate(year, month, day);
    }


    /**
     * Method to change the current date of the entry (for GUI purposes)
     * @param newDate String: String representation of a Time
     * @throws IllegalArgumentException if illegal arguments encountered
     */
    public void changeTime(String newDate) throws IllegalArgumentException
    {
        String[] timeArray = newDate.split(":");
        int hour = Integer.valueOf(timeArray[0]);
        int minute = Integer.valueOf(timeArray[1]);
        int second = Integer.valueOf(timeArray[2]);
        this.time.changeTime(hour, minute, second);
    }


    /**
     * Method to change the current heart rate of the entry (for GUI purposes)
     * @param newHeartRate String: String representation of the heart rate double
     * @throws NumberFormatException String does not represent a number
     */
    public void changeHeartRate(String newHeartRate) throws NumberFormatException
    {
        this.heartRate = Double.valueOf(newHeartRate);
    }


    /**
     * Method to change the current latitude of the entry (for GUI purposes)
     * @param newLatitude String: String representation of the heart rate double
     * @throws NumberFormatException String does not represent a number
     */
    public void changeLatitude(String newLatitude) throws NumberFormatException
    {
        this.position.setLatitude(Double.valueOf(newLatitude));
    }


    /**
     * Method to change the current longitude of the entry (for GUI purposes)
     * @param newLongitude String: String representation of the heart rate double
     * @throws NumberFormatException String does not represent a number
     */
    public void changeLongitude(String newLongitude) throws NumberFormatException
    {
        this.position.setLongitude(Double.valueOf(newLongitude));
    }


    /**
     * Method to change the current elevation of the entry (for GUI purposes)
     * @param newElevation String: String representation of the heart rate double
     * @throws NumberFormatException String does not represent a number
     */
    public void changeElevation(String newElevation) throws NumberFormatException
    {
        this.position.setElevation(Double.valueOf(newElevation));
    }


    /**
     * Getter method for the String representation of the date
     */
    public String getDateString()
    {
        return this.dateString.get();
    }


    /**
     * Getter method for the String representation of the time
     */
    public String getTimeString()
    {
        return this.timeString.get();
    }


    public String getHeartRateString()
    {
        return this.heartRateString.get();
    }


    /**
     * Getter method for the String representation of the latitude
     */
    public String getLatitudeString()
    {
        return this.latitudeString.get();
    }


    /**
     * Getter method for the String representation of the longitude
     */
    public String getLongitudeString()
    {
        return this.longitudeString.get();
    }


    /**
     * Getter method for the String representation of the elevation
     */
    public String getElevationString()
    {
        return this.elevationString.get();
    }


    /**
     * Getter method to check if it is user's first entry.
     * @return firstEntry: boolean
     */
    public boolean isFirstEntry() {
        return firstEntry;
    }

    /**
     * Setter method to set user's first entry.
     * @param firstEntry: boolean
     */
    public void setFirstEntry(boolean firstEntry) {
        this.firstEntry = firstEntry;
    }

    /**
     * Getter method to get user's entry time.
     * @return time: double
     */
    public DateTime getTime() {
        return time;
    }

    /**
     * Setter method to set user's entry time.
     * @param time: double
     */
    public void setTime(DateTime time) {
        this.time = time;
    }

    /**
     * Getter method to get user's heart rate.
     * @return heartRate: double
     */
    public double getHeartRate() {
        return heartRate;
    }

    /**
     * Setter method to set user's heart rate.
     * @param heartRate: double
     */
    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * Getter method to get user's position.
     * @return position: Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setter method to set user's position.
     * @param position: Position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Getter method to get user's distance.
     * @return distance: double
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Method to calculate user's distance.
     * @param prevEntry: Entry
     */
    public void calculateDistance(Entry prevEntry) {
        Position prevPosition = prevEntry.getPosition();
        this.distance = prevPosition.subtract(this.position);
    }

    /**
     * Getter method to get user's velocity.
     * @return velocity: double
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Method to calculate user's velocity.
     * @param prevEntry: Entry
     */
    public void calculateVelocity(Entry prevEntry) {
        double prevDistance = prevEntry.getDistance();
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/((time.subtract(prevTime)));
    }

    public String toString(){
        return ("First Entry? : " + this.firstEntry + " , " + position.toString());
    }
    /**
     * Getter method to get user's activities.
     * @return  activity: Activity
     */
    // Commented out as we don't need it for now but might need it later.
    //public Activity getActivity() {
    //    return activity;
    //}


}