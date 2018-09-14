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


    /** Constructor method for Position Class
     * @param latitude double: Latitude for this position
     * @param longitude double: Longitude for this position
     * @param elevation double: Elevation for this position
     */
    public Position(double latitude, double longitude, double elevation)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }


    /**
     * Getter method to get user's latitude.
     * @return latitude: double
     */
    public double getLatitude()
    {
        return latitude;
    }


    /**
     * Setter method to set user's distance.
     * @param latitude: double
     */
    public void setLatitude(double latitude) throws IllegalArgumentException
    {
        if ((-90 <= latitude) && (latitude <= 90)) {
            this.latitude = latitude;
        } else {
            throw new IllegalArgumentException("Latitude Invalid, must be between -90 & 90");
        }
    }


    /**
     * Getter method to get user's longitude.
     * @return longitude: double
     */
    public double getLongitude()
    {
        return longitude;
    }


    /**
     * Setter method to set user's longitude.
     * @param longitude: double
     */
    public void setLongitude(double longitude) throws IllegalArgumentException
    {
        if ((-180 <= longitude) && (longitude <= 180)) {
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException("Longitude Invalid, must be between -180 & 180");
        }
    }


    /**
     * Getter method to get user's elevation.
     * @return elevation: double
     */
    public double getElevation()
    {
        return elevation;
    }


    /**
     * Setter method to set user's elevation.
     * @param elevation: double
     */
    public void setElevation(double elevation) throws IllegalArgumentException
    {
        if (elevation < 0) {
            throw new IllegalArgumentException("Elevation Invalid, must be a positive number");
        } else {
            this.elevation = elevation;
        }
    }


//    /**
//     * Subtract method calculates the distance between two positions.
//     * @param position: double
//     * @return distance: double
//     */
//    public double subtract(Position position)
//    {
//        //TODO Change this to calculate in meters
//        double latitudeDifference = position.getLatitude() - this.latitude;
//        double longitudeDifference = position.getLongitude() - this.longitude;
//        double elevationDifference = position.getElevation() - this.elevation;
//        return sqrt(pow(latitudeDifference, 2) + pow(longitudeDifference, 2) + pow(elevationDifference, 2));
//    }

    /**
     * Subtract method calculates the distance between two positions.
     * @param position: double
     * @return distance: double
     */
    public double subtract(Position position)
    {
        double polarX1 = this.elevation * cos(this.latitude) * sin(this.longitude);
        double polarY1 = this.elevation * sin(this.latitude);
        double polarZ1 = this.elevation * cos(this.latitude) * cos(this.longitude);

        double polarX2 = position.getElevation() * cos(position.getLatitude()) * sin(position.getLongitude());
        double polarY2 = position.getElevation() * sin(position.getLatitude());
        double polarZ2 = position.getElevation() * cos(position.getLatitude()) * cos(position.getLongitude());

        double polarXDifference = polarX2 - polarX1;
        double polarYDifference = polarY2 - polarY1;
        double polarZDifference = polarZ2 - polarZ1;
        return sqrt(pow(polarXDifference, 2) + pow(polarYDifference, 2) + pow(polarZDifference, 2));
    }

    public String toString()
    {
        return ("Latitude: " + this.latitude + ". Longitude: " + this.longitude + ". Elevation: " + this.elevation);
    }
}