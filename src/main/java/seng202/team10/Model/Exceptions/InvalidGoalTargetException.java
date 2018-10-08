package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when the goal target is invalid.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class InvalidGoalTargetException extends Exception{


    /**
     * Constructor method for InvalidGoalTargetException
     * @param message  A <b>String</b> detailing the message this exception throws.
     */
    public InvalidGoalTargetException(String message)
    {
        super(message);
    }
}
