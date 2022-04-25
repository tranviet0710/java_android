package com.example.contactapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("Select * from contact")
    List<Contact> getAllContacts();

    @Query("DELETE FROM contact")
    public void deleteAll();
    @Insert
    void insertAll(List<Contact> contacts);
    @Insert
    void insert(Contact contact);
    @Delete
    void delete(Contact contact);


}
