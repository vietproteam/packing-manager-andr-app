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
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.parkingmanager.R;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.entities.UserAdapter;

public class ListUserActivity extends Activity {

    private ListView listView;
    private ArrayList<User> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        ArrayList userList = getListData();
        final ListView lv = (ListView) findViewById(R.id.lvUser);
        lv.setAdapter(new UserAdapter(this, userList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                User user = (User) lv.getItemAtPosition(position);
                Toast.makeText(ListUserActivity.this, "Selected :" + " " + user.getName()+", "+ user.getPositions().getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayList getListData() {
        Position position = new Position(1, "Manager");
        ArrayList<User> results = new ArrayList<User>();
        User user = new User(1, "John","pass", "john", position);
        results.add(user);
        user = new User(2,"Kathie", "pass","janedoe","1234567890123456", position);
        results.add(user);
        user = new User(3,"John Smith", "pass","johnsmith","1234567890123456", position);
        results.add(user);
        user = new User(4,"Daria", "pass","janesmith","1234567890123456", position);
        results.add(user);
        return results;
    }
}