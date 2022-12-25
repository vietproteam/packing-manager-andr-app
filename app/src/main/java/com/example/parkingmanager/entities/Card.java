package com.example.parkingmanager.entities;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "cards")
public class Card {
    @PrimaryKey ()
    @NonNull private String id;
    private String name;
    @Embedded(prefix = "type_")
    private Type type;

    public Card() {
        id = "";
        name = "";
        type = new Type();
    }

    public Card(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
