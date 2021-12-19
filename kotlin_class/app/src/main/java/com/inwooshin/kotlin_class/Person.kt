package com.inwooshin.kotlin_class

import android.util.Log

class Person (val value : String){ //val 쓰면 클래스내에서 다 사용간으
    //class Person(val value : String) 이런식으로 생성자 만드는 것이
    //프라이머리 생성자이다.

    var name = ""

    //프라이머리 방식을 사용하면 생성자가 호출되면서 init 블록 안의 코드가 자동으로 실행
    //세컨더리 방식은 init -> constructor 실행
    init{ //초기화가 필요할 경우에 작성해줘야하는 부분
        Log.d("person","person 생성")
    }

    /*
    constructor(value: String){ //이게 세컨더리 생성자이다.
        Log.d("person","person의 이름은 ${value} 이다 ")
    }
     */
    
    fun process(){
        Log.d("person","process 수행") // 요 로그도 오브젝트여서 사용가능
    }

    companion object { //일반 클래스에서 오브젝트를 사용하기 위함!
        var name : String = "None"
        fun printName(){
            Log.d("person", "Person 의 이름은 $name")
        }
    }


}