package com.example.room_database_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.room_database_app.Entity.Contact;

import java.util.ArrayList;
import java.util.List;

public class show_data_for_delete_activity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RoomAndrodProjectDatabase database;
    private List<Contact> contactList;
    public static ContactRvAdapterDelete contactRvAdapterDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data_for_delete_activity);

        recyclerView=findViewById(R.id.delete_data_rv);
        database=RoomAndrodProjectDatabase.getInstance(this);
        contactList=database.getContactDao().getAllContact();
        contactRvAdapterDelete=new ContactRvAdapterDelete((ArrayList<Contact>) contactList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(contactRvAdapterDelete);
    }

    public static void notifydata()
    {
        contactRvAdapterDelete.notifyDataSetChanged();
    }


}
