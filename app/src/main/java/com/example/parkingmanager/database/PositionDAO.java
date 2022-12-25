package com.example.parkingmanager.database;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.parkingmanager.entities.Position;

import java.util.List;

@Dao
public interface PositionDAO {
    @Insert
    void insertPosition(Position position);

    @Query("SELECT * FROM positions")
    List<Position> getAllPositions();

    @Query("SELECT * FROM positions WHERE id = :id")
    Position getPositionById(int id);

    @Update
    void updatePosition(Position position);

    @Delete
    void deletePosition(Position position);




}
