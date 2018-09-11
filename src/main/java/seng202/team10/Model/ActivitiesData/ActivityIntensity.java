package seng202.team10.Model.ActivitiesData;


/**
 * ActivityIntensity Enum for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public enum ActivityIntensity {
    LOW, MEDIUM, HIGH;


    /**
     * Method to get an ActivityIntensity type for a string
     * @param intensityString String: String representation of the type requested
     * @return ActivityIntensity
     * @throws IllegalArgumentException if invalid string was entered as an argument
     */
    public static ActivityIntensity getIntensityFromString(String intensityString) throws IllegalArgumentException
    {
        if (intensityString.equals("Low")) {
            return ActivityIntensity.LOW;
        } else if (intensityString.equals("Medium")) {
            return ActivityIntensity.MEDIUM;
        } else if (intensityString.equals("High")) {
            return ActivityIntensity.HIGH;
        } else {
            throw new IllegalArgumentException("Invalid Activity Intensity Selected, Please Try Again");
        }
    }
}
