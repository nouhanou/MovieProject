package com.example.movie.DataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.movie.DAO.FilmDAO;
import com.example.movie.DAO.UserDAO;
import com.example.movie.Model.Film;
import com.example.movie.Model.User;

@Database(entities = {User.class,Film.class},version = 4,exportSchema = true)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public abstract UserDAO userDAO();
    public abstract FilmDAO filmDAO();

    public static AppDataBase getAppDataBAse (Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"databasepersonne")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}

