package seng202.team10.Model;

public class BadActivityException extends Exception{


    /**
     * Constructor method for DuplicateEntryException
     */
    public BadActivityException()
    {
        super("This activity is unparsable and has been discarded");
    }
}
