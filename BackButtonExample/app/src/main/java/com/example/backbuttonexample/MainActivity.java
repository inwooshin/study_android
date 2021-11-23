package com.example.backbuttonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backBtnTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        long CurTime = System.currentTimeMillis();
        long gapTime = CurTime - backBtnTime;

        if(0 <= gapTime && 2000 >= gapTime){
            super.onBackPressed();//뒤로가기!
        } else {
            backBtnTime = CurTime;
            Toast.makeText(this, "한번더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }

    }
}