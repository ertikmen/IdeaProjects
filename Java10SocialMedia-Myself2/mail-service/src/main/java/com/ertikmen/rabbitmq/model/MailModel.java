package com.ertikmen.rabbitmq.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailModel implements Serializable {

    private String token;
    private String activationCode;
    private String email;
    // 2 tanesi istek mail kısmı da zaten kime göndereceğimizi görmek için...
    private String username; // gerekli değil
}
