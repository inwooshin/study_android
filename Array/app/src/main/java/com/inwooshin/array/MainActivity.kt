package com.inwooshin.array

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //이런식으로 배열을 선언한다!
        var arrInt = IntArray(10)
        var arrDouble = DoubleArray(10)
        var arrFloat = FloatArray(10)

        var StringArray = Array(10, {item->""})
        var dayArray = arrayOf("안녕하세요", "저는", "신인우라고", "합니다!")

        //배열의 인수를 변경하는 방법 메서드를 사용하거나 인덱스로 직접접근해서 바꾸는
        //방법 이렇게 있다!
        arrInt[0] = 30
        arrInt.set(1, 20)

        //배열을 꺼내는 방법
        arrInt[0]
        arrInt.get(1)

        var strThree = dayArray[3]

        Log.d("dayAlive","AreUHappy")

        // 콜렉션! dataType!
        var tired = mutableListOf("MON", "TUE", "WED")
        tired.add("THU") //인수를 추가할 때는 add 메서드를 사용한다
        tired.set(0, "FRI") //요런식으로 값을 수정할 수 있음!
        tired.removeAt(1) //1번째 인덱스를 제거해준다.

        var tireElement = tired.get(0)
        Log.d("tired Element", "$tireElement")

        //괄호의 정식명칭은 제네릭이다!
        var emptyList = mutableListOf<String>() //빈 리스트를 사용할 때에는 이렇게
                                                //이렇게 변수형을 설정해줘야한다
        emptyList.add("앙앙")
        Log.d("tired Element", "0 번째의 인덱스의 값은 ${emptyList.get(0)} 이다 사이즈는 ${emptyList.size}이다!")

        //Set
        var set = mutableSetOf("요런식으로 셋을 생성", "그런데 인덱스로", "호출이 안됨", "호출이 안됨")
        Log.d("set", "set 전체출력 : ${set}")

        var map = mutableMapOf<String, Int>()
        map.put("사과", 10)
        map.put("바나나", 10)
        map.put("키위", 5)

        map.remove("키위")

        Log.d("fruit", "사과는 ${map.get("사과")}, 키위는 ${map.get("키위")} 개입니다.") //이렇게 지운 것을 호출하면 null 없다! 가 뜬다


        //이뮤터블! 변화 불가능한 배열!
        val IMMUTABLE_LIST = listOf("사과", "바나나", "포도")
        Log.d("fruit", "${IMMUTABLE_LIST.get(1)}")


    }
}