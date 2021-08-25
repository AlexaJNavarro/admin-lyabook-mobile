package com.example.adminlyabook;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adminlyabook.adapter.ListDirectionsAdapter;
import com.example.adminlyabook.controller.DirectionController;
import com.example.adminlyabook.entity.DirectionEntity;
import com.example.adminlyabook.helper.Store;
import com.example.adminlyabook.interfaces.LocationNameApi;
import com.example.adminlyabook.models.Data;
import com.example.adminlyabook.models.Location;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.adminlyabook.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    EditText txt_location;
    RecyclerView listDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void ButtonSearch(View view){
        apiPlaces();
    }

    public void apiPlaces() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.7:8081/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        LocationNameApi locationNameApi = retrofit.create(LocationNameApi.class);

        txt_location = findViewById(R.id.id_location);

        Call<Location> call = locationNameApi.find(txt_location.getText().toString());
        call.enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call<Location> call, Response<Location> response) {
                if (response.code() == 200) {
                    Location location = response.body();
                    ArrayList<Data> res = location.getData();
                    Toast.makeText(MapsActivity.this, response.toString() , Toast.LENGTH_SHORT).show();

                    listDirection = findViewById(R.id.listDirections);
                    listDirection.setLayoutManager(new LinearLayoutManager(MapsActivity.this));
                    ListDirectionsAdapter adapter = new ListDirectionsAdapter(res);
                    listDirection.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Location> call, Throwable t) {
                Toast.makeText(MapsActivity.this, ":c" , Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-12.078213, -77.074434);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}