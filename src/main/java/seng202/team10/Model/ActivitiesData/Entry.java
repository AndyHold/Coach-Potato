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
        if ((0 < newHeartRate) && (newHeartRate <= 300)) {
            this.heartRate = newHeartRate;
        } else {
            throw new IllegalArgumentException("Heart Rate Invalid, must be between 1 & 300");
        }
    }


    /**
     * Setter method to set user's position.
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
     * Setter method to set user's first entry.
     * @param firstEntry: boolean
     */
    public void setFirstEntry(boolean firstEntry)
    {
        if (firstEntry) {
            this.velocity = 0.0;
        }
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
        double prevDistance = prevEntry.getDistance();
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance - prevDistance)/((time.subtract(prevTime)));
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
     * Getter method to get user's entry time.
     * @return time: double
     */
    public DateTime getTime()
    {
        return time;
    }


    /**
     * Getter method to get user's heart rate.
     * @return heartRate: double
     */
    public int getHeartRate()
    {
        return heartRate;
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
     * Getter method to check if it is user's first entry.
     * @return firstEntry: boolean
     */
    public boolean isFirstEntry()
    {
        return firstEntry;
    }


    /**
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
}