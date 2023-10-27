package com.ertikmen.model;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")

public class Customer {

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CustomerDetail customerDetail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private int customerId;

    @Column(name = "TITLE", length = 30)
    private String title;

    @Column(name = "FIRST_NAME", length = 60, nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", length = 60)
    private String lastname;

    public Customer() {
    }

    public Customer(String title, String firstname, String lastname) {
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public CustomerDetail getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetail customerDetail) {
        this.customerDetail = customerDetail;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", customerId=" + customerId +
                ", title='" + title + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
