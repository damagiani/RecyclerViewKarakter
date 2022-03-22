package com.example.aplikasirecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.ViewHolder> {

    private final ArrayList<Karakter> dataItem;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textHead;
        TextView textSubhead;
        ImageView imageIcon;

        ViewHolder(View v) {

            super(v);

            textHead = v.findViewById(R.id.headlineGrid);
            textSubhead = v.findViewById(R.id.sublineGrid);
            imageIcon = v.findViewById(R.id.imageGrid);
        }
    }

    AdapterGrid(ArrayList<Karakter> data) {

        this.dataItem = data;
    }

    @NonNull
    @Override
    public AdapterGrid.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character_grid, parent, false);
        //myonClickListener
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView textHead = holder.textHead;
        TextView textSubhead = holder.textSubhead;
        ImageView imageIcon = holder.imageIcon;

        textHead.setText(dataItem.get(position).getName());
        textSubhead.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return dataItem.size();
    }
}