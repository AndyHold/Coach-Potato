package seng202.team10.Model.Exceptions;



/**
 * InvalidGoalDateException Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class InvalidGoalDateException extends Exception {


    /**
     * Constructor method for PastDateSelectedException
     */
    public InvalidGoalDateException(String message)
    {
        super(message);
    }
}
