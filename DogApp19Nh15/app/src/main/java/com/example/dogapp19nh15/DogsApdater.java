package com.example.dogapp19nh15;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp19nh15.model.DogBreed;
import com.example.dogapp19nh15.viewmodel.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogsApdater  extends RecyclerView.Adapter<DogsApdater.ViewHolder> {
    public ArrayList<DogBreed> dogs;

    public DogsApdater(ArrayList<DogBreed> dogs) {
        this.dogs = dogs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(dogs.get(position).getName());
        ImageView iv = holder.ivDog;
        Picasso.get()
                .load(dogs.get(position).getUrl())
                .into(iv);
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                ImageButton bt = view.findViewById(R.id.bt_heart);
                //bt.setBackgroundColor(Color.RED);
                bt.setColorFilter(Color.RED);
            }
        });
    }


    @Override
    public int getItemCount() {
        return dogs.size();
    }

    public void addContact(DogBreed dog) {
        dogs.add(dog);
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        private TextView tvName;
        public ImageView ivDog;
        private ItemClickListener itemClickListener;

        public ViewHolder(View view) {
            super(view);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            ivDog = view.findViewById(R.id.iv_dog);
            tvName = view.findViewById(R.id.tv_name);
        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),false);
        }

        @Override
        public boolean onLongClick(View view) {
            itemClickListener.onClick(view,getAdapterPosition(),true); // Gọi interface , true là vì đây là onLongClick
            return true;
        }
    }
}
