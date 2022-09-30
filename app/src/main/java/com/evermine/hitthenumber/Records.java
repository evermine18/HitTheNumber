package com.evermine.hitthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public class Records extends AppCompatActivity {
    private ArrayList<User> users;
    private TextView ranking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        User u1 = new User("test",0);
        String textRanking = "";
        users = (ArrayList<User>) getIntent().getSerializableExtra("users");
        Collections.sort(users);
        ranking = (TextView) findViewById(R.id.textView5);
        for (User user:users) {
            textRanking+=user.toString()+"\n";
        }
        ranking.setText(textRanking);
    }
}