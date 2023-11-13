package com.example.educonn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnComeco;

        btnComeco = findViewById(R.id.btnComeco);
        btnComeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent facil = new Intent(getApplicationContext(), Facil.class);
                startActivity(facil);
            }
        });

    }
}