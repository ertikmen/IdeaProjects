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
@Table(name = "tbl_agents")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="AGENT_NAME",length = 50)
    private String agentName;

    @Column(name="EMAIL",length = 60)
    private String email;

    @Column(name="PHONE",length = 40)
    private String phone;

    @Column(name="OFFICE_ADDRESS",length = 80)
    private String officeAddress;

    @OneToMany(mappedBy = "Agent",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Property> properties=new HashSet<>();
}
