package seng202.team10.Model.ActivitiesData;


import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Position Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Position {

    private double latitude;
    private double longitude;
    private double elevation;


    /** Constructor method for Position Class
     * @param latitude double: Latitude forthis position
     * @param longitude double: Longitude for this position
     * @param elevation double: Elevation for this position
     */
    public Position(double latitude, double longitude, double elevation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    /**
     * Getter method to get user's latitude.
     * @return double
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Setter method to set user's distance.
     * @param latitude: double
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter method to get user's longitude.
     * @return double
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Setter method to set user's longitude.
     * @param longitude: double
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Getter method to get user's elevation.
     * @return double
     */
    public double getElevation() {
        return elevation;
    }

    /**
     * Setter method to set user's elevation.
     * @param elevation: double
     */
    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    /**
     * Subtract method calculates the distance between two positions.
     * @param position: double
     * @return double
     */
    public double subtract(Position position) {
        double latitudeDifference = position.getLatitude() - this.latitude;
        double longitudeDifference = position.getLongitude() - this.longitude;
        double elevationDifference = position.getElevation() - this.elevation;
        double distance = sqrt(pow(latitudeDifference, 2) + pow(longitudeDifference, 2) + pow(elevationDifference, 2));
        return distance;
    }
}