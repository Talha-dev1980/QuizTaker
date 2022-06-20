package com.quizapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.quizapp.databinding.ActivityResultsBinding;

public class ResultsActivity extends AppCompatActivity {

    ActivityResultsBinding binding;

    public static boolean food;
    public static boolean place;
    int correctAns = 0;

    static int f=0;
    static  int p=0;
     int total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        if (getIntent().getStringExtra("question").equals("food")) {
            for (int i = 0; i < CategoryActivity.foodQuestionList.size(); i++) {


                Log.e("correctAns", "useranswer: " + CategoryActivity.foodQuestionList.get(i).getAnswer()
                        .equals(CategoryActivity.foodQuestionList.get(i).getUserAns()));
                if (CategoryActivity.foodQuestionList.get(i).getAnswer()
                        .equals(CategoryActivity.foodQuestionList.get(i).getUserAns())) {
                    correctAns++;
                }
                Log.e("correctAns", "" + correctAns);
            }
            food = true;
            f=correctAns;
            binding.resultText.setText("Your Score is " + correctAns + " out of 10");

        }
        else if (getIntent().getStringExtra("question").equals("place")) {
            for (int i = 0; i < CategoryActivity.placesQuestionList.size(); i++) {

                Log.e("correctAns", "useranswer: " + CategoryActivity.placesQuestionList.get(i).getAnswer()
                        .equals(CategoryActivity.placesQuestionList.get(i).getUserAns()));
                if (CategoryActivity.placesQuestionList.get(i).getAnswer()
                        .equals(CategoryActivity.placesQuestionList.get(i).getUserAns())) {
                    correctAns++;
                }
                Log.e("correctAns", "" + correctAns);
            }
            place = true;
            p=correctAns;
            binding.resultText.setText("Your Score is " + correctAns + " out of 12");
        }
        else {
            for (int i = 0; i < CategoryActivity.gInfoQuestionList.size(); i++) {
                Log.e("correctAns", "useranswer: " + CategoryActivity.gInfoQuestionList.get(i).getAnswer()
                        .equals(CategoryActivity.gInfoQuestionList.get(i).getUserAns()));
                if (CategoryActivity.gInfoQuestionList.get(i).getAnswer()
                        .equals(CategoryActivity.gInfoQuestionList.get(i).getUserAns())) {
                    correctAns++;
                }
                Log.e("correctAns", "" + correctAns);
                total=f+p+correctAns;
                binding.resultText.setText("Your Score is " + total + " out of 32");
                food=false;
                place=false;
            }

        }




    }
}
