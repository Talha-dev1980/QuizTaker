package com.quiztaker.Views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.quiztaker.R;

public class Splash extends AppCompatActivity {

    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        user = getSharedPreferences("Quiz_ref", MODE_PRIVATE).getString("user", "");

        Log.e("getSharedPreferences", "" + user);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (user.equals("true")) {
                    startActivity(new Intent(Splash.this, CategoryActivity.class));
                } else {
                    startActivity(new Intent(Splash.this, SignupActivity.class));
                }
                finish();


//                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//
//                    FirebaseFirestore.getInstance()
//                            .collection("users")
//                            .document(FirebaseAuth.getInstance().getCurrentUser().getUid())
//                            .get()
//                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    if (documentSnapshot != null) {
//                                        userModel = documentSnapshot.toObject(UserModel.class);
//                                        if (userModel.isVerification()) {
//                                            startActivity(new Intent(Splash.this, UserMainActivity.class));
//                                            finish();
//                                        } else {
//                                            FirebaseAuth.getInstance().signOut();
//                                            startActivity(new Intent(Splash.this, UserTypeActivity.class));
//                                            finish();
//                                            Toast.makeText(Splash.this, "Admin remove Verification. Please contact admin ", Toast.LENGTH_SHORT).show();
//                                        }
//
//                                    }
//                                }
//                            });
//
//
//                }
//                else if (admin.equals("admin")) {
//                    startActivity(new Intent(Splash.this, AdminMainActivity.class));
//                    finish();
//
//                }
//                else {
//                    startActivity(new Intent(Splash.this, UserTypeActivity.class));
//                    finish();
//                }

            }
        }, 2500);

    }
}