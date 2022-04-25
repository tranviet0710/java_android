package com.midterm.trancongviet.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.midterm.trancongviet.model.Data;

import java.util.List;

@Dao
public interface DataDao {
    @Query("Select * from Data")
    List<Data> getAllDatas();

    @Query("DELETE FROM Data")
    public void deleteAll();
    @Insert
    void insertAll(List<Data> dogs);
    @Insert
    void insert(Data contact);
    @Delete
    void delete(Data contact);


}
