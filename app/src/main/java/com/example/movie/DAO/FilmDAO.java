package com.example.movie.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.movie.Model.Film;
import com.example.movie.Model.User;

import java.util.List;

@Dao
public interface FilmDAO {
    @Insert
    void insertFilm(Film film);

    @Query("SELECT * FROM film_table WHERE type = :type  ")
    User LoginUser(String type);

    @Query("SELECT * FROM film_table")
    List<Film> getAll();
    @Query("SELECT * FROM film_table where flagt = 1")
    List<Film> getAllfave();
    @Query("UPDATE film_table SET flagt = 1 WHERE id = :id")
    void updatefave(int id);
}
