package com.example.dogapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Height {
    @SerializedName("imperial")
    private String imperial;
    @SerializedName("metric")
    private String metric;

    public Height(String imperial, String metric) {
        this.imperial = imperial;
        this.metric = metric;
    }
    public Height(List<String> data) {
        this.imperial = data.get(0);
        this.metric = data.get(1);
    }
    public String getImperial() {
        return imperial;
    }

    public void setImperial(String imperial) {
        this.imperial = imperial;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }
}
