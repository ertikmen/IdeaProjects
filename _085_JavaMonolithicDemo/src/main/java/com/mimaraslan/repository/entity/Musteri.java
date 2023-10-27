package com.mimaraslan.repository.entity;

import lombok.*;

import javax.persistence.*;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
@ToString
@Entity
@Table(name = "tblmusteri")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String ad;
    String adres;
    String tel;

    String il;
    String username;
    String password;
    String email;
    String img;
}
