package seng202.team10.Model.Exceptions;

public class UniqueNameException extends Exception {
    /**
     * Constructor method for UniqueNameException
     */
    public UniqueNameException()
    {
        super("This username already exists.");
    }
}
