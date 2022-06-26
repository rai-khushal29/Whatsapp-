package com.example.whatsapp;

import static com.example.whatsapp.chats.arrChats;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static Dialog optdialog;
    Dialog adduser;

    //public static  Dialog adduser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewpager);
        TabLayout tabs = findViewById(R.id.tabs);


        ViewpagerFragmentAdapter adapter = new ViewpagerFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        Button btnCancel = findViewById(R.id.btn_cancel);
        EditText newName = findViewById(R.id.new_name);
        EditText newMsg = findViewById(R.id.new_msg);


        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Snackbar.make(v, "In Progress", Snackbar.LENGTH_LONG).setAction("Action",null).show();
                adduserdialog();
                Button btnAdd = adduser.findViewById(R.id.btn_add_user);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = newName.getText().toString();
                        String msg = newMsg.getText().toString();
                        arrChats.add(new ChatsModel(R.drawable.ic_baseline_account_circle_24, name, msg, "1:00 PM"));


                    }
                });

                adduser.show();
            }
        });

    }

    public void onBackPressed() {
        AlertDialog.Builder exitdia = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit")
                .setMessage("Are You Sure Want to Exit")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setCancelable(false);
        exitdia.show();
    }

    public void showDialog() {


        optdialog = new Dialog(MainActivity.this);
        optdialog.setContentView(R.layout.options);
        ArrayList<String> arrOptions = new ArrayList<>();
        arrOptions.add("Edit");
        arrOptions.add("Delete");
        ListView list_options = optdialog.findViewById(R.id.option_list);
        list_options.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrOptions));
        optdialog.show();
        list_options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    optdialog.dismiss();
                    showdeletedialog();
                }
            }
        });

    }

    public void showdeletedialog() {
        Dialog optdelete = new Dialog(MainActivity.this);
        optdelete.setContentView(R.layout.delete_dialog);
        optdelete.show();
    }

    public void adduserdialog() {
        adduser = new Dialog(MainActivity.this);
        adduser.setContentView(R.layout.add_user_dialog);
    }
}