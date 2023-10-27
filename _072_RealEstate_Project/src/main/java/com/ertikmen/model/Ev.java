package com.ertikmen.model;

import com.ertikmen.model.enums.EEvStatus;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDate;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
@Entity
public class Ev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "yapim_yili")
    private LocalDate yapimYili;
    private String tur;
    private int kat;
    private String semt;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EEvStatus durum=EEvStatus.MUSAIT;

}
