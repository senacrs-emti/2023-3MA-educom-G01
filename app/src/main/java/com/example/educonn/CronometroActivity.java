package com.example.educonn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class CronometroActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private Button buttonStart;
    private Button buttonStop;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTimer = findViewById(R.id.textViewTimer);
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
    }

    public void startTimer(View view) {
        countDownTimer = new CountDownTimer(60000, 1000) { // 1 minute, tick every 1 second
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                seconds = seconds % 60;

                String time = String.format("%02d:%02d", minutes, seconds);
                textViewTimer.setText("Tempo: " + time);
            }

            @Override
            public void onFinish() {
                textViewTimer.setText("Tempo esgotado!");
            }
        };

        countDownTimer.start();

        buttonStart.setEnabled(false);
        buttonStop.setEnabled(true);
    }

    public void stopTimer(View view) {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            textViewTimer.setText("Tempo: 00:00");

            buttonStart.setEnabled(true);
            buttonStop.setEnabled(false);
        }
    }
}






