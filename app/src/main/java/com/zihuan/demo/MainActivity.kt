package com.zihuan.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var builder = rv_view.buildVerticalLayout(ReAdapter()).setWrapContent()
//        var list = ArrayList<String>()
//        (0..100).forEach {
//            list.add("$it")
//        }
//        rv_view.getBuilder().setData(list).scrollToBottom()
//        bt_click.setOnClickListener {
//            startActivity(Intent(this, Main2Activity::class.java))
//        }
    }
}
