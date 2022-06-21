package com.quiztaker.Views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.quiztaker.Class.QuestionModel;
import com.quiztaker.R;
import com.quiztaker.databinding.ActivityQuestionBinding;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {

    ActivityQuestionBinding binding;
    String userAns = "";
    boolean activity = false;
    int index = 1;
    CountDownTimer timer;
    boolean ans;
    String placeAswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        if (getIntent().getStringExtra("question").equals("food")) {
            binding.subtitleText.setText(CategoryActivity.foodQuestionList.get(0).getQuestion());
            binding.qImageView.setImageResource(CategoryActivity.foodQuestionList.get(0).getImage());
            addRadioButtons(CategoryActivity.foodQuestionList.get(0).getOptions()
                    .length, CategoryActivity.foodQuestionList.get(0).getOptions(), CategoryActivity.foodQuestionList.get(0).getAnswer());

            countTimer(CategoryActivity.foodQuestionList, "food");
            binding.nextImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.answerImage.setVisibility(View.GONE);
                    binding.answerText.setVisibility(View.GONE);
                    timer.cancel();
                    CategoryActivity.foodQuestionList.get(index - 1).setUserAns(userAns);
                    userAns = "";
                    if (index < 10) {
                        binding.radioGroup.removeAllViews();
                        binding.subtitleText.setText(CategoryActivity.foodQuestionList.get(index).getQuestion());
                        binding.qImageView.setImageResource(CategoryActivity.foodQuestionList.get(index).getImage());
                        addRadioButtons(CategoryActivity.foodQuestionList.get(index).getOptions()
                                .length, CategoryActivity.foodQuestionList.get(index).getOptions(), CategoryActivity.foodQuestionList.get(index).getAnswer());
                        binding.headerText.setText("Question " + (index + 1));
                        index++;
                        countTimer(CategoryActivity.foodQuestionList, "food");
                    } else {
                        activity = true;
                        startActivity(new Intent(QuestionActivity.this, ResultsActivity.class)
                                .putExtra("question", "food"));
                        finish();
                    }

                }
            });
        } else if (getIntent().getStringExtra("question").equals("place")) {


            binding.subtitleText.setText(CategoryActivity.placesQuestionList.get(0).getQuestion());
            binding.qImageView.setImageResource(CategoryActivity.placesQuestionList.get(0).getImage());
            addRadioButtons(CategoryActivity.placesQuestionList.get(0).getOptions()
                            .length, CategoryActivity.placesQuestionList.get(0).getOptions(),
                    CategoryActivity.placesQuestionList.get(0).getAnswer());

            countTimer(CategoryActivity.placesQuestionList, "place");
            binding.nextImageView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View view) {

                    binding.answerImage.setVisibility(View.GONE);
                    binding.answerText.setVisibility(View.GONE);
                    timer.cancel();
                    if (index < 12) {
                        CategoryActivity.placesQuestionList.get(index - 1).setUserAns(userAns);
                    } else {
                        CategoryActivity.placesQuestionList.get(index - 1).setUserAns(placeAswer);
                    }
                    userAns = "";
                    if (index < 12) {
                        if (index == 10) {
                            binding.radioGroup.removeAllViews();
                            binding.subtitleText.setText(CategoryActivity.placesQuestionList.get(index).getQuestion());
//                                binding.qImageView.setVisibility(View.GONE);
                            binding.bulidingImage.setVisibility(View.VISIBLE);
                            addRadioButtons(CategoryActivity.placesQuestionList.get(index).getOptions()
                                            .length, CategoryActivity.placesQuestionList.get(index).getOptions(),
                                    CategoryActivity.placesQuestionList.get(index).getAnswer());
                            binding.headerText.setText("Question " + (index + 1));
                            index++;
                            countTimerfortwo(CategoryActivity.placesQuestionList, 10000);
                        } else if (index == 11) {
                            binding.bulidingImage.setVisibility(View.GONE);
                            binding.radioGroup.removeAllViews();
                            binding.subtitleText.setText(CategoryActivity.placesQuestionList.get(index).getQuestion());
                            binding.qImageView.setImageResource(CategoryActivity.placesQuestionList.get(index).getImage());
                            binding.radioGroup.setVisibility(View.GONE);
                            binding.keyboard.setVisibility(View.VISIBLE);
                            binding.headerText.setText("Question " + (index + 1));
                            index++;
                            countTimerfortwo(CategoryActivity.placesQuestionList, 20000);
                        } else {
                            binding.radioGroup.removeAllViews();
                            binding.subtitleText.setText(CategoryActivity.placesQuestionList.get(index).getQuestion());
                            binding.qImageView.setImageResource(CategoryActivity.placesQuestionList.get(index).getImage());
                            addRadioButtons(CategoryActivity.placesQuestionList.get(index).getOptions()
                                            .length, CategoryActivity.placesQuestionList.get(index).getOptions(),
                                    CategoryActivity.placesQuestionList.get(index).getAnswer());
                            binding.headerText.setText("Question " + (index + 1));
                            index++;
                            countTimer(CategoryActivity.placesQuestionList, "place");
                        }

                    } else {
                        activity = true;
                        startActivity(new Intent(QuestionActivity.this, ResultsActivity.class)
                                .putExtra("question", "place"));
                        finish();
                    }

                }
            });


        } else {
            binding.subtitleText.setText(CategoryActivity.gInfoQuestionList.get(0).getQuestion());
            binding.qImageView.setImageResource(CategoryActivity.gInfoQuestionList.get(0).getImage());
            addRadioButtons(CategoryActivity.gInfoQuestionList.get(0).getOptions()
                            .length, CategoryActivity.gInfoQuestionList.get(0).getOptions(),
                    CategoryActivity.gInfoQuestionList.get(0).getAnswer());

            countTimer(CategoryActivity.gInfoQuestionList, "gInfo");
            binding.nextImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    binding.answerImage.setVisibility(View.GONE);
                    binding.answerText.setVisibility(View.GONE);
                    timer.cancel();
                    CategoryActivity.gInfoQuestionList.get(index - 1).setUserAns(userAns);
                    userAns = "";
                    if (index < 10) {
                        binding.radioGroup.removeAllViews();
                        binding.subtitleText.setText(CategoryActivity.gInfoQuestionList.get(index).getQuestion());
                        binding.qImageView.setImageResource(CategoryActivity.gInfoQuestionList.get(index).getImage());
                        addRadioButtons(CategoryActivity.gInfoQuestionList.get(index).getOptions()
                                        .length, CategoryActivity.gInfoQuestionList.get(index).getOptions(),
                                CategoryActivity.gInfoQuestionList.get(index).getAnswer());
                        binding.headerText.setText("Question " + (index + 1));
                        index++;
                        countTimer(CategoryActivity.gInfoQuestionList, "gInfo");
                    } else {
                        activity = true;
                        startActivity(new Intent(QuestionActivity.this, ResultsActivity.class)
                                .putExtra("question", "gInfo"));
                        finish();
                    }

                }
            });
        }


        binding.aCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "a";
                setTextinPinView();
            }
        });
        binding.bCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "b";
                setTextinPinView();
            }
        });
        binding.hCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "h";
                setTextinPinView();
            }
        });
        binding.oCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "o";
                setTextinPinView();
            }
        });
        binding.kCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "k";
                setTextinPinView();
            }
        });
        binding.lCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "l";
                setTextinPinView();
            }
        });
        binding.iCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "i";
                setTextinPinView();
            }
        });
        binding.nCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "n";
                setTextinPinView();
            }
        });
        binding.qCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "q";
                setTextinPinView();
            }
        });
        binding.wCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "w";
                setTextinPinView();
            }
        });
        binding.sCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "s";
                setTextinPinView();
            }
        });
        binding.rCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "r";
                setTextinPinView();
            }
        });
        binding.jCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "j";
                setTextinPinView();
            }
        });
        binding.uCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeAswer.length() < 11)
                    placeAswer = placeAswer + "u";
                setTextinPinView();
            }
        });


    }

    public void addRadioButtons(int number, String[] option, String answer) {
        binding.radioGroup.setOrientation(LinearLayout.VERTICAL);
        //
        for (int i = 0; i < number; i++) {
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId(View.generateViewId());
            rdbtn.setText(option[i]);
            rdbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    if (!ans) {
                    userAns = rdbtn.getText().toString();
                    if (userAns.equals(answer)) {
                        binding.answerImage.setImageResource(R.drawable.check_circle);
                        binding.answerText.setText("Answer is Correct");
                    } else {
                        binding.answerImage.setImageResource(R.drawable.cancel);
                        binding.answerText.setText("Answer is Wrong.Correct answer is " + answer);
                    }
//                        ans = true;
                    binding.answerImage.setVisibility(View.VISIBLE);
                    binding.answerText.setVisibility(View.VISIBLE);
//                    }

                }
            });
            binding.radioGroup.addView(rdbtn);
        }
    }

    void countTimer(ArrayList<QuestionModel> arrayList, String intent) {

        timer = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                binding.timerText.setText(String.format("%02d", millisUntilFinished / 1000));
            }

            public void onFinish() {
                if (!activity)

                    binding.answerImage.setVisibility(View.GONE);
                binding.answerText.setVisibility(View.GONE);
                timer.cancel();
                arrayList.get(index - 1).setUserAns(userAns);
                userAns = "";
                if (index < 10) {
                    binding.radioGroup.removeAllViews();
                    binding.subtitleText.setText(arrayList.get(index).getQuestion());
                    binding.qImageView.setImageResource(arrayList.get(index).getImage());
                    addRadioButtons(arrayList.get(index).getOptions()
                                    .length, arrayList.get(index).getOptions(),
                            arrayList.get(index).getAnswer());
                    binding.headerText.setText("Question " + (index + 1));
                    index++;
                    countTimer(CategoryActivity.foodQuestionList, intent);
                } else {
                    activity = true;
                    startActivity(new Intent(QuestionActivity.this, ResultsActivity.class)
                            .putExtra("question", intent));
                    finish();
                }
            }
        }.start();
    }

    void countTimerfortwo(ArrayList<QuestionModel> arrayList, long time) {

        timer = new CountDownTimer(20000, 1000) {
            public void onTick(long millisUntilFinished) {
                binding.timerText.setText(String.format("%02d", millisUntilFinished / 1000));
            }

            public void onFinish() {
                if (!activity)

                    binding.answerImage.setVisibility(View.GONE);
                binding.answerText.setVisibility(View.GONE);
                timer.cancel();
                arrayList.get(index - 1).setUserAns(userAns);
                userAns = "";
                if (index == 10) {
                    binding.radioGroup.removeAllViews();
                    binding.subtitleText.setText(CategoryActivity.placesQuestionList.get(index).getQuestion());
//                                binding.qImageView.setVisibility(View.GONE);
                    binding.bulidingImage.setVisibility(View.VISIBLE);
                    addRadioButtons(CategoryActivity.placesQuestionList.get(index).getOptions()
                                    .length, CategoryActivity.placesQuestionList.get(index).getOptions(),
                            CategoryActivity.placesQuestionList.get(index).getAnswer());
                    binding.headerText.setText("Question " + (index + 1));
                    index++;
                    countTimerfortwo(CategoryActivity.placesQuestionList, 1000);
                } else if (index == 11) {
                    binding.bulidingImage.setVisibility(View.GONE);
                    binding.radioGroup.removeAllViews();
                    binding.subtitleText.setText(CategoryActivity.placesQuestionList.get(index).getQuestion());
                    binding.qImageView.setImageResource(CategoryActivity.placesQuestionList.get(index).getImage());
                    binding.radioGroup.setVisibility(View.GONE);
                    binding.keyboard.setVisibility(View.VISIBLE);
                    binding.headerText.setText("Question " + (index + 1));
                    index++;
                    countTimerfortwo(CategoryActivity.placesQuestionList, 20000);
                } else {
                    activity = true;
                    startActivity(new Intent(QuestionActivity.this, ResultsActivity.class)
                            .putExtra("question", "place"));
                    finish();
                }
            }
        }.start();
    }

    void setTextinPinView() {
        if (placeAswer.length() <= 4) {
            binding.firstFour.setText(placeAswer);
        } else if (placeAswer.length() <= 6) {
            binding.cetertwo.setText(placeAswer.substring(4));
        } else {
            binding.endFour.setText(placeAswer.substring(6));
        }

        if (placeAswer.length() == 10) {

            if (placeAswer.equals(CategoryActivity.placesQuestionList.get(11).getAnswer())) {
                binding.answerImage.setImageResource(R.drawable.check_circle);
                binding.answerText.setText("Answer is Correct");
            } else {
                binding.answerImage.setImageResource(R.drawable.cancel);
                binding.answerText.setText("Answer is Wrong. Correct answer is " + CategoryActivity.placesQuestionList.get(11).getAnswer());
            }
//                        ans = true;
            binding.answerImage.setVisibility(View.VISIBLE);
            binding.answerText.setVisibility(View.VISIBLE);
        }
    }
}