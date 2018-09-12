package seng202.team10.Model;

public class ExistingActivityException extends Exception {

    /**
     * Constructor method for ExistingElementException
     *
     * @param newMessage String: Message to be displayed on exception.
     */
    ExistingActivityException(String newMessage) {
        super(newMessage);
    }
}
