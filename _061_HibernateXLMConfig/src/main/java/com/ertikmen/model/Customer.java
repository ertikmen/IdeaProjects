package com.ertikmen.model;

import javax.persistence.*;
import java.util.Date;
//@Entity
//@Table(name = "tblcustomers")
public class Customer {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(name = "first_name",length = 25,nullable = false)
    private String firsname;
//    @Column(name = "last_name",length = 25)
    private String lastname;
//    @Column(name = "address",length = 25)
    private String address;
//    @Column(name = "creation_date")
    private Date creationDate;

    public Customer() {
    }

    public Customer(int id, String firsname, String lastname, String address, Date creationDate) {
        this.id = id;
        this.firsname = firsname;
        this.lastname = lastname;
        this.address = address;
        this.creationDate = creationDate;
    }

    public Customer(String firsname, String lastname, String address, Date creationDate) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
