package seng202.team10.Model.Exceptions;



/**
 * UserNameException Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class UserNameException extends Exception {



    /**
     * Constructor method for UserNameException
     */
    public UserNameException()
    {
        super("Invalid Username");
    }
}
