package com.jkp.pandb;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements Runnable{

    private String TAG = "MainActivity";

    private TextView result, jsonResult;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Thread th = new Thread(MainActivity.this);
        th.start();

    }//onCreate ens

    Handler handler = new Handler(){
        // Alt + Enter -> Override Methods
        // 백그라운드 스레드에서 전달된 메시지를 처리하는 method
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            jsonResult.setText( str );
        }
    };

    private void init() {
        result = (TextView) findViewById(R.id.headerText);
        jsonResult = (TextView) findViewById(R.id.jsonResult);
    }//init end

    @Override
    public void run() {
        // http://192.168.0.127:8080/
        Log.i(TAG, "run: runing ");
        str = download();
        handler.sendEmptyMessage(0); // sendEmptyMessage( 핸들러에게 전달할 메시지 )
        //jsonResult.setText( str );
    }


    String download(){
        StringBuffer sb = new StringBuffer();
        try{

            // 호출할 spring 서버측 주소 입력(URL주소 형태로 객체화)
            URL url = new URL("http://172.30.9.91:80/ajax/main");
            Log.i(TAG, "download URL "+url);
            // url에 접속 객체 가져오기
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();

            if ( conn != null ){
                // 연결 timeout 시간 설정(밀리세컨드 단위) : 지정된 시간 이후 연결 종료
                conn.setConnectTimeout(10000);
                // 캐시 사용 여부 설정
                conn.setUseCaches(false);

                Log.i(TAG, "download: 성공 1");
                // http status code 상태코드, 200 - success
                Log.i(TAG, "download: "+conn.getResponseCode());
                if ( conn.getResponseCode() == 200 ){
                    // conn.getInputStream() : InputStream을 리턴받음
                    Log.i(TAG, "download: 성공 2");
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
                    for(;;){ // 무한 반복
                        String line = br.readLine(); // 한줄 읽기
                        if(line == null) break; // 더이상 내용이 없으면 루프 종료
                        sb.append(line+"\n");
                        Log.i(TAG, "download: 성공 3");
                    }
                    br.close(); // 버퍼 닫기
                }
                conn.disconnect(); // 연결 종료
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        // 가져와 append한 내용을 리턴
        return sb.toString();
    }


}//MainActivity end
