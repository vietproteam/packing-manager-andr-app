package com.example.parkingmanager.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.parkingmanager.entities.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM users")
    List<User> getAllUsers();

}
