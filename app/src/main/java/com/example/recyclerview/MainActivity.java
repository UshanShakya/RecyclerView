package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import model.Contacts;
import adapter.ContactsAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        List<Contacts> contactsList = new ArrayList<>();
        contactsList.add(new Contacts("Saugat Malla","98454551561","saugat@gmail.com","Patan",R.drawable.saugat));
        contactsList.add(new Contacts("Saugat Malla","98454551561","saugat@gmail.com","Patan",R.drawable.saugat));
        contactsList.add(new Contacts("Saugat Malla","98454551561","saugat@gmail.com","Patan",R.drawable.saugat));
        contactsList.add(new Contacts("Rajesh Hamal","98454551561","rajesh@yahoo.com","Bhaktapur",R.drawable.rajesh));
        contactsList.add(new Contacts("Rajesh Hamal","98454551561","rajesh@yahoo.com","Bhaktapur",R.drawable.rajesh));
        contactsList.add(new Contacts("Rajesh Hamal","98454551561","rajesh@yahoo.com","Bhaktapur",R.drawable.rajesh));
        contactsList.add(new Contacts("Rajesh Hamal","98454551561","rajesh@yahoo.com","Bhaktapur",R.drawable.rajesh));
        contactsList.add(new Contacts("Dayahang Rai","98454551561","dayahang@hotmail.com", "Kathmandu",R.drawable.dahayang));
        contactsList.add(new Contacts("Dayahang Rai","98454551561","dayahang@hotmail.com", "Kathmandu",R.drawable.dahayang));
        contactsList.add(new Contacts("Dayahang Rai","98454551561","dayahang@hotmail.com", "Kathmandu",R.drawable.dahayang));
        contactsList.add(new Contacts("Dayahang Rai","98454551561","dayahang@hotmail.com", "Kathmandu",R.drawable.dahayang));
        contactsList.add(new Contacts("Bhuwan KC","98454551561","bhuwan@ooutlook.com","Hetauda",R.drawable.bhuwan));
        contactsList.add(new Contacts("Bhuwan KC","98454551561","bhuwan@ooutlook.com","Hetauda",R.drawable.bhuwan));
        contactsList.add(new Contacts("Bhuwan KC","98454551561","bhuwan@ooutlook.com","Hetauda",R.drawable.bhuwan));
        contactsList.add(new Contacts("Bhuwan KC","98454551561","bhuwan@ooutlook.com","Hetauda",R.drawable.bhuwan));

        final ContactsAdapter contactsAdapter= new ContactsAdapter(this,contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SearchView searchView;
        searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
               contactsAdapter.getFilter().filter(newText);
                return false;
            }
        });


        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            Toast.makeText(this,bundle.getString("message"),Toast.LENGTH_LONG).show();

        }
    }
}
