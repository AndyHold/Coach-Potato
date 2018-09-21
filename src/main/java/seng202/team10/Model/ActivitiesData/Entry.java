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
    private double distance;
    private double velocity;


    /**
     * Override Method to get the string representation of an Entry.
     * @return String
     */
    @Override
    public String toString()
    {
        return "Entry{" +
                "firstEntry=" + firstEntry +
                ", time=" + time +
                ", heartRate=" + heartRate +
                ", position=" + position +
                ", distance=" + distance +
                ", velocity=" + velocity +
                '}';
    }

    /**
     * Constructor for the Entry.
     * @param time: double Time field of the entry.
     * @param heartRate: double Heart rate field of the entry.
     * @param position: Position Position of the entry.
     */
    public Entry(DateTime time, int heartRate, Position position)
    {
        setTime(time);
        setHeartRate(heartRate);
        setPosition(position);
    }


    /**
     * Method to set user's entry time.
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
        if ((0 < newHeartRate) && (newHeartRate <= 300)) {
            this.heartRate = newHeartRate;
        } else {
            throw new IllegalArgumentException("Heart Rate Invalid, must be between 1 & 300");
        }
    }


    /**
     * Method to set user's position.
     * @param position: Position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }


    /**
     * Method to set the current latitude of the entry
     * @param newLatitude double: latitude double
     * @throws IllegalArgumentException newLatitude does not represent a valid latitude
     */
    public void setLatitude(double newLatitude) throws IllegalArgumentException
    {
        this.position.setLatitude(newLatitude);
    }


    /**
     * Method to change the current longitude of the entry
     * @param newLongitude double: longitude double
     * @throws IllegalArgumentException newLongitude does not represent a valid longitude
     */
    public void setLongitude(double newLongitude) throws IllegalArgumentException
    {
        this.position.setLongitude(newLongitude);
    }


    /**
     * Method to set the current elevation of the entry (for GUI purposes)
     * @param newElevation double: elevation double
     * @throws NumberFormatException newElevation does not represent a valid elevation
     */
    public void setElevation(double newElevation) throws IllegalArgumentException
    {
        this.position.setElevation(newElevation);
    }


    /**
     * Method to set user's first entry.
     * @param firstEntry: boolean
     */
    public void setFirstEntry(boolean firstEntry)
    {
        this.firstEntry = firstEntry;
    }


    /**
     * Method to calculate user's distance.
     * @param prevEntry: Entry
     */
    public void calculateDistance(Entry prevEntry)
    {
        Position prevPosition = prevEntry.getPosition();
        this.distance = prevPosition.subtract(this.position);
    }


    /**
     * Method to calculate user's velocity.
     * @param prevEntry: Entry
     */
    public void calculateVelocity(Entry prevEntry)
    {
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance/time.subtract(prevTime));
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
     * Method to get user's entry time.
     * @return time: double
     */
    public DateTime getTime()
    {
        return time;
    }


    /**
     * Method to get user's heart rate.
     * @return heartRate: double
     */
    public int getHeartRate()
    {
        return heartRate;
    }


    /**
     * Method to get user's position.
     * @return position: Position
     */
    public Position getPosition()
    {
        return position;
    }


    /**
     * Method to get user's distance.
     * @return distance: double
     */
    public double getDistance()
    {
        return distance;
    }


    /**
     * Method to get user's velocity.
     * @return velocity: double
     */
    public double getVelocity()
    {
        return velocity;
    }


    /**
     * Method to check if it is user's first entry.
     * @return firstEntry: boolean
     */
    public boolean isFirstEntry()
    {
        return firstEntry;
    }


    /**
     * Method to get the string representation of the date.
     * @return String
     */
    public String getDateString()
    {
        return this.time.getDateAsString();
    }


    /**
     * Method to get the string representation of the time.
     * @return String
     */
    public String getTimeString()
    {
        return this.time.getTimeAsString();
    }


    /**
     * Method to get the string representation of an entry's heart rate.
     * @return String
     */
    public String getHeartRateString()
    {
        return String.valueOf(this.heartRate);
    }


    /**
     * Method to get the string representation of the latitude.
     * @return String
     */
    public String getLatitudeString()
    {
        return String.format("%.6f", this.position.getLatitude());
    }


    /**
     * Method to get the string representation of the longitude.
     * @return String
     */
    public String getLongitudeString()
    {
        return String.format("%.6f", this.position.getLongitude());
    }


    /**
     * Method to get the string representation of the elevation.
     * @return String
     */
    public String getElevationString()
    {
        return String.format("%.2f", this.position.getElevation());
    }


    /**
     * Method to get the string representation of the distance from the previous Entry.
     * @return String
     */
    public String getDistanceString()
    {
        return String.format("%.2f", this.getDistance());
    }


    /**
     * Method to get the string representation of the velocity at this Entry.
     * @return String
     */
    public String getVelocityString()
    {
        return String.format("%.2f", this.getVelocity());
    }


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

}