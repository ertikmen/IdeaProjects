package com.ertikmen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthManagerException.class)
    public ResponseEntity<ErrorMessage> handleManagerException(AuthManagerException exception){
        ErrorType errorType=exception.getErrorType();
        HttpStatus httpStatus=errorType.getHttpStatus();

        return new ResponseEntity<>(createError(errorType,exception),httpStatus);
    }

    private ErrorMessage createError (ErrorType errorType,Exception exception){
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }


}
