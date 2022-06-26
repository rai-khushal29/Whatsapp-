package com.example.whatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class calls extends Fragment {





    public calls() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View callscontent = inflater.inflate(R.layout.fragment_calls, container, false);
       /* FloatingActionButton floatingActionButton = callscontent.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "In Progress", Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });*/
        return callscontent;
    }
}