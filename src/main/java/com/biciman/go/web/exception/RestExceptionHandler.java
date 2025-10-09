package com.biciman.go.web.exception;

import com.biciman.go.domain.exception.BiciAlreadyExist;
import com.biciman.go.domain.exception.BiciNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BiciAlreadyExist.class)
    public ResponseEntity<Error> handleException(Exception exception) {
        Error error = new Error("Internal Server Error", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errors = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.add(new Error(error.getField(), error.getDefaultMessage()));

        });

        return ResponseEntity.badRequest().body(errors);

    }
    @ExceptionHandler(BiciNotFound.class)
    public ResponseEntity<Error> handleException(BiciNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("Bici Not Found", ex.getMessage()));

    }
    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error = new Error("Unknown Error", ex.getMessage());
        ex.printStackTrace();
        return ResponseEntity.internalServerError().body(error);
    }*/


}
