package com.mimaraslan.repository.entity;

import lombok.*;

import javax.persistence.*;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
@ToString
@Entity
@Table(name = "tblurun")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String marka;
    String model;
    Double fiyat;
    Double kdv;
    String img;
    String aciklama;
    String birim;
}
