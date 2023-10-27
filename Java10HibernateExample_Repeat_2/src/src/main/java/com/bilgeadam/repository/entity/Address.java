package com.bilgeadam.repository.entity;
/*
    city ve country ozellikleri olsun


 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Address {

    private  String city;
    private  String country;
}
