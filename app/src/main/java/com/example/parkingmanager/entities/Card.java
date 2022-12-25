package com.example.parkingmanager.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "cards")
public class Card {
    @PrimaryKey ()
    @NonNull private String id;
    private String name;
    private int typeId;
    @Ignore
    private Type type;

    public Card() {
        id = "";
        name = "";
        typeId = 0;
    }

    public Card(String id, String name, int typeId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
