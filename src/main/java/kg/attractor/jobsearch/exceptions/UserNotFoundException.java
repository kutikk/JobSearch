package kg.attractor.jobsearch.exceptions;

public class UserNotFoundException extends NoSuchFieldException {
    public UserNotFoundException() {

        super("User not found: ");
    }

}
