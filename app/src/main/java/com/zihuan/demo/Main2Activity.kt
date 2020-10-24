package com.zihuan.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zihuan.view.crvlibrary.BaseRecyclerBuilder
import com.zihuan.view.crvlibrary.RecyclerViewWrapper
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        bt_click2.setOnClickListener {
            startActivity(Intent(this, Main3Activity::class.java))
        }
        var list = ArrayList<String>()
        (0..100).forEach {
            list.add("$it")
        }
        var builder =  RecyclerViewWrapper<BaseRecyclerBuilder>(re_view2)
        builder.buildVerticalLayout(ReAdapter(this)).setData(list)
    }
}
