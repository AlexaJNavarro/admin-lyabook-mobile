package com.example.adminlyabook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adminlyabook.adapter.ListDirectionsAdapter;
import com.example.adminlyabook.controller.DirectionController;
import com.example.adminlyabook.entity.DirectionEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listDirection;
    ArrayList<DirectionEntity> listArrayDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listDirection = findViewById(R.id.listDirections);
        listDirection.setLayoutManager(new LinearLayoutManager(this));
        listArrayDirection = new ArrayList<>();

        ListDirectionsAdapter adapter = new ListDirectionsAdapter(DirectionController.GetAllDirection());
        listDirection.setAdapter(adapter);
    }
}