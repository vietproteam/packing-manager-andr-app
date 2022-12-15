package com.example.parkingmanager.entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ParkingRecord {
    @PrimaryKey (autoGenerate = true)
    @NonNull private int id;
    private int IdUser;
    private int IdPosition;
    private String timeIn;
    private String timeOut;
    private String imgIn;
    private String imgOut;
    private String isLocking;

    public ParkingRecord(int id, int idUser, int idPosition, String timeIn, String timeOut, String imgIn, String imgOut, String isLocking) {
        this.id = id;
        IdUser = idUser;
        IdPosition = idPosition;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.imgIn = imgIn;
        this.imgOut = imgOut;
        this.isLocking = isLocking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public int getIdPosition() {
        return IdPosition;
    }

    public void setIdPosition(int idPosition) {
        IdPosition = idPosition;
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
}
