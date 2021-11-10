package com.example.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.movie.DataBase.AppDataBase;
import com.example.movie.Model.User;


public class SignUpFragment extends Fragment {
    private Button btnlogin;
    private EditText loginf;
    private EditText pwdf;

    private AppDataBase dataBase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        btnlogin=view.findViewById(R.id.addf);
        loginf =view.findViewById(R.id.titlef);
        pwdf =view.findViewById(R.id.typef);
        dataBase = AppDataBase.getAppDataBAse(getActivity().getApplicationContext());
        btnlogin.setOnClickListener(view1 -> {
            User user = new User();
            user.setLogin(loginf.getText().toString());
            user.setPwd(pwdf.getText().toString());
            dataBase.userDAO().insertUser(user);
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, new LoginFragment())
                .commit();

        });
        return view ;}
}