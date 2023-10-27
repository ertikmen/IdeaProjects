package com.ertikmen.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR_SERVER(5300,"Sunucu Hatası",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4300,"Parametre hatası",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4310, "Böyle bir kullanıcı bulunamadı",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4311, "Hesabınız Aktif değildir",HttpStatus.BAD_REQUEST),
    INVALID_CODE(4312, "Geçersiz Kod",HttpStatus.BAD_REQUEST),
    UNEXPECTED_ERROR(4313,"Beklenmeyen bir hata olustu",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4314, "Geçersiz Token !!!",HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4315, "Token Oluşturulamadı !!!",HttpStatus.BAD_REQUEST),

    USER_NOT_CREATED(4316,"Kullanıcı oluşturulamadı." ,HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    HttpStatus httpStatus;


}
