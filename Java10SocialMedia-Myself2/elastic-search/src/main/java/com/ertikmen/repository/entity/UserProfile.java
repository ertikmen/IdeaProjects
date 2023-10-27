package com.ertikmen.repository.entity;


import com.ertikmen.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Document(indexName = "user_profile")
public class UserProfile extends BaseEntity{

    @Id
    private String id;
    private Long authId;
    private String username;
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private String about;
    private String name;
    private String surName;
    private LocalDate birthDate;
    @Builder.Default
    private EStatus status = EStatus.PENDING;
}
