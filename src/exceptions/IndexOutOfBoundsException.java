package exceptions;

/**
 * Custom exception class for index out of bounds situations in data structures
 */
public class IndexOutOfBoundsException extends RuntimeException {
    
    /**
     * Constructs an IndexOutOfBoundsException with no message
     */
    public IndexOutOfBoundsException() {
        super();
    }

    /**
     * Constructs an IndexOutOfBoundsException with the specified message
     * @param message the detail message
     */
    public IndexOutOfBoundsException(String message) {
        super(message);
    }
}
