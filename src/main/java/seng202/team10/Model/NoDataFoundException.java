package seng202.team10.Model.Exceptions;



/**
 * NoDataFoundException Class for Coach Potato
 * SENG202 2018S2
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
