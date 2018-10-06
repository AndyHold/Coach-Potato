package seng202.team10.Model.Exceptions;


/**
 * Exception thrown when an entry is out of sequence.
 *
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