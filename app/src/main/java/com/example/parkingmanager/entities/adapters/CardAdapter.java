
package com.example.parkingmanager.entities.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.parkingmanager.R;
import com.example.parkingmanager.entities.Card;

import java.util.List;

public class CardAdapter extends BaseAdapter {
    Context myContext;
    TextView ID;
    TextView nameCard;
    TextView TypeCard;
    ListView lvCard;
    int mylayout;
    private List<Card> listData;
    public CardAdapter(Context aContext,int layout, List<Card> listData) {
        this.listData = listData;
        myContext = aContext;
        this.mylayout=layout;
    }



    public void setListData(List<Card> listData) {
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

    public View getView(int positionId, View v, ViewGroup vg) {
        LayoutInflater layoutInflater= (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=layoutInflater.inflate(mylayout,null);


        nameCard = v.findViewById(R.id.nameCard);
        nameCard.setText(listData.get(positionId).getName());

            ID=v.findViewById(R.id.ID);
            ID.setText(String.valueOf(listData.get(positionId).getId()));

            TypeCard = v.findViewById(R.id.TypeCard);
        TypeCard.setText(String.valueOf(listData.get(positionId).getTypeId()));
        return v;
    }
}


//package com.example.parkingmanager.entities;
//
//import android.app.Activity;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import com.example.parkingmanager.R;
//import com.example.parkingmanager.database.AppDatabase;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CardAdapter extends BaseAdapter {
//    private List<Card> listData;
//    private LayoutInflater layoutInflater;
//    public CardAdapter(Context aContext, List<Card> listData) {
//        this.listData = listData;
//        layoutInflater = LayoutInflater.from(aContext);
//    }
//    public void setListData(List<Card> listData) {
//        this.listData=listData;
//        notifyDataSetChanged();
//    }
//    @Override
//    public int getCount() {
//        return listData.size();
//    }
//    @Override
//    public Object getItem(int position) {
//        return listData.get(position);
//    }
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//    public View getView(int position, View v, ViewGroup vg) {
////        List<Position> positions = new ArrayList<Position>();
////        positions = AppDatabase.getInstance(vg.getContext()).positionDAO().getAllPositions();
//        ViewHolder holder;
//        System.out.println("abc");
//        if (v == null) {
//            v = layoutInflater.inflate(R.layout.card_card, null);
//            holder = new ViewHolder();
//            holder.ID =  v.findViewById(R.id.ID);
//            holder.nameCard = v.findViewById(R.id.nameCard);
//            holder.TypeCard = v.findViewById(R.id.TypeCard);
//            v.setTag(holder);
//        } else {
//            holder = (ViewHolder) v.getTag();
//        }
//
//
//
//        return v;
//    }
//    static class ViewHolder {
//        TextView ID;
//        TextView nameCard;
//        TextView TypeCard;
//    }
//}