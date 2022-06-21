package com.quiztaker.Views;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.quiztaker.Class.SQLiteHelper;
import com.quiztaker.Models.RegisterResponse;
import com.quiztaker.R;
import com.quiztaker.Utils.AppLogger;
import com.quiztaker.ViewModels.JoinCompleteViewModel;
import com.quiztaker.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {


    ActivitySignupBinding binding;

    String NameHolder, EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    Boolean PasswordMatches;
    Boolean EmailPattren;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    JoinCompleteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sqLiteHelper = new SQLiteHelper(this);
        viewModel = ViewModelProviders.of(this).get(JoinCompleteViewModel.class);

        binding.alreagyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
            }
        });

        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                CheckPasswordMatches();

                CheckEmaiPattren();

                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();

                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();
            }
        });
        viewModel.getLiveRegResponse().observe(this, new Observer<RegisterResponse>() {
            @Override
            public void onChanged(RegisterResponse registerResponse) {
                if (registerResponse != null) {

                    AppLogger.log("API Call-getResponseObserver", registerResponse.isError() + "");
                } else {

                    AppLogger.log("API Call-getResponse", "in observer");
                }

            }
        });

       /* binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailEditText.getText().toString().trim();
                if (binding.passwordEditText.getText().length() > 0) {
                    String pass = binding.passwordEditText.getText().toString().trim();
                    RegisterModel model = new RegisterModel();
                    model.setEmail(email);
                    model.setPassword(pass);
                    model.setRole("User");
                    viewModel.startRegisterUser(model);
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    // startActivity(intent);
                } else {
                    binding.passwordEditText.setError(getResources().getString(R.string.invalidEmail));
                }
            }
        });
       */
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
        findViewById(R.id.confirmPasswordShowHideImageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.confirmPasswordEditText.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                    binding.confirmPasswordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    binding.confirmPasswordShowHideImageView.setImageResource(R.drawable.hide);

                } else {
                    binding.confirmPasswordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.confirmPasswordShowHideImageView.setImageResource(R.drawable.show);
                }
                binding.confirmPasswordEditText.setSelection(binding.confirmPasswordEditText.length());
            }
        });

    }

    // SQLite database build method.
    public void SQLiteDataBaseBuild() {

        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    // SQLite table build method.
    public void SQLiteTableBuild() {

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME + "( " + SQLiteHelper.Table_Column_1_Name + " VARCHAR, " + SQLiteHelper.Table_Column_2_Email + " VARCHAR PRIMARY KEY , " + SQLiteHelper.Table_Column_3_Password + " VARCHAR);");

    }

    // Insert data into SQLite database method.
    public void InsertDataIntoSQLiteDatabase() {

        // If editText is not empty then this block will executed.
        if (EditTextEmptyHolder == false) {
// Printing toast message if any of EditText is empty.
            Toast.makeText(SignupActivity.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        } else if (PasswordMatches == false) {
            Toast.makeText(SignupActivity.this, "Password does not matches.", Toast.LENGTH_LONG).show();

        } else if (EmailPattren == false) {
            Toast.makeText(SignupActivity.this, "Please Enter Valid Email.", Toast.LENGTH_LONG).show();
        } else {


            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO " + SQLiteHelper.TABLE_NAME + " (name,email,password) VALUES('" + NameHolder + "', '" + EmailHolder + "', '" + PasswordHolder + "');";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();
            getSharedPreferences("Quiz_ref", MODE_PRIVATE).edit()
                    .putString("user", "true").commit();
            // Printing toast message after done inserting.
            Toast.makeText(SignupActivity.this, "User Registered Successfully", Toast.LENGTH_LONG).show();


            startActivity(new Intent(SignupActivity.this, CategoryActivity.class));
            finish();

        }

    }

    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert() {

        binding.nameEditText.getText().clear();

        binding.emailEditText.getText().clear();

        binding.passwordEditText.getText().clear();

        binding.confirmPasswordEditText.getText().clear();

    }

    // Method to check EditText is empty or Not.
    public void CheckEditTextStatus() {

        // Getting value from All EditText and storing into String Variables.
        NameHolder = binding.passwordEditText.getText().toString();
        EmailHolder = binding.emailEditText.getText().toString();
        PasswordHolder = binding.passwordEditText.getText().toString();

        if (TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(binding.confirmPasswordEditText.getText().toString())) {

            EditTextEmptyHolder = false;

        } else {
            EditTextEmptyHolder = true;
        }
    }

    public void CheckPasswordMatches() {

        // Getting value from All EditText and storing into String Variables.

        PasswordHolder = binding.passwordEditText.getText().toString();

        if (!PasswordHolder.equals(binding.confirmPasswordEditText.getText().toString())) {

            PasswordMatches = false;

        } else {

            PasswordMatches = true;
        }
    }

    public void CheckEmaiPattren() {

        // Getting value from All EditText and storing into String Variables.

        EmailHolder = binding.emailEditText.getText().toString();

        if (!EmailHolder.matches(emailPattern)) {

            EmailPattren = false;

        } else {

            EmailPattren = true;
        }
    }

    // Checking Email is already exists or not.
    public void CheckingEmailAlreadyExistsOrNot() {

        // Opening SQLite database write permission.
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

        while (cursor.moveToNext()) {

            if (cursor.isFirst()) {

                cursor.moveToFirst();

                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Email Found";

                // Closing cursor.
                cursor.close();
            }
        }

        // Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();

    }


    // Checking result
    public void CheckFinalResult() {

        // Checking whether email is already exists or not.
        if (F_Result.equalsIgnoreCase("Email Found")) {

            // If email is exists then toast msg will display.
            Toast.makeText(SignupActivity.this, "Email Already Exists", Toast.LENGTH_LONG).show();

        } else {

            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();

        }

        F_Result = "Not_Found";

    }


}