package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when the weight is invalid.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class InvalidWeightException extends Exception {



    /**
     * Constructor method for InvalidWeightException
     */
    public InvalidWeightException()
    {
        super("Invalid Weight");
    }
}
