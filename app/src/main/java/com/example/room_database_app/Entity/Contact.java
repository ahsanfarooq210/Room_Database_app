package com.example.room_database_app.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Contact_table")
public class Contact
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name="mobile_no")
    private String mobile;


    public Contact(int id, String name, String mobile)
    {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }


    @Ignore
    public Contact(String name, String mobile)
    {
        this.name = name;
        this.mobile = mobile;

    }


    public int getId()
    {
        return id;
    }

    @Ignore
    public void setId(int id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }

    @Ignore
    public void setName(String name)
    {
        this.name = name;
    }

    public String getMobile()
    {
        return mobile;
    }

    @Ignore
    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }
}
