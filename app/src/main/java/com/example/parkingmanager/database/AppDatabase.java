package com.example.parkingmanager.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.parkingmanager.entities.Calculator;
import com.example.parkingmanager.entities.Card;
import com.example.parkingmanager.entities.Record;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.Type;
import com.example.parkingmanager.entities.User;

@Database(entities = {User.class, Position.class, Calculator.class, Type.class, Card.class, Record.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {


    public static final String DB_NAME = "parking_manager_db";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract PositionDAO positionDAO();

    public abstract UserDAO userDAO();

    public abstract CalculatorDAO calculatorDAO();

    public abstract TypeDAO typeDAO();

    public abstract CardDAO cardDAO();

    public abstract RecordDAO recordDAO();
}

