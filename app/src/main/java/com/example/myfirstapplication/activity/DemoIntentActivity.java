package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;

public class DemoIntentActivity extends AppCompatActivity {

    public static final String KEY_WOLOLO = "wololo";
    public static final String KEY_ZOLOLO = "zololo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_intent);
    }

    public void onClickMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickMainInsert(View view) {
        Intent intent = new Intent(this, InsertUserActivity.class);
        intent.putExtra(KEY_WOLOLO, 14568);
        intent.putExtra(KEY_ZOLOLO, "Soliers");
        //pass an object - need to be parsible - go to class
        User user = new User(0, "fee", "fee");
        intent.putExtra("objectKey", user);
        startActivity(intent);
    }

    public void onClickMainList(View view) {
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }


}