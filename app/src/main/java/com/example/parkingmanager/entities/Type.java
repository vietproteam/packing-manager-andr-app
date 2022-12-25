package com.example.parkingmanager.entities;

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
    private int calculatorId;
    @Ignore
    private Calculator calculator;

    public Type() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.price = 0;
        this.calculatorId = 0;
        this.calculator = new Calculator();
    }

    public Type(int id, String name, String description, int price, int calculatorId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.calculatorId = calculatorId;
        this.calculator = new Calculator();
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

    public int getCalculatorId() {
        return calculatorId;
    }

    public void setCalculatorId(int calculatorId) {
        this.calculatorId = calculatorId;
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
