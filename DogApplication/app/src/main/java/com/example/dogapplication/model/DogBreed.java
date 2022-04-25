package com.example.dogapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.dogapplication.utils.DataConverter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
@Entity
public class DogBreed implements Serializable {
    @PrimaryKey
    @SerializedName("id")
    private int id;
    @ColumnInfo
    @SerializedName("name")
    private String name;
    @ColumnInfo
    @SerializedName("life_span")
    private String life_span;
    @ColumnInfo
    @SerializedName("origin")
    private String origin;
    @ColumnInfo
    @SerializedName("temperament")
    private String temperament;
    @ColumnInfo
    @SerializedName("url")
    private String url;
    @ColumnInfo
    @SerializedName("height")
    @TypeConverters(DataConverter.class)
    private Height height;
    @ColumnInfo
    @SerializedName("weight")
    @TypeConverters(DataConverter.class)
    private Weight weight;
    @ColumnInfo
    @SerializedName("bred_for")
    private String bred_for;
    @ColumnInfo
    @SerializedName("breed_group")
    private String breed_group;

    public DogBreed(int id, String name, String life_span, String origin, String temperament, String url, Height height, Weight weight, String bred_for, String breed_group) {
        this.id = id;
        this.name = name;
        this.life_span = life_span;
        this.origin = origin;
        this.temperament = temperament;
        this.url = url;
        this.height = height;
        this.weight = weight;
        this.bred_for = bred_for;
        this.breed_group = breed_group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getBred_for() {
        return bred_for;
    }

    public void setBred_for(String bred_for) {
        this.bred_for = bred_for;
    }

    public String getBreed_group() {
        return breed_group;
    }

    public void setBreed_group(String breed_group) {
        this.breed_group = breed_group;
    }
}
