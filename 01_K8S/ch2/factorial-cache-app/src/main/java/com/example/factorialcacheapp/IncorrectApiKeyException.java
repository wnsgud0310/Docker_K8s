package com.example.factorialcacheapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class IncorrectApiKeyException extends RuntimeException {
    public IncorrectApiKeyException(String message) {
        super(message);
    }
}