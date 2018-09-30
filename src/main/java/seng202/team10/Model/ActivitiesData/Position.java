package seng202.team10.Model.ActivitiesData;


import java.io.Serializable;

import static java.lang.Math.*;


/**
 * Position Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Position  implements Serializable {

    private double latitude;
    private double longitude;
    private double elevation;


    /** Constructor method for Position Class.
     * @param latitude double: Latitude for this position
     * @param longitude double: Longitude for this position
     * @param elevation double: Elevation for this position
     */
    public Position(double latitude, double longitude, double elevation) throws IllegalArgumentException
    {
        setLatitude(latitude);
        setLongitude(longitude);
        setElevation(elevation);
    }


    /**
     * Setter method to set user's distance.
     * @param latitude: double
     */
    protected void setLatitude(double latitude) throws IllegalArgumentException
    {
        if ((-90.0 <= latitude) && (latitude <= 90.0)) {
            this.latitude = latitude;
        } else {
            throw new IllegalArgumentException("Latitude Invalid, must be between -90 & 90");
        }
    }


    /**
     * Setter method to set user's longitude.
     * @param longitude: double
     */
    protected void setLongitude(double longitude) throws IllegalArgumentException
    {
        if ((-180 <= longitude) && (longitude <= 180)) {
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException("Longitude Invalid, must be between -180 & 180");
        }
    }


    /**
     * Setter method to set user's elevation.
     * @param elevation: double
     */
    protected void setElevation(double elevation) throws IllegalArgumentException
    {
        if (-430.0 <= elevation && elevation <= 8850.0) {
            this.elevation = elevation;
        } else {
            throw new IllegalArgumentException("Elevation Invalid, must be above 430 meters below sea level and below 8850 meters above sea level");
        }
    }


    /**
     * Getter method to get user's latitude.
     * @return latitude: double
     */
    public double getLatitude()
    {
        return this.latitude;
    }


    /**
     * Getter method to get user's longitude.
     * @return longitude: double
     */
    public double getLongitude()
    {
        return longitude;
    }


<<<<<<< HEAD
    /**
     * Getter method to get user's elevation.
     * @return elevation: double
     */
    public double getElevation()
    {
        return elevation;
    }


=======
<<<<<<< HEAD
>>>>>>> 0b144cca... Got the correct Distance formula working and all good to go.
=======
>>>>>>> ad6d5c5... Got the correct Distance formula working and all good to go.
>>>>>>> 24e2cd90... Got the correct Distance formula working and all good to go.
    /**
     * Subtract method calculates the distance between two positions.
     * @param position: double
     * @return distance: double
     */
    public double subtract(Position position)
    {
        final double radiusOfEarth = 6371e3;
        double latitudeDifference = Math.toRadians(position.getLatitude()) - Math.toRadians(this.latitude);
        double longitudeDifference = Math.toRadians(position.getLongitude()) - Math.toRadians(this.longitude);
        double elevationDifference = position.getElevation() - this.elevation;

        double answer = sin(latitudeDifference/2) * sin(latitudeDifference/2) +
                cos(Math.toRadians(this.latitude)) * cos(Math.toRadians(position.getLatitude())) *
                sin(longitudeDifference/2) * sin(longitudeDifference/2) ;

        double answer2 = 2 * atan2(sqrt(answer), sqrt(1-answer));
        double dist = (radiusOfEarth * answer2);
        return sqrt(pow(dist, 2) + pow(elevationDifference, 2));
    }


    /**
     * Method to print a Position as a string.
     * @return string
     */
    public String toString()
    {
        return ("Latitude: " + this.latitude + ", Longitude: " + this.longitude + ", Elevation: " + this.elevation);
    }
}