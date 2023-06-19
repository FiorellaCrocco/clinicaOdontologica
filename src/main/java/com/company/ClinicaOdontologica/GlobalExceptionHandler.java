package com.company.ClinicaOdontologica;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> todosLosErrores(Exception exception, WebRequest req) {
        logger.error(exception.getMessage());
        return new ResponseEntity("ExceptionHandler Error: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
