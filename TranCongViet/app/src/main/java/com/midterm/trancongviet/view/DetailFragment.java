package com.midterm.trancongviet.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.midterm.trancongviet.databinding.FragmentDetailBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midterm.trancongviet.R;
import com.midterm.trancongviet.model.Data;

public class DetailFragment extends Fragment {

    private Data data;
    private FragmentDetailBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            data = (Data) getArguments().getSerializable("data");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_detail, null, false);
        View viewRoot = binding.getRoot();
        binding.setData(data);
        return viewRoot;
    }
}