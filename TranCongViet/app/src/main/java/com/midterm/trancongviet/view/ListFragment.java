package com.midterm.trancongviet.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogapplication.database.AppDatabase;
import com.midterm.trancongviet.R;
import com.midterm.trancongviet.database.DataDao;
import com.midterm.trancongviet.model.Data;
import com.midterm.trancongviet.viewModel.DatasAdapter;
import com.midterm.trancongviet.viewModel.DatasApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class ListFragment extends Fragment {
    private DatasApiService datasApiService;
    private RecyclerView rvDatas;
    private ArrayList<Data> datas;
    private DatasAdapter datasAdapter;


    private DataDao dataDao;
    private AppDatabase appDatabase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvDatas = view.findViewById(R.id.rv_datas);
        datas = new ArrayList<>();
        datasAdapter = new DatasAdapter(datas);
        rvDatas.setAdapter(datasAdapter);
        rvDatas.setLayoutManager(new LinearLayoutManager(getContext()));
        //appDatabase = AppDatabase.getInstance(getContext());
        //dataDao = appDatabase.dataDao();
        datasApiService = new DatasApiService();
        datasApiService.getDatas()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<Data>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<Data> datas1) {
                        datas1.forEach(data ->{
                            //datas.add(data);
                            //dataDao.insert(data);
                            //datasAdapter.notifyDataSetChanged();
                            Log.d("DEBUG1", data.getTitle());
                        });
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("DEBUG1", e.getMessage());
                    }
                });
        List<Data> dataList = dataDao.getAllDatas();
        dataList.forEach(System.out::println);
    }
}