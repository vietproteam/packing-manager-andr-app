package com.example.parkingmanager.entities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.parkingmanager.R;
import com.example.parkingmanager.database.AppDatabase;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {


    private List<User> listData;
    private LayoutInflater layoutInflater;
    public UserAdapter(Context aContext, List<User> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    public void setListData(List<User> listData) {
        this.listData=listData;
        notifyDataSetChanged();
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
        List<Position> positions = new ArrayList<Position>();
        positions = AppDatabase.getInstance(vg.getContext()).positionDAO().getAllPositions();
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

        for (int i = 0; i < positions.size(); i++) {
            if (listData.get(position).getPosition().getId() == positions.get(i).getId()) {
                holder.uPosition.setText(positions.get(i).getName());
            }
        }


        return v;
    }
    static class ViewHolder {
        TextView uName;
        TextView uUsername;
        TextView uCardNumber;
        TextView uPosition;
    }
}