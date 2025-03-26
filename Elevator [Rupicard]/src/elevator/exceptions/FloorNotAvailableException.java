package elevator.exceptions;

public class FloorNotAvailableException extends RuntimeException {
    public FloorNotAvailableException(String message) {
        super(message);
    }
}
