package com.example.room_database_app;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.room_database_app.Dao.ContactDao;
import com.example.room_database_app.Entity.Contact;

@Database(entities = Contact.class,version = 1)
public abstract class RoomAndrodProjectDatabase extends RoomDatabase
{
    private static final String DB_NAME="RoomAndrodProjectDatabase";
    private static RoomAndrodProjectDatabase instance;

    public static synchronized RoomAndrodProjectDatabase getInstance(Context context)
    {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),RoomAndrodProjectDatabase.class,DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        return instance;


    }

    public abstract ContactDao getContactDao();

}
