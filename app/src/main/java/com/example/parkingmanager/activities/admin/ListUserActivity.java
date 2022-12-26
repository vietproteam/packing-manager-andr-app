package com.example.parkingmanager.activities.admin;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.parkingmanager.R;
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.entities.adapters.UserAdapter;

public class ListUserActivity extends Activity {


    private UserAdapter list;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        final ListView lv = (ListView) findViewById(R.id.lvUser);
        List<User> users = new ArrayList<User>();
        users = AppDatabase.getInstance(this).userDAO().getAllUsers();
        lv.setAdapter(new UserAdapter(this, users));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                User o = (User) lv.getItemAtPosition(position);
                Intent intent = new Intent(ListUserActivity.this, UserManagerActivity.class);
                int userId = o.getId();
                Bundle bundle = new Bundle();
                bundle.putInt("userId", userId);
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_CODE, bundle);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                recreate();
            }
        }
    }


}