package com.example.adminlyabook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminlyabook.Helper.Store;
import com.example.adminlyabook.R;
import com.example.adminlyabook.entity.MapsDirectionModels;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.DirectionsViewHolder> {
    List<MapsDirectionModels> listDirection;

    public ListAdapter (List<MapsDirectionModels> listDirection){
        this.listDirection = listDirection;
    }

    @NonNull
    @Override
    public DirectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_direction, null, false);
        return new ListAdapter.DirectionsViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.DirectionsViewHolder holder, int position) {
        holder.lblDirection.setText(listDirection.get(position).getDisplay_address());
        holder.lblRegion.setText(listDirection.get(position).getDisplay_region());
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
