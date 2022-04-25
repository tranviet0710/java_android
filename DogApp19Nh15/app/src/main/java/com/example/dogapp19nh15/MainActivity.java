package com.example.dogapp19nh15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.dogapp19nh15.databinding.ActivityMainBinding;
import com.example.dogapp19nh15.databinding.ItemImageBinding;
import com.example.dogapp19nh15.model.DogBreed;
import com.example.dogapp19nh15.viewmodel.DogsApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ItemImageBinding binding2;
    private DogsApiService dogsApiService;
    private ArrayList<DogBreed> dogs;
    private DogsApdater dogsApdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding2 = ItemImageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        dogsApiService = new DogsApiService();
        dogsApiService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DogBreed>>() {
                    @Override
                    public void onSuccess(@NonNull List<DogBreed> dogBreeds) {
                        dogs = new ArrayList<>(dogBreeds);
                        dogsApdater = new DogsApdater(dogs);
                        binding.rvDogs.setAdapter(dogsApdater);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("DEBUG1", e.getMessage());
                    }

        });

        binding.rvDogs.setLayoutManager(new GridLayoutManager(this, 2));

    }
}