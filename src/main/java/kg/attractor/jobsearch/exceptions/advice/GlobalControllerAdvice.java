package kg.attractor.jobsearch.exceptions.advice;

import jakarta.servlet.http.HttpServletRequest;
import kg.attractor.jobsearch.exceptions.ErrorResponseBody;
import kg.attractor.jobsearch.exceptions.ProfileAlreadyExistsException;
import kg.attractor.jobsearch.exceptions.ResumeNotFoundException;
import kg.attractor.jobsearch.service.interfaces.ErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {
      private final ErrorService errorService;
    @ExceptionHandler({NoSuchFieldException.class, ResumeNotFoundException.class,
            ProfileAlreadyExistsException.class})
    private String handleNoSuchFieldException(Model model ,HttpServletRequest request , Exception e) {
        model.addAttribute("status", HttpStatus.NOT_FOUND);
        model.addAttribute("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
        model.addAttribute("details", request);
        model.addAttribute("message", e.getMessage());
        return "errors/error";
    }

}
