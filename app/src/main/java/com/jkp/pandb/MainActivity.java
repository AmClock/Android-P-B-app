package com.jkp.pandb;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    private TextView result , jsonResult ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        // URL 설정.
        //String url = "http://172.30.9.74/ajax/main";

        // AsyncTask를 통해 HttpURLConnection 수행.
        //NetworkTask networkTask = new NetworkTask(url, null);
        //networkTask.execute();

        jsonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , DetailActivity.class);
                startActivity(intent);
            }
        });

    }//onCreate ens

    private void init(){
        result = (TextView)findViewById(R.id.headerText);
        jsonResult = (TextView)findViewById(R.id.jsonResult);
    }//init end


    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {

            this.url = url;
            this.values = values;

            Log.i(TAG, "NetworkTask: ");
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            jsonResult.setText(s);
        }
    }



}//MainActivity end
