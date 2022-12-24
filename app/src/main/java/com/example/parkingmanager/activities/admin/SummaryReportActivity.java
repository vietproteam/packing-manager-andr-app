package com.example.parkingmanager.activities.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.parkingmanager.R;

public class SummaryReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_report);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_admin, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_user_management:
                return true;
            case R.id.action_report:
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_logout:
                Intent intent = new Intent(this, SuperLoginActivity.class);
                startActivity(intent);
                this.finish();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}