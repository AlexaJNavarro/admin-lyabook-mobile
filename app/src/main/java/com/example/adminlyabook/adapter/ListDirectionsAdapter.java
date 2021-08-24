package com.example.adminlyabook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminlyabook.R;
import com.example.adminlyabook.entity.DirectionEntity;

import java.util.ArrayList;

public class ListDirectionsAdapter extends RecyclerView.Adapter<ListDirectionsAdapter.DirectionsViewHolder> {
    ArrayList<DirectionEntity> listDirection;

    public ListDirectionsAdapter (ArrayList<DirectionEntity> listDirection){
        this.listDirection = listDirection;
    }

    @NonNull
    @Override
    public DirectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_direction, null, false);
        return new  ListDirectionsAdapter.DirectionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ListDirectionsAdapter.DirectionsViewHolder holder, int position) {
        holder.lblDirection.setText(listDirection.get(position).getDirection());
        holder.lblRegion.setText(listDirection.get(position).getRegion());
    }

    @Override
    public int getItemCount() {
        return listDirection.size();
    }

    public class DirectionsViewHolder extends RecyclerView.ViewHolder {
        TextView lblDirection, lblRegion;
        public DirectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            lblDirection = itemView.findViewById(R.id.lbl_direction);
            lblRegion = itemView.findViewById(R.id.lbl_region);
        }
    }
}
