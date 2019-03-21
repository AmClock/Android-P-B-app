package com.jkp.pandb;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }//onCreate ens

    private void init(){
        result = (TextView)findViewById(R.id.headerText);
    }//init end

}//MainActivity end
