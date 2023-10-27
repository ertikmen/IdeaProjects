package com.ertikmen.repository.entity;

import com.ertikmen.repository.enums.EAdressType;
import com.ertikmen.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(unique = true)
    private String username;
    @Column(length = 10)
    private String password;
    @Transient // bu özellik artık database de görünmeyecek.
    private int age;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EGender gender=EGender.WOMAN;
    @ElementCollection
    @Builder.Default
    List<String> interests=new ArrayList<>();
    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    Map<EAdressType,Address> adresses;
}
