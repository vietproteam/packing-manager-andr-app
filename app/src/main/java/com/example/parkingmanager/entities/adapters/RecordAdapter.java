package com.example.parkingmanager.entities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkingmanager.R;
import com.example.parkingmanager.entities.Card;
import com.example.parkingmanager.entities.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordAdapter extends BaseAdapter {
    private List<Record> listData;
    private LayoutInflater layoutInflater;


    public RecordAdapter(Context aContext, List<Record> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);



    }
public void setListData(List<Record> listData) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.record_item, null);
            holder = new ViewHolder();
            holder.rTimeIn = (TextView) convertView.findViewById(R.id.tvTimein);
            holder.rTimeOut = (TextView) convertView.findViewById(R.id.tvTimeOut);
            holder.rImage = (ImageView) convertView.findViewById(R.id.imgAvatar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.rTimeIn.setText(listData.get(position).getTimeIn());
        holder.rTimeOut.setText(listData.get(position).getTimeOut());
//        holder.rImage.setImageResource(R.drawable.ic_launcher_background);
        return convertView;

    }


    static class ViewHolder {

        ImageView rImage;
        TextView rTimeIn;
        TextView rTimeOut;

    }





}
