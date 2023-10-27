package com.ertikmen.exception;

import lombok.Getter;

@Getter
public class ElasticManagerException extends RuntimeException {

    private final ErrorType errorType;

    public ElasticManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public ElasticManagerException(ErrorType errorType, String customMessage){
        super(customMessage);
        this.errorType=errorType;
    }

}
