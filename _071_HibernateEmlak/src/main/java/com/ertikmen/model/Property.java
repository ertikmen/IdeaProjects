package com.ertikmen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PROPERTY_NAME", length = 50)
    private String propertyName;

    @Column(name = "TITTLE", length = 50)
    private String tittle;

    @Column(name = "DESCRIPTION", length = 50)
    private String description;

    @Column(name = "TYPE", length = 50)
    private String type;

    private BigDecimal price;

    private int bedrooms;
    private int bathrooms;
    private float area;
    private String location;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToMany
    @JoinTable(name="property_buyer",
    joinColumns = @JoinColumn(name="Property_id"),
    inverseJoinColumns = @JoinColumn(name = "buyer_id")
    )
    private Set<Buyer> buyers=new HashSet<>();

}
