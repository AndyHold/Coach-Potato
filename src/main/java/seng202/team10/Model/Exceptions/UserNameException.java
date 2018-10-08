package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when the user name entered is invalid.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class UserNameException extends Exception {



    /**
     * Constructor method for UserNameException
     */
    public UserNameException()
    {
        super("Invalid Username");
    }
}
