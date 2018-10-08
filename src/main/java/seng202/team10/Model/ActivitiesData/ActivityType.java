package seng202.team10.Model.ActivitiesData;


import java.io.Serializable;


/**
 * Enum for the intensity level of an activity, measured by type of activity.
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public enum ActivityType implements Serializable {
    WALK("Walk"), RUN("Run"), HIKE("Hike"), CYCLE("Cycle"), SWIM("Swim"), WORKOUT("Workout"), OTHER("Other");


    private String name;


    /**
     * Constructor method for ActivityType Enum.
     * @param newName A <b>String</b> representation of the type.
     */
    ActivityType(String newName)
    {
        this.name = newName;
    }


    /**
     * Method to determine and return the type of the activity based on the name string.
     * Possible types are walk, run, hike, cycle, swim, workout and other.
     * @param name  A <b>String</b> of the name of the activity.
     * @return An <b>ActivityType</b>.
     * */
    public static ActivityType determineType(String name)
    {
        String lowerName = name.toLowerCase();
        ActivityType type;
        if (lowerName.contains("hike") || lowerName.contains("hiking")) {
            type = ActivityType.HIKE;
        } else if (lowerName.contains("swim")) {
            type = ActivityType.SWIM;
        } else if (lowerName.contains("run") || lowerName.contains("jog")) {
            type = ActivityType.RUN;
        } else if (lowerName.contains("cycle") || lowerName.contains("cycling") || lowerName.contains("bike") ||
                   lowerName.contains("biking")) {
            type = ActivityType.CYCLE;
        } else if (lowerName.contains("workout") || lowerName.contains("work out") || lowerName.contains("working out")) {
            type = ActivityType.WORKOUT;
        } else if (lowerName.contains("walk")) {
            type = ActivityType.WALK;
        } else {
            type = ActivityType.OTHER;
        }
        return type;
    }


    /**
     * Returns the type as a string.
     * @return A <b>String</b> of the activity type.
     */
    @Override
    public String toString()
    {
        return this.name;
    }
}
