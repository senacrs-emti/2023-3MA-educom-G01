package com.example.myquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView TotalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;

    ihnt score = 0;
    int totalQuestions = QuestionAnswer.question.length;
    int cuurentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        totalQuestionsTextView.setText("Total questions: " + totalQuestions);

        loadNewQuestion();

    }

    @Override
    public void onClick(View view){

        ansA.setBackgroundColor(Color.White);
        ansB.setBackgroundColor(Color.White);
        ansC.setBackgroundColor(Color.White);
        ansD.setBackgroundColor(Color.White);

        Button clickedButton = (Button) view;
        if(clickedButton.getId() == R.id.submit_btn){
            cuurentQuestionIndex++;
            loadNewQuestion();
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }

        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    void loadNewQuestion(){
        questionTextView.setTextView(QuestionAnswer.question[curentQuestionIndex]);
        ansA.setTec(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setTec(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setTec(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setTec(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

}