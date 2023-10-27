package com.ertikmen.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name",length = 25,nullable = false)
    private String firsname;
    @Transient
    @Column(name = "last_name",length = 25)
    private String lastname;

    @Embedded
    private Address address;

    @ElementCollection
    private Set<Address> adresListesi=new HashSet<>();


    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    public Customer() {
    }

    public Customer(int id, String firsname, String lastname, Address address, Date creationDate) {
        this.id = id;
        this.firsname = firsname;
        this.lastname = lastname;
        this.address = address;
        this.creationDate = creationDate;
    }

    public Customer(String firsname, String lastname, Address address, Date creationDate) {
        this.firsname = firsname;
        this.lastname = lastname;
        this.address = address;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Address> getAdresListesi() {
        return adresListesi;
    }

    public void setAdresListesi(Set<Address> adresListesi) {
        this.adresListesi = adresListesi;
    }
}
