package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubAcitivity extends AppCompatActivity {

    private Button btn_back;
    private TextView text_rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_acitivity);

        btn_back = findViewById(R.id.btn_back);
        text_rec = findViewById(R.id.text_rec);

        //어디선가 날라오는 데이터가 있을경우, 그것을 받겠다!
        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        text_rec.setText(str);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(SubAcitivity.this, MainActivity.class);

                startActivity(intentBack);
            }
        });
    }
}