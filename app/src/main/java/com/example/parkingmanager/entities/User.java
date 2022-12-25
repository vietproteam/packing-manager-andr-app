package com.example.parkingmanager.entities;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "users")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull private int id;
    private String name;
    private String password;
    private String username;
    private String cardNumber;
    @Embedded(prefix = "position_")
    private Position position;

    public User() {
        this.id = 0;
        this.name = "";
        this.password = "";
        this.username = "";
        this.cardNumber = "";
        this.position = new Position();
    }

    public User(int id, String name, String password, String username, String cardNumber, Position position) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.cardNumber = cardNumber;
        this.position = new Position();
    }

    public User(String name, String password, String username, String cardNumber, Position position) {
        this.id = 0;
        this.name = name;
        this.password = password;
        this.username = username;
        this.cardNumber = cardNumber;
        this.position = new Position();
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getCardNumberFormatted() {
        return cardNumber.substring(0, 4) + "...";
    }
}
