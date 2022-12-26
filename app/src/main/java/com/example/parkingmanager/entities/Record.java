package com.example.parkingmanager.entities;


import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(tableName = "records")
public class Record {
    @PrimaryKey (autoGenerate = true)
    @NonNull private int id;
    private String timeIn;
    private String timeOut;
    private String imgIn;
    private String imgOut;
    private String isLocking;
    @Embedded(prefix = "user_")
    private User user;
    @Embedded(prefix = "card_")
    private Card card;

    public Record() {
        this.id = 0;
        this.timeIn = "";
        this.timeOut = "";
        this.imgIn = "";
        this.imgOut = "";
        this.isLocking = "";
        this.user = new User();
        this.card = new Card();
    }

    public Record(int id, String timeIn, String timeOut, String imgIn, String imgOut, String isLocking, User user, Card card) {
        this.id = id;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.imgIn = imgIn;
        this.imgOut = imgOut;
        this.isLocking = isLocking;
        this.user = user;
        this.card = card;
    }

    public Record(String timeIn, String timeOut, String imgIn, String imgOut, String isLocking, User user, Card card) {
        this.id = 0;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.imgIn = imgIn;
        this.imgOut = imgOut;
        this.isLocking = isLocking;
        this.user = user;
        this.card = card;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getImgIn() {
        return imgIn;
    }

    public void setImgIn(String imgIn) {
        this.imgIn = imgIn;
    }

    public String getImgOut() {
        return imgOut;
    }

    public void setImgOut(String imgOut) {
        this.imgOut = imgOut;
    }

    public String getIsLocking() {
        return isLocking;
    }

    public void setIsLocking(String isLocking) {
        this.isLocking = isLocking;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Record> getAdapter() {
        ArrayList<Record> records = new ArrayList<Record>();
        records.add(new Record("2020-01-01 00:00:00", "2020-01-01 00:00:00", "imgIn", "imgOut", "true", new User(), new Card()));
        records.add(new Record("2020-01-01 00:00:00", "2020-01-01 00:00:00", "imgIn", "imgOut", "true", new User(), new Card()));
        records.add(new Record("2020-01-01 00:00:00", "2020-01-01 00:00:00", "imgIn", "imgOut", "true", new User(), new Card()));
        return  records;

    }
}
