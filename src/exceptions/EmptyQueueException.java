package exceptions;

/**
 * Exception thrown when attempting to access or remove an element from an empty queue.
 */
public class EmptyQueueException extends RuntimeException {
   
    /**
     * Constructs a new EmptyQueueException with no message.
     */
    public EmptyQueueException() {
        super("The queue is empty.");
    }
   
    /**
     * Constructs a new EmptyQueueException with the specified message.
     *
     * @param message the detail message
     */
    public EmptyQueueException(String message) {
        super(message);
    }
}
