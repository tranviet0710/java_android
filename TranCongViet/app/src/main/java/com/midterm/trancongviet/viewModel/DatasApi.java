package com.midterm.trancongviet.viewModel;

import com.midterm.trancongviet.model.Data;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface DatasApi {
    @GET("b/625039f3d20ace068f9580fb")
    Single<List<Data>> getDatas();
}
