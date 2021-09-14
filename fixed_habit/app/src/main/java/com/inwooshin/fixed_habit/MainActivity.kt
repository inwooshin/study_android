package com.inwooshin.fixed_habit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.active_main.*
import kotlinx.android.synthetic.main.fragment_calender.*


class MainActivity : AppCompatActivity() {

    lateinit var tab1:ToDoList
    lateinit var tab2:Calender
    lateinit var tab3:Diary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.active_main)

        tab1 = ToDoList()
        tab2 = Calender()
        tab3 = Diary()

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, tab1).commit()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
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
                //TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //TODO("Not yet implemented")
            }
        })

        tabLayout.getTabAt(0)?.setIcon(R.drawable.list)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.calender)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.diary)

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