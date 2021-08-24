package com.example.adminlyabook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adminlyabook.adapter.ListDirectionsAdapter;
import com.example.adminlyabook.controller.DirectionController;
import com.example.adminlyabook.entity.DirectionEntity;

import com.example.adminlyabook.interfaces.IBook;
import com.example.adminlyabook.models.Book;
import com.example.adminlyabook.models.Fisico;
import com.example.adminlyabook.models.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText txt_name, txt_author, txt_editorial, txt_price, txt_image, txt_description, txt_details, txt_stock;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_location);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });

    }

    public void BtnSave(View view) {
        txt_name = findViewById(R.id.txt_name);
        txt_author = findViewById(R.id.txt_author);
        txt_editorial = findViewById(R.id.txt_editorial);
        txt_price = findViewById(R.id.txt_price);
        txt_image = findViewById(R.id.txt_image);
        txt_description = findViewById(R.id.txt_description);
        txt_details = findViewById(R.id.txt_details);
        txt_stock = findViewById(R.id.txt_stock);


        List<String> images = new ArrayList<>();
        List<String> details = new ArrayList<>();
        List<String> cat = new ArrayList<>();
        images.add(txt_image.getText().toString());
        details.add(txt_details.getText().toString());
        cat.add("611c6b5e43ec261a0e087e37");

        Fisico fisico = new Fisico();
        fisico.setDetails(details);
        fisico.setLat("-1111111111");
        fisico.setLog("-2222222222");
        fisico.setStock(Integer.parseInt(txt_price.getText().toString()));

        Type type = new Type();
        type.setFisico(fisico);

        Book book= new Book();
        book.setName(txt_name.getText().toString());
        book.setAuthor(txt_author.getText().toString());
        book.setDescription(txt_description.getText().toString());
        book.setEditorial(txt_editorial.getText().toString());
        book.setImages_src(images);
        book.setPrice_current(Float.parseFloat(txt_price.getText().toString()));
        book.setCategories(cat);
        book.setType(type);

        SaveBook(book);
    }

    private void SaveBook(Book book) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.7:8080/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        IBook iBook = retrofit.create(IBook.class);
        Call<Book> call = iBook.newBookFisico(book, "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MTI0OTJiOTJmYmRjYmU1YzlkYzVlYmIiLCJuYW1lIjoiUmFxdWVsIE5hbmN5IiwibGFzdF9uYW1lIjoiQmVkb24gQ3VhZHJvcyIsImRuaSI6IjEwMDI5MDY4Iiwicm9sIjoiQWRtaW4iLCJjcmVhdGVkX2F0IjoiMDAwMS0wMS0wMVQwMDowMDowMFoiLCJ1cGRhdGVkX2F0IjoiMDAwMS0wMS0wMVQwMDowMDowMFoiLCJkZWxldGVkX2F0IjoiMDAwMS0wMS0wMVQwMDowMDowMFoiLCJleHAiOjE2Mjk5NjY4MTgsImlzcyI6Ikxlb25hcmRvIEFudG9uaW8gTm9sYXNjbyBMZXl2YSJ9.nMzt1DEGOwJEUx39l9pa3M4Bw3EyceW62WTuWbYFrkZo4XJAnu828rNosYw0Ok-6WmgilleVw2p_6kxmDho-74gTlM5jCvIBZ5qO4RMeiGNb5QmlI3I3xIqWB0bXvtFf6GgD7kC6wQms-RASfgB-QTIdG9YUUYfQ8dOcR1aTVyA");
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                if (response.code() == 201) {
                    Book res = response.body();
                    Toast.makeText(MainActivity.this, "creado", Toast.LENGTH_SHORT).show();
                }
                System.out.println("###############################################################333");
                System.out.println(response.toString());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error the connection or server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}