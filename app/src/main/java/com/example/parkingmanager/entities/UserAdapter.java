package com.example.parkingmanager.entities;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingmanager.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{
private List<User> ListUsers;
public void SetData(List<User> ListUsers){
    this.ListUsers = ListUsers;
    notifyDataSetChanged();
}

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_my_info,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
    User user = ListUsers.get(position);
    if (user == null){
        return;

    }
    holder.tvName.setText(user.getName());
    holder.tvEmail.setText(user.getEmail());
    holder.tvPhone.setText(user.getPhone());


}

    @Override
    public int getItemCount() {
    if (ListUsers != null){
        return ListUsers.size();
    }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private EditText tvName;
        private EditText tvPassword;
        private EditText tvEmail;
        private EditText tvPhone;
        private EditText tvPosition;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvPassword = itemView.findViewById(R.id.tvPassword);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPhone = itemView.findViewById(R.id.tvPhone);

        }
    }

}
