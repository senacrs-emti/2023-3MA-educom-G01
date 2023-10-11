package com.example.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnAdicao, btnSubtracao, btnMultiplicacao, btnDivisao;

        btnAdicao = findViewById(R.id.btnAdicao);
        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perguntas = new Intent(getApplicationContext(), Perguntas.class);
                startActivity(perguntas);
            }
        });

        btnSubtracao = findViewById(R.id.btnSubtracao);
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perguntas = new Intent(getApplicationContext(), Perguntas.class);
                startActivity(perguntas);
            }
        });

        btnMultiplicacao = findViewById(R.id.btnMultiplicacao);
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perguntas = new Intent(getApplicationContext(), Perguntas.class);
                startActivity(perguntas);
            }
        });

        btnDivisao = findViewById(R.id.btnDivisao);
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perguntas = new Intent(getApplicationContext(), Perguntas.class);
                startActivity(perguntas);
            }
        });

    }
}