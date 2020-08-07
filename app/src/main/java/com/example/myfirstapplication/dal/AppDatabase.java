package com.example.myfirstapplication.dal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myfirstapplication.bo.User;

@Database(entities = {User.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //singleton for having only one connection to the bdd
    private static AppDatabase INSTANCE;

    /**
    *Permet de fournir une instance de la dao user aux couches superieures
    * gives us access to the userDAO - need to do it for each entity used in bdd
     */
    public abstract UserDao getUserDao();

    /**
     * singleton info - linked to static Instance
     * @param context
     * @return
     */
    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            //creation - context (who access it) - this class info - database name
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "wololo.db").build();
        }
        return INSTANCE;
    }
}
