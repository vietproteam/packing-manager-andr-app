package com.example.parkingmanager.database;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.parkingmanager.entities.Position;

@Dao
public interface PositionDAO {
    @Insert
    void insertPosition(Position position);

    @Delete
    void deletePosition(Position position);

    @Update
    void updatePosition(Position position);




}
