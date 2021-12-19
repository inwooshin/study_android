package com.inwooshin.kotlin_class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

//class student(value : String) : person(value) {} 이렇게 전달해줄 수 있다.

//세컨더리 생성자를 사용하는 경우에는 괄호를 쓰지 않는다.
//싱속을 받을 때 클론을 사용해서 부모 클래스는 괄호를 사용해서 생성자를 호출해줘야한다.
class MainActivity : AppCompatActivity() {
    class wolf{
        lateinit var name : String
        init{
            name = "Lionel"
        }
        fun process(){
            name.plus(" messi")
            print("이름의 길이 ${name.length}")
            print("이름의 첫 글자 ${name[0]}")
        }
    }

    object Pig { // object 를 사용해서 클래스를 생성자로 인스턴스화하지 않아도
                // 사용할 수 있다.
        var name : String = "Pig"
        fun printName(){
            Log.d("person", "${name}")
        }
    }

    //데이터 클래스는 일반적으로, 데이터를 네트워크를 통해 주고받거나, 데이터를 다루기
    //위한 용도로 사용한다.
    data class data(val value : Int, var str : String) {
        //앞에서 함수나 클래스와는 다르게 매개변수에 var, val 을 사용해줘야한다.

        fun happy(){ //요런식으로 일반 클래스와 같게 생성해준다.
            Log.d("person", "djdjd")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ins = Person("Inwoo")

        ins.process()

        Pig.printName()
        Person.printName()

        // toString
        //일반 클래스 - 주소만 리턴한다.
        Log.d("person", "일반 클래스 toString : ${ins.toString()}")

        //data 클래스 - 값을 리턴한다.
        var a = data(30, "name")
        Log.d("person", "data 클래스 toString : ${a.toString()}")

        var dataValue = a.copy()
        Log.d("person", "복사한 값 : ${dataValue}")

        var variable : String? //이렇게하면 null 값을 넣을 수 있다.
        variable = null


        fun nullCheckLength(str : String?){
            //null 값을 허용해주었기 때문에 null 값인지 확인하는 과정을 거쳐야한다.
            /*
            if(str == null){
                return
            }
             */

            //여기서 문자열이 null 인지 확인하고 null 이면 null 리턴
            Log.d("person", "null 인지 체크하고 리턴 : ${str?.length} ")

            var getInt : Int = str?.length ?: 0

            Log.d("person", "문자열의 길이 : ${getInt}")

        }


        nullCheckLength(null)


        var nullCheck : String? = null
        var nullCheckLength = nullCheck?.length ?: 33
        Log.d("person", "${nullCheckLength}")

        var wolfInstance = wolf()

        wolfInstance.process()
    }
}