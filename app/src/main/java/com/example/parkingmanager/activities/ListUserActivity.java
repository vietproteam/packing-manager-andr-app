package com.example.parkingmanager.activities;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.parkingmanager.R;
import com.example.parkingmanager.entities.Position;
import com.example.parkingmanager.entities.User;
import com.example.parkingmanager.entities.UserAdapter;

public class ListUserActivity extends Activity {

    private ListView listView;
    private ArrayList<User> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);
        ArrayList userList = getListData();
        final ListView lv = (ListView) findViewById(R.id.lvUser);
        lv.setAdapter(new UserAdapter(this, userList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                User user = (User) lv.getItemAtPosition(position);
                Toast.makeText(ListUserActivity.this, "Selected :" + " " + user.getName()+", "+ user.getPositions().getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayList getListData() {
        Position position = new Position(1, "Manager");
        ArrayList<User> results = new ArrayList<User>();
        User user = new User(1,"John Doe","johndoe","1234567890123456","Manager", position);
        results.add(user);
        user = new User(2,"Jane Doe","janedoe","1234567890123456","Manager", position);
        results.add(user);
        user = new User(3,"John Smith","johnsmith","1234567890123456","Manager", position);
        results.add(user);
        user = new User(4,"Jane Smith","janesmith","1234567890123456","Manager", position);
        results.add(user);
        return results;
    }
    //gọi hàm xử lý nhập thông tin nhân viên
//    public void xulyNhap()
//    {
//        String ma=editMa.getText()+"";
//        String ten=editTen.getText()+"";
//        boolean gioitinh=false;//Nam =false
//        if(genderGroup.getCheckedRadioButtonId()==R.id.rdoNu)
//            gioitinh=true;
//        //Tạo một employee
//        SuperUser emp=new SuperUser();
//        emp.setId(ma);
//        emp.setName(ten);
//        emp.setGender(gioitinh);
//        //Đưa vào danh sách
//        arrEmployee.add(emp);
//        //gọi hàm cập nhật giao diện
//        adapter.notifyDataSetChanged();
//        //Sau khi update thì xóa trắng dữ liệu và cho editma focus
//        editMa.setText("");
//        editTen.setText("");
//        editMa.requestFocus();
//    }
//    //hàm xử lý xóa
//    public void xulyXoa()
//    {
//        //ta nên đi ngược danh sách, kiểm tra phần tử nào checked
//        //thì xóa đúng vị trí đó ra khỏi arrEmployee
//        for(int i=lvNhanvien.getChildCount()-1;i>=0;i--)
//        {
//            //lấy ra dòng thứ i trong ListView
//            //Dòng thứ i sẽ có 3 phần tử: ImageView, TextView, Checkbox
//            View v=lvNhanvien.getChildAt(i);
//            //Ta chỉ lấy CheckBox ra kiểm tra
////            CheckBox chk=(CheckBox) v.findViewById(R.id.chkitem);
//            //Nếu nó Checked thì xóa ra khỏi arrEmployee
////            if(chk.isChecked())
////            {
////                //xóa phần tử thứ i ra khỏi danh sách
////                arrEmployee.remove(i);
////            }
//        }
//        //Sau khi xóa xong thì gọi update giao diện
//        adapter.notifyDataSetChanged();
//    }
}