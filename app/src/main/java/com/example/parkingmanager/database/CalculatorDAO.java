package com.example.parkingmanager.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.parkingmanager.entities.Calculator;

@Dao
public interface CalculatorDAO {
    @Insert
    void insertCalculator(Calculator calculator);

    @Query("SELECT * FROM calculators WHERE id = :id")
    Calculator getCalculatorById(int id);

    @Query("SELECT * FROM calculators")
    Calculator[] getAllCalculators();

    @Update
    void updateCalculator(Calculator calculator);

    @Query("DELETE FROM calculators WHERE id = :id")
    void deleteCalculatorById(int id);

    @Delete
    void deleteCalculator(Calculator calculator);
}
