package kg.attractor.jobsearch.service.interfaces;

import kg.attractor.jobsearch.exceptions.ErrorResponseBody;
import org.springframework.validation.BindingResult;

public interface ErrorService {
    ErrorResponseBody makeResponse(Exception exception);

    ErrorResponseBody makeResponse(BindingResult bindingResult);
}
