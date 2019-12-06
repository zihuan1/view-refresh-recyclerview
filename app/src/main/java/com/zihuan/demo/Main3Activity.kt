package com.zihuan.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var list = ArrayList<String>()
        (0..100).forEach {
            list.add("$it")
        }
        re_view3.buildVerticalLayout(ReAdapter(this))
            .setData(list)
        var manager = re_view3.getRealBuilder()
        manager.setLoadListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                manager.loadOrPullComplete()
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                manager.loadOrPullComplete()
            }
        }).setRecyclerViewLayoutParam(height = -2)
    }
}
