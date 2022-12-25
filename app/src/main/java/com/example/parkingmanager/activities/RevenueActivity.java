package com.example.parkingmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.parkingmanager.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RevenueActivity extends AppCompatActivity {

    Button btnSave;
    EditText edFrom, edTo;
    TextView tvTotal,tvRevenue;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        edFrom = findViewById(R.id.edFrom);
        edTo= findViewById(R.id.edTo);
        tvTotal= findViewById(R.id.tvTotal);
        tvRevenue= findViewById(R.id.tvRevenue);
        btnSave= findViewById(R.id.btnSave);
        edFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c= Calendar.getInstance();
                int day= c.get(Calendar.DAY_OF_MONTH);
                int month= c.get(Calendar.MONTH);
                int year= c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog= new DatePickerDialog(RevenueActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        c.set(i,i1,i2);
                        edFrom.setText(sdf.format(c.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        edTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c= Calendar.getInstance();
                int day= c.get(Calendar.DAY_OF_MONTH);
                int month= c.get(Calendar.MONTH);
                int year= c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog= new DatePickerDialog(RevenueActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        c.set(i,i1,i2);
                        edTo.setText(sdf.format(c.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();

            }

        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from= edFrom.getText().toString();
                String to= edTo.getText().toString();

                if (from.isEmpty() || to.isEmpty()){
                    edFrom.setError("Please enter date");
                    edTo.setError("Please enter date");
                }else {
                    tvTotal.setText(String.valueOf(tvTotal));
                    tvRevenue.setText(String.valueOf(tvRevenue));
                }
            }


        });
    }
    DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(android.widget.DatePicker datePicker, int i, int i1, int i2) {
            Calendar c= Calendar.getInstance();
            c.set(Calendar.YEAR,i);
            c.set(Calendar.MONTH,i1);
            c.set(Calendar.DAY_OF_MONTH,i2);
            edFrom.setText(sdf.format(c.getTime()));
        }
    };


}