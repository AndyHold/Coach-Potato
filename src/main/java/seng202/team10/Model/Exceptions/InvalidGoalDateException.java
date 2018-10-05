package seng202.team10.Model.Exceptions;



/**
 * InvalidGoalDateException Class for Coach Potato
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class InvalidGoalDateException extends Exception {


    /**
     * Constructor method for PastDateSelectedException
     * @param message  A <b>String</b> detailing the message this exception throws.
     */
    public InvalidGoalDateException(String message)
    {
        super(message);
    }
}
