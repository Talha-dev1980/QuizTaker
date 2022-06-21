package com.quiztaker.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.quiztaker.Class.QuestionModel;
import com.quiztaker.R;
import com.quiztaker.databinding.ActivityCategoryBinding;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    public static ArrayList<QuestionModel> foodQuestionList = new ArrayList<>();
    public static ArrayList<QuestionModel> placesQuestionList = new ArrayList<>();
    public static ArrayList<QuestionModel> gInfoQuestionList = new ArrayList<>();
    ActivityCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        Food Questions

        foodQuestionList.add(new QuestionModel("Emiratis eat this plate on breakfast, the plate's name is:", new String[]{"Harees", "Homus", "Batheeth"}, "Homus", "food", R.drawable.foodq1));
        foodQuestionList.add(new QuestionModel("Emiratis eat this plate on breakfast, the name of this plate:", new String[]{"Harees", "sweeten bread", "Khabeesa"}, "Khabeesa", "food", R.drawable.foodq2));
        foodQuestionList.add(new QuestionModel("The Bread has many types in UAE, the name of this type is:", new String[]{"Khobz Mohala", "Kobz Khameer", "Rogag "}, "Khobz Mohala", "food", R.drawable.foodq3));
        foodQuestionList.add(new QuestionModel("The Bread has many types in UAE, the name of this type is:", new String[]{"Khobz Mohala", "Kobz Khameer", "Rogag"}, "Kobz Khameer", "food", R.drawable.foodq4));
        foodQuestionList.add(new QuestionModel("The Bread has many types in UAE; the name of this type is Rogag.", new String[]{"True", "False"}, "True", "food", R.drawable.foodq5));
        foodQuestionList.add(new QuestionModel("It is traditional, Yummy and crunchy sweet, famous in UAE as Batheeth.", new String[]{"True", "False"}, "False", "food", R.drawable.foodq6));
        foodQuestionList.add(new QuestionModel("It is traditional sweet in UAE. Yummy, Soft and it melt in your moth. it's called:", new String[]{"Batheeth", "Rogag", "Loqaimat"}, "Batheeth", "food", R.drawable.foodq7));
        foodQuestionList.add(new QuestionModel("This is the tasty UAE coffee, we call the coffee Pot in Emirati:", new String[]{"Halwa", "Fenjan", "Dallah"}, "Dallah", "food", R.drawable.foodq8));
        foodQuestionList.add(new QuestionModel("Very famous Traditional food in UAE, Emiratis have it on Lunch. it's called Machboos.", new String[]{"True", "False"}, "True", "food", R.drawable.foodq9));
        foodQuestionList.add(new QuestionModel("Very famous Traditional food in UAE, Emiratis could have it on Lunch. it's called Loqaimat", new String[]{"True", "False"}, "False", "food", R.drawable.foodq10));


        // Places Questions


        placesQuestionList.add(new QuestionModel("On which of these roads would you find the 828-meter tall Burj Khalifa?", new String[]{"Sheikh Zayed Road", "Hatta Road", "Al Ain Road"}, "Sheikh Zayed Road", "place", R.drawable.placeq1));
        placesQuestionList.add(new QuestionModel("Dubai is famous for its high rise buildings and sky scrapers. Which high rise buiding cannot be found in Dubai?", new String[]{"Princess Tower", "Shanghai Tower", "Burj Khalifa"}, "Shanghai Tower", "place", 0));
        placesQuestionList.add(new QuestionModel("Where is Indoor ski slope and snow park?", new String[]{"Dragon mall", "The Mall of the Emirates", "Global village"}, "The Mall of the Emirates", "place", R.drawable.placeq3));
        placesQuestionList.add(new QuestionModel("Dubai is divided into two geographic parts , Deira and Bur Dubai.", new String[]{"True", "False"}, "True", "place", 0));
        placesQuestionList.add(new QuestionModel("What is the name given to a pair of gigantic islands built off the shore of Dubai?", new String[]{"The Tree", "The Forest", "The Palm"}, "The Palm", "place", 0));
        placesQuestionList.add(new QuestionModel("You can find the Dubai International Airport at Sayh Mudayrah.", new String[]{"True", "False"}, "False", "place", R.drawable.placeq6));
        placesQuestionList.add(new QuestionModel("On the western coast, what city has number of universities and colleges, as well as the famous Manar Mall?", new String[]{"Umm AL Quwain", "Ras Al Khaimah", "Dubai"}, "Ras Al Khaimah", "place", 0));
        placesQuestionList.add(new QuestionModel("Which emirate is geographically \"long\" and is approximately 50 kms from Ras Al Khaimah?", new String[]{"Umm AL Quwain", "Dubai", "Oman"}, "Umm AL Quwain", "place", 0));
        placesQuestionList.add(new QuestionModel("Al Ain falls in Abu Dhabi's territory.", new String[]{"True", "False"}, "True", "place", 0));
        placesQuestionList.add(new QuestionModel("Which city is close to Oman, on the Gulf of Oman coast, and is surrounded by mountains? The city and the emirate it lies in have the same name.", new String[]{"Fujairah", "al ain", "Dubai"}, "Fujairah", "place", R.drawable.placeq10));
        placesQuestionList.add(new QuestionModel("Arrange these image in correct order", new String[]{"1 2 3", "3 2 1", "2 3 1"}, "3 2 1", "place", 0));
        placesQuestionList.add(new QuestionModel("Name the place in below image", new String[]{"Fujairah", "al ain", "Dubai"}, "qasralhosn", "place", R.drawable.place_image));


        //       GInformation Question

        gInfoQuestionList.add(new QuestionModel("The United Arab Emirates are comprised of how many emirates?", new String[]{"6", "3", "7"}, "7", "GI", 0));
        gInfoQuestionList.add(new QuestionModel("What is name of the range of mountains found on the UAE's border with Oman?", new String[]{"Ash Shariqua", "Hajar Mountains", "Dubayy"}, "Hajar Mountains", "GI", 0));
        gInfoQuestionList.add(new QuestionModel("The Dubai Gold Cup held every March is called Meydan Racecourse", new String[]{"True", "False"}, "True", "GI", 0));
        gInfoQuestionList.add(new QuestionModel("What was the name of the UAE before independence?", new String[]{"Emama States", "Humama States", "Trucial States"}, "Trucial States", "GI", 0));
        gInfoQuestionList.add(new QuestionModel("The Emirates capital is Dubai", new String[]{"True", "False"}, "False", "GI", R.drawable.giq5));
        gInfoQuestionList.add(new QuestionModel("Which of these metro 'lines' was the first to open for Dubai Metro?", new String[]{"Red Line", "Blue Line", "Green Line"}, "Red Line", "GI", R.drawable.giq6));
        gInfoQuestionList.add(new QuestionModel("What is the second largest city (by population) and capital of United Arab Emirates?", new String[]{"Ajman", "Abu Dhabi", "Dubai"}, "Abu Dhabi", "GI", 0));
        gInfoQuestionList.add(new QuestionModel("Which of these airlines has its base in Dubai?", new String[]{"Al Itihad airlines", "Emirates airlines", "Gulf Air airlines"}, "Emirates airlines", "GI", 0));
        gInfoQuestionList.add(new QuestionModel("The flag of U.A.E has a vertical stripe of which colour?", new String[]{"Red", "White", "Green"}, "Red", "GI", R.drawable.giq9));
        gInfoQuestionList.add(new QuestionModel("What type of climate could you expect in Dubai?", new String[]{"Snowy", "Hot, desert climate", "Foggy"}, "Hot, desert climate", "GI", 0));


        binding.foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, QuestionActivity.class)
                        .putExtra("question", "food"));
            }
        });
        binding.placesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ResultsActivity.food) {
                    startActivity(new Intent(CategoryActivity.this, QuestionActivity.class)
                            .putExtra("question", "place"));
                } else {
                    Toast.makeText(CategoryActivity.this, "Please attempt food question first", Toast.LENGTH_SHORT).show();
                }

            }
        });
        binding.gInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ResultsActivity.place) {
                    startActivity(new Intent(CategoryActivity.this, QuestionActivity.class)
                            .putExtra("question", "gInfo"));
                } else {
                    Toast.makeText(CategoryActivity.this, "Please attempt places question first", Toast.LENGTH_SHORT).show();

                }
            }
        });
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSharedPreferences("Quiz_ref", MODE_PRIVATE).edit()
                        .putString("user", "").commit();
                startActivity(new Intent(CategoryActivity.this, LoginActivity.class));
                finish();
            }
        });


    }
}