package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when an activity is unparsable.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class BadActivityException extends Exception{


    /**
     * Constructor method for BadActivityException
     */
    public BadActivityException()
    {
        super("This activity is unparsable and has been discarded");
    }
}
