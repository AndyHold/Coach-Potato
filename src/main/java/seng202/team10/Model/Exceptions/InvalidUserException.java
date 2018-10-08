package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when the user is invalid.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class InvalidUserException extends Exception {

    /**
     * Constructor method for InvalidUserException
     */
    public InvalidUserException()
    {
        super("Invalid user");
    }
}
