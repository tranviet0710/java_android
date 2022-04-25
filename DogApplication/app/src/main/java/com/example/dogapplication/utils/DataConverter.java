package com.example.dogapplication.utils;

import androidx.room.TypeConverter;

import com.example.dogapplication.model.Height;
import com.example.dogapplication.model.Weight;

import java.util.Arrays;
import java.util.List;

public class DataConverter {
        @TypeConverter
        public Height storedStringToHeight(String value) {
            List<String> data = Arrays.asList(value.split("\\s*,\\s*"));
            return new Height(data);
        }

        @TypeConverter
        public String heightToStoredString(Height height) {
            //return height.getImperial();
            return "height";
        }

        @TypeConverter
        public Weight storedStringToWeight(String value) {
            List<String> data = Arrays.asList(value.split("\\s*,\\s*"));
            return new Weight(data);
        }

        @TypeConverter
        public String weightToStoredString(Weight weight) {
            //return weight.getImperial();
            return "weight";
        }
    }