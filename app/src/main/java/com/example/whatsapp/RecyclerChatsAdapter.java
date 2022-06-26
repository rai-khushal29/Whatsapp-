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

public class RecyclerChatsAdapter extends RecyclerView.Adapter<RecyclerChatsAdapter.ViewHolder> {
Context context;
ArrayList<ChatsModel> arrChats = new ArrayList<>();
    //private Dialog optdialog;

    public RecyclerChatsAdapter(Context context, ArrayList<ChatsModel> arrChats)
{
    this.context=context;
    this.arrChats=arrChats;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.chats_row,parent,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.img.setImageResource(arrChats.get(position).img);
    holder.name.setText(arrChats.get(position).name);
    holder.msg.setText(arrChats.get(position).msg);
    holder.time.setText(arrChats.get(position).time);


    holder.itemView.setOnClickListener(new View.OnClickListener() {
        //private Dialog optdialog;

        @Override
        public void onClick(View v) {
            ((MainActivity)context).showDialog();
        }
    });
    }



    @Override
    public int getItemCount() {
        return arrChats.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
    ImageView img;
    TextView name,msg,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.user_dp);
            name=itemView.findViewById(R.id.user_name);
            msg=itemView.findViewById(R.id.recent_chats);
            time=itemView.findViewById(R.id.recent_time);
        }
    }
}
