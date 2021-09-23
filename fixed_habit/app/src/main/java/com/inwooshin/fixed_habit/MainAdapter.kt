package com.inwooshin.fixed_habit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainAdapter(arrayList: ArrayList<MainData>?) :
    RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {
    //리스트 뷰의 아이템들을 담을 배열을 선언해준 부분이다.
    private val arrayList: ArrayList<MainData>?

    //리스트뷰가 처음으로 생성이 될떄 동작
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.dynamic_add_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        //실제 추가될때!
        holder.iv_profile.setImageResource(arrayList!![position].getIv_profile())
        holder.tv_title.setText(arrayList[position].getTv_title())
        holder.tv_time.setText(arrayList[position].getTv_name())
        holder.tv_content.setText(arrayList[position].getTv_content())
        holder.itemView.tag = position
        holder.itemView.setOnClickListener { v -> //object 형태를 string 형태로 벼환해서 받음
            val curName = holder.tv_title.text.toString()
            var stateMessage : String = holder.tv_title.text.toString() + "를 " + holder.tv_time.text.toString() + "에 수행할 예정입니다."
            Toast.makeText(v.context, stateMessage, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnLongClickListener {
            remove(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int {
        return arrayList?.size ?: 0
    }

    //길게 누르면 삭제할 수 있는 부분!
    fun remove(position: Int) {
        try {
            //리스트를 지운후에 새로고침을 해야 실제로 보여진다!
            arrayList!!.removeAt(position)
            notifyItemRemoved(position) //새로고침이라는 뜻이다.
        } catch (ex: IndexOutOfBoundsException) {
            ex.printStackTrace() //예외 상황이 벌어졌을때 강제 실행
        }
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView
        var tv_title: TextView
        var tv_time: TextView
        var tv_content: TextView

        init {
            iv_profile = itemView.findViewById<View>(R.id.add_list_img) as ImageView
            tv_title = itemView.findViewById<View>(R.id.add_list_text) as TextView
            tv_time = itemView.findViewById<View>(R.id.add_list_time) as TextView
            tv_content = itemView.findViewById<View>(R.id.add_list_week) as TextView
        }
    }

    init {
        this.arrayList = arrayList
    }
}
