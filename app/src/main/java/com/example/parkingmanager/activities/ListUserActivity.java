package com.example.parkingmanager.activities;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
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
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.entities.UserAdapter;

public class ListUserActivity extends Activity {


    private UserAdapter list;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        final ListView lv = (ListView) findViewById(R.id.lvUser);
        List<User> users= new ArrayList<User>();
        users= AppDatabase.getInstance(this).userDAO().getAllUsers();

        lv.setAdapter(new UserAdapter(this, users));



             lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    Object o= lv.getItemAtPosition(position);
                    Intent intent = new Intent(ListUserActivity.this, UserManagerActivity.class);
                    User user = (User) o;

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("users", user);
                    intent.putExtras(bundle);
                    startActivityForResult(intent, REQUEST_CODE);






                }
        });

    }




}