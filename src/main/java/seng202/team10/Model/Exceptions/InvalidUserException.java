package seng202.team10.Model.Exceptions;



/**
 * InvalidUserException Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class InvalidUserException extends Exception {

    /**
     * Constructor method for InvalidUserException
     */
    public InvalidUserException()
    {
        super("Invalid User");
    }
}
