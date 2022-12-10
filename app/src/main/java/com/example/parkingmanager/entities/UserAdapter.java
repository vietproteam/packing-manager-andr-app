package com.example.parkingmanager.entities;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class UserAdapter extends
        ArrayAdapter<SuperUser> {
    Activity context;
    ArrayList<SuperUser> myArray;
    int layoutId;

    public UserAdapter(Activity context,
                       int layoutId,
                       ArrayList<SuperUser> arr) {
        super(context, layoutId, arr);
        this.context = context;
        this.layoutId = layoutId;
        this.myArray = arr;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {

        LayoutInflater inflater =
                context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);

        return convertView;//trả về View này, tức là trả luôn

    }
}
