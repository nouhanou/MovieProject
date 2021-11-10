package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.movie.Adapter.MyAdapter;
import com.example.movie.DataBase.AppDataBase;

public class ListFavActivity3 extends AppCompatActivity {
    private AppDataBase dataBase;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fav3);
        dataBase = AppDataBase.getAppDataBAse(this);
        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyAdapter(this,dataBase.filmDAO().getAllfave()));

    }
}