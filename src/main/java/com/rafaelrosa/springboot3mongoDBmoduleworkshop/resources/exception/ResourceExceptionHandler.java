package com.rafaelrosa.springboot3mongoDBmoduleworkshop.resources.exception;

import com.rafaelrosa.springboot3mongoDBmoduleworkshop.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Not found", e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(err);
    }
}
