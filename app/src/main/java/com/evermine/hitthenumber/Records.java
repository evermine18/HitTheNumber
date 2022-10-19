package com.evermine.hitthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Records extends AppCompatActivity {
    private ArrayList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        users = (ArrayList<User>) getIntent().getSerializableExtra("users");
        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        TableLayout tabLayout=(TableLayout) findViewById(R.id.tabLayout);
        for (User user: users) {
            //Creating new tablerows and textviews
            TableRow row=new TableRow(this);
            TextView txt1=new TextView(this);
            TextView txt2=new TextView(this);
            TextView txt3=new TextView(this);
            //setting the text
            txt1.setText(user.getUsername());
            txt2.setText(Integer.toString(user.getTries()));
            txt3.setText(Integer.toString(user.getTime()));
            txt1.setLayoutParams(params1);
            txt2.setLayoutParams(params1);
            txt3.setLayoutParams(params1);
            //the textviews have to be added to the row created
            row.addView(txt1);
            row.addView(txt2);
            row.addView(txt3);
            row.setLayoutParams(params2);
            tabLayout.addView(row);

        }
    }
}