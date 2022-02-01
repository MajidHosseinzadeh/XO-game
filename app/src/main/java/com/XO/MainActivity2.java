package com.XO;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends Activity {
    String turn0 = "It's " + MainActivity.N1 + "'s turn";
    String turn1 = "It's " + MainActivity.N2 + "'s turn";
    int counter = 0;
    int [] gameState = {2,2,2,2,2,2,2,2,2};
    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameIsActive = true;
    @SuppressLint("WrongConstant")
    public void click(View view) {
        TextView turnView = findViewById(R.id.turnView);
        TextView text = (TextView) view;
        int tapped = Integer.parseInt(text.getTag().toString());
        if (gameState[tapped] == 2 && gameIsActive) {
            gameState[tapped] = counter;
            if (counter == 0) {
                text.setTextColor(Color.RED);
                text.setText("X");
                turnView.setText(turn1);
                counter = 1;
            } else {
                text.setTextColor(Color.BLUE);
                text.setText("O");
                turnView.setText(turn0);
                counter = 0;
            }
            for (int [] winningPositions : winningPositions){
                if (gameState[winningPositions[0]] == gameState[winningPositions[1]] &&
                    gameState[winningPositions[1]] == gameState[winningPositions[2]] &&
                    gameState[winningPositions[0]] != 2) {
                    gameIsActive = false;
                    LinearLayout layout = findViewById(R.id.layout);
                    TextView won = findViewById(R.id.won);
                    Button playAgain = findViewById(R.id.playAgain);
                    if (gameState[winningPositions[0]] == 0) {
                        won.setText(MainActivity.N1 + " has won");
                        layout.animate().alpha(1f).rotation(360f).setDuration(1000);
                    }else {
                        won.setText(MainActivity.N2 + " has won");
                        layout.animate().alpha(1f).rotation(360f).setDuration(1000);
                    }
                }
            }
        }
    }
    public void playAgain(View view){
        gameIsActive = true;
        LinearLayout layout = findViewById(R.id.layout);
        layout.animate().alpha(0f);
        counter = 0;
        TextView turnView = findViewById(R.id.turnView);
        turnView.setText(turn0);
        for (int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }
        TextView one = findViewById(R.id.Z0);
        TextView two = findViewById(R.id.Z1);
        TextView three = findViewById(R.id.Z2);
        TextView four = findViewById(R.id.O0);
        TextView five = findViewById(R.id.O1);
        TextView six = findViewById(R.id.O2);
        TextView seven = findViewById(R.id.T0);
        TextView eight = findViewById(R.id.T1);
        TextView nine = findViewById(R.id.T2);
        one.setText("");
        two.setText("");
        three.setText("");
        four.setText("");
        five.setText("");
        six.setText("");
        seven.setText("");
        eight.setText("");
        nine.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView turnView = findViewById(R.id.turnView);
        turnView.setText(turn0);
        LinearLayout layout = findViewById(R.id.layout);
        layout.animate().alpha(0f).setDuration(1);
    }
}