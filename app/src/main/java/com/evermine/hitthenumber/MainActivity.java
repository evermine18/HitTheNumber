package com.evermine.hitthenumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int tries = 0;
    private int number = 0;
    private String username = "";
    private ArrayList<User> users = new ArrayList<User>();
    private TextView logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //PlayGameDialog playagain = new PlayGameDialog().onCreateDialog();
        Random rand = new Random();
        // Obtain a number between 0 and 100
        number = rand.nextInt(101);
        //Getting logs text view
        logs = (TextView) findViewById(R.id.textView2);
        logs.setMovementMethod(new ScrollingMovementMethod());

        //Getting the button by ID
        Button button = (Button) findViewById(R.id.button);
        //Getting userInput EditText
        EditText userinput = (EditText) findViewById(R.id.inputNumber1);
        //Setting Records button clicks
        Button records = (Button) findViewById(R.id.recordsButton);
        records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Records.class);
                intent.putExtra("users",users);
                startActivity(intent);
            }
        });
        //Setting onclicklistener
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                int inputNumber = 0;
                CharSequence text = "";
                new PlayGameDialog();
                // Getting user input
                inputNumber = Integer.valueOf(userinput.getText().toString());

                if (inputNumber == number){
                    text = "Good Job!! The number is "+number;
                    users.add(new User(text.toString(),tries));
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
    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setMessage("You win with "+tries+" tries!!! You wanna play again?\nType your username:")
                .setPositiveButton("Play again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        input.getText();
                        playAgain();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        builder.create();
        builder.show();
    }
    public void playAgain(){
        Random rand = new Random();
        tries=0;
        number = rand.nextInt(101);
        logs.setText("");
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

    public class StartGameDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("test")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // START THE GAME!
                        }
                    })
                    .setNegativeButton("no", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
