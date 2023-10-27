package com.ertikmen.repository.entity;

import lombok.*;

import javax.persistence.*;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
@ToString
@Entity
@Table(name = "tbl_auth")
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(unique = true)
    private String username;
    private String email;
    private String password;

    private  Long createAt;
    private boolean state;
}
