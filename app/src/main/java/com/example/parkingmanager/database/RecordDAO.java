package com.example.parkingmanager.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
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

    @Query("SELECT * FROM Record")
    Record getAllParkingRecord();



    @Query("SELECT * FROM Record WHERE idCard = :idCard")
    Record getParkingRecordByIdCard(String idCard);

    @Query("SELECT * FROM Record WHERE timeIn = :timeIn")
    Record getParkingRecordByTimeIn(String timeIn);

    @Query("SELECT * FROM Record WHERE timeOut = :timeOut")
    Record getParkingRecordByTimeOut(String timeOut);


}
