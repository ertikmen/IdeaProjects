package com.mimaraslan.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorMesaj {
     Integer code;
     String mesaj;
     HttpStatus status;

}
