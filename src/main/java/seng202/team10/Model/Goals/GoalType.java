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
<<<<<<< HEAD
<<<<<<< HEAD
     * Converts a type from a string to an enum
     * @param typeName
     * @return
=======
     * Method to get the goal type from the string typeName
     * @param typeName: String
     * @return GoalType
>>>>>>> 44795a96... Found incomplete JavaDoc in goal subclasses and ActivityType and GoalType Enums. Finshed writing these
=======
     * Method to convert a goal type from a string to an enum.
     * @param typeName A <b>String</b> of the name of the type of goal.
     * @return A <b>GoalType</b>.
>>>>>>> 4837059d... Javadocced the goals
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
<<<<<<< HEAD
     * returns the enum goal type as a string
<<<<<<< HEAD
     * @return
=======
     * @return A <b>String</b>
>>>>>>> 030d16ee... Javadoc overhaul, fully documented the ActivitiesData and Control packages, did some work on the other packages.
=======
     * ToString method for goaltype.
     * @return A <b>String</b> of the name of the type of goal.
>>>>>>> 4837059d... Javadocced the goals
     */
    @Override
    public String toString()
    {
        return name;
    }
}
