package com.example.whatsapp;

import static com.example.whatsapp.chats.arrChats;
import static com.example.whatsapp.chats.insertdata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class status extends Fragment {



    public status() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_status, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerstatusview);
        arrChats.clear();
        insertdata();
        /*FloatingActionButton floatingActionButton = v.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "In Progress", Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });*/
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerStatusAdapter adapter = new RecyclerStatusAdapter(getContext(),arrChats);
        recyclerView.setAdapter(adapter);
        return v;
    }
}