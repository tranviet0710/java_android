package com.example.twonumbers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.twonumbers.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MyViewModel model;

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        binding.lvOperations.setAdapter(arrayAdapter);

        model = new ViewModelProvider(this).get(MyViewModel.class);
        model.getStrings().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                arrayList.clear();
                for(String string: strings){
                    arrayList.add(string);
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });


        binding.addBtn.setOnClickListener(v->
                doOperation(binding.addBtn.getText().toString() ,(a,b) -> a + b));
        binding.subBtn.setOnClickListener(v->
                doOperation(binding.subBtn.getText().toString() , (a,b) -> a - b));
        binding.mulBtn.setOnClickListener(v->
                doOperation(binding.mulBtn.getText().toString() , (a,b) -> a * b));
        binding.divBtn.setOnClickListener(v->
                doOperation(binding.divBtn.getText().toString(),  (a,b) -> a / b));

    }

    private void doOperation(String str, Operation operation){
        Float a = 0f;
        Float b = 0f;
        String op = "";
        try {
            a = Float.parseFloat(binding.aTxt.getText().toString());
            b = Float.parseFloat(binding.bTxt.getText().toString());
            op = a + str + b + "=" + operation.apply(a,b);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(op);
        model.addString(op);
    }

    public interface Operation {
        Float apply(Float a, Float b);
    }

}