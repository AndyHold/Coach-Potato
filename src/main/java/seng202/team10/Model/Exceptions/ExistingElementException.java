package seng202.team10.Model.Exceptions;



/**
 * ExistingElementException Class for Coach Potato
 * SENG202 2018S2
 * @author Andrew Holden, Cam Arnold, Paddy Mitchell, Priyesh Shah, Torben Klausen
 */
public class ExistingElementException extends Exception {


    private String message;


    /**
     * Constructor method for ExistingElementException
     * @param newMessage String: Message to be displayed on exception.
     */
    public ExistingElementException(String newMessage)
    {
        this.message = newMessage;
    }


    /**
     * Getter method for message
     * @return String
     */
    public String getMessage()
    {
        return this.message;
    }
}
