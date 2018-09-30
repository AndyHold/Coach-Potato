package seng202.team10.Model.Exceptions;



/**
 * BadActivityException Class for Coach Potato
 * SENG202 2018S2
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
