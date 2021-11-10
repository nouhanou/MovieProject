package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.movie.DataBase.AppDataBase;

public class DetailsActivity extends AppCompatActivity {
private TextView textView;
private Button btn;
private AppDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
textView =findViewById(R.id.textView);
btn = findViewById(R.id.favori);
        int id = getIntent().getIntExtra("id",0);
        String login = getIntent().getStringExtra("login");

        textView.setText(id +"\n"+login );
        dataBase = AppDataBase.getAppDataBAse(this);
        btn.setOnClickListener(view ->
                dataBase.filmDAO().updatefave(id)
                );

    }
}