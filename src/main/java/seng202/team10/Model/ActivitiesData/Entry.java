package seng202.team10.Model.ActivitiesData;



/**
 * Entry Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Entry {

    private boolean firstEntry;
    private double time;
    private double heartRate;
    private Position position;
    private double distance;
    private double velocity;
    private Activities activities;

    /**
     * Getter method to check if it is user's first entry.
     * @return boolean
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
     * @return double
     */
    public double getTime() {
        return time;
    }

    /**
     * Setter method to set user's entry time.
     * @param time: double
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Getter method to get user's heart rate.
     * @return double
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
     * @return Position
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
     * @return double
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Method to calculate user's distance.
     * @param distance: double
     */
    public void calculateDistance(double distance) {
        this.distance += distance;
    }

    /**
     * Getter method to get user's velocity.
     * @return double
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Method to calculate user's velocity.
     * @param velocity: double
     */
    public void calculateVelocity(double velocity) {
        this.velocity += velocity;
    }

    /**
     * Getter method to get user's activities.
     * @return  activities: Activities
     */
    public Activities getActivities() {
        return activities;
    }






}
