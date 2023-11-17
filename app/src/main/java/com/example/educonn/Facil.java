package com.example.educonn;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Facil extends AppCompatActivity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    int score = 0;
    int totalQuestion = PerguntaFacil.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);


        totalQuestionsTextView.setText("Total de questoes: " + totalQuestion);

        loadNewQuestion();

    }

    @Override

    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            if (selectedAnswer.equals(PerguntaFacil.correctAnswer[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.RED);
        }
    }

    void loadNewQuestion(){

        if (currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        questionTextView.setText(PerguntaFacil.question[currentQuestionIndex]);
        ansA.setText(PerguntaFacil.choices[currentQuestionIndex][0]);
        ansB.setText(PerguntaFacil.choices[currentQuestionIndex][1]);
        ansC.setText(PerguntaFacil.choices[currentQuestionIndex][2]);
        ansD.setText(PerguntaFacil.choices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";
        if (score > totalQuestion * 0.60){
            passStatus = "Passou!";
        }else{
            passStatus = "Reprovou!";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Sua pontuacao foi de: " + score)
                .setPositiveButton( "Restart", (dialogInterface, i) -> restartQuiz() )
                .setNeutralButton("Próxima Fase", (dialogInterface, i) -> {
                    Intent medio = new Intent(this, Medio.class);
                    startActivity(medio);
                })
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

}