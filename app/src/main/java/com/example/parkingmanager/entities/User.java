package com.example.parkingmanager.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Enumeration;
@Entity (tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull private int id;
    private String name;
    private String password;
    private String username;
    private String cardNumber;
    private int idPosition= new Position().getId();



//    Constructor no argument
    public User() {
        this.id = 0;
        this.name = "";
        this.password = "";
        this.username = "";
        this.cardNumber = "";
        this.idPosition = 0;

    }

    public User(int id, String name, String password, String username, String cardNumber, int idPosition, Position position) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.cardNumber = cardNumber;
        this.idPosition = idPosition;


    }

    public User(int id, String name, String password, String username, String cardNumber, int idPosition) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.cardNumber = cardNumber;
        this.idPosition = idPosition;
    }

    //    Constructor with full parameters
    public User(int id, String name, String password, String username, String cardNumber, Position positions) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.username = username;
        this.cardNumber = cardNumber;
        this.idPosition = idPosition;


    }

//  Constructor missing cardNumber
    public User(int id, String name, String password, String username, Position positions) {
        this.id = id;
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

    public String getCardNumberFormatted() {
        if (cardNumber==null) {
            return "no card";
        } else {
            return cardNumber.substring(0, 5) + "...";
        }
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

    public ArrayList getListData() {
        Position position = new Position();
        position.getListData();
        ArrayList<User> results = new ArrayList<User>();
        User user = new User(1, "John","pass", "john", "123456789", 1);
        results.add(user);
        user = new User(2,"Kathie", "pass","janedoe","1234567890123456", 2);
        results.add(user);
        user = new User(3,"John Smith", "pass","johnsmith","999999", 1);
        results.add(user);
        user = new User(4,"Daria", "pass","janesmith","1234567890123456", 3);
        results.add(user);
        return results;
    }
}
