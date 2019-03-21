package com.jkp.pandb;

import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;


public class TitleActivity extends AppCompatActivity {

    protected String TAG = "TitleActivity";

    Button singIn, singUp;
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        workSplash();
        init();

        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(TitleActivity.this, SignInActivtiy.class);
                startActivity(intent);
            }
        });//signIn end

        singUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(TitleActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });//signUp end

    }//onCreate end

    public void workSplash() {
        final ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                layout.setVisibility(View.GONE);
            }
        }, 1500);
    }//workSplash end

    private void init(){
        singIn = (Button) findViewById(R.id.signInBtn);
        singUp = (Button) findViewById(R.id.signUpBtn);
    }//init end


}// TitleActivity end
