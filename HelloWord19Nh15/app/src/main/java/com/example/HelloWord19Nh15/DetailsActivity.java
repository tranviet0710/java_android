package com.example.HelloWord19Nh15;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.HelloWord19Nh15.databinding.ActivityDetailsBinding;
import com.example.HelloWord19Nh15.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        Intent intent = getIntent();
        if (intent != null) {
            String data = intent.getStringExtra("number");
            binding.edText.setText(data);
        }

        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent();
                String changedNumber = binding.edText.getText().toString();
                detailIntent.putExtra("detailNumber", changedNumber);
                setResult(Activity.RESULT_OK, detailIntent);
                finish();
            }
        });
    }

}