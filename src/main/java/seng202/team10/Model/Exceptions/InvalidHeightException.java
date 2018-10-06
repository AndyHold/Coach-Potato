package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when the height is invalid.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class InvalidHeightException extends Exception {


    /**
     * Constructor method for InvalidHeightException
     */
    public InvalidHeightException()
    {
        super("Invalid Height");
    }
}
