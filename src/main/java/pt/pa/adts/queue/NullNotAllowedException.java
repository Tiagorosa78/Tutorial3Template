package pt.pa.adts.queue;

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        super("Null elements are not allowed.");
    }

    public NullNotAllowedException(String message) {
        super(message);
    }
}
