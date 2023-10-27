package com.ertikmen.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR_SERVER(5200,"Sunucu Hatası",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4200,"Parametre hatası",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4210, "Böyle bir kullanıcı bulunamadı",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4211, "Hesabınız Aktif değildir",HttpStatus.BAD_REQUEST),
    INVALID_CODE(4212, "Geçersiz Kod",HttpStatus.BAD_REQUEST),
    UNEXPECTED_ERROR(4213,"Beklenmeyen bir hata olustu",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4214, "Geçersiz Token !!!",HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4215, "Token Oluşturulamadı !!!",HttpStatus.BAD_REQUEST),

    USER_NOT_CREATED(4216,"Kullanıcı oluşturulamadı." ,HttpStatus.BAD_REQUEST),
    STATUS_NOT_FOUND(4217,"Böye bir kullancıı durumu bulunamadı." ,HttpStatus.BAD_REQUEST);


    private int code;
    private String message;
    HttpStatus httpStatus;


}
