package com.midterm.trancongviet.viewModel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.trancongviet.R;
import com.midterm.trancongviet.model.Data;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DatasAdapter extends RecyclerView.Adapter<DatasAdapter.ViewHolder>{
    private ArrayList<Data> datas;


    public DatasAdapter(ArrayList<Data> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public DatasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatasAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(datas.get(position).getTitle());
        holder.tvDecs.setText(datas.get(position).getDesc());
        holder.timeStamp.setText(datas.get(position).getTimeStamp());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvTitle;
        public TextView tvDecs;
        public TextView timeStamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDecs = itemView.findViewById(R.id.tv_desc);
            timeStamp = itemView.findViewById(R.id.timeStamp);

            itemView.setOnClickListener(view -> {
                Data data = datas.get(getAdapterPosition());
                Bundle bundle = new Bundle();
                bundle.putSerializable("data",data);
                Navigation.findNavController(view).navigate(R.id.detailFragment, bundle);
            });
        }
    }
}
