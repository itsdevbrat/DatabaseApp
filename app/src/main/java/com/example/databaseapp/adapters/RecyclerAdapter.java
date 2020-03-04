package com.example.databaseapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databaseapp.db.UserEntity;
import com.example.databaseapp.R;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<UserEntity> usersList;
    private Context context;
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.id.setText(usersList.get(position).getId());
        holder.name.setText(usersList.get(position).getName());
        holder.email.setText(usersList.get(position).getEmail());
        holder.website.setText(usersList.get(position).getWebsite());
        holder.address.setText(usersList.get(position).getAddress());
        try {
            Picasso.get().load("file:///android_asset/"+usersList.get(position).getUserImage()+".jpg").resize(100,100).into(holder.userImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return usersList != null ? usersList.size() : 0;
    }

    public void setUsers(ArrayList<UserEntity> usersList){
        this.usersList = usersList;
        notifyDataSetChanged();
    }
}

class UserViewHolder extends RecyclerView.ViewHolder{
    TextView id, email, website, name, address;
    ImageView userImage;

    UserViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        email = itemView.findViewById(R.id.email);
        website = itemView.findViewById(R.id.website);
        name = itemView.findViewById(R.id.name);
        address = itemView.findViewById(R.id.address);
        userImage = itemView.findViewById(R.id.userImage);
    }


}
