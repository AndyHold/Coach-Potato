package seng202.team10.Model.ActivitiesData;


import java.io.Serializable;


/**
 * Class that contains the data for an instance in time in an activity.
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
     * Constructor for the Entry.
     * @param time A <b>double</b> of the time field for the entry.
     * @param heartRate A <b>double</b> of the heart rate field for the entry.
     * @param position The <b>Position</b> of the entry.
     */
    public Entry(DateTime time, int heartRate, Position position) throws NullPointerException, IllegalArgumentException
    {
        setTime(time);
        setHeartRate(heartRate);
        setPosition(position);
    }


    /**
     * Method to set user's entry time.
     * @param time A <b>double</b> of the time of the entry.
     */
    public void setTime(DateTime time)
    {
        if (time != null) {
            this.time = time;
        } else {
            throw new NullPointerException("Time cannot be null");
        }
    }


    /**
     * Method to set the heart rate of the entry.
     * @param newHeartRate An <b>int</b> of the heart rate being set.
     * @throws IllegalArgumentException when the heart rate is not valid.
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
     * Method to set the position.
     * @param position A <b>Position</b> of the location for the entry.
     */
    public void setPosition(Position position)
    {
        if (position != null) {
            this.position = position;
        } else {
            throw new NullPointerException("Position cannot be null");
        }
    }


    /**
     * Method to set the latitude of the entry.
     * @param newLatitude A <b>Double</b> of the latitude being set.
     * @throws IllegalArgumentException when the latitude is not valid.
     */
    public void setLatitude(double newLatitude) throws IllegalArgumentException
    {
        this.position.setLatitude(newLatitude);
    }


    /**
     * Method to set the longitude of the entry.
     * @param newLongitude A <b>Double</b> of the longitude being set.
     * @throws IllegalArgumentException when the longitude is not valid.
     */
    public void setLongitude(double newLongitude) throws IllegalArgumentException
    {
        this.position.setLongitude(newLongitude);
    }


    /**
     * Method to set the elevation of the entry.
     * @param newElevation A <b>Double</b> of the elevation being set.
     * @throws IllegalArgumentException when the elevation is not valid.
     */
    public void setElevation(double newElevation) throws IllegalArgumentException
    {
        this.position.setElevation(newElevation);
    }


    /**
     * Method to set the first entry.
     * @param firstEntry <b>true</b> when the entry is first in the activity, <b>false</b> otherwise.
     */
    public void setFirstEntry(boolean firstEntry)
    {
        this.firstEntry = firstEntry;
    }


    /**
     * Method to calculate user's distance.
     * @param prevEntry The previous <b>Entry</b> in the activity this entry is in.
     */
    public void calculateDistance(Entry prevEntry)
    {
        Position prevPosition = prevEntry.getPosition();
        distance = prevPosition.subtract(position);
    }


    /**
     * Method to calculate user's velocity.
     * @param prevEntry The previous <b>Entry</b> in the activity this entry is in.
     */
    public void calculateVelocity(Entry prevEntry)
    {
        DateTime prevTime = prevEntry.getTime();
        this.velocity = (this.distance/time.subtract(prevTime));
    }


    /**
     * Method to change the date of the entry.
     * @param newDate A <b>String</b> representation of a date.
     * @throws IllegalArgumentException when the date is invalid.
     */
    public void changeDate(String newDate) throws IllegalArgumentException
    {
        String[] dateArray = newDate.split("/");
        int day = Integer.valueOf(dateArray[0]);
        int month = Integer.valueOf(dateArray[1]);
        int year = Integer.valueOf(dateArray[2]);
        DateTime newDateTime = new DateTime(year, month, day, time.getHour(), time.getMinute(), time.getSecond());
        if (newDateTime.isAfter(DateTime.now())) {
            throw new IllegalArgumentException("You cannot edit entry points to be in the future.");
        }
        time.changeDate(year, month, day);
    }


    /**
     * Method to change the time of the entry.
     * @param newTime A <b>String</b> representation of a time.
     * @throws IllegalArgumentException when the time is invalid.
     */
    public void changeTime(String newTime) throws IllegalArgumentException
    {
        String[] timeArray = newTime.split(":");
        int hour = Integer.valueOf(timeArray[0]);
        int minute = Integer.valueOf(timeArray[1]);
        int second = Integer.valueOf(timeArray[2]);
        this.time.changeTime(hour, minute, second);
    }


    /**
     * Getter for the date and time of the entry.
     * @return A <b>DateTime</b> of the date and time of the entry.
     */
    public DateTime getTime()
    {
        return time;
    }


    /**
     * Getter for the heart rate of the entry.
     * @return A <b>Double</b> of the heart rate of the entry.
     */
    public int getHeartRate()
    {
        return heartRate;
    }


    /**
     * Getter for the position of the entry.
     * @return A <b>Position</b> of the location of the entry.
     */
    public Position getPosition()
    {
        return position;
    }


    /**
     * Getter for the distance of the entry.
     * @return A <b>Double</b> of the distance of the entry.
     */
    public double getDistance()
    {
        return distance;
    }


    /**
     * Getter for the velocity of the entry.
     * @return A <b>Double</b> of the velocity of the entry.
     */
    public double getVelocity()
    {
        return velocity;
    }


    /**
     * Method to check if it is user's first entry.
     * @return <b>true</b> when the entry is first in the activity, <b>false</b> otherwise.
     */
    public boolean isFirstEntry()
    {
        return firstEntry;
    }


    /**
     * Getter for the string representation of the date.
     * @return A <b>String</b> of the date of the entry.
     */
    public String getDateString()
    {
        return this.time.getDateAsString();
    }


    /**
     * Getter for the string representation of the time.
     * @return A <b>String</b> of the time of the entry.
     */
    public String getTimeString()
    {
        return this.time.getTimeAsString();
    }


    /**
     * Getter for the string representation the heart rate.
     * @return A <b>String</b> of the heart rate of the entry.
     */
    public String getHeartRateString()
    {
        return String.valueOf(this.heartRate);
    }


    /**
     * Getter for the string representation of the latitude.
     * @return A <b>String</b> of the latitude of the entry.
     */
    public String getLatitudeString()
    {
        return String.format("%.6f", this.position.getLatitude());
    }


    /**
     * Getter for the string representation of the longitude.
     * @return A <b>String</b> of the longitude of the entry.
     */
    public String getLongitudeString()
    {
        return String.format("%.6f", this.position.getLongitude());
    }


    /**
     * Getter for the string representation of the elevation.
     * @return A <b>String</b> of the elevation of the entry.
     */
    public String getElevationString()
    {
        return String.format("%.2f", this.position.getElevation());
    }


    /**
     * Getter for the string representation of the distance from the previous Entry.
     * @return A <b>String</b> of the distance of the entry.
     */
    public String getDistanceString()
    {
        return String.format("%.2f", this.getDistance());
    }


    /**
     * Getter for the string representation of the velocity at this Entry.
     * @return A <b>String</b> of the velocity of the entry.
     */
    public String getVelocityString()
    {
        return String.format("%.2f", this.getVelocity());
    }


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
}