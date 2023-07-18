package com.bookstore.services.exceptions;


public class DataIntegtrityViolationException extends RuntimeException{

    public DataIntegtrityViolationException(String message) {
        super(message);
    }

    public DataIntegtrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
