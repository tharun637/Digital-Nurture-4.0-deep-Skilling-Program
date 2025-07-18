package com.cognizant.orm_learn.model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "dp_id")
    private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }
}
