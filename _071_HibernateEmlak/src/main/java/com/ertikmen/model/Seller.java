package com.ertikmen.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="FIRTS_NAME",length = 50)
    private String firstName;

    @Column(name="lAST_NAME",length = 50)
    private String lastName;

    @Column(name="EMAIL",length = 60)
    private String email;

    @Column(name="PHONE",length = 40)
    private String phone;

    @OneToMany(mappedBy = "Seller",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Property> properties=new HashSet<>();
}
