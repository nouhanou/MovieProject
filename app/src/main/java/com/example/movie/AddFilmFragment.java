package com.example.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.movie.DataBase.AppDataBase;
import com.example.movie.Model.Film;
import com.example.movie.Model.User;


public class AddFilmFragment extends Fragment {
    private Button addfilm;
    private EditText title;
    private EditText type;
    private EditText description;
    private EditText year;

    private AppDataBase dataBase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_film, container, false);
        addfilm=view.findViewById(R.id.addf);
        title =view.findViewById(R.id.titlef);
        type =view.findViewById(R.id.typef);
        description=view.findViewById(R.id.descripf);
        year=view.findViewById(R.id.anee);
        dataBase = AppDataBase.getAppDataBAse(getActivity().getApplicationContext());
        addfilm.setOnClickListener(view1 -> {
            Film film = new Film();
            film.setTitle(title.getText().toString());
            film.setType(type.getText().toString());
            film.setDescription(description.getText().toString());
            film.setAnnee(year.getText().toString());



            dataBase.filmDAO().insertFilm(film);
            Intent intent = new Intent(getActivity(),MainActivity2.class);
            startActivity(intent);
//        getActivity()
//                .getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.frameLayout, new LoginFragment())
//                .commit();

        });
        return view ;}
}