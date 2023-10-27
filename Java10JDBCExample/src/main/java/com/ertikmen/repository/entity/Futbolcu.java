package com.ertikmen.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Futbolcu {
    private Long id;
    private String ad;
    private String mevki;
    private int formaNo;
    private Long deger;
    private Long takim_id;
}
