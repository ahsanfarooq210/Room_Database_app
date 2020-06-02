package com.example.room_database_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.room_database_app.Entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class update_rv_activity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RoomAndrodProjectDatabase database;
    private List<Contact> contactList;
    private static ContactAdapterUpdate contactAdapterUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_rv_activity);

        recyclerView=findViewById(R.id.update_rv);
        database=RoomAndrodProjectDatabase.getInstance(this);
        contactList=database.getContactDao().getAllContact();
        contactAdapterUpdate=new ContactAdapterUpdate((ArrayList<Contact>) contactList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactAdapterUpdate);
    }

    public static void notifydata()
    {
        contactAdapterUpdate.notifyDataSetChanged();
    }
}
