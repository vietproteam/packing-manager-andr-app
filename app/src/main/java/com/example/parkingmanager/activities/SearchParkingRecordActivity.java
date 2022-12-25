package com.example.parkingmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TimePicker;

import com.example.parkingmanager.R;
import com.example.parkingmanager.entities.Record;
import com.example.parkingmanager.entities.adapters.RecordAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SearchParkingRecordActivity extends AppCompatActivity {
    Button btnSave;
    ImageButton btnDateFrom, btnDateTo;
    ImageButton btnTimeFrom, btnTimeTo;
    EditText edFrom, edTo;
    SimpleDateFormat sdfDay = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdfTime = new SimpleDateFormat("mm:HH");

     List<Record> records ;
    RecordAdapter recordAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_parking_record);
        edFrom = findViewById(R.id.edFrom);
        edTo= findViewById(R.id.edTo);
        final ListView lv = (ListView) findViewById(R.id.lvParkingRecord);
        btnSave= findViewById(R.id.btnSave);
        btnDateFrom = findViewById(R.id.btnDateFrom);
        btnDateTo = findViewById(R.id.btnDateTo);
        btnTimeFrom = findViewById(R.id.btnTimeFrom);
        btnTimeTo = findViewById(R.id.btnTimeTo);
        btnDateFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c= Calendar.getInstance();
                int day= c.get(Calendar.DAY_OF_MONTH);
                int month= c.get(Calendar.MONTH);
                int year= c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog= new DatePickerDialog(SearchParkingRecordActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        c.set(i,i1,i2);
                        edFrom.setText(sdfDay.format(c.getTime()));
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        btnDateTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c= Calendar.getInstance();
                int day= c.get(Calendar.DAY_OF_MONTH);
                int month= c.get(Calendar.MONTH);
                int year= c.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog= new DatePickerDialog(SearchParkingRecordActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        c.set(i,i1,i2);
                        edTo.setText(sdfDay.format(c.getTime()));
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
                    edFrom.setError("Please enter");
                    edTo.setError("Please enter ");
                }else {
                    //show list
                    records = new ArrayList<>();
                    Record record = new Record();
                    records= record.getAdapter();
                    recordAdapter = new RecordAdapter(SearchParkingRecordActivity.this, records);
                    lv.setAdapter(recordAdapter);





                }
            }
        });
        btnTimeTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c= Calendar.getInstance();
                int hour= c.get(Calendar.HOUR_OF_DAY);
                int minute= c.get(Calendar.MINUTE);
                int second= c.get(Calendar.SECOND);
                TimePickerDialog timePickerDialog= new TimePickerDialog(SearchParkingRecordActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        c.set(hourOfDay,minute,second);
                        edTo.setText(sdfTime.format(c.getTime()));
                    }
                },hour,minute,true);



                timePickerDialog.show();
            }
        });
        btnTimeFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c= Calendar.getInstance();
                int hour= c.get(Calendar.HOUR_OF_DAY);
                int minute= c.get(Calendar.MINUTE);
                int second= c.get(Calendar.SECOND);
                TimePickerDialog timePickerDialog= new TimePickerDialog(SearchParkingRecordActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        c.set(hourOfDay,minute,second);
                        edFrom.setText(sdfTime.format(c.getTime()));
                    }
                },hour,minute,true);
                timePickerDialog.show();
            }
        });


    }






}