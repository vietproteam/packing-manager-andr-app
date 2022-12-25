package com.example.parkingmanager.activities.admin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.fragments.MenuAdminFragment;


public class SummaryReportActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_summary_report);

        MenuAdminFragment menuAdminFragment = new MenuAdminFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, menuAdminFragment).commit();



    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_admin, menu);
        return true;
    }
    @Override

    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_user_management:
                return true;
            case R.id.action_report:
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_logout:
                Intent intent = new Intent( this, SuperLoginActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}