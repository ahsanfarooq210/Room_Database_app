package com.example.room_database_app.Dao;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.room_database_app.Entity.Contact;

import java.util.List;

@Dao
public interface ContactDao
{
    @Insert
    void insertContact(Contact contact);

    @Update
    void updateContact(Contact contact);

    @Delete
    void deleteContact(Contact contact);

    @Query("Select * from Contact_table")
    List<Contact> getAllContact();

    @Query("Select * from Contact_table where :id=id")
    Contact getContactyId(int id);

}
