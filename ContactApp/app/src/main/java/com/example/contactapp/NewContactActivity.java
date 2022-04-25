package com.example.contactapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.databinding.NewContactActivityBinding;

import java.util.ArrayList;

public class NewContactActivity extends AppCompatActivity {
    private NewContactActivityBinding binding;
    ArrayList<String> mobileItems;
    ArrayAdapter<String> mobileAdapter;

    ArrayList<String> emailItems;
    ArrayAdapter<String> emailAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = NewContactActivityBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        mobileItems = new ArrayList<>();
        mobileItems.add("Home");
        mobileItems.add("Company");
        mobileItems.add("Personal");

        mobileAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, mobileItems);
        binding.spinnerMobile.setAdapter(mobileAdapter);

        emailItems = new ArrayList<>();
        emailItems.add("Company");
        emailItems.add("Personal");

        emailAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, emailItems);
        binding.spinnerEmail.setAdapter(emailAdapter);

        binding.btnSave.setOnClickListener(view -> {
                String firstname = binding.tvFname.getText().toString();
                String lastname= binding.tvLname.getText().toString();
                String phone = binding.tvPhone.getText().toString();
                String email = binding.tvEmail.getText().toString();
                String[] strings = {firstname+" "+lastname, phone, email};
//                Contact contact = new Contact(firstname+lastname, phone, email);
                Intent newContactIntent = new Intent();
                newContactIntent.putExtra("data", strings);
                setResult(Activity.RESULT_OK, newContactIntent);
                finish();
        });
    }
}
