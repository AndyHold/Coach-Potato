package seng202.team10.Model.ActivitiesData;


import java.io.Serializable;


/**
 * Entry Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Entry  implements Serializable {


    private boolean firstEntry;
    private DateTime time;
    private int heartRate;
    private Position position;
    private double distance = 0;
    private double velocity = 0;
<<<<<<< HEAD

=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    //private Activity activity;
=======

>>>>>>> 173bfae... Refactored Activity Class to delete some redundant code, fixed Activity class created a ActivityTypeTest class and implemented tests for it. Wrote some more tests for DateTime's new change methods, wrote some tests for the Position class.
>>>>>>> d15fa3f6... Refactored Activity Class to delete some redundant code, fixed Activity class created a ActivityTypeTest class and implemented tests for it. Wrote some more tests for DateTime's new change methods, wrote some tests for the Position class.

    /**
     * Constructor for the Entry.
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
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
>>>>>>> 0c709513... Changed latitude and longitude error checking in Position class and removed unnecessary lines from Entry class.
     * @param firstEntry True if first entry.
     * @param time Time field of the entry.
     * @param heartRate Heart rate field of the entry.
     * @param position Position of the entry.
     * @param activity Activity field of the entry.
=======
=======
>>>>>>> 939a15b8... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
     * @param firstEntry: boolean True if first entry.
=======
//     * @param firstEntry: boolean True if first entry.
<<<<<<< HEAD
>>>>>>> 4efdce81... Big ol fixing of parser and related things
=======
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
=======
>>>>>>> 863c0ab... Working on some updates to dataUpload screen, had to change the constructor for the entry Class too.
>>>>>>> 9df8089c... Working on some updates to dataUpload screen, had to change the constructor for the entry Class too.
     * @param time: double Time field of the entry.
     * @param heartRate: double Heart rate field of the entry.
     * @param position: Position Position of the entry.
<<<<<<< HEAD
     * //@param activity: Activity Activity field of the entry.
<<<<<<< HEAD
>>>>>>> f5029c7d... No changes made
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> b7e8ef2... No changes made
     */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
=======
     */
