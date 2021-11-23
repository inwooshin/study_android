package com.inwooshin.fixed_habit

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class ToDoList : Fragment() {
    private var arrayList: ArrayList<MainData>? = null
    private var mainAdapter: MainAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var intentOk = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_to_do_list, container, false)

        var setup = rootView.findViewById<ImageView>(R.id.setup_view)

        setup.setOnClickListener {
            val intent = Intent(activity, SetupActivity::class.java)
            startActivity(intent)
        }

        var addbtn = rootView.findViewById<FloatingActionButton>(R.id.addButton)

        recyclerView = rootView.findViewById<View>(R.id.add_list_rv) as RecyclerView
        linearLayoutManager = LinearLayoutManager(activity)
        recyclerView!!.layoutManager = linearLayoutManager

        arrayList = ArrayList<MainData>()

        mainAdapter = MainAdapter(arrayList)
        recyclerView!!.adapter = mainAdapter
        val lm = GridLayoutManager(activity, 2)
        recyclerView?.layoutManager = lm as RecyclerView.LayoutManager?

        addbtn.setOnClickListener {
            /*
            var mainData = MainData(R.drawable.ic_run,"달리기", "PM 7 : 30", "월, 수, 금")

            arrayList!!.add(mainData)
            mainAdapter!!.notifyDataSetChanged()
             */

            val intent = Intent(activity, AddPropertyActivity::class.java)
            startActivityForResult(intent, 100)
        }

        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == intentOk) {
            when (requestCode) {
                100 -> {

                    var mainData = MainData(R.drawable.ic_run,
                        data!!.getStringExtra("name").toString(), //습관 이름
                        data!!.getStringExtra("time").toString(), //습관 시간
                        data!!.getStringExtra("award").toString()) //보상

                    arrayList!!.add(mainData)
                    mainAdapter!!.notifyDataSetChanged()

                }
            }
        }
    }

}