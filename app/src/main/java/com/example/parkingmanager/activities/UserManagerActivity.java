package com.example.parkingmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.parkingmanager.R;
import com.example.parkingmanager.entities.Position;

import java.util.ArrayList;
import java.util.List;


public class UserManagerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);

        Spinner spinner = findViewById(R.id.spPositions);
        Position position = new Position();
        position.getListData();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < position.getListData().size(); i++) {
            list.add(position.getListData().get(i).getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



}