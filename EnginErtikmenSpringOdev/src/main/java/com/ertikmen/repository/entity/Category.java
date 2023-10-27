package com.ertikmen.repository.entity;


import com.ertikmen.repository.enums.ECategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private ECategoryType categoryType=ECategoryType.SOCIAL;
    @Lob
    private String description;
}
