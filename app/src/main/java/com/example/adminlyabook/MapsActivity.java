package com.example.adminlyabook;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.adminlyabook.adapter.ListDirectionsAdapter;
import com.example.adminlyabook.controller.DirectionController;
import com.example.adminlyabook.entity.DirectionEntity;
import com.example.adminlyabook.entity.MapsDirectionModels;
import com.example.adminlyabook.interfaces.MapsDIrectionInterface;
import com.example.adminlyabook.models.Book;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    RecyclerView listDirection;
    ArrayList<DirectionEntity> listArrayDirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        listDirection = findViewById(R.id.listDirections);
        listDirection.setLayoutManager(new LinearLayoutManager(this));
        listArrayDirection = new ArrayList<>();

        ListDirectionsAdapter adapter = new ListDirectionsAdapter(DirectionController.GetAllDirection());
        listDirection.setAdapter(adapter);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    public void GetAllDirection(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.mymappi.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        MapsDIrectionInterface mapsDirecInter = retrofit.create(MapsDIrectionInterface.class);
        Call<MapsDirectionModels> call = mapsDirecInter.getAllDirection("5a6f0cf3-af52-4aaf-bb06-2c5ed3dd0da7", "Scotiabank San Juan de Miraflores Avenida San Juan 1186, Lima, Lima, Peru");
        call.enqueue(new Callback<MapsDirectionModels>() {
            @Override
            public void onResponse(Call<MapsDirectionModels> call, Response<MapsDirectionModels> response) {

                if (response.code() == 200) {
                    MapsDirectionModels model = response.body();
                    Toast.makeText(MapsActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MapsDirectionModels> call, Throwable t) {
                Toast.makeText(MapsActivity.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void ButtonSearch(View view){
        GetAllDirection();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-45511, 151515500);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        CameraPosition CameraPosition = new CameraPosition.Builder().target(sydney).zoom(13).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(CameraPosition);
        mMap.moveCamera(update);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}