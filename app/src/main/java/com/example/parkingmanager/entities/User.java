package com.example.parkingmanager.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Enumeration;
@Entity (tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Enumeration<Position> position;

    public User(String id, String name, String password, String email, String phone, Enumeration<Position> position) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.position = position;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Enumeration<Position> getPosition() {
        return position;
    }

    public void setPosition(Enumeration<Position> position) {
        this.position = position;
    }
}
