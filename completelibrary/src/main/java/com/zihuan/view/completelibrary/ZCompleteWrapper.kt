package com.zihuan.demo

import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.zihuan.view.crvlibrary.ZBaseRecyclerWrapper

class ZCompleteWrapper(private val recyclerView: RecyclerView, private val refreshLayout: SmartRefreshLayout) : ZBaseRecyclerWrapper<ZCompleteBuilder>() {

    override fun createBuilder(adapter: RecyclerView.Adapter<*>, type: Int): ZCompleteBuilder {
        return ZCompleteBuilder(recyclerView, adapter, type, refreshLayout)
    }
}