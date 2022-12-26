package com.example.parkingmanager.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calculators")
public class Calculator {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;

    public Calculator() {
        this.id = 0;
        this.name = "";
        this.description = "";
    }

    public Calculator(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Calculator(String name, String description) {
        this.id = 0;
        this.name = name;
        this.description = description;
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
}
