package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
