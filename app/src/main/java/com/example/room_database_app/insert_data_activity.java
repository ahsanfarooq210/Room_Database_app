package com.example.room_database_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.room_database_app.Entity.Contact;

public class insert_data_activity extends AppCompatActivity
{
    private EditText name,mobile;
    RoomAndrodProjectDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data_activity);
        name=findViewById(R.id.insert_name_et);
        mobile=findViewById(R.id.insert_mobile_et);
        database=RoomAndrodProjectDatabase.getInstance(this);
    }

    public void insert(View view)
    {
        if(name.getText().toString().trim().length()==0)
        {
            name.setError("Enter name");
            return;
        }
        if(mobile.getText().toString().trim().length()==0)
        {
            mobile.setError("Enter the mobile");
            return;
        }

        String namestr,mobilestr;
        namestr=name.getText().toString().trim();
        mobilestr=mobile.getText().toString().trim();

        Contact contact=new Contact(namestr,mobilestr);
        database.getContactDao().insertContact(contact);
        Toast.makeText(this, "Reccod successfully added", Toast.LENGTH_SHORT).show();

        name.setText("");
        mobile.setText("");

    }
}
