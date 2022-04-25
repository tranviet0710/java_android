package com.example.dogapplication.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogapplication.R;
import com.example.dogapplication.database.AppDatabase;
import com.example.dogapplication.database.DogDao;
import com.example.dogapplication.model.DogBreed;
import com.example.dogapplication.viewmodel.DogsAdapter;
import com.example.dogapplication.viewmodel.DogsApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ListFragment extends Fragment {
    private DogsApiService dogsApiService;
    private RecyclerView rvDogs;
    private ArrayList<DogBreed> dogBreeds;
    private DogsAdapter dogsAdapter;


    private DogDao dogDao;
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
        //dogDao.insertAll(dataToDB);

        rvDogs = view.findViewById(R.id.rv_dogs);
        dogBreeds = new ArrayList<>();
        dogsAdapter = new DogsAdapter(dogBreeds);
        rvDogs.setAdapter(dogsAdapter);
        rvDogs.setLayoutManager(new GridLayoutManager(getContext(), 2));
        appDatabase = AppDatabase.getInstance(getContext());
        dogDao = appDatabase.dogDao();
        dogsApiService = new DogsApiService();
        dogsApiService.getDogs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<DogBreed>>() {
                    @Override
                    public void onSuccess(@io.reactivex.rxjava3.annotations.NonNull List<DogBreed> dogBreeds1) {
                        dogBreeds1.forEach(dog ->{
                            dogBreeds.add(dog);
                            dogDao.insert(dog);
                            dogsAdapter.notifyDataSetChanged();
                        });
                    }

                    @Override
                    public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                        Log.d("DEBUG1", e.getMessage());
                    }
                });

//        System.out.println("Dog Breeds: ");
//        dogBreeds.forEach(System.out::println);
    }
}