package com.ertikmen.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;

    private String city;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "address")
    @Builder.Default
    @ToString.Exclude
    private Set<UserInformation> userInformations=new HashSet<>();
}
