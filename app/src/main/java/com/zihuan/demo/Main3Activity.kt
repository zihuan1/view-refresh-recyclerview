package com.zihuan.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zihuan.view.completelibrary.SimpleOnRefreshLoadListener
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var list = ArrayList<String>()

        re_view3.buildVerticalLayout(ReAdapter(this)).setData(list)
        var manager = re_view3.getRealBuilder()
//        原监听
//        manager.setLoadListener(object : OnRefreshLoadMoreListener {
//            override fun onLoadMore(refreshLayout: RefreshLayout) {
//                list.clear()
//                manager.setData(list)
//                manager.loadOrPullComplete()
//            }
//
//            override fun onRefresh(refreshLayout: RefreshLayout) {
//                (0..100).forEach {
//                    list.add("$it")
//                }
//                manager.setData(list)
//                manager.loadOrPullComplete()
//            }
//        }).setRecyclerViewLayoutParam(height = -2)
//        扩展监听
        manager.setLoadListener(object : SimpleOnRefreshLoadListener() {
//            override fun onLoadMore(refreshLayout: RefreshLayout) {
//                list.clear()
//                manager.setData(list)
//                Log.e("加载", "完成")
//            }
//
//            override fun onRefresh(refreshLayout: RefreshLayout) {
//                (0..100).forEach {
//                    list.add("$it")
//                }
//                manager.setData(list)
//                Log.e("刷新", "完成")
//            }

            override fun onFusion(isRefresh: Boolean) {
                Log.e("刷新/加载", "完成$isRefresh")
                if (isRefresh) {
                    (0..100).forEach {
                        list.add("$it")
                    }
                    manager.setData(list)
//                    Log.e("刷新", "完成")
                } else {
                    list.clear()
                    manager.setData(list)
                }
            }
        })
    }
}
