package com.mimaraslan.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    MUSTERI_BULUNAMADI(1003,"Aradığınız müşteri sistemde kayıtlı değil", NOT_FOUND),
    URUN_EKLEME_HATASI(2001,"Ürün ekleme başarısız oldu", INTERNAL_SERVER_ERROR),
    INVALID_PARAMETER(3001,"Geçersiz parametre girişi yaptınız", BAD_REQUEST);

    private int code;
    private String mesaj;
    private HttpStatus status;
}
