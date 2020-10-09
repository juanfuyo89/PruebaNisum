package cl.nisum.techtest.controller;

import cl.nisum.techtest.exception.InternalValidationException;
import cl.nisum.techtest.model.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

public class GenericController {

    protected final static Logger LOGGER = LogManager.getRootLogger();

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> generalExceptionHandler(Exception e) {
        logError(e);
        return new ResponseEntity<Response>(Response.getIntance(Response.GENERAL_ERR_MSG),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response> validatorsExceptionHandler(ConstraintViolationException e) {
        logError(e);
        return new ResponseEntity<Response>(Response.getIntance(e.getConstraintViolations().iterator().next().getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalValidationException.class)
    public ResponseEntity<Response> internalValidatorsExceptionHandler(InternalValidationException e) {
        logError(e);
        return new ResponseEntity<Response>(Response.getIntance(e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    protected void logInfo(String message) {
        LOGGER.info(message);
    }

    protected void logError(Exception e) {
        LOGGER.error("Error en la solicitud: " + e.getMessage());
        LOGGER.catching(e);
    }
}
