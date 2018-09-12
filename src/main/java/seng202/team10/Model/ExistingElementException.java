package seng202.team10.Model;

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
