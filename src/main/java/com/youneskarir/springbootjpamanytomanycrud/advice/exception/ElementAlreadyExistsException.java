package com.youneskarir.springbootjpamanytomanycrud.advice.exception;

public class ElementAlreadyExistsException extends RuntimeException {
   
    public ElementAlreadyExistsException(String message) {
        super(message);
    }

    public ElementAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
