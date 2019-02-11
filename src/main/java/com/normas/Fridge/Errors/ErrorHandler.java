package com.normas.Fridge.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ErrorHandler extends RuntimeException {
    public ErrorHandler(String message) {
        super(message);
    }
}