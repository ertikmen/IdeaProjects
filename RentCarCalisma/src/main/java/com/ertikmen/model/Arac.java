package com.ertikmen.model;

import com.ertikmen.model.enums.EAracStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "uretim_yili")
    private LocalDate uretimYili;

    private String marka;
    private String model;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EAracStatus durum =EAracStatus.MUSAIT;

}
