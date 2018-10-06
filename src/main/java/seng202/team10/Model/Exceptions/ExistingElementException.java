package seng202.team10.Model.Exceptions;



/**
 * Exception thrown when an element already exists.
 *
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class ExistingElementException extends Exception {


    private String message;


    /**
     * Constructor method for ExistingElementException
     * @param newMessage A <b>String</b> Message to be displayed on exception.
     */
    public ExistingElementException(String newMessage)
    {
        this.message = newMessage;
    }


    /**
     * Getter method for message
     * @return A <b>String</b>
     */
    public String getMessage()
    {
        return this.message;
    }
}
