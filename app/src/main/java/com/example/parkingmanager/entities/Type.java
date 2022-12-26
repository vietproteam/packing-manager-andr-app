package com.example.parkingmanager.entities;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "types")
public class Type {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private int price;
    @Embedded(prefix = "calculator_")
    private Calculator calculator;

    public Type() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.price = 0;
        this.calculator = new Calculator();
    }

    public Type(int id, String name, String description, int price, Calculator calculator) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.calculator = calculator;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
