package com.inwooshin.fixed_habit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_add_property.*

class AddPropertyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_property)

        add_habit_back.setOnClickListener {
            finish()
        }

        add_habit_nextbtn.setOnClickListener{
            val intent = Intent(this, AddPropertyFrequency::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right)
            finish()

        }

        // 카테고리 스피너 값 설정하기
        var category_data = listOf<String>("선택하세요", "운동", "공부", "휴식", "취미 생활", "만남", "기타")
        var frequency_data = listOf<String>("하루 기준입니다.")
        //어댑터를 설정해서 값을 넣어줘야함 스피너도 리사이클러뷰와 같은 뷰여서!
        //  var adapter = ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, category_data)

        var adapter =  ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, category_data)
        add_habit_spinner_category.adapter = adapter

        //카테고리 스피너 눌렀을 경우


        add_habit_spinner_category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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