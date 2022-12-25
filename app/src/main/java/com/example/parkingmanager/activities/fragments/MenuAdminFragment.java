package com.example.parkingmanager.activities.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.parkingmanager.R;
import com.example.parkingmanager.activities.admin.ListCardActivity;
import com.example.parkingmanager.activities.admin.ListUserActivity;
import com.example.parkingmanager.activities.admin.SuperLoginActivity;
import com.example.parkingmanager.activities.admin.UserManagerActivity;
import com.example.parkingmanager.activities.user.RevenueActivity;


public class MenuAdminFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_menu_admin, container, false);
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        inflater.inflate(R.menu.menu_admin, menu);
        super.onCreateOptionsMenu(menu, inflater);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_user_management:

                openActivity(ListUserActivity.class);
                return true;

            case R.id.action_report:
                openActivity(RevenueActivity.class);
                return true;
            case R.id.action_settings:
                return true;
            case R.id.action_list_card:
                openActivity(ListCardActivity.class);
                return true;
            case R.id.action_logout:
                openActivity(SuperLoginActivity.class);
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
    public void openActivity(Class<? extends Activity> activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }
}