package com.example.parkingmanager.entities;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

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

    public ParkingRecord() {
        this.id = 0;
        this.IdUser = 0;
        this.IdPosition = 0;
        this.timeIn = "";
        this.timeOut = "";
        this.imgIn = "";
        this.imgOut = "";
        this.isLocking = "";
    }

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

    private ArrayList getListData() {

        ArrayList<ParkingRecord> results = new ArrayList<ParkingRecord>();
        ParkingRecord position = new ParkingRecord(1, 1, 1, "2020-12-12 12:12:12", "2020-12-12 12:12:12", "imgIn", "imgOut", "1");
        results.add(position);
        position = new ParkingRecord(2, 2, 2, "2020-12-12 12:12:12", "2020-12-12 12:12:12", "imgIn", "imgOut", "1");
        results.add(position);
        position = new ParkingRecord(3, 3, 3, "2020-12-12 12:12:12", "2020-12-12 12:12:12", "imgIn", "imgOut", "1");
        results.add(position);
        return results;
    }
}
