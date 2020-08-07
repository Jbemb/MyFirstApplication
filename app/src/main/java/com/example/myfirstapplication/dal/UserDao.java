package com.example.myfirstapplication.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myfirstapplication.bo.User;

import java.util.List;

/**
* Class for the instructions necessary for room to create the DAO to create the User table
 */
@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Insert
    void insert(User ... users);

    @Query("SELECT * FROM User")
    //allows for asinc action
    LiveData<List<User>> get();

    @Query("SELECT * FROM User WHERE id = :id")
    LiveData<User> get(int id);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("Delete from User")
    void delete();
}
