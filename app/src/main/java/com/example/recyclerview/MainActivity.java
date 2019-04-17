package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import model.Contacts;
import model.ContactsAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        List<Contacts> contactsList = new ArrayList<>();
        contactsList.add(new Contacts("Saugat Malla","98454551561",R.drawable.saugat));
        contactsList.add(new Contacts("Rajesh Hamal","98454551561",R.drawable.rajesh));
        contactsList.add(new Contacts("Dayahang Rai","98454551561",R.drawable.dahayang));
        contactsList.add(new Contacts("Bhuwan KC","98454551561",R.drawable.bhuwan));

        ContactsAdapter contactsAdapter= new ContactsAdapter(this,contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }
}
