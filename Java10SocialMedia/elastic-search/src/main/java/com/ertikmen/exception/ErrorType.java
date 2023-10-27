package com.ertikmen.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR_SERVER(5400,"Sunucu Hatası",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4400,"Parametre hatası",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4410, "Böyle bir kullanıcı bulunamadı",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4411, "Hesabınız Aktif değildir",HttpStatus.BAD_REQUEST),
    INVALID_CODE(4412, "Geçersiz Kod",HttpStatus.BAD_REQUEST),
    UNEXPECTED_ERROR(4413,"Beklenmeyen bir hata olustu",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4414, "Geçersiz Token !!!",HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4415, "Token Oluşturulamadı !!!",HttpStatus.BAD_REQUEST),

    USER_NOT_CREATED(4416,"Kullanıcı oluşturulamadı." ,HttpStatus.BAD_REQUEST),
    STATUS_NOT_FOUND(4417,"Böye bir kullancıı durumu bulunamadı." ,HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    HttpStatus httpStatus;


}
