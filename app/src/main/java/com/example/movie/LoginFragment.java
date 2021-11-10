package com.example.movie;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movie.DataBase.AppDataBase;
import com.example.movie.Model.User;


public class LoginFragment extends Fragment {
private Button btnlogin;
private EditText loginf;
private EditText pwdf;
private User user;
    private AppDataBase dataBase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_login, container, false);
        btnlogin=view.findViewById(R.id.loginf);
        loginf =view.findViewById(R.id.loginf1);
        pwdf =view.findViewById(R.id.pwdf1);
        dataBase = AppDataBase.getAppDataBAse(getActivity().getApplicationContext());
        btnlogin.setOnClickListener(view1 -> {
       if(dataBase.userDAO().LoginUser(loginf.getText().toString(),pwdf.getText().toString())!= null){
            user =dataBase.userDAO().LoginUser(loginf.getText().toString(),pwdf.getText().toString());
       }

        if (user != null){
//            Intent intent = new Intent(getActivity(),MainActivity2.class);
//            startActivity(intent);
            getActivity()
            .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new AddFilmFragment())
                    .commit();

        }else
        {
            Toast.makeText(getActivity().getApplicationContext(),"Errooooooor",Toast.LENGTH_LONG).show();
        }


        });

        return view ;   }
}