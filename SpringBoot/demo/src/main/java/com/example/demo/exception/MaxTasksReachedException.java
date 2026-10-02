package com.example.demo.exception;

public class MaxTasksReachedException extends RuntimeException {
    public MaxTasksReachedException(String message) {

        super(message);
    }
}
