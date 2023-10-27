package com.mimaraslan.repository.entity;

import lombok.*;

import javax.persistence.*;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data //get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //dolu constructor oluşturur.
@ToString
@Entity
@Table(name = "tblsatis")
public class Satis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long musteriid;
    Long urunid;
    Long tarih;
    Integer adet;
    Double birimfiyat;
    Double toplamfiyat;
}
