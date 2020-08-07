package com.example.myfirstapplication.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.repository.IUserRepository;
import com.example.myfirstapplication.repository.UserBDRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    //take all the repositories necessary to access objects
    IUserRepository repo;
    /**
     * create it here so you only have one instead of one for each screen
     */
    private LiveData<List<User>> observateur = null;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repo = new UserBDRepository(application);
        observateur = repo.get();
    }

    public LiveData<List<User>> get(){

        return observateur;
    }


    void insert(User user){
        repo.insert(user);
    }

    void update(User user){
        repo.update(user);
    }
    void delete(User user){

        repo.delete(user);
    }
    void delete(){
        repo.delete();
    }

}
