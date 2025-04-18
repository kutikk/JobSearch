package kg.attractor.jobsearch.service.impl;

import kg.attractor.jobsearch.exceptions.ErrorResponseBody;
import kg.attractor.jobsearch.service.interfaces.ErrorService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErrorServiceImpl implements ErrorService {
    @Override
    public ErrorResponseBody makeResponse(Exception exception){
        String message = exception.getMessage();
        return ErrorResponseBody.builder()
                .title(message)
                .response(Map.of("errors", List.of(message)))
                .build();
    }
@Override
public ErrorResponseBody makeResponse(BindingResult bindingResult){
        Map<String , List<String>> reasons = new HashMap<>();
        bindingResult.getFieldErrors().stream()
                .filter(e ->e.getDefaultMessage() != null)
                .forEach(e -> {
                    List<String> errors = new ArrayList<>();
                    errors.add(e.getDefaultMessage());
                    if(!reasons.containsKey(e.getField())) {
                        reasons.put(e.getField(), errors);
                    }
                });
        return ErrorResponseBody.builder()
                .title("Ошибка валидации")
                .response(reasons)
                .build();
    }
}
