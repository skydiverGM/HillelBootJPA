package imaks.hillelbootjpa.controller;

import imaks.hillelbootjpa.exception.CustomException;
import imaks.hillelbootjpa.exception.CustomExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomExceptionResponse> handleException(CustomException exc){
        CustomExceptionResponse response = new CustomExceptionResponse();
        response.setStatus(exc.getStatus().value());
        response.setMessage(exc.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
