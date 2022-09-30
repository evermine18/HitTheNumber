package com.evermine.hitthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class Records extends AppCompatActivity {
    private ArrayList<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        Bundle extras = getIntent().getExtras();
        //user = extras.getArray
    }
}