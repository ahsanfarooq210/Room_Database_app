package com.example.room_database_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insertData(View view)
    {
        Intent intent=new Intent(MainActivity.this,insert_data_activity.class);
        startActivity(intent);
    }

    public void showData(View view)
    {
        Intent intent=new Intent(MainActivity.this,show_data_activity.class);
        startActivity(intent);
    }

    public void deleteData(View view)
    {
        Intent intent=new Intent(MainActivity.this,show_data_for_delete_activity.class);
        startActivity(intent);

    }

    public void updateData(View view)
    {
        Intent intent=new Intent(MainActivity.this,update_rv_activity.class);
        startActivity(intent);
    }
}
