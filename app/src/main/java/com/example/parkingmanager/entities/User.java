package com.example.parkingmanager.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "users")
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private String password;
    private String username;
    private String cardNumber;
    private int idPosition = new Position().getId();
    @Ignore
    private Position position;

    public User() {
        this.id = 0;
        this.name = "";
        this.password = "";
        this.username = "";
        this.cardNumber = "";
        this.idPosition = 0;
    }

    public User(int id, String name, String password, String username, String cardNumber, int idPosition) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.cardNumber = cardNumber;
        this.idPosition = idPosition;
    }

    public User(String name, String password, String username, String cardNumber, int idPosition) {
        this.id = 0;
        this.name = name;
        this.password = password;
        this.username = username;
        this.cardNumber = cardNumber;
        this.idPosition = idPosition;
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

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
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
