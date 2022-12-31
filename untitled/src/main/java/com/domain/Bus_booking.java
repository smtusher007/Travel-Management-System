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
    @Column(name = "dept_At")
    private String dept_At;

    @NotNull
    @Column(name = "dept_From")
    private  String dept_From;

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

    public String getDept_At() {
        return dept_At;
    }

    public void setDept_At(String dept_At) {
        this.dept_At = dept_At;
    }

    public String getDept_From() {
        return dept_From;
    }

    public void setDept_From(String dept_From) {
        this.dept_From = dept_From;
    }
}
