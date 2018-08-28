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
    private double distance = 0;
    private double velocity = 0;
    private Activity activity;

    /**
     * Constructor for the Entry.
     * @param firstEntry True if first entry.
     * @param time Time field of the entry.
     * @param heartRate Heart rate field of the entry.
     * @param position Position of the entry.
     * @param activity Activity field of the entry.
     */
    public Entry(boolean firstEntry, double time, double heartRate, Position position, Activity activity) {
        this.firstEntry = firstEntry;
        this.time = time;
        this.heartRate = heartRate;
        this.position = position;
        this.activity = activity;
    }

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
     * @param prevEntry: Entry
     */
    public void calculateDistance(Entry prevEntry) {
        Position prevPosition = prevEntry.getPosition();
        this.distance = prevPosition.subtract(this.position);
    }

    /**
     * Getter method to get user's velocity.
     * @return double
     */
    public double getVelocity(Entry prevEntry) {
        return velocity;
    }

    /**
     * Method to calculate user's velocity.
     * @param prevEntry: Entry
     */
    public void calculateVelocity(Entry prevEntry) {
        double prevDistance = prevEntry.getDistance();
        double prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/(this.time-prevTime);
    }

    /**
     * Getter method to get user's activities.
     * @return  activities: Activities
     */
    public Activity getActivity() {
        return activity;
    }






}