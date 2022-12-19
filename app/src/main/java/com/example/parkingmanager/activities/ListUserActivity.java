package com.example.parkingmanager.activities;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingmanager.R;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.entities.UserAdapter;

public class ListUserActivity extends Activity {

    private RecyclerView lvUser;
    private UserAdapter list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);




        User user = new User();
        Position position = new Position();
        position.getListData();
        final ListView lv = (ListView) findViewById(R.id.lvUser);
        lv.setAdapter(new UserAdapter(this, user.getListData()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                User user = (User) lv.getItemAtPosition(position);
                Toast.makeText(ListUserActivity.this, "Selected :" + " " + user.getName()+", "+ user.getIdPosition(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}