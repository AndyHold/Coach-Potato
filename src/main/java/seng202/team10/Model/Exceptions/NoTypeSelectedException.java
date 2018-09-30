package seng202.team10.Model.Exceptions;



/**
 * NoTypeSelectedException Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class NoTypeSelectedException extends Exception {


    /**
     * Constructor method for NoTypeSelectedException
     */
    public NoTypeSelectedException()
    {
        super("Please choose a goal type");
    }
}
