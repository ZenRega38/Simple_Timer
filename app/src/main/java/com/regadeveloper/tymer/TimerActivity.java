package com.regadeveloper.tymer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TimerActivity extends Activity {
    Button button, btnP, btnR, btnS;
    EditText textview;
    CountDownTimer countdowntimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        button = findViewById(R.id.button1);
        btnP = findViewById(R.id.button2);
        btnR = findViewById(R.id.button3);
        btnS = findViewById(R.id.button4);
        textview = findViewById(R.id.textView1);

        btnP.setVisibility(View.GONE);
        btnR.setVisibility(View.GONE);
        btnS.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                countdowntimer = new CountDownTimerClass(100000, 1000);

                countdowntimer.start();

                button.setVisibility(View.GONE);
                btnP.setVisibility(View.VISIBLE);

            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countdowntimer.cancel();
                btnP.setVisibility(View.GONE);
                btnR.setVisibility(View.VISIBLE);
                btnS.setVisibility(View.VISIBLE);
            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countdowntimer.start();
            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countdowntimer.onFinish();
                btnR.setVisibility(View.GONE);
                btnS.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
            }
        });

    }


    public class CountDownTimerClass extends CountDownTimer {

        public CountDownTimerClass(long millisInFuture, long countDownInterval) {

            super(millisInFuture, countDownInterval);

        }

        @Override
        public void onTick(long millisUntilFinished) {

            int progress = (int) (millisUntilFinished / 1000);

            textview.setText(Integer.toString(progress));

        }

        @Override
        public void onFinish() {

            textview.setText(" Count Down Finish ");
        }
    }
}
