package com.example.myfirstapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;
import com.example.myfirstapplication.repository.IUserRepository;
import com.example.myfirstapplication.repository.UserBDRepository;

public class InsertUserActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_user);

        //recouperate info
        Intent intent = getIntent();

        int number = intent.getIntExtra(DemoIntentActivity.KEY_ZOLOLO, 0);
        String variable = intent.getStringExtra(DemoIntentActivity.KEY_WOLOLO);

        //recourperate object
        User user = intent.getParcelableExtra("userKey");

        Toast.makeText(this, "number " + number + variable, Toast.LENGTH_SHORT).show();
    }



    public void onClickSave(View view) {
        IUserRepository userRepo = new UserBDRepository(this);

        EditText etLastName = findViewById(R.id.et_lastname_user);
        EditText etfirstname = findViewById(R.id.et_firstName_user);
        String firstname = etfirstname.getText().toString();
        String name = etLastName.getText().toString();

        User insert = new User(0,name,firstname);
        userRepo.insert(insert);

        Toast.makeText(this, "Last name: " + name, Toast.LENGTH_LONG).show();
    }
}