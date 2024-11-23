package exceptions;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("The queue is empty.");
    }
    
    public EmptyQueueException(String message) {
        super(message);
    }
}
