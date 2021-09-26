package com.inwooshin.fixed_habit

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_add_property_aword.*


class AddPropertyAword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_property_aword)

        add_habit_aword_back.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            builder.setMessage("작성 중인 정보가 있습니다. 정말로 나가시겠습니까?")

            // 버튼 클릭시에 무슨 작업을 할 것인가!
            var listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE ->
                            finish()

                    }
                }
            }

            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", listener)

            builder.show()


        }

        add_habit_aword_nextbtn.setOnClickListener {
            finish()
        }
    }

}