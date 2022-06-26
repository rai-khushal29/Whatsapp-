package com.example.whatsapp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class chats extends Fragment {


public static ArrayList<ChatsModel> arrChats = new ArrayList<>();

    public chats() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View chatscontent = inflater.inflate(R.layout.fragment_chats, container, false);
        RecyclerView recyclerView = chatscontent.findViewById(R.id.recyclerchatsview);

        arrChats.clear();
        insertdata();
        /*FloatingActionButton floatingActionButton = chatscontent.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "In Progress", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                ((MainActivity)getContext()).adduserdialog();
            }
        });*/
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerChatsAdapter adapter = new RecyclerChatsAdapter(getActivity(),arrChats);

        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
        return chatscontent;
    }
    static public void insertdata()
    {
        arrChats.add(new ChatsModel(R.drawable.ic_baseline_account_circle_24,"Vijay","Aur Sa Kathe Hai","10:00 AM"));
        arrChats.add(new ChatsModel(R.drawable.ic_baseline_account_circle_24,"Ashish", "Assignment Complete Kr Liya?","11:00 AM"));
    }

    private void options()
    {

    }
}
