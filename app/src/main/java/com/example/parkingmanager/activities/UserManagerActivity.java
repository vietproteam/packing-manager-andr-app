package com.example.parkingmanager.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkingmanager.R;
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class UserManagerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

private EditText edUserNames;
private EditText edPasswords;
private EditText edCardNumbers;
private Spinner spinner;
private Button btnUpdate;
private Button btnDelete;
private User lUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_manager);
        init();
        setSpinner();

        lUser= (User) getIntent().getExtras().get("users");
        if(lUser!=null){
            edUserNames.setText(lUser.getUsername());
            edPasswords.setText(lUser.getPassword());
            edCardNumbers.setText(lUser.getCardNumber());
            spinner.setSelection(lUser.getIdPosition()-1);
        }
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void init(){
        edUserNames = findViewById(R.id.etUsername);
        edPasswords = findViewById(R.id.edPasswords);
        edCardNumbers = findViewById(R.id.edCardNumbers);
        spinner = findViewById(R.id.spPositions);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
    }
    public void setSpinner(){
        List<Position>  positions = new ArrayList<Position>();
        positions= AppDatabase.getInstance(this).positionDAO().getAllPositions();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < positions.size(); i++) {
            list.add(positions.get(i).getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void update(){
        User lUser;
        lUser= (User) getIntent().getExtras().get("users");
        lUser.setUsername(edUserNames.getText().toString());
        lUser.setPassword(edPasswords.getText().toString());
        lUser.setCardNumber(edCardNumbers.getText().toString());
        lUser.setIdPosition(spinner.getSelectedItemPosition()+1);
        AppDatabase.getInstance(this).userDAO().updateUser(lUser);
        Toast toast = Toast.makeText(this, "User updated", Toast.LENGTH_SHORT);
    }
    private boolean UserExists(@NotNull  User user){
        List<User> list= (List<User>) AppDatabase.getInstance(this).userDAO().getUserByUsername(user.getUsername());
        return list!=null && list.isEmpty();


    }
    public void delete(){
        User lUser;
        lUser= (User) getIntent().getExtras().get("users");
        AppDatabase.getInstance(this).userDAO().deleteUser(lUser);
        Toast toast = Toast.makeText(this, "User deleted", Toast.LENGTH_SHORT);


    }


}