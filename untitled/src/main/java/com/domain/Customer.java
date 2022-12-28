package com.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "phoneNo")
    private long phoneNo;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private  String password;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "nid")
    private long nid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "customer")
    private Set<Hotel_booking> hotels;

    @OneToMany(mappedBy = "customer")
    private Set<Bus_booking> buses;

    public Set<Bus_booking> getBuses() {
        return buses;
    }

    public void setBuses(Set<Bus_booking> buses) {
        this.buses = buses;
    }

    public Set<Hotel_booking> getHotels() {
        return hotels;
    }

    public void setHotels(Set<Hotel_booking> hotels) {
        this.hotels = hotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }
}
