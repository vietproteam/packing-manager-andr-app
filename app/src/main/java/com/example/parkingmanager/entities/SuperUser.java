package com.example.parkingmanager.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "super_users")
public class SuperUser {
    @PrimaryKey(autoGenerate = true)
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String company;
    private String taxNumber;
    private String password;

    public SuperUser() {
        this.id = "";
        this.name = "";
        this.phone = "";
        this.email = "";
        this.address = "";
        this.company = "";
        this.taxNumber = "";
        this.password = "";
    }

    public SuperUser(String id, String name, String phone, String email, String address, String company, String taxNumber, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.company = company;
        this.taxNumber = taxNumber;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
