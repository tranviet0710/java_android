package com.midterm.trancongviet.model;

import com.google.gson.annotations.SerializedName;
import com.midterm.trancongviet.utils.DataConverter;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.DatabaseConfiguration;
import androidx.room.Entity;
import androidx.room.InvalidationTracker;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.io.Serializable;
@Entity
@TypeConverters(DataConverter.class)
public abstract class Data extends RoomDatabase implements Serializable {
//    @PrimaryKey (autoGenerate = true)
//    private int id;
    @ColumnInfo
    @SerializedName("lat")
    private double lat;
    @ColumnInfo
    @SerializedName("lng")
    private double lng;
    @ColumnInfo
    @SerializedName("desc")
    private String desc;
    @ColumnInfo
    @SerializedName("zip")
    private String zip;
    @ColumnInfo
    @SerializedName("title")
    private String title;
    @ColumnInfo
    @SerializedName("timeStamp")
    private String timeStamp;
    @ColumnInfo
    @SerializedName("twp")
    private String twp;
    @ColumnInfo
    @SerializedName("addr")
    private String addr;
    @ColumnInfo
    @SerializedName("e")
    private String e;

    public Data(double lat, double lng, String desc, String zip, String title, String timeStamp, String twp, String addr, String e) {
        this.lat = lat;
        this.lng = lng;
        this.desc = desc;
        this.zip = zip;
        this.title = title;
        this.timeStamp = timeStamp;
        this.twp = twp;
        this.addr = addr;
        this.e = e;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTwp() {
        return twp;
    }

    public void setTwp(String twp) {
        this.twp = twp;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

}
