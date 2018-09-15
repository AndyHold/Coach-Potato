package seng202.team10.Model.ActivitiesData;


/**
 * ActivityIntensity Enum for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public enum ActivityType {
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
     * determines and sets the type of the activity based on the name string.
     * possible types are walk, run, hike, cycle, swim, workout, other
     * */
    public static ActivityType determineType(String name)
    {
        String lowername = name.toLowerCase();
        ActivityType type;
        if(lowername.contains("walk")){
            type = ActivityType.WALK;
        } else if (lowername.contains("run") || lowername.contains("jog")){
            type = ActivityType.RUN;
        } else if (lowername.contains("hike") || lowername.contains("hiking")){
            type = ActivityType.HIKE;
        } else if (lowername.contains("cycle") || lowername.contains("cycling") || lowername.contains("bike") ||
                lowername.contains("biking")){
            type = ActivityType.CYCLE;
        } else if (lowername.contains("swim")){
            type = ActivityType.SWIM;
        } else if (lowername.contains("workout") || lowername.contains("work out") || lowername.contains("working out")){
            type = ActivityType.WORKOUT;
        } else{
            type = ActivityType.OTHER;
        }
        return type;
    }


    @Override
    public String toString()
    {
        return this.name;
    }
}
