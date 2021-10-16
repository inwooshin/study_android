package com.inwooshin.fixed_habit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_property.*

class AddPropertyActivity : AppCompatActivity() {

    private var intentRecOk = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_property)

        add_habit_back.setOnClickListener{
            finish()
        }

        add_habit_nextbtn.setOnClickListener{
            //val intent = Intent(this, AddPropertyFrequency::class.java)
            //startActivity(intent)
            //overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right)
            val intent = Intent()
            intent.putExtra("name", add_habit_spinner_time.selectedItem.toString())
            intent.putExtra("time", add_habit_spinner_activity.selectedItem.toString())
            intent.putExtra("award", add_habit_spinner_award.selectedItem.toString())
            setResult(intentRecOk, intent)

            finish()
        }

        // 카테고리 스피너 값 설정하기
        val whatTime = listOf("직접 입력", "시간 설정")
        val whatActivity = listOf("운동", "공부", "휴식", "취미 생활", "만남", "기타")
        val whatAward = listOf("칭찬 일기 쓰기", "직접 입력")
        //어댑터를 설정해서 값을 넣어줘야함 스피너도 리사이클러뷰와 같은 뷰여서!
        //  var adapter = ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, category_data)

        val adapter_time =  ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, whatTime)
        add_habit_spinner_time.adapter = adapter_time

        val adapter_activity =  ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item, whatActivity)
        add_habit_spinner_activity.adapter = adapter_activity

        val adapter_award =  ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item, whatAward)
        add_habit_spinner_award.adapter = adapter_award

        //카테고리 스피너 눌렀을 경우

        add_habit_spinner_time.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var zero : Long = 0
                if(id == zero){
                    // 동적 생성하기! tv 랑 editText!
                    //tv 는 직접 입력이라고 해주면 됨, 그리고 밑에는 et 띄우기
                }

                //TODO("Not yet implemented")

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("Not yet implemented")
            }
        }

        add_habit_spinner_activity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //TODO("Not yet implemented")

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("Not yet implemented")
            }
        }

        add_habit_spinner_award.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //TODO("Not yet implemented")

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("Not yet implemented")
            }
        }


    }
}