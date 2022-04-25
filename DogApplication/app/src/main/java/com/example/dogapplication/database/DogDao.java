package com.example.dogapplication.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.dogapplication.model.DogBreed;

import java.util.List;

@Dao
public interface DogDao {
    @Query("Select * from DogBreed")
    List<DogBreed> getAllDogs();

    @Query("DELETE FROM DogBreed")
    public void deleteAll();
    @Insert
    void insertAll(List<DogBreed> dogs);
    @Insert
    void insert(DogBreed contact);
    @Delete
    void delete(DogBreed contact);


}
