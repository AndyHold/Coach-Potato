package seng202.team10.Model.ActivitiesData;


import java.io.Serializable;


/**
 * ActivityIntensity Enum for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public enum ActivityType implements Serializable {
    WALK("Walk"), RUN("Run"), HIKE("Hike"), CYCLE("Cycle"), SWIM("Swim"), WORKOUT("Workout"), OTHER("Other");


    private String name;


    /**
     * Constructor method for ActivityType Enum
     * @param newName String: String representation of the type.
     */
    ActivityType(String newName)
    {
        this.name = newName;
    }


    /**
     * determines and returns the type of the activity based on the name string.
     * possible types are walk, run, hike, cycle, swim, workout, other
     * @param name: String
     * @return ActivityType
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
     * returns the type as a string
     * @return string
     */
    @Override
    public String toString()
    {
        return this.name;
    }
}
