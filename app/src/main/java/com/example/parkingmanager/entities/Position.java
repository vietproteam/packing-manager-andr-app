package com.example.parkingmanager.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity (tableName = "positions")
public class Position {
    @PrimaryKey(autoGenerate = true)
    @NonNull private int id;
    private String name;
    private String description;

    public Position() {
        this.id = 0;
        this.name = "";
        this.description = "";
    }

    public Position(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Position(int id, String name) {
        this.id = id;
        this.name = name;
        this.description = "This is a description";
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Position> getListData() {
        List<Position> list = new ArrayList<>();
        list.add(new Position(1, "Manager"));
        list.add(new Position(2, "Staff"));
        list.add(new Position(3, "Admin"));
        return list;
    }

}
