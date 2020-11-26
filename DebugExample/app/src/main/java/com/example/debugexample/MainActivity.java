package com.example.debugexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String hong = "홍드로이드";

        //로그가 실행이될때 출력이 되어라! 라는 의미이다.
        //e 메서드는 에러로 출력된다!
        //로그는 이런식으로 찍으면 된다!
        Log.e("MainActivity : ", hong);

        int d = 10;
        Log.e("MainActivity : ", String.valueOf(d));


    }
}