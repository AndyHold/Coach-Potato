package seng202.team10.Model.Goals;



/**
 * Enum for types of goals.
 *
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
     * Method to convert a goal type from a string to an enum.
     * @param typeName A <b>String</b> of the name of the type of goal.
     * @return A <b>GoalType</b>.
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
     * ToString method for goaltype.
     * @return A <b>String</b> of the name of the type of goal.
     */
    @Override
    public String toString()
    {
        return name;
    }
}
