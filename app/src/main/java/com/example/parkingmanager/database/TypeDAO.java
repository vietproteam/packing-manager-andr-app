package com.example.parkingmanager.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.parkingmanager.entities.Type;

@Dao
public interface TypeDAO {
    @Insert
    void insertType(Type type);

    @Query("SELECT * FROM types")
    Type[] getAllTypes();

    @Query("SELECT * FROM types WHERE id = :id")
    Type getTypeById(int id);

    @Update
    void updateType(Type type);

    @Query("DELETE FROM types WHERE id = :id")
    void deleteTypeById(int id);

    @Delete
    void deleteType(Type type);
}
