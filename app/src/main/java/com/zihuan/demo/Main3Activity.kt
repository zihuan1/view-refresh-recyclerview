package com.zihuan.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zihuan.view.refreshlibrary.SimpleRefreshListener
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var list = ArrayList<String>()
        (0..10).forEach {
            list.add("$it")
        }
        re_view3.buildVerticalLayout(ReAdapter(this)).setData(list)
        var manager = re_view3.getBuilder()
        manager.getRefreshLayout().isNestedScrollingEnabled = true
        manager.setLoadingEnabled(true)
        manager.getRecyclerView().isNestedScrollingEnabled = true
//        扩展监听
        manager.setLoadListener(object : SimpleRefreshListener() {
            override fun onFusion(isRefresh: Boolean) {
                Log.e("刷新/加载", "完成$isRefresh")
                if (isRefresh) {
                    list.clear()
                    (0..10).forEach {
                        list.add("$it")
                    }
                    manager.setData(list)
                    Log.e("刷新", "完成"+list.size)
                } else {
//                    list.clear()
                    (0..10).forEach {
                        list.add("$it")
                    }
                    manager.setData(list)
                }
            }
        })
    }
}
