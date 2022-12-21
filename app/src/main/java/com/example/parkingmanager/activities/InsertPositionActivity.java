package com.example.parkingmanager.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkingmanager.R;
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.database.PositionDAO;
import com.example.parkingmanager.entities.Position;

public class InsertPositionActivity extends AppCompatActivity {
private EditText etName;
private EditText etdescription;
private Button btnSave;
private Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_position);
        init();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });


    }
    public void init(){
        etName = findViewById(R.id.etName);
        etdescription = findViewById(R.id.etdescription);
        btnSave = findViewById(R.id.btnSave);
    }
    public void save(){
        String name = etName.getText().toString();
        String description = etdescription.getText().toString();
        if (
                name.isEmpty()
        ) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        Position position = new Position(name, description);

        AppDatabase.getInstance(this).positionDAO().insertPosition(position);
        Toast.makeText(this, "Position saved", Toast.LENGTH_SHORT).show();
        finish();
    }

}