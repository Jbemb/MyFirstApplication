package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.dal.AppDatabase;
import com.example.myfirstapplication.dal.UserDao;
import com.example.myfirstapplication.repository.IUserRepository;
import com.example.myfirstapplication.repository.UserBDRepository;
import com.example.myfirstapplication.view_model.UserViewModel;
import com.facebook.stetho.Stetho;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context = null;

    /**
     * premiere function applelee dans le cycle de vie de l'activité
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //import Stetho
        Stetho.initializeWithDefaults(this);
        //charges IHM
        setContentView(R.layout.activity_main);


        IUserRepository repoUser = new UserBDRepository(this);
        //one instance of the vm
        UserViewModel vm = ViewModelProviders.of(this).get(UserViewModel.class);

        LiveData<List<User>> observateur = vm.get();

        observateur.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for (User item : users) {
                    Log.i("wololo", "Item:" + item);
                }
            }
        });
    }

    //save in fichier - parameters making changes for git qsdf
    public void onClickSave(View view) {
        SharedPreferences sp = getSharedPreferences("Wololo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("myKey", "123456");
        editor.putInt("Key", 555);

        editor.commit();
    }
    // load in fichier
    public void onClickload(View view) {
        SharedPreferences sp = getSharedPreferences("Wololo", MODE_PRIVATE);
        String info1 = sp.getString("myKey", "vide");
        int info2 = sp.getInt("Key", 2);

        Toast.makeText(this, "info: " + info1 + info2, Toast.LENGTH_LONG).show();
    }
}