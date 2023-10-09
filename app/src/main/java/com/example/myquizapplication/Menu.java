package com.example.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
/*
        Button btnAdicao = findViewById(R.id.btnAdicao);
        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dificuldade = new Intent(getApplicationContext(), dificuldade.class);
                startActivity(dificuldade);
            }
        });
*/

    }
}