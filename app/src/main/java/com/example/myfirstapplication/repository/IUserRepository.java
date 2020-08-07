package com.example.myfirstapplication.repository;

import androidx.lifecycle.LiveData;

import com.example.myfirstapplication.bo.User;

import java.util.List;

/**
 * Interface permettant de mettre en place le design pattern DAO
 */
public interface IUserRepository {

    void insert(User user);

    LiveData<List<User>> get();

    LiveData<User> get(int id);

    void update(User user);

    void delete(User user);

    void delete();
}
