package com.example.sharedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_save;
    private String shared = "file";

    @Override
    // 1. 일단 editText 변수를 만들고 가져온다
    // 2. editText 변수를 findViewById 로 연결해준다.
    // 3. sharedPreferences sharedPreferences 변수에
    //    getSharedPreferences(String 변수, mode : 0) 함수를 할당해준다.
    // 4. 그리고 editText.setText(value); 를 해서 value 를 editText에
//        출력한다!
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText)findViewById(R.id.et_save);

        //
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("Sin", "");
        et_save.setText(value);
    }

    @Override
    //여기서는 프로그램이 종료하게 될 경우에 수행할 함수를 말한다.
//     1. SharedPreferences sharedPreferences = getSharedPreferences(shared, mode : 0);
//        위와 같이 해서 sharedPreferences String 변수를 연결시켜준다.
//     2. SharedPreferences.Editor 변수를 사용해서 editor 를 만드는데
//        이 변수는 sharedPreferences.edit() 이라는 메서드를 통해서 만들어줄 수 있다.
//     3. String 변수를 사용해서 EditText 변수의 값을 getText().toString() 메서드로
//        읽어온다.
//     4. 가져온 value 의 값을 통해서 editor 에 putString 을 해서 "Sin"
//        이라는 이름을 가진 String 을 저장해준다.
//     5. 그리고 commit은 editor 의 svae 를 완료하라는 것이다!
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        //저장할때는 항상 editor 를 불러와서 저장해줘야한다.
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String value = et_save.getText().toString();

        //Sin 이라는 이름으로 밸류에 저장하는 것이다!
        editor.putString("Sin",value);

        //save 를 완료해라 라는 부분이다.
        editor.commit();
    }
}