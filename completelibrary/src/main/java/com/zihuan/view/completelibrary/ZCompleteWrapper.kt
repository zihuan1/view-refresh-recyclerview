package com.zihuan.view.completelibrary

import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.zihuan.view.crvlibrary.BaseRecyclerWrapper

class ZCompleteWrapper(private val recyclerView: RecyclerView, private val refreshLayout: SmartRefreshLayout) : BaseRecyclerWrapper<ZCompleteBuilder>() {

    override fun createBuilder(adapter: RecyclerView.Adapter<*>, type: Int): ZCompleteBuilder {
        return ZCompleteBuilder(recyclerView, adapter, type, refreshLayout)
    }
}