package kg.attractor.jobsearch.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {

        super("User not found: ");
    }

}
