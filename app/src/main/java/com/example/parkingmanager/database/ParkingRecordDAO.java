package com.example.parkingmanager.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.parkingmanager.entities.ParkingRecord;

@Dao
public interface ParkingRecordDAO {
    @Insert
    void insertParkingRecord(ParkingRecord parkingRecord);

    @Delete
    void deleteParkingRecord(ParkingRecord parkingRecord);

    @Update
    void updateParkingRecord(ParkingRecord parkingRecord);
}
