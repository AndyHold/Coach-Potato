package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when no activity is found.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class NoActivityFoundException extends Exception{


    /**
     * Constructor method for NoActivityFoundException
     */
    public NoActivityFoundException()
    {
        super("No activity found");
    }
}
