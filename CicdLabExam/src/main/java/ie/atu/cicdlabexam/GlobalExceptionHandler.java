package ie.atu.cicdlabexam;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> showErrors(MethodArgumentNotValidException ex)
    {
        Map<String, String> errorList = new HashMap<>();
        Map<String, Object> errorResponse = new HashMap<>();
        for(FieldError error : ex.getFieldErrors()){
            String err_name = error.getField();
            String err_message = error.getDefaultMessage();
            errorList.put(err_name, err_message);
        }

        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("errors", errorList);

        return ResponseEntity.status(400).body(errorResponse);
    }

    @ExceptionHandler(DuplicateProductCodeException.class)
    public ResponseEntity<Object> handleDuplicateProductCodeException(DuplicateProductCodeException ex){
        Map<String, Object> errorResponse = new HashMap<>();

        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("errors", ex.getMessage());
        
        return ResponseEntity.status(400).body(errorResponse);
    }


}
