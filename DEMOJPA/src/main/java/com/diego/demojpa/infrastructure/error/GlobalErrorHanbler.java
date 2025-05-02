package com.diego.demojpa.infrastructure.error;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.diego.demojpa.infrastructure.error.model.fielError;

@RestControllerAdvice
public class GlobalErrorHanbler {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> hanblRunTimeException(RuntimeException e) {
        return ResponseEntity.badRequest().body(Map.of(
            "error", e.getMessage(),"statusCode", HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(RolDuplicateExeption.class)
    public ResponseEntity<?> hanblRolDuplicateException(RolDuplicateExeption e) {
        return ResponseEntity.badRequest().body(Map.of(
            "error", e.getMessage(),"statusCode", e.getStatus().value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlefieldsException(MethodArgumentNotValidException e){
        List<fielError> fieldErrors = e.getFieldErrors().stream()
        .map(field -> new FieldError(field.getField(), field.getDefaultMessage())) 
        .toList();
        return ResponseEntity.badRequest().body(fieldErrors);
    }

}
