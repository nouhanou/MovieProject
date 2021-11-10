package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.movie.Adapter.MyAdapter;
import com.example.movie.DataBase.AppDataBase;

public class MainActivity2 extends AppCompatActivity {
private AppDataBase dataBase;
private RecyclerView recyclerView;
private Button btnfav;
private Button addfilm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dataBase = AppDataBase.getAppDataBAse(this);
        recyclerView = findViewById(R.id.recyclerView);
        btnfav =findViewById(R.id.favorie);
        btnfav.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this,ListFavActivity3.class);
            startActivity(intent);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyAdapter(this,dataBase.filmDAO().getAll()));

    }
}