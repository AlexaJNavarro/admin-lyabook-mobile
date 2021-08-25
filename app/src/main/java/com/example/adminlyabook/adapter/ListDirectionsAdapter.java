package com.example.adminlyabook.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adminlyabook.MapsActivity;
import com.example.adminlyabook.MapsFragment;
import com.example.adminlyabook.R;
import com.example.adminlyabook.ViewStore;
import com.example.adminlyabook.databinding.ActivityMapsBinding;
import com.example.adminlyabook.entity.DirectionEntity;
import com.example.adminlyabook.helper.Ubication;
import com.example.adminlyabook.models.Data;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class ListDirectionsAdapter extends RecyclerView.Adapter<ListDirectionsAdapter.DirectionsViewHolder> {
    ArrayList<Data> listDirection;

    public ListDirectionsAdapter (ArrayList<Data> listDirection){
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
        holder.lblDirection.setText(listDirection.get(position).getDisplay_address());
        holder.lblRegion.setText(listDirection.get(position).getDisplay_region());
        holder.lblLat.setText(listDirection.get(position).getLat().toString());
        holder.lblLog.setText(listDirection.get(position).getLon().toString());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ubication.setLat(Float.parseFloat(holder.lblLat.getText().toString()));
                Ubication.setLon(Float.parseFloat(holder.lblLog.getText().toString()));
                Ubication.setAdreess(holder.lblDirection.getText().toString());

                Intent i = new Intent(view.getContext(), ViewStore.class);
                view.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listDirection.size();
    }

    public class DirectionsViewHolder extends RecyclerView.ViewHolder {
        TextView lblDirection, lblRegion, lblLog, lblLat;
        Button btn;
        public DirectionsViewHolder(@NonNull View itemView) {
            super(itemView);
            lblDirection = itemView.findViewById(R.id.lbl_direction);
            lblRegion = itemView.findViewById(R.id.lbl_region);
            lblLog = itemView.findViewById(R.id.lbl_log);
            lblLat = itemView.findViewById(R.id.lbl_lat);
            btn = itemView.findViewById(R.id.btn_cor);
        }
    }
}