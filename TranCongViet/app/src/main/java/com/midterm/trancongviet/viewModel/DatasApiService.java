package com.midterm.trancongviet.viewModel;

import com.midterm.trancongviet.model.Data;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DatasApiService {
    private static final String BASE_URL = "https://api.jsonbin.io";
    private DatasApi api;

    public DatasApiService(){
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(DatasApi.class);
    }

    public Single<List<Data>> getDatas(){
        return api.getDatas();
    }
}
