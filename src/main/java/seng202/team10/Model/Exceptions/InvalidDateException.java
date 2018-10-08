package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when the date is invalid.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class InvalidDateException extends Exception{


    /**
     * Constructor method for InvalidDateException
     */
    public InvalidDateException()
    {
        super("The date entered is invalid");
    }
}
