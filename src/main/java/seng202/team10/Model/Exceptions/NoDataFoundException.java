package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when no data is found.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class NoDataFoundException extends Exception{


    /**
     * Constructor method for NoDataFoundException
     */
    public NoDataFoundException()
    {
        super("No activities found in file.");
    }
}
