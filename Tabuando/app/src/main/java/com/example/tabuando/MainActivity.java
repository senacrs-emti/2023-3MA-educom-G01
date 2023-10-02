package com.example.tabuando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdicao = findViewById(R.id.btnAdicao);
        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Adicao = new Intent(getApplicationContext(), Adicao.class);
                startActivity(Adicao);
            }
        });

    }
}