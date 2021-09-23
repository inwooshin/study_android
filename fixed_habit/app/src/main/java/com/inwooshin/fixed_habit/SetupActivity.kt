package com.inwooshin.fixed_habit

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TouchDelegate
import android.view.View
import kotlinx.android.synthetic.main.activity_setup.*

class SetupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)

        back_image.setOnClickListener {
            finish()
        }

        val delegateArea = Rect()
        delegateArea.right += 100
        delegateArea.left += 100

        (back_image.parent as? View)?.apply{
            touchDelegate = TouchDelegate(delegateArea, back_image)
        }
    }
}