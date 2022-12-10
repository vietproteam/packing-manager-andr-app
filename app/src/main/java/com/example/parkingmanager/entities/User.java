package com.example.parkingmanager.entities;

import java.util.Enumeration;

public class User {
    private int id;
    private String name;
    private String password;
    private String username;
    private String cardNumber;
    private Position positions;

    public User(int id, String name, String password, String username, String cardNumber, Position positions) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.cardNumber = cardNumber;
        this.positions = positions;
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

    public String getCardNumberFormatted() {
        return cardNumber.substring(0, 4) + "...";
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Position getPositions() {
        return positions;
    }

    public void setPositions(Position positions) {
        this.positions = positions;
    }
}
