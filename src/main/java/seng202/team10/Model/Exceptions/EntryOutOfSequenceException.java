package seng202.team10.Model.Exceptions;


/**
 * EntryOutOfSequenceException Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class EntryOutOfSequenceException extends Exception{


    /**
     * Constructor method for DuplicateEntryException
     */
    public EntryOutOfSequenceException()
    {
        super("Entry continuity has been broken");
    }
}