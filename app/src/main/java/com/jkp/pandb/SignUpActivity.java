package com.jkp.pandb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SignUpActivity extends AppCompatActivity {

    private String TAG = "SignUpActivity";

    private EditText nameTxt, idTxt, pwdTxt, dateTxt;
    private RadioGroup genderGroup;
    private Button successBtn;
    private String gender = null;

    private Intent intent = null;

    private TextView backBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.man:
                        gender = "M";
                        break;
                    case R.id.woman:
                        gender = "W";
                        break;
                    default:
                        gender = null;
                        break;
                }
            }
        });

        successBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    intent = gender != null ? new Intent(SignUpActivity.this, SignInActivtiy.class) : null;
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }//try catch end
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(SignUpActivity.this , TitleActivity.class);
                startActivity(intent);
            }
        });

    }//onCreate end

    private void init(){
        genderGroup = (RadioGroup) findViewById(R.id.gender);
        nameTxt = (EditText) findViewById(R.id.name);
        dateTxt = (EditText) findViewById(R.id.date);
        dateTxt.setHint(getDateString());
        successBtn = (Button) findViewById(R.id.successBtn);
        backBtn = (TextView)findViewById(R.id.backBtn);
    }//init end

    public String getDateString() {
        return "Your Birthday Ex" + new SimpleDateFormat(") yyyyMMdd", Locale.KOREA).format(new Date());
    }//getDateString end

}//SignUpActivity
