package com.example.movie.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.movie.Model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user_table WHERE loginT = :login and pwdT = :pwd ")
    User LoginUser(String login,String pwd);

    @Query("SELECT * FROM user_table")
    List<User> getAll();
    @Query("SELECT * FROM user_table where flagt = 1")
    List<User> getAllfave();
    @Query("UPDATE user_table SET flagt = 1 WHERE id = :id")
    void updatefave(int id);


}
