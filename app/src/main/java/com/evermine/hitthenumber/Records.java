package com.evermine.hitthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Records extends AppCompatActivity {
    private ArrayList<User> users;
    private String textRanking = "";
    private TextView ranking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        Bundle extras = getIntent().getExtras();
        users = (ArrayList<User>) extras.get("users");
        ranking = (TextView) findViewById(R.id.textView5);
        for (User user:users) {
            textRanking+=user.toString()+"\n";
        }
        ranking.setText(textRanking);
    }
}