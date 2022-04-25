package com.midterm.trancongviet.utils;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.midterm.trancongviet.model.Data;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class DataConverter {
    @TypeConverter
    public static List<Data> storedStringToMyObjects(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Data>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(List<Data> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}
