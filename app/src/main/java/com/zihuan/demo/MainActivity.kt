package com.zihuan.demo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.header.MaterialHeader
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.zihuan.baseadapter.ViewOnItemChildClick
import com.zihuan.baseadapter.ViewOnItemClick
import com.zihuan.baseadapter.ViewOnItemLongClick
import com.zihuan.view.crvlibrary.RecycleViewDivider
import com.zihuan.view.crvlibrary.initGrid
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewOnItemClick, ViewOnItemLongClick {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var builder = rv_view.buildVerticalLayout<ReAdapter>(this)
        val recyclerOperation = builder.getRecyclerOperation()
        recyclerOperation.setDivider(RecycleViewDivider(this, LinearLayoutManager.VERTICAL, 1, R.color.colorPrimaryDark))
        var list = ArrayList<String>()
        (0..100).forEach {
            list.add("$it")
        }
        rv_view.getBuilder().setData(list)
//        recyclerOperation.scrollToBottom()
        bt_click.setOnClickListener {
            startActivity(Intent(this, Main2Activity::class.java))
        }
        //adapter 2
//        val reAdapter = ReAdapter(this)
//        rv_view.buildVerticalLayout(reAdapter)
//        reAdapter.setOnItemClick { view, position ->
//
//        }
//        reAdapter.setOnChildClick(object : ViewOnItemChildClick {
//            override fun setOnChildClick(view: View?, position: Int) {
//
//            }
//
//            override fun setOnChildLongClick(view: View?, position: Int) {
//            }
//
//        }, R.id.tvTest)
    }

    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, _ -> MaterialHeader(context) }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ ->
            ClassicsFooter(context).setDrawableSize(20f)
        }
    }

    //点击
    override fun setOnItemClickListener(view: View?, position: Int) {
        Log.e("点击", "$position")
    }

    //长按
    override fun setOnItemLongClickListener(view: View?, position: Int) {
        Log.e("点击", "$position")
    }
}
