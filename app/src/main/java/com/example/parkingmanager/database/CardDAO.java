package com.example.parkingmanager.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.parkingmanager.entities.Card;

import java.util.List;

@Dao
public interface CardDAO {
    @Insert
    void insertCard(Card card);

    @Query("SELECT * FROM cards WHERE id = :cardId")
    Card getCardById(int cardId);

    @Query("SELECT * FROM cards")
    Card[] getAllCards();

    @Delete
    void deleteCard(Card card);

    @Query("SELECT * FROM cards")
    List<Card> getAllCard();

    @Update
    void updateCard(Card card);
}
