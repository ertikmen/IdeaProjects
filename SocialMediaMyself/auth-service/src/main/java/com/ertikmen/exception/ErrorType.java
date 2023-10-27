package com.ertikmen.exception;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorType {


    USER_NOT_FOUND(5100,"Böyle bir kullanıcı bulunamadı.",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4100,"Hesabınız aktif değildir.",HttpStatus.BAD_REQUEST),
    ALREADY_ACTIVE(4200,"Hesabınız zaten aktif durumdadır.",HttpStatus.BAD_REQUEST),



    INVALID_CODE(4101,"Geçersiz kod",HttpStatus.BAD_REQUEST);








    private int code;
    private String message;
    HttpStatus httpStatus;







}
