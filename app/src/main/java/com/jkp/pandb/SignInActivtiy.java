package com.jkp.pandb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivtiy extends AppCompatActivity {

    protected String TAG = "SignInActivtiy";


    Button login, signUp;
    EditText id, pwd;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        id = (EditText) findViewById(R.id.id);
        pwd = (EditText) findViewById(R.id.pwd);


        login = (Button) findViewById(R.id.login);
        signUp = (Button) findViewById(R.id.signUp);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(SignInActivtiy.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }//onCreate end

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i(TAG, "onKeyUp: "+keyCode +" :: " + event);
        return super.onKeyUp(keyCode, event);
    }
}//SignInActivity end
