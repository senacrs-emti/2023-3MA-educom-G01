package com.example.educonn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        Button btnRecomeca;

        btnRecomeca = findViewById(R.id.btnRecomeca);
        btnRecomeca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  MainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(MainActivity);
            }
        });

    }
}