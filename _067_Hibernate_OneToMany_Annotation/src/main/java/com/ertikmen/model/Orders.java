package com.ertikmen.model;

import jdk.jfr.Timestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Orders {


    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID",nullable = false)
    private int id;
    @Column(length = 40)
    private String productCode;
    @Column(name = "AMOUNT",precision = 10,scale = 2)
    private float amount;
    @Column(name = "ORDER_DATE",length = 20)
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    public Orders(String productCode, float amount, Date orderDate) {
        this.productCode = productCode;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public Orders(Customer customer, String productCode, float amount, Date orderDate) {
        this.customer = customer;
        this.productCode = productCode;
        this.amount = amount;
        this.orderDate = orderDate;
    }

    public Orders() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
