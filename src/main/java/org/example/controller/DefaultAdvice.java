package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.example.utils.ResponseErrorMessageUtil.setResponseError;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(value = {NoSuchElementException.class})
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         NoSuchElementException noSuchElementException
    ) throws IOException {
        // 404
        setResponseError(response, HttpServletResponse.SC_NOT_FOUND,
                String.format("Resource not found: %s", noSuchElementException.getMessage()));
    }


    @ExceptionHandler (value = {
            ConstraintViolationException.class, org.hibernate.exception.ConstraintViolationException.class,
            DataIntegrityViolationException.class, MethodArgumentNotValidException.class
    })
    public void constraints(HttpServletRequest request, HttpServletResponse response, Exception exception) throws IOException {
        var cause = getRootCause(exception);
        // 400
        setResponseError(response, HttpServletResponse.SC_BAD_REQUEST, String.format("Constraints failed: %s", cause.getMessage()));
    }
    private Exception getRootCause(Exception ex) {

        Exception cause = ex;
        Exception deepCause;

        do {
            deepCause = (Exception) cause.getCause();

            if (cause == deepCause || deepCause == null) {
                return cause;
            }

            cause = deepCause;
        } while (true);
    }
}
