package com.demo.retrofitdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    List<UserModel> allUsersList;
    MainActivity mainActivity;

    public MyAdapter(MainActivity mainActivity, List<UserModel> allUsersList) {

        this.mainActivity = mainActivity;
        this.allUsersList = allUsersList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mainActivity).inflate(R.layout.data, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {


        holder.txt1.setText(String.valueOf(allUsersList.get(position).getAlbumId()));
        holder.txt2.setText(String.valueOf(allUsersList.get(position).getId()));
        holder.txt3.setText(allUsersList.get(position).getTitle());
        holder.txt4.setText(allUsersList.get(position).getUrl());
        holder.txt5.setText(allUsersList.get(position).getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return allUsersList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView txt1, txt2, txt3, txt4, txt5;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            txt1 = itemView.findViewById(R.id.txt1);
            txt2 = itemView.findViewById(R.id.txt2);
            txt3 = itemView.findViewById(R.id.txt3);
            txt4 = itemView.findViewById(R.id.txt4);
            txt5 = itemView.findViewById(R.id.txt5);

        }
    }
}
