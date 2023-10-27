package com.ertikmen.model;

import lombok.*;
import com.ertikmen.model.enums.EArabaStatus;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Arac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "marka")
    private String marka;
    @Column(name = "model")
    private String model;
    @Column(name = "uretim_yili")
    private String uretimYili;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EArabaStatus durum = EArabaStatus.MUSAIT;

}
