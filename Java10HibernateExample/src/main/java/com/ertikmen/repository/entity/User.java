package com.ertikmen.repository.entity;

import com.ertikmen.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false,unique = true)
    private String username;
    @Size(min=4,max=32,message="Şifre 4 ile 32 arasında olmalıdır.")
    private String password;
    private int age;
    private EGender gender;
}
