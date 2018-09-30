package seng202.team10.Model.Exceptions;



/**
 * ExistingActivityException Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class ExistingActivityException extends Exception {


    /**
     * Constructor method for ExistingActivityException
     * @param newMessage String: Message to be displayed on exception.
     */
    public ExistingActivityException(String newMessage)
    {
        super(newMessage);
    }
}
