package com.example.adminlyabook;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.adminlyabook.controller.AdreesController;
import com.example.adminlyabook.entity.AdreessEntity;
import com.example.adminlyabook.entity.DirectionEntity;
import com.example.adminlyabook.interfaces.IAdrees;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.adminlyabook.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    List<AdreessEntity> adreessList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void Example(){
        adreessList = new ArrayList<>();
        IAdrees adrees_i = AdreesController.getAdreess().create(IAdrees.class);
        Call<List<AdreessEntity>> call = adrees_i.getAllDirection("5a6f0cf3-af52-4aaf-bb06-2c5ed3dd0da7", "san juan ");
        call.enqueue(new Callback<List<AdreessEntity>>() {
            @Override
            public void onResponse(Call<List<AdreessEntity>> call, Response<List<AdreessEntity>> response) {
                adreessList = response.body();

                Toast.makeText(MapsActivity.this, response.body().toString() , Toast.LENGTH_SHORT).show();
                Log.d("MapsActivity", adreessList.toString());
            }

            @Override
            public void onFailure(Call<List<AdreessEntity>> call, Throwable t) {
                Toast.makeText(MapsActivity.this, "error" , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ButtonSearch(View view){
        Example();
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