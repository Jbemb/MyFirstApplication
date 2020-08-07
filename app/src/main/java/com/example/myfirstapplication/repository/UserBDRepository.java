package com.example.myfirstapplication.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.dal.AppDatabase;
import com.example.myfirstapplication.dal.UserDao;

import java.util.List;

public class UserBDRepository implements IUserRepository {

    private UserDao userDao;
    List<User> resultat = null;

    public UserBDRepository(Context context){
        //get the database Instance
        AppDatabase myDatabase = AppDatabase.getInstance(context);
        //Instance de la dao user
        userDao = myDatabase.getUserDao();
    }

    @Override
    public void insert(User user) {
        //create a new thread (worker)
        new AsyncTask<User,Void,Void>(){
            // tell them what to do
            @Override
            protected Void doInBackground(User... users) {
                //insert
                userDao.insert(users[0]);
                return null;
            }
        }.execute(user);
    }

    @Override
    public LiveData<List<User>> get(){
        return userDao.get();
    }

    @Override
    public LiveData<User> get(int id) {
        return null;
    }

    @Override
    public void update(User user) {
        //create a new thread (worker)
        new AsyncTask<User,Void,Void>(){
            // tell them what to do
            @Override
            protected Void doInBackground(User... users) {
                   //update
                userDao.update(users[0]);
                return null;
            }
        }.execute(user);
    }

    @Override
    public void delete(User user) {
        //create a new thread (worker)
        new AsyncTask<User,Void,Void>(){
            // tell them what to do
            @Override
            protected Void doInBackground(User... users) {
                //delete
                userDao.delete(users[0]);
                return null;
            }
        }.execute(user);
    }

    @Override
    public void delete() {
        //create a new thread (worker)
        new AsyncTask<Void,Void,Void>(){
            // tell them what to do
            @Override
            protected Void doInBackground(Void... voids) {
                //delete all
                userDao.delete();
                return null;
            }
        }.execute();
    }
}
