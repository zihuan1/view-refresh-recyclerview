package com.zihuan.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var list = ArrayList<String>()
        (0..100).forEach {
            list.add("$it")
        }
//        var builder = ZWrapRecyclerView(re_view2)
//        builder.buildVerticalLayout(ReAdapter()).setData(list)
//        builder.getBuilder()
    }
}