<<<<<<< HEAD
    public Entry(boolean firstEntry, double time, double heartRate, Position position, Activity activity) {
>>>>>>> e576ec5... No changes made
=======
     */
<<<<<<< HEAD
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
>>>>>>> 79c9f1d... No changes made
=======
>>>>>>> 9df8089c... Working on some updates to dataUpload screen, had to change the constructor for the entry Class too.
=======
     * @param activity: Activity Activity field of the entry.
<<<<<<< HEAD
>>>>>>> 939a15b8... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> 939a15b... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
     * @param firstEntry: boolean True if first entry.
     * @param time: double Time field of the entry.
     * @param heartRate: double Heart rate field of the entry.
     * @param position: Position Position of the entry.
>>>>>>> f947029... Changed latitude and longitude error checking in Position class and removed unnecessary lines from Entry class.
     */
    public Entry(boolean firstEntry, double time, double heartRate, Position position, Activity activity) {
>>>>>>> 5a3c8cd... No changes made
=======
=======
     * @param firstEntry: boolean True if first entry.
     * @param time: double Time field of the entry.
     * @param heartRate: double Heart rate field of the entry.
     * @param position: Position Position of the entry.
>>>>>>> cd4ab4b... Changed latitude and longitude error checking in Position class and removed unnecessary lines from Entry class.
     */
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
>>>>>>> 7de2265... No changes made
=======
     */
    public Entry(boolean firstEntry, double time, double heartRate, Position position, Activity activity) {
>>>>>>> 3c6c4ff... No changes made
>>>>>>> 0c709513... Changed latitude and longitude error checking in Position class and removed unnecessary lines from Entry class.
=======
<<<<<<< HEAD
     * @param firstEntry: boolean True if first entry.
=======
     */
<<<<<<< HEAD
    public Entry(boolean firstEntry, DateTime time, double heartRate, Position position) {
>>>>>>> f5029c7... No changes made
=======
    public Entry(boolean firstEntry, DateTime time, int heartRate, Position position) {
>>>>>>> b21c354... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
    public Entry(boolean firstEntry, DateTime time, int heartRate, Position position) {
>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
>>>>>>> d15fa3f6... Refactored Activity Class to delete some redundant code, fixed Activity class created a ActivityTypeTest class and implemented tests for it. Wrote some more tests for DateTime's new change methods, wrote some tests for the Position class.
=======
<<<<<<< HEAD
>>>>>>> 4e355c0c... Working on some updates to dataUpload screen, had to change the constructor for the entry Class too.
     * @param time: double Time field of the entry.
     * @param heartRate: double Heart rate field of the entry.
     * @param position: Position Position of the entry.
>>>>>>> 793f578b... Changed latitude and longitude error checking in Position class and removed unnecessary lines from Entry class.
     */
    public Entry(DateTime time, int heartRate, Position position) {
=======
    public Entry(boolean firstEntry, DateTime time, int heartRate, Position position) {
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
        this.firstEntry = firstEntry;
=======
    public Entry(DateTime time, int heartRate, Position position) {
>>>>>>> 863c0ab... Working on some updates to dataUpload screen, had to change the constructor for the entry Class too.
<<<<<<< HEAD
>>>>>>> 9df8089c... Working on some updates to dataUpload screen, had to change the constructor for the entry Class too.
=======
    public Entry(DateTime time, int heartRate, Position position)
    {
<<<<<<< HEAD
>>>>>>> 24c904e8... Refactored Activity Class to delete some redundant code, fixed Activity class created a ActivityTypeTest class and implemented tests for it. Wrote some more tests for DateTime's new change methods, wrote some tests for the Position class.
=======
=======
    public Entry(DateTime time, int heartRate, Position position)
    {
=======
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
<<<<<<< HEAD
>>>>>>> 173bfae... Refactored Activity Class to delete some redundant code, fixed Activity class created a ActivityTypeTest class and implemented tests for it. Wrote some more tests for DateTime's new change methods, wrote some tests for the Position class.
>>>>>>> d15fa3f6... Refactored Activity Class to delete some redundant code, fixed Activity class created a ActivityTypeTest class and implemented tests for it. Wrote some more tests for DateTime's new change methods, wrote some tests for the Position class.
        this.time = time;
        this.heartRate = heartRate;
        this.position = position;
<<<<<<< HEAD
        setStrings();
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
        setStrings();
>>>>>>> 5a8b62d... Modified table in Data Upload Screen so that it can edit values and input entries. Code is messy but works so will require a refactor
=======
        setStrings();
<<<<<<< HEAD
>>>>>>> c4550eb... Modified table in Data Upload Screen so that it can edit values and input entries. Code is messy but works so will require a refactor
=======
        setStrings();
>>>>>>> 5395118... Modified table in Data Upload Screen so that it can edit values and input entries. Code is messy but works so will require a refactor
        //this.activity = activity;
>>>>>>> 7de2265... No changes made
=======
        this.activity = activity;
>>>>>>> 3c6c4ff... No changes made
=======
=======
        setStrings();
<<<<<<< HEAD
>>>>>>> b4179b8... Modified table in Data Upload Screen so that it can edit values and input entries. Code is messy but works so will require a refactor
        //this.activity = activity;
>>>>>>> f5029c7... No changes made
=======
>>>>>>> cd4ab4b... Changed latitude and longitude error checking in Position class and removed unnecessary lines from Entry class.
=======
        setTime(time);
        setHeartRate(heartRate);
        setPosition(position);
>>>>>>> 4774d9b... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
     * Setter method to set user's entry time.
     * @param time: double
     */
    public void setTime(DateTime time)
    {
<<<<<<< HEAD
        this.dateString = this.time.getDate();
        this.timeString = this.time.getTime();
        this.heartRateString = String.valueOf(this.heartRate);
        this.latitudeString = String.format("%.8f", this.position.getLatitude());
        this.longitudeString = String.format("%.8f", this.position.getLongitude());
        this.elevationString = String.valueOf(this.position.getElevation());
    }


    /**
<<<<<<< HEAD
<<<<<<< HEAD
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
    public void changeHeartRate(String newHeartRate) throws IllegalArgumentException
    {
        if ((0 < heartRate) && (heartRate <= 300)) {
            this.heartRate = Integer.valueOf(newHeartRate);
        } else {
            throw new IllegalArgumentException("Heart Rate Invalid, must be between 1 & 300");
        }
=======
>>>>>>> f947029... Changed latitude and longitude error checking in Position class and removed unnecessary lines from Entry class.
>>>>>>> 0c709513... Changed latitude and longitude error checking in Position class and removed unnecessary lines from Entry class.
=======
        setTime(time);
        setHeartRate(heartRate);
        setPosition(position);
>>>>>>> dfa015a9... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
     * Setter method to set user's entry time.
     * @param time: double
     */
    public void setTime(DateTime time)
    {
        this.time = time;
    }


    /**
     * Method to set the current heart rate of the entry
     * @param newHeartRate int: heart rate int
     * @throws IllegalArgumentException newHeartRate is not a valid heart rate.
     */
    public void setHeartRate(int newHeartRate) throws IllegalArgumentException
    {
<<<<<<< HEAD
<<<<<<< HEAD
        if ((0 < heartRate) && (heartRate <= 300)) {
=======
        if ((0 < newHeartRate) && (newHeartRate <= 300)) {
>>>>>>> a05ec57b... Fixed a small bug in the setHeartRate method to fix the pipeline.
            this.heartRate = newHeartRate;
        } else {
            throw new IllegalArgumentException("Heart Rate Invalid, must be between 1 & 300");
        }
=======
        this.dateString = this.time.getDateAsString();
        this.timeString = this.time.getTimeAsString();
        this.heartRateString = String.valueOf(this.heartRate);
        this.latitudeString = String.format("%.8f", this.position.getLatitude());
        this.longitudeString = String.format("%.8f", this.position.getLongitude());
        this.elevationString = String.valueOf(this.position.getElevation());
=======
        this.time = time;
>>>>>>> 4774d9b... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Setter method to set user's position.
     * @param position: Position
     */
    public void setPosition(Position position)
    {
        this.position = position;
=======
     * Method to set the current heart rate of the entry
     * @param newHeartRate int: heart rate int
     * @throws IllegalArgumentException newHeartRate is not a valid heart rate.
     */
    public void setHeartRate(int newHeartRate) throws IllegalArgumentException
    {
        if ((0 < heartRate) && (heartRate <= 300)) {
            this.heartRate = newHeartRate;
        } else {
            throw new IllegalArgumentException("Heart Rate Invalid, must be between 1 & 300");
        }
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Method to set the current latitude of the entry
     * @param newLatitude double: latitude double
     * @throws IllegalArgumentException newLatitude does not represent a valid latitude
     */
    public void setLatitude(double newLatitude) throws IllegalArgumentException
    {
        this.position.setLatitude(newLatitude);
=======
     * Setter method to set user's position.
     * @param position: Position
     */
    public void setPosition(Position position)
    {
        this.position = position;
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Method to change the current longitude of the entry
     * @param newLongitude double: longitude double
     * @throws IllegalArgumentException newLongitude does not represent a valid longitude
     */
    public void setLongitude(double newLongitude) throws IllegalArgumentException
    {
        this.position.setLongitude(newLongitude);
=======
     * Method to set the current latitude of the entry
     * @param newLatitude double: latitude double
     * @throws IllegalArgumentException newLatitude does not represent a valid latitude
     */
    public void setLatitude(double newLatitude) throws IllegalArgumentException
    {
        this.position.setLatitude(newLatitude);
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Method to set the current elevation of the entry (for GUI purposes)
     * @param newElevation double: elevation double
     * @throws NumberFormatException newElevation does not represent a valid elevation
     */
    public void setElevation(double newElevation) throws IllegalArgumentException
    {
        this.position.setElevation(newElevation);
=======
     * Method to change the current longitude of the entry
     * @param newLongitude double: longitude double
     * @throws IllegalArgumentException newLongitude does not represent a valid longitude
     */
    public void setLongitude(double newLongitude) throws IllegalArgumentException
    {
        this.position.setLongitude(newLongitude);
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Setter method to set user's first entry.
     * @param firstEntry: boolean
     */
    public void setFirstEntry(boolean firstEntry)
    {
        if (firstEntry) {
            this.velocity = 0.0;
        }
        this.firstEntry = firstEntry;
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> b4179b8... Modified table in Data Upload Screen so that it can edit values and input entries. Code is messy but works so will require a refactor
=======
>>>>>>> c4550eb... Modified table in Data Upload Screen so that it can edit values and input entries. Code is messy but works so will require a refactor
=======
>>>>>>> 5395118... Modified table in Data Upload Screen so that it can edit values and input entries. Code is messy but works so will require a refactor
     * Method to change the current longitude of the entry (for GUI purposes)
     * @param newLongitude String: String representation of the heart rate double
     * @throws NumberFormatException String does not represent a number
=======
     * Method to set the current elevation of the entry (for GUI purposes)
     * @param newElevation double: elevation double
     * @throws NumberFormatException newElevation does not represent a valid elevation
>>>>>>> 4774d9b... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
     */
    public void setElevation(double newElevation) throws IllegalArgumentException
    {
        this.position.setElevation(newElevation);
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Method to calculate user's distance.
     * @param prevEntry: Entry
     */
    public void calculateDistance(Entry prevEntry)
    {
        Position prevPosition = prevEntry.getPosition();
        this.distance = prevPosition.subtract(this.position);
=======
     * Setter method to set user's first entry.
     * @param firstEntry: boolean
     */
    public void setFirstEntry(boolean firstEntry)
    {
        if (firstEntry) {
            this.velocity = 0.0;
        }
        this.firstEntry = firstEntry;
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Method to calculate user's velocity.
     * @param prevEntry: Entry
     */
    public void calculateVelocity(Entry prevEntry)
    {
        double prevDistance = prevEntry.getDistance();
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/((time.subtract(prevTime)));
=======
     * Method to calculate user's distance.
     * @param prevEntry: Entry
     */
    public void calculateDistance(Entry prevEntry)
    {
        Position prevPosition = prevEntry.getPosition();
        this.distance = prevPosition.subtract(this.position);
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
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
=======
     * Method to calculate user's velocity.
     * @param prevEntry: Entry
     */
    public void calculateVelocity(Entry prevEntry)
    {
        double prevDistance = prevEntry.getDistance();
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/((time.subtract(prevTime)));
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
     * Method to change the current date of the entry (for GUI purposes)
<<<<<<< HEAD
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
=======
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
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Getter method to get user's entry time.
     * @return time: double
     */
    public DateTime getTime()
    {
        return time;
=======
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
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Getter method to get user's heart rate.
     * @return heartRate: double
     */
    public int getHeartRate()
    {
        return heartRate;
=======
     * Getter method to get user's entry time.
     * @return time: double
     */
    public DateTime getTime()
    {
        return time;
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
<<<<<<< HEAD
     * Getter method to get user's position.
     * @return position: Position
     */
    public Position getPosition()
    {
        return position;
=======
     * Getter method to get user's heart rate.
     * @return heartRate: double
     */
    public int getHeartRate()
    {
        return heartRate;
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    }


    /**
     * Getter method to get user's position.
     * @return position: Position
     */
    public Position getPosition()
    {
        return position;
    }


    /**
<<<<<<< HEAD
=======
     * Getter method to check if it is user's first entry.
     * @return firstEntry: boolean
     */
    public boolean isFirstEntry()
    {
        return firstEntry;
    }


    /**
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
     * Getter method for the String representation of the date
     */
    public String getDateString()
    {
        return this.time.getDateAsString();
    }


    /**
     * Getter method for the String representation of the time
     */
    public String getTimeString()
    {
        return this.time.getTimeAsString();
    }


    /**
     * Getter method for the String representation of the Heart Rate
     * @return String
     */
    public String getHeartRateString()
    {
        return String.valueOf(this.heartRate);
    }


    /**
     * Getter method for the String representation of the latitude
     */
    public String getLatitudeString()
    {
        return String.format("%.6f", this.position.getLatitude());
    }


    /**
     * Getter method for the String representation of the longitude
     */
    public String getLongitudeString()
    {
        return String.format("%.6f", this.position.getLongitude());
    }


    /**
     * Getter method for the String representation of the elevation
     */
    public String getElevationString()
    {
        return String.format("%.2f", this.position.getElevation());
    }


    /**
     * Getter method to get user's distance.
     * @return distance: double
     */
    public double getDistance()
    {
        return distance;
    }


    /**
     * Getter method to get user's velocity.
     * TODO Torben can create a graph for this attribute now.
     * @return velocity: double
     */
    public double getVelocity()
    {
        return velocity;
    }


<<<<<<< HEAD
=======
<<<<<<< HEAD
    /**
     * Method to calculate user's velocity.
     * @param prevEntry: Entry
     */
    public void calculateVelocity(Entry prevEntry)
    {
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


=======
>>>>>>> 4774d9b... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
>>>>>>> 04fec49c... DateTime now has 100% test coverage, refactored Activity and Entry to make them more readable and got rid of unnecessary String attributes and had them be derived when asked for in the getter method instead. This will make it easier when the values are changed. Implemented the calculateVelocity method in Entry and the calculateEntriesVelocity method in Activity properly so that the data can now be used for graphing.
    //THE FOLLOWING METHOD WAS AN ATTEMPT TO INTERPOLATE, LEAVING IT HERE JUST IN CASE BUT WILL TRY INTERPOLATION IN DATAANALYSIS
    // TODO how did this end up??? Can we use more two or three entries either side if possible???

//    /**
//     * Method to find the average of two entries. Assumes that the year and the month are the same.
//     * @param otherEntry  Is the entry directly after this entry.
//     * @return An entry that will be slotted between this entry and other entry.
//     */
//    public Entry getAverageEntry(Entry otherEntry)
//        {
//
//        int timeDifference = otherEntry.getTime().subtract(this.time);
//        DateTime averageTime = this.time.
//        int averageHeartRate = (this.heartRate + otherEntry.getHeartRate()) / 2;
//
//        double averageLatitude = (this.getPosition().getLatitude() - otherEntry.getPosition().getLatitude()) / 2;
//        double averageLongitude = (this.getPosition().getLongitude() - otherEntry.getPosition().getLongitude()) / 2;
//        double averageElevation = (this.getPosition().getElevation() - otherEntry.getPosition().getElevation()) / 2;
//        Position averagePosition = new Position(averageLatitude, averageLongitude, averageElevation);
//
//        return new Entry(false, averageTime, averageHeartRate, averagePosition);
//    }


    @Override
    public String toString()
    {
        return ("First Entry? : " + this.firstEntry + " , " + position.toString());
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.


//    /**
//     * Getter method to get user's activities.
//     * @return  activity: Activity
//     */
//    // Commented out as we don't need it for now but might need it later.
//    public Activity getActivity() {
//        return activity;
//    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> b21c354... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.


=======
>>>>>>> d6a4db3... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> da734e9... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> 5810ac0... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======
>>>>>>> 939a15b... Minor changes for Javadoc for Entry and Position classes. Had to push before I pull.
=======


>>>>>>> c64d7f7... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
=======
>>>>>>> 73cd156... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.


>>>>>>> 40229ad... Finished Upload Data Screen, complete with error messages and full functionality. One Error will need to be modified but need to speak to team about it first. Changed heart rate from a double to an int. Made some changes to Parser, Activity, DateTime, Entry and Position to get it working.
=======
>>>>>>> 173bfae... Refactored Activity Class to delete some redundant code, fixed Activity class created a ActivityTypeTest class and implemented tests for it. Wrote some more tests for DateTime's new change methods, wrote some tests for the Position class.
>>>>>>> d15fa3f6... Refactored Activity Class to delete some redundant code, fixed Activity class created a ActivityTypeTest class and implemented tests for it. Wrote some more tests for DateTime's new change methods, wrote some tests for the Position class.
}