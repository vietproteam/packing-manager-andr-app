package com.example.parkingmanager.entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Record {
    @PrimaryKey (autoGenerate = true)
    @NonNull private long id;
    private String timeIn;
    private String timeOut;
    private String imgIn;
    private String imgOut;
    private String isLocking;
    private int idUser;
    @Ignore
    private User user;
    private String idCard;
    @Ignore
    private Card card;

    public Record() {
        this.id = 0;
        this.timeIn = "";
        this.timeOut = "";
        this.imgIn = "";
        this.imgOut = "";
        this.isLocking = "";
        this.idUser = 0;
        this.idCard = "";
    }

    public Record(Long id, String timeIn, String timeOut, String imgIn, String imgOut, String isLocking, int idUser, String idCard) {
        this.id = id;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.imgIn = imgIn;
        this.imgOut = imgOut;
        this.isLocking = isLocking;
        this.idUser = idUser;
        this.idCard = idCard;
    }

    public Record(String s, String s1, String s2, String s3, String s4, String s5, int i) {
        this.id = 0;
        this.timeIn = s;
        this.timeOut = s1;
        this.imgIn = s2;
        this.imgOut = s3;
        this.isLocking = s4;
        this.idUser = i;
        this.idCard = s5;
    }

    public Record(long l, String timeOut, String imgOut, int idUser, String idCard) {
        this.id = l;
        this.timeOut = timeOut;
        this.imgOut = imgOut;
        this.idUser = idUser;
        this.idCard = idCard;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Record> getAdapter() {
        ArrayList<Record> records = new ArrayList<Record>();
        records.add(new Record("1","1","1","1","1","1",1));
        records.add(new Record("2","2","2","2","2","2",2));
        records.add(new Record("3","3","3","3","3","3",3));
        return  records;

    }
}
