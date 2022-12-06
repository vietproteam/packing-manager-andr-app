//package com.example.parkingmanager.activities;
//
//import java.util.ArrayList;
//
//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.parkingmanager.R;
//
//public class myadappter extends
//        ArrayAdapter<User> {
//    Activity context = null;
//    ArrayList<User> myArray = null;
//    int layoutId;
//
//    public myadappter(Activity context,
//                      int layoutId,
//                      ArrayList<User> arr) {
//        super(context, layoutId, arr);
//        this.context = context;
//        this.layoutId = layoutId;
//        this.myArray = arr;
//    }
//
//    public View getView(int position, View convertView,
//                        ViewGroup parent) {
//
//        LayoutInflater inflater =
//                context.getLayoutInflater();
//        convertView = inflater.inflate(layoutId, null);
//        //chỉ là test thôi, bạn có thể bỏ If đi
//        if (myArray.size() > 0 && position >= 0) {
//            final TextView txtdisplay = (TextView)
//                    convertView.findViewById(R.id.txtitem);
//            final User emp = myArray.get(position);
//
//            txtdisplay.setText(emp.toString());
//            final ImageView imgitem = (ImageView)
//                    convertView.findViewById(R.id.imgitem);
//            if (emp.isGender())
//                imgitem.setImageResource(R.drawable.bgtech);
//            else
//                imgitem.setImageResource(R.drawable.bgtech);
//        }
//
//        return convertView;//trả về View này, tức là trả luôn
//
//    }
//}
