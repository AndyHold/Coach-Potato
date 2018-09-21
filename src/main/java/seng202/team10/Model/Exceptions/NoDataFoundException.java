package seng202.team10.Model.Exceptions;

public class NoDataFoundException extends Exception{


    /**
     * Constructor method for DuplicateEntryException
     */
    public NoDataFoundException()
    {
        super("No activities found in file.");
    }
}
