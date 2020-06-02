package com.example.room_database_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room_database_app.Entity.Contact;

import java.util.List;

public class update_form_activity extends AppCompatActivity
{
    private EditText name,mobile;

    private int id;
    private RoomAndrodProjectDatabase database;
    private Contact contact;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_form_activity);
        database=RoomAndrodProjectDatabase.getInstance(this);
        name=findViewById(R.id.update_name_et);
        mobile=findViewById(R.id.update_mobile_et);
        Intent intent=getIntent();
        id=intent.getIntExtra("update_id",Integer.MIN_VALUE);

        if(id!=Integer.MIN_VALUE)
        {
            contact=database.getContactDao().getContactyId(id);
            name.setText(contact.getName());
            mobile.setText(contact.getMobile());
        }
    }

    public void update(View view)
    {
        String namestr,mobilestr;
        if(name.getText().toString().trim().length()==0)
        {
            name.setError("enter a name");
            return;
        }

        if(mobile.getText().toString().length()==0)
        {
            mobile.setError("enter a mobile number");
            return;
        }

        namestr=name.getText().toString().trim();
        mobilestr=mobile.getText().toString().trim();

        contact.setName(namestr);
        contact.setMobile(mobilestr);
        database.getContactDao().updateContact(contact);

        name.setText("");
        mobile.setText("");

        Toast.makeText(this, "updated successfully", Toast.LENGTH_SHORT).show();
        update_rv_activity.notifydata();

    }
}
