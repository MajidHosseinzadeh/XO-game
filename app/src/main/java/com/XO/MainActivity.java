package com.XO;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;

public class MainActivity extends Activity {


    public static String N1;
    public static String N2;

    public Timer timer;

    public void letsGoClick(View view) {
        TextView no1 = findViewById(R.id.no1);
        TextView no2 = findViewById(R.id.no2);
        N1 = no1.getText().toString();
        N2 = no2.getText().toString();
        Button letsGo = findViewById(R.id.letsGo);
        openActivity2();

    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000000,1000){

            TextView XA = findViewById(R.id.XA);
            TextView OA = findViewById(R.id.OA);
            int i = 0;

            @Override
            public void onTick(long l) {
                if (i % 2 == 0) {
                    XA.animate().translationX(800).translationY(-200).translationZ(500).scaleX(0.2f).scaleY(0.5f).setDuration(1000);
                    OA.animate().translationX(-800).translationY(200).translationZ(-500).scaleX(1f).scaleY(1f).setDuration(1000);
                }else {
                    XA.animate().translationX(-800).translationY(200).translationZ(-500).scaleX(1f).scaleY(1f).setDuration(1000);
                    OA.animate().translationX(800).translationY(-200).translationZ(500).scaleX(0.2f).scaleY(0.5f).setDuration(1000);
                }
                i++;
            }

            @Override
            public void onFinish() {

            }
        }.start();

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);

        String text = "Welcome to XO game";

        SpannableString spannableString = new SpannableString(text);

        ForegroundColorSpan white = new ForegroundColorSpan(Color.WHITE);
        ForegroundColorSpan red = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan blue = new ForegroundColorSpan(Color.BLUE);

        spannableString.setSpan(white, 0, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(red, 11, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(blue, 12, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        welcomeTextView.setText(spannableString);
    }
}
