package com.example.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        List<String> data = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        list.setAdapter(adapter);


        /*
        list = findViewById(R.id.list);

        //배열 안에 String 형태로 list 를 넣겠다는 의미이다.
        List<String> data = new ArrayList<>();

        //콘센트 어댑터같이 arrayadapter 를 선언해준다.
        //어댑터는 new ArrayAdapter 현재 우리의 액티비티에 해당이 된다.

        //이 메인 페이지와 중간다리 역할을 하는 어댑터가 선언이 되고 list 와 메인이 연결된다
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);

        //listView 에다가 다리 역할을 하는 애를 세팅을 해줘야한다.
        list.setAdapter(adapter); // 실질적으로 세팅하는것!

        //연결은 완료가 되었음. 이제 아이템을 추가해야됨

        data.add("와이파이 연결");
        data.add("설정");
        data.add("디스플레이");
        data.add("애플리케이션");
        data.add("유용한 기능");
        data.add("계정 및 백업");
        data.add("배터리 및 디바이스");
        data.add("일반");
        data.add("접근성");
        data.add("소프트웨어 업데이트");
        data.add("휴대전화 정보");

        adapter.notifyDataSetChanged(); //이 상태를 저장을 해주는 것이다.

         */
    }
}