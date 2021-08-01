# Study Android

## 목차   
 - [TextView](#TextView)
 - [EditText](#edittext)
 - [intent](#intent)   
 - [Image View](#image-view)
   
## TextView   
 - TextView 는 말그대로 Hello world 와 같이 문자를 넣어주는 것을 이야기한다.
 - TextColor 같은 경우에는 #ffffff 와 같은 #R,G,B를 16진수로 표현해주는 방법을 사용한다. 여기서 #ffffff 라고 설정하면 android studio 옆에 색상을 선택해줄 수 있는 창이 나온다. 그것으로 설정해주면 된다.

html
~~~html
<!-- 위의 옵션을 vertical 로 설정해주면 세로로 순서대로 출력하는 것을 볼 수 있다.-->

<TextView 
    android:layout_width="width_parent"    android:layout_height="wrap_content"
    android:text="적어줄 텍스트"
    android:textSize="20sp"
    android:textColor="#ffffff"
~~~   
   
[목차로 돌아가기](#목차)
   
## EditText   
 - 문자를 넣을 수 있는 Text 창을 EditText 라고 한다.
 - 여기에서 넣은 정보를 id를 주고 넣어준 값을 활용할 수 있다.
 - hint 는 id를 입력하세요 이런식으로 나오는 실질적으로 글을 입력하면 사라지는 문자열을 설정하는 부분이다.   
   
1. html
~~~html
<EditText
    android:id="@+id/et_id"
    android:layout_width="300dp"
    android:layout_height="wrap_content" 
    hint="아이디를 입력하세요"
    android:text="empty"
    
    />

<Button
    android:id="@+id/btn_login"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="버튼"
    />

~~~   
  2. java
~~~java
public class Main extends AppCompatActivity{

    EditText et_id;
    Button btn_test;
        //alt+Enter 로 import 해준다.

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.id.activity_main);

        et_id = findViewById(R.id.et_id);
        btn_test = findViewById(R.id.btn_test);

        btn_test.setOnClickListner(new View.OnClickListner()){
            @Override
            public void onClick(View v){
                et_id.setText("초기 입력");
            }
        }

    }


}
~~~
   
[목차로 돌아가기](#목차)   
   
## Intent   
 - intent 객체는 다른 화면으로 넘어갈 수 있도록 의사를 전달하는 것을 말한다.

1. java(Main)
~~~java
public class MainActivity extends AppCompatActivity {

    private EditText et_text;
    private Button btn_send;
    String str = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_text = findViewById(R.id.et_text);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SubAcitivity.class);

                str = et_text.getText().toString();
                intent.putExtra("str", str);

                startActivity(intent);
            }
        });
    }
}
~~~   
2. java(Sub)
~~~java
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
        //보내준 String 과 같은 이름의 문자열의 내용을 받아옴
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
~~~
   
[목차로 돌아가기](#목차)   
   
## Image View   
 - 이미지를 띄울 수 있게 한다. 위치를 설정할 수 있고, 또한 클릭했을 경우 동작을 id 로 설정할 수 있다.
   
1. html   
~~~html
<ImageView
            android:id="@+id/img_test"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/ic_launcher" />

~~~   
2. java   
~~~java
public class MainActivity extends AppCompatActivity {

    private ImageView img_test;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_test = findViewById(R.id.img_test);

        img_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Toast.makeText(getApplicationContext(), i + "번 클릭하셨습니다!",Toast.LENGTH_SHORT);
            }
        });
    }
}
~~~
   
[목차로 돌아가기](#목차)   
   
## list
 - 목록을 쭈루룩 만들어서 각각 제어할 수 있도록 한것이다!
 - 리스트는 ListView 와 data 를 연결해주는 adapter 는 다리의 역할을 하는 것이다.

1. html
~~~html
<ListView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/list"
    />
~~~
   
2. java   
~~~java
public class MainActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
~~~   
   
[목차로 돌아가기](#목차)   
   
## Navigation Menu   
 - 
