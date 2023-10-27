package com.ertikmen.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private Set<Orders> order=new HashSet<Orders>(10);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID",nullable = false)
    private int id;
    @Column(name = "FIRST_NAME",length = 50)
    private String firstName;
    @Column(name = "LAST_NAME",length = 60)
    private String lastName;
    @Column(name = "TITLE",length = 30)
    private String title;

    public Customer(String firstName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Orders> getOrder() {
        return order;
    }

    public void setOrder(Set<Orders> order) {
        this.order = order;
    }
}
