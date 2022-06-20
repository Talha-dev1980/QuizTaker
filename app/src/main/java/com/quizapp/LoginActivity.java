package com.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.quizapp.Class.SQLiteHelper;
import com.quizapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;


    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sqLiteHelper = new SQLiteHelper(this);

        binding.doNotHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
                finish();
            }
        });

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                CheckEditTextStatus();

                // Calling login method.
                LoginFunction();

//                startActivity(new Intent(LoginActivity.this,CategoryActivity.class));
//                finish();
            }
        });

        binding.passwordShowHideImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.passwordEditText.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    binding.passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    binding.passwordShowHideImageView.setImageResource(R.drawable.hide);

                } else {
                    binding.passwordShowHideImageView.setImageResource(R.drawable.show);
                    binding.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                binding.passwordEditText.setSelection(binding.passwordEditText.length());
            }
        });

    }

    // Login function starts from here.
    @SuppressLint("Range")
    public void LoginFunction(){

        if(EditTextEmptyHolder) {

            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Password));

                    // Closing cursor.
                    cursor.close();
                }
            }

            // Calling method to check final result ..
            CheckFinalResult();

        }
        else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(LoginActivity.this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = binding.emailEditText.getText().toString();
        PasswordHolder =binding.passwordEditText.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult(){

        if(TempPassword.equalsIgnoreCase(PasswordHolder))
        {

            getSharedPreferences("Quiz_ref", MODE_PRIVATE).edit()
                    .putString("user", "true").commit();
            Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
            // Going to Dashboard activity after login success message.
            Intent intent = new Intent(LoginActivity.this, CategoryActivity.class);

            // Sending Email to Dashboard Activity using intent.
//            intent.putExtra(UserEmail, EmailHolder);

            startActivity(intent);
            finish();


        }
        else {

            Toast.makeText(LoginActivity.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();

        }
        TempPassword = "NOT_FOUND" ;

    }


}