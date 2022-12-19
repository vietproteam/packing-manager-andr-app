package com.example.parkingmanager.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.parkingmanager.entities.Card;

@Dao
public interface CardDAO {
    @Insert
    void insertCard(Card card);

    @Delete
    void deleteCard(Card card);

    @Update
    void updateCard(Card card);
}