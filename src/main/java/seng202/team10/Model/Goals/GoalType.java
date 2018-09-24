package seng202.team10.Model.Goals;



/**
 * GoalType Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public enum GoalType {

    WEIGHT("Weight"), DISTANCE("Distance"), FREQUENCY("Frequency"), BMI("BMI"), TIME("Time");

    private String name;

    GoalType(String newName)
    {
        this.name = newName;
    }

    /**
     * Converts a type from a string to an enum
     * @param typeName  The type name being converted
     * @return GoalType
     */
    public static GoalType getTypeFromString(String typeName)
    {
        switch (typeName) {
            case "Weight":
                return GoalType.WEIGHT;
            case "Distance":
                return GoalType.DISTANCE;
            case "BMI":
                return GoalType.BMI;
            case "Frequency":
                return GoalType.FREQUENCY;
            default:
                return GoalType.TIME;
        }
    }

    /**
     * returns the enum goal type as a string
     * @return String
     */
    @Override
    public String toString()
    {
        return name;
    }
}
