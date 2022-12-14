package com.example.parkingmanager.entities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.parkingmanager.R;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private ArrayList<User> listData;
    private LayoutInflater layoutInflater;
    public UserAdapter(Context aContext, ArrayList<User> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View v, ViewGroup vg) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.card_user, null);
            holder = new ViewHolder();
            holder.uName = (TextView) v.findViewById(R.id.tvName);
            holder.uUsername = (TextView) v.findViewById(R.id.tvUsername);
            holder.uCardNumber = (TextView) v.findViewById(R.id.tvCardNumber);
            holder.uPosition = (TextView) v.findViewById(R.id.tvPosition);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.uName.setText(listData.get(position).getName());
        holder.uUsername.setText(listData.get(position).getUsername());
        holder.uCardNumber.setText(listData.get(position).getCardNumberFormatted());
        holder.uPosition.setText(listData.get(position).getPositions().getName());
        return v;
    }
    static class ViewHolder {
        TextView uName;
        TextView uUsername;
        TextView uCardNumber;
        TextView uPosition;
    }
}