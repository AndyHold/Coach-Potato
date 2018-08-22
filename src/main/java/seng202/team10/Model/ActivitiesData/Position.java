package seng202.team10.Model.ActivitiesData;



/**
 * Position Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class Position {

    private double latitude;
    private double longitude;
    private double elevation;


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
     * Setter method to set user's elevation.
     * @param position: double
     * @return double
     */
    public double subtract(Position position) {
        return latitude; // Check with the team about this
    }
}
