package com.example.parkingmanager.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.parkingmanager.entities.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDB extends RoomDatabase {


    public static final String DB_NAME = "user_db";
    private static UserDB instance;

    public static synchronized UserDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDB.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract UserDAO userDAO();
}

