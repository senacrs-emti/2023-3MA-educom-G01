package com.example.educonn;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Facil extends AppCompatActivity implements View.OnClickListener {

    // instancia os atributos
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn, btnProximo;

    // variaveis de controle
    int score = 0;
    int totalQuestion = PerguntaFacil.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);

        // reconhece os elementos
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        // clique nas funcionalidades
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        // set do texto de apresentacao total
        totalQuestionsTextView.setText("Total de Questões: " + totalQuestion);


    }

    // metodo que carrega nova questao
    void loadNewQuestion(){
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }
        questionTextView.setText(PerguntaFacil.question[currentQuestionIndex]);
        ansA.setText(PerguntaFacil.choices[currentQuestionIndex][0]);
        ansB.setText(PerguntaFacil.choices[currentQuestionIndex][1]);
        ansC.setText(PerguntaFacil.choices[currentQuestionIndex][2]);
        ansD.setText(PerguntaFacil.choices[currentQuestionIndex][3]);
    }

    // restart do quiz
    void restartQuiz(){
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }

    // metodo de finalizacao de erro
    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Acertou a maioria";
        }else{
            passStatus = "Falhou";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Sua pontuação foi de: " + score + " de " + totalQuestion + " questões")
                .setPositiveButton("Restart", (dialogInterface, i) ->  restartQuiz() )
                .setNeutralButton("Nova Tela", (dialogInterface, i) -> {
                    Intent medio = new Intent(this, Medio.class);
                    startActivity(medio);
                })
                .setCancelable(false)
                .show();
    }

    @Override
    public void onClick(View v) {
        ansA.setBackgroundColor(Color.BLACK);
        ansB.setBackgroundColor(Color.BLACK);
        ansC.setBackgroundColor(Color.BLACK);
        ansD.setBackgroundColor(Color.BLACK);

        Button clickedButton = null;
        if (clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(PerguntaFacil.correctAnswer[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.BLUE);
        }
    }
}