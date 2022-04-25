package com.midterm.trancongviet.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.midterm.trancongviet.R;
import com.midterm.trancongviet.model.Data;
import com.midterm.trancongviet.viewModel.DatasApiService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

}
}
