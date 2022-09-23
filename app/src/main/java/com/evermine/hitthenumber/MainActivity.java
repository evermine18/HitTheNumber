package com.evermine.hitthenumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int tries = 0;
    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayGameDialog playagain = new PlayGameDialog().onCreateDialog();
        Random rand = new Random();
        // Obtain a number between 0 and 100
        number = rand.nextInt(101);
        //Getting logs text view
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
                    showDialog();
                }
                else if (inputNumber<number){
                    tries++;
                    logs.append("The number is bigger, Number: "+inputNumber+", Trys: "+tries+"\n");
                    text = "Error :( The number is bigger";
                }
                else if (inputNumber>number){
                    tries++;
                    logs.append("The number is lower, Number: "+inputNumber+", Trys: "+tries+"\n");
                    text = "Error :( The number is lower";
                }

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            }
        });
    }
    public void playAgain(){
        Random rand = new Random();
        tries=0;
        number = rand.nextInt(101);
    }
    public void showDialog(){
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("You win!!! You wanna play again?")
                .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        playAgain();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
    }
    public class PlayGameDialog extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("You win!!! You wanna play again?")
                    .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            playAgain();
                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
