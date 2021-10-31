package com.inwooshin.mynavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    EditText et_id, et_pw;
    Button btn_login;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);
        btn_login = findViewById(R.id.btn_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        readUser();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUserName = et_id.getText().toString();
                String getUserPW = et_pw.getText().toString();

                writeNewUser("1", getUserName, getUserPW);

            }
        });

    }

    private void writeNewUser(String userId, String name, String pw){
        User user = new User(name, pw);


        //DatabaseReference 라는 자료형은 Query 를 상속받고 있다.
            //Query 는 특정한 데이터를 보여달라는 사용자의 요청을 의미
        //DatabaseReference 에서 child 는 현재 주소로 설정되어 있는 것에서
        //users 가 유효한 주소인지 확인하고, 현재 주소 경로에 붙여준 것을 리턴해준다.
        //그렇게 리턴해준 경로에 setValue 를 해주면 Object 로 받아서 각각의 값을 설정해준다.
        mDatabase.child("users").child(userId).setValue(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "저장을 완료했습티다.",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "저장을 실패했습니다.", Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void readUser(){
        //데이터베이스에서 users에 1 주소 덧붙인다.
        //여기서 1을 추가해준 리턴된 DatabaseReference 객체의
        //addValueEventListener 메서드를 호출한다.
        //onDataChange 메서드와 onCancelled 메서드를 설정해준다.
        mDatabase.child("users").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue(User.class) != null){
                    User post = dataSnapshot.getValue(User.class);
                    //Log.w 는 warining
                    Log.w("FireBaseData", "getData" + post.toString());
                } else {
                    Toast.makeText(MainActivity.this, "데이터 없음...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("FireBaseData", "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
}