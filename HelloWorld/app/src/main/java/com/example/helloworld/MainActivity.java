package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    private MyViewModel model;

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;
    private int clickValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        binding.lvCount.setAdapter(arrayAdapter);

        model = new ViewModelProvider(this).get(MyViewModel.class);
        model.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                //binding.tvCount.setText("" + ++integer);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        model.getStrings().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                arrayList.clear();
                for (String string: strings){
                    arrayList.add(string);
                }
		        arrayAdapter.notifyDataSetChanged();
            }	
        });


        binding.btnUp.setOnClickListener(view -> model.increaseNumber());

        binding.btnDown.setOnClickListener(view -> model.decreaseNumber());

        binding.lvCount.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                model.removeItem(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

        binding.lvCount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("number", arrayList.get(i));
                clickValue = arrayList.indexOf(arrayList.get(i));
                startActivityForResult(intent, 123);
            }
        });
    }
    //Change the value and return to Main Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            if(resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("text");
                model.changeValue(clickValue, result);
                Toast.makeText(MainActivity.this, clickValue + "", Toast.LENGTH_SHORT).show();
            } else {
                // Do some thing when error arise !
            }
        }
    }

    //Binding the floating button (-)
}
