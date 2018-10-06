package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when a user name is entered that already exists in the program.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class UniqueNameException extends Exception {



    /**
     * Constructor method for UniqueNameException
     */
    public UniqueNameException()
    {
        super("This username already exists.");
    }
}
