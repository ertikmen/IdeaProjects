package com.ertikmen.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER_DETAIL")
public class CustomerDetail {

    @OneToOne
    @JoinColumn
    private Customer customer;

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @Parameter(name = "property", value = "customer"))
    @Column(name = "CUSTOMER_ID", nullable = false)
    private int customerId;
    @Column(name = "ADDRESS", length = 50)
    private String address;
    @Column(name = "PHONE", length = 20, nullable = false)
    private String phone;
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    public CustomerDetail() {
    }

    public CustomerDetail(String address, String phone, Date creationDate) {
        this.address = address;
        this.phone = phone;
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "CustomerDetail{" +
                "customer=" + customer +
                ", customerId=" + customerId +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
