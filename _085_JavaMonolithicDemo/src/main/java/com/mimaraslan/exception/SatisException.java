package com.mimaraslan.exception;

import lombok.Getter;

@Getter
public class SatisException extends RuntimeException{
    private final ErrorType type;

    public SatisException(ErrorType type){
        super(type.getMesaj());
        this.type=type;
    }
    public SatisException(ErrorType type, String mesaj){
        super(mesaj);
        this.type=type;
    }

}
