package com.ertikmen.repository.entity;

/*
        firtname
        middlename
        lastname
        bu özelliklerle name sınıfını olusturup
        user ile olan ilişkisini kurup database'e yeni bir veri ekleyelim
 */


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class Name {

    private String firstName;
    private String middleName;
    private String lastName;



}
