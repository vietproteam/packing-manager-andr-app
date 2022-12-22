package com.example.parkingmanager.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.parkingmanager.entities.Record;

@Dao
public interface RecordDAO {
    @Insert
    void insertParkingRecord(Record record);

    @Delete
    void deleteParkingRecord(Record record);

    @Update
    void updateParkingRecord(Record record);
}
