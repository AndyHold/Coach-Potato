package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when an existing activity is added to a user.

 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class ExistingActivityException extends Exception {


    /**
     * Constructor method for ExistingActivityException
     * @param newMessage A <b>String</b> Message to be displayed on exception.
     */
    public ExistingActivityException(String newMessage)
    {
        super(newMessage);
    }
}
