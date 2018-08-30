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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
>>>>>>> d6a4db3... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> da734e9... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> 5810ac0... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> 939a15b... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
     * @param firstEntry: boolean True if first entry.
=======
//     * @param firstEntry: boolean True if first entry.
>>>>>>> f4dbc9a... Big ol fixing of parser and related things
=======
//     * @param firstEntry: boolean True if first entry.
>>>>>>> 7f65578... Big ol fixing of parser and related things
=======
//     * @param firstEntry: boolean True if first entry.
>>>>>>> 382449a... Big ol fixing of parser and related things
=======
//     * @param firstEntry: boolean True if first entry.
>>>>>>> 4efdce8... Big ol fixing of parser and related things
     * @param time: double Time field of the entry.
     * @param heartRate: double Heart rate field of the entry.
     * @param position: Position Position of the entry.
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
     * @param activity: Activity Activity field of the entry.
>>>>>>> d6a4db3... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
     * @param activity: Activity Activity field of the entry.
>>>>>>> da734e9... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
     * @param activity: Activity Activity field of the entry.
>>>>>>> 5810ac0... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
     * @param activity: Activity Activity field of the entry.
>>>>>>> 939a15b... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
        this.velocity = (this.distance - prevDistance)/((time.subtract(prevTime)));
>>>>>>> 7a666de... Modified Entry class and tests for it as datetime class was updated.
=======
        this.velocity = (this.distance - prevDistance)/((time.subtract(prevTime)));
>>>>>>> 4de7043... Modified Entry class and tests for it as datetime class was updated.
=======
        this.velocity = (this.distance - prevDistance)/((time.subtract(prevTime)));
>>>>>>> 8522a53... Modified Entry class and tests for it as datetime class was updated.
=======
        this.velocity = (this.distance - prevDistance)/((time.subtract(prevTime)));
>>>>>>> beae2e7... Modified Entry class and tests for it as datetime class was updated.
    }

    public String toString(){
        return ("First Entry? : " + this.firstEntry + " , " + position.toString());
    }
    /**
     * Getter method to get user's activities.
     * @return  activity: Activity
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


=======
>>>>>>> d6a4db3... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> da734e9... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> 5810ac0... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> 939a15b... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
}