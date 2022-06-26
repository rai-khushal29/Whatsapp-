package com.example.whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerStatusAdapter extends RecyclerView.Adapter<RecyclerStatusAdapter.ViewHolder> {
    Context context;
    ArrayList<ChatsModel> arrChats = new ArrayList<>();

    public RecyclerStatusAdapter(Context context, ArrayList<ChatsModel> arrChats) {
        this.context = context;
        this.arrChats = arrChats;
    }


    @NonNull
    @Override
    public RecyclerStatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.status_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(R.drawable.status);
        holder.name.setText(arrChats.get(position).name);
        holder.time.setText(arrChats.get(position).time);
    }



    @Override
    public int getItemCount() {
        return arrChats.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, time;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.user_sdp);
            name = itemView.findViewById(R.id.user_name1);
            time = itemView.findViewById(R.id.upload_time);
        }

    }
}