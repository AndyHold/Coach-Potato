package seng202.team10.Model;



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


    public static GoalType getTypeFromString(String typeName)
    {
        if (typeName.equals("Weight")) {
            return GoalType.WEIGHT;
        } else if (typeName.equals("Distance")) {
            return GoalType.DISTANCE;
        } else if (typeName.equals("BMI")) {
            return GoalType.BMI;
        } else if (typeName.equals("Frequency")) {
            return GoalType.FREQUENCY;
        } else {
            return GoalType.TIME;
        }

    }
}
