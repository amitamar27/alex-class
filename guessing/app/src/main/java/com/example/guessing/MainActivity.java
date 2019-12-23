package com.example.guessing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private TextView msgTv;
    private TextView mainTv;
    public int numOfTries =5;
    private TextView counter;
    private EditText inputNum;
    private Button guess;
    public static Random randomNum = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTv = (TextView) findViewById(R.id.instractions);
        mainTv.setText(R.string.level1);
        level1();

    }

    private void level1() {
        inputNum = (EditText) findViewById(R.id.input);
        counter = (TextView) findViewById(R.id.counter);
        msgTv = (TextView)findViewById(R.id.msgTv);
        guess = (Button) findViewById(R.id.button);
        guess.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == guess){
            guess();
        }
    }


    public void guess() {
        int ofTry = numOfTries;
        numOfTries--;

        int numGot = Integer.parseInt(inputNum.getText().toString());
        int num = randomNum.nextInt(11);

        if (numGot!= num){
            msgTv.setText(R.string.tryAgin);
            //Toast.makeText(this,"Not Good",Toast.LENGTH_SHORT).show();
        }

        if (numGot == num){
            msgTv.setText(R.string.nextLevel);
            nextLeve2();
            //Toast.makeText(this,"Good",Toast.LENGTH_SHORT).show();
        }
        if (ofTry<1){
            youLost();
        }
        Toast.makeText(this,"You have " + ofTry  + " Attempts left",Toast.LENGTH_SHORT).show();
        level1();

    }

    private void nextLeve2() {
        mainTv.setText(R.string.level2);

        int ofTry = numOfTries;
        numOfTries=4;

        int numGot = Integer.parseInt(inputNum.getText().toString());
        int num = randomNum.nextInt(11);

        if (numGot!= num){
            msgTv.setText(R.string.tryAgin);
            //Toast.makeText(this,"Not Good",Toast.LENGTH_SHORT).show();
        }

        if (numGot == num){
            msgTv.setText(R.string.nextLevel);
            //Toast.makeText(this,"Good",Toast.LENGTH_SHORT).show();
        }
        if (ofTry<1){
            youLost();
        }
        Toast.makeText(this,"You have " + ofTry  + " Attempts left",Toast.LENGTH_SHORT).show();
        level1();
    }

    private void youLost() {
        msgTv.setText(R.string.lostgame);
        numOfTries=5;

    }
}
