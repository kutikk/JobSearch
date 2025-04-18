package kg.attractor.jobsearch.exceptions;

public class ProfileAlreadyExistsException extends RuntimeException {
    public ProfileAlreadyExistsException(String message) {
        super(message);
    }
}
