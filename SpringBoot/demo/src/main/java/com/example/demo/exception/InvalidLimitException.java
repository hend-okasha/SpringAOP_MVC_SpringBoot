package com.example.demo.exception;

public class InvalidLimitException extends RuntimeException {
    public InvalidLimitException(String message) {

        super(message);
    }
}
