package com.inwooshin.fixed_habit

class MainData(icRun: Int, title : String, time: String, week : String) {
    //imageView 는 int 값이다.
    private var iv_profile = icRun
    private var tv_title = title
    private var tv_name: String? = time
    private var tv_content : kotlin.String? = week

    fun getIv_profile(): Int {
        return iv_profile
    }

    fun setIv_profile(iv_profile: Int) {
        this.iv_profile = iv_profile
    }

    fun getTv_title(): String {
        return tv_title
    }

    fun setTv_title(tv_title: String) {
        this.tv_title = tv_title
    }

    fun getTv_name(): String? {
        return tv_name
    }

    fun setTv_name(tv_name: String?) {
        this.tv_name = tv_name
    }

    fun getTv_content(): String? {
        return tv_content
    }

    fun setTv_content(tv_content: String) {
        this.tv_content = tv_content
    }

}
