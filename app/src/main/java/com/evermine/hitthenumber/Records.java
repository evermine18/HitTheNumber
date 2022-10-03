package com.evermine.hitthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;

public class Records extends AppCompatActivity {
    private ArrayList<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        user = (ArrayList<User>) getIntent().getSerializableExtra("users");
        TableLayout tabLayout = (TableLayout) findViewById(R.id.tabLayout);
    }
}