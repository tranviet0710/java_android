package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.calculator.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Observable;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyViewModel model;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        model = new ViewModelProvider(this).get(MyViewModel.class);
        model.getString().observe(this, string ->  binding.numTxt.setText(string));
        model.getOperations().observe(this, string -> binding.listTxt.setText(string));


        binding.CBtn.setOnClickListener(v -> model.removeAll());
        binding.delBtn.setOnClickListener(v -> model.remove());
        binding.oppositeBtn.setOnClickListener(v -> model.opposite());
        binding.equalsBtn.setOnClickListener(v->  model.makeResult());

        Button[] buttons = {binding.divBtn, binding.mulBtn, binding.addBtn, binding.subBtn, binding.dotBtn, binding.oneBtn,
                            binding.twoBtn, binding.threeBtn, binding.fourBtn, binding.fiveBtn, binding.sixBtn, binding.sevenBtn, binding.eightBtn, binding.nineBtn};
        for (Button button: buttons){
            button.setOnClickListener(v->model.addText(button.getText().toString()));
        }
    }
}