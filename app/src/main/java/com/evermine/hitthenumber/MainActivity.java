package com.evermine.hitthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int trys = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int number = 45;
        //int trys = 0;
        TextView logs = (TextView) findViewById(R.id.textView2);
        //Getting the button by ID
        Button button = (Button) findViewById(R.id.button);
        //Getting userInput EditText
        EditText userinput = (EditText) findViewById(R.id.inputNumber1);
        //Setting onclicklistener
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                int inputNumber = 0;
                CharSequence text = "";
                // Getting user input
                inputNumber = Integer.valueOf(userinput.getText().toString());
                if (inputNumber == number){
                    logs.setText("");
                    text = "Good Job!! The number is "+number;
                    trys=0;
                }
                else if (inputNumber>number){
                    trys++;
                    logs.append("The number is bigger, Number: "+inputNumber+", Trys: "+trys+"\n");
                    text = "Error :( The number is bigger";
                }
                else if (inputNumber<number){
                    trys++;
                    logs.append("The number is lower, Number: "+inputNumber+", Trys: "+trys+"\n");
                    text = "Error :( The number is lower";
                }

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });
    }
}