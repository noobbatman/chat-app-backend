package com.Istiak.chat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

/**
 * A global exception handler to catch exceptions from any controller
 * and convert them into clean, user-friendly HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This method handles any IllegalArgumentException thrown from anywhere in the application.
     * @param ex The exception that was thrown.
     * @return A ResponseEntity with a 400 Bad Request status and a clean error message.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        // Create a clean JSON response body
        Map<String, String> errorResponse = Map.of("error", ex.getMessage());

        // Return a 400 Bad Request status, which is more appropriate for this kind of error.
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}