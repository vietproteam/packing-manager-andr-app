package com.example.parkingmanager.activities.fragments;

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
import com.example.parkingmanager.activities.admin.SuperLoginActivity;


public class MenuAdminFragment extends Fragment {

    public MenuAdminFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_admin, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_admin, menu);
        super.onCreateOptionsMenu(menu, inflater);


    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_user_management:
//                return true;
//            case R.id.action_report:
//                return true;
//            case R.id.action_settings:
//                return true;
//            case R.id.action_logout:
//                Intent intent = new Intent( getActivity(), SuperLoginActivity.class);
//                startActivity(intent);
//                getActivity().finish();
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }
}