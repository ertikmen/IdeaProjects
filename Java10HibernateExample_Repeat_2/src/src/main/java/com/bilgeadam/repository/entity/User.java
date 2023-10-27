package com.bilgeadam.repository.entity;

import com.bilgeadam.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Name name;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    @Size(min = 4,max = 32,message = "Sifre  4 ile 32 karakter arası olmalıdır")
    private String password;
    @Transient // bu özellik artık databsede gorunmeyecek
    private int age;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EGender gender=EGender.WOMAN;
    /*
        Her kullnaıcın birden falz ilgi alanı  olsun ve
         ve her bir ilgi alnı turu  string olsun
         Muzik ,Sinema
     */

    @ElementCollection
    @Builder.Default
    List<String> interests=new ArrayList<>();

    /*
        Bir kullanıcın birden fazla adresi olabilir
        ve adresileri burada adres turlerine gore tutalım
        iş: adresss1
        ev: address2
     */
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    Map<EAddressType,Address> addresses;

    int postCount;



}
