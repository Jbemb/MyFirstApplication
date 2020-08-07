package com.example.myfirstapplication.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myfirstapplication.R;
import com.example.myfirstapplication.bo.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User>{

    public UserAdapter(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View newLine, @NonNull ViewGroup parent) {
        //the first time it is called, the view is null, so this code allows us to only decompress(inflate) one time
        if(newLine == null){
       LayoutInflater li = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       newLine = li.inflate(R.layout.style_user_list, parent, false);
        }
        //get item
       TextView tvFirstName = newLine.findViewById(R.id.tv_firstname);
        //set text in item
       tvFirstName.setText(getItem(position).getFirstName());

        return newLine;
    }
}
