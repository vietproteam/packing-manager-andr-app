package com.example.parkingmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.parkingmanager.R;
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.Card;
import com.example.parkingmanager.entities.adapters.CardAdapter;

import java.util.ArrayList;
import java.util.List;

public class activity_list_card extends AppCompatActivity {
    Button btnThem;
    EditText txtName;
    EditText txtType;
    CardAdapter adapter;
    List<Card> cardss = new ArrayList<Card>();
    ListView lv ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_card);
        btnThem= findViewById(R.id.btnThem);
        txtName=  findViewById(R.id.txtName);
        txtType= findViewById(R.id.txtType);
        lv = (ListView) findViewById(R.id.lvCard);
        cardss = AppDatabase.getInstance(this).cardDAO().getAllCard();
        adapter=new CardAdapter(this,R.layout.card_card, cardss);
        lv.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCard();
//                cardss = AppDatabase.getInstance().cardDAO().getAllCard();
                adapter.notifyDataSetChanged();
            }
        });

    }
    public void AddCard(){
        Card card = new Card();
        AppDatabase.getInstance(this).cardDAO().insertCard(card);
        cardss = AppDatabase.getInstance(this).cardDAO().getAllCard();
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Thêm card thành công", Toast.LENGTH_SHORT).show();


    }
}