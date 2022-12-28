package com.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bus_booking")
public class Bus_booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "dept_at")
    private String dept_at;

    @NotNull
    @Column(name = "dept_from")
    private String dept_from;


    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept_at() {
        return dept_at;
    }

    public void setDept_at(String dept_at) {
        this.dept_at = dept_at;
    }

    public String getDept_from() {
        return dept_from;
    }

    public void setDept_from(String dept_from) {
        this.dept_from = dept_from;
    }

}
