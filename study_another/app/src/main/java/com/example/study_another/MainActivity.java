package com.example.study_another;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_id, et_pw;
    Button btn_test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id); //앞에 있던 edit text id 꺼와 연결이 된 것이다!
        et_pw = findViewById(R.id.et_pw); //앞에 있던 edit text id 꺼와 연결이 된 것이다!

        btn_test = findViewById(R.id.btn_test);

        //버튼을 클릭했을때 id 에 글씨를 써줘라!
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_id.setText("신인우");
                et_pw.setText("신인우");
            }
        });
    }
}