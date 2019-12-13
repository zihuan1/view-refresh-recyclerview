package com.zihuan.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.zihuan.view.crvlibrary.ZEmptyView
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        var list = ArrayList<String>()

        re_view3.buildVerticalLayout(ReAdapter(this)).setData(list)
        var manager = re_view3.getRealBuilder()
        manager.setLoadListener(object : OnRefreshLoadMoreListener {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                list.clear()
                manager.setData(list)
                manager.loadOrPullComplete()
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                (0..100).forEach {
                    list.add("$it")
                }
                manager.setData(list)
                manager.loadOrPullComplete()
            }
        }).setRecyclerViewLayoutParam(height = -2)
    }
}
