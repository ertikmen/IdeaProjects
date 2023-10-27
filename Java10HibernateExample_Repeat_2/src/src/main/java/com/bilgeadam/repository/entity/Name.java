package com.bilgeadam.repository.entity;
/*
    firstname
    middlename
    lastname
    bu ozelliklerle name sınıfını olusturup
    user ile olan ilişkisini kurup databse'e yeni bri veri ekleyelim

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
public class Name {

    private String firstName;
    private String middleName;
    private String lastName;
}
