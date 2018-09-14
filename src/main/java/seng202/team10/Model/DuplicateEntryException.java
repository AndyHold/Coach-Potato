package seng202.team10.Model;

public class DuplicateEntryException extends Exception{


    /**
     * Constructor method for DuplicateEntryException
     */
    public DuplicateEntryException()
    {
        super("An entry has already been added to your activity at this time slot");
    }
}
