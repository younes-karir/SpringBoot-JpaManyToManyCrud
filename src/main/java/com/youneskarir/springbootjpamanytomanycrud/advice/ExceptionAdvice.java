package com.youneskarir.springbootjpamanytomanycrud.advice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionAdvice {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> data = new HashMap<>();
        
        exception.getBindingResult().getFieldErrors().forEach(
                item -> data.put(item.getField(), item.getDefaultMessage())
        );
                
        return new ResponseEntity<>(data,HttpStatus.BAD_REQUEST);
    }
}
