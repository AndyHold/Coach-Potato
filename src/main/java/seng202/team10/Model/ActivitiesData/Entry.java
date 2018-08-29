package seng202.team10.Model.ActivitiesData;



/**
 * Entry Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Entry {

    private boolean firstEntry;
    private DateTime time;
    private double heartRate;
    private Position position;
    private double distance = 0;
    private double velocity = 0;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    //private Activity activity;

    /**
     * Constructor for the Entry.
<<<<<<< HEAD
=======
    private Activity activity;
=======
    //private Activity activity;
>>>>>>> 79c9f1d... No changes made
=======
    //private Activity activity;
>>>>>>> 7de2265... No changes made

    /**
     * Constructor for the Entry.
>>>>>>> e576ec5... No changes made
=======
=======
>>>>>>> 3c6c4ff... No changes made
    private Activity activity;
=======
    //private Activity activity;
>>>>>>> f5029c7... No changes made

    /**
     * Constructor for the Entry.
<<<<<<< HEAD
>>>>>>> 5a3c8cd... No changes made
=======
>>>>>>> 3c6c4ff... No changes made
     * @param firstEntry True if first entry.
     * @param time Time field of the entry.
     * @param heartRate Heart rate field of the entry.
     * @param position Position of the entry.
     * @param activity Activity field of the entry.
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
     * @param firstEntry: boolean True if first entry.
     * @param time: double Time field of the entry.
     * @param heartRate: double Heart rate field of the entry.
     * @param position: Position Position of the entry.
     * //@param activity: Activity Activity field of the entry.
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> b7e8ef2... No changes made
     */
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
=======
     */
    public Entry(boolean firstEntry, double time, double heartRate, Position position, Activity activity) {
>>>>>>> e576ec5... No changes made
=======
     */
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
>>>>>>> 79c9f1d... No changes made
=======
     */
    public Entry(boolean firstEntry, double time, double heartRate, Position position, Activity activity) {
>>>>>>> 5a3c8cd... No changes made
=======
     */
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
>>>>>>> 7de2265... No changes made
=======
     */
    public Entry(boolean firstEntry, double time, double heartRate, Position position, Activity activity) {
>>>>>>> 3c6c4ff... No changes made
=======
     */
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
>>>>>>> f5029c7... No changes made
        this.firstEntry = firstEntry;
        this.time = time;
        this.heartRate = heartRate;
        this.position = position;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        //this.activity = activity;
=======
        this.activity = activity;
>>>>>>> e576ec5... No changes made
=======
        //this.activity = activity;
>>>>>>> 79c9f1d... No changes made
=======
        this.activity = activity;
>>>>>>> 5a3c8cd... No changes made
=======
        //this.activity = activity;
>>>>>>> 7de2265... No changes made
=======
        this.activity = activity;
>>>>>>> 3c6c4ff... No changes made
=======
        //this.activity = activity;
>>>>>>> f5029c7... No changes made
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/((time.getMinute()-prevTime.getMinute())*60);
=======
        double prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/(this.time-prevTime);
>>>>>>> e576ec5... No changes made
=======
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/((time.getMinute()-prevTime.getMinute())*60);
>>>>>>> 79c9f1d... No changes made
=======
        double prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/(this.time-prevTime);
>>>>>>> 5a3c8cd... No changes made
=======
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/((time.getMinute()-prevTime.getMinute())*60);
>>>>>>> 7de2265... No changes made
=======
        double prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/(this.time-prevTime);
>>>>>>> 3c6c4ff... No changes made
=======
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/((time.getMinute()-prevTime.getMinute())*60);
>>>>>>> f5029c7... No changes made
    }

    /**
     * Getter method to get user's activities.
     * @return  activities: Activities
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 79c9f1d... No changes made
=======
>>>>>>> 7de2265... No changes made
=======
>>>>>>> f5029c7... No changes made
    // Commented out as we don't need it for now but might need it later.
    //public Activity getActivity() {
    //    return activity;
    //}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 5a3c8cd... No changes made
=======
>>>>>>> 3c6c4ff... No changes made
    public Activity getActivity() {
        return activity;
    }
>>>>>>> e576ec5... No changes made




=======
>>>>>>> 79c9f1d... No changes made
=======
>>>>>>> 7de2265... No changes made
=======
>>>>>>> f5029c7... No changes made


}