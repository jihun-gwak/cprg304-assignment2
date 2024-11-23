package exceptions;
<<<<<<< HEAD

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("The queue is empty.");
    }
    
    public EmptyQueueException(String message) {
        super(message);
    }
}
=======
 
/**
 * Exception thrown when attempting to access or remove an element from an empty queue.
 */
public class EmptyQueueException extends RuntimeException {
   
    /**
     * Constructs a new EmptyQueueException with no message.
     */
    public EmptyQueueException() {
        super();
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
>>>>>>> 2a819f392affca1e5fa88802b3f67078a1219bd1
