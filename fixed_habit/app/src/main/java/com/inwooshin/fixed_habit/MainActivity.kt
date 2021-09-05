package com.inwooshin.fixed_habit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_calender.*

class MainActivity : AppCompatActivity() {
    lateinit var tab1:ToDoList
    lateinit var tab2:Diary
    lateinit var tab3:Calender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab1 = ToDoList()
        tab2 = Diary()
        tab3 = Calender()

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, tab1).commit()

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        replaceView(tab1)
                    }
                    1 -> {
                        replaceView(tab2)
                    }
                    2 -> {
                        replaceView(tab3)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun replaceView(tab: Fragment) {
        var selectedFragment : Fragment? = null
        selectedFragment = tab
        selectedFragment?.let{
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, it).commit()
        }
    }
}