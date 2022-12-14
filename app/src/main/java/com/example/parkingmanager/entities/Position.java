package com.example.parkingmanager.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "positions")
public class Position {
    @PrimaryKey(autoGenerate = true)
    private String id;
    private String name;
    private String description;

    public Position(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
