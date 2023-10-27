package com.ertikmen.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Kisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;


    @ToString.Exclude
    @OneToMany(mappedBy = "kisi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Kiralama> kiralamaList;
}
