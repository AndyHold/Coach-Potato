package seng202.team10.Model.Exceptions;



/**
 * BadGoalNameException Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class BadGoalNameException extends Exception {


    /**
     * Constructor method for BadGoalNameException
     */
    public BadGoalNameException()
    {
        super("Please select a name for your goal.\nMust be between 2 - 20 characters long.");
    }
}
