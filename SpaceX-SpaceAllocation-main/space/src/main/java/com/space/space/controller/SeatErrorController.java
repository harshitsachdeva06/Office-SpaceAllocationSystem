package com.space.space.controller;

import com.space.space.exception.ErrorResponse;
import com.space.space.exception.SeatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@RestControllerAdvice
public class SeatErrorController {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = SeatNotFoundException.class)
    public ErrorResponse handleAnalystNotFoundException(Exception ex,
                                                        HttpServletRequest req) {
        return new ErrorResponse(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI());
    }
}