package com.example.parkingmanager.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "super_users")
public class SuperUser {
    @PrimaryKey(autoGenerate = true)
    private String id;
    private String name;
    private boolean gender;
    private String phone;
    private String email;
    private String address;
    private String position;
    private String password;

    public SuperUser(String id, String name, boolean gender, String phone, String email, String address, String position, String password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
