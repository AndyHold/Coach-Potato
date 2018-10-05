package seng202.team10.Model.Exceptions;



/**
 * DuplicateEntryException Class for Coach Potato
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class DuplicateEntryException extends Exception{


    /**
     * Constructor method for DuplicateEntryException
     */
    public DuplicateEntryException()
    {
        super("An entry has already been added to your activity at this time slot");
    }
}
