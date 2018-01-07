package com.example.virajjoshi.bookmypandit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_navigation_header extends AppCompatActivity {


    private TextView EmailStatus, SigninStatus;

     FirebaseAuth fbAuth;
     FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_header);

        EmailStatus = (TextView) findViewById(R.id.emailStatus);
        SigninStatus = (TextView) findViewById(R.id.signinStatus);

        fbAuth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if(user!=null){
                    EmailStatus.setText(user.getEmail());
                    SigninStatus.setText("Sign In");
                }
                else
                {
                    EmailStatus.setText("");
                    SigninStatus.setText("Sign Out");
                }
            }
        };
    }
}

