package com.zihuan.view.completelibrary

import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.zihuan.view.crvlibrary.BaseRecyclerWrapper

class RefreshWrapper(private val recyclerView: RecyclerView, private val refreshLayout: SmartRefreshLayout) : BaseRecyclerWrapper<RefreshBuilder>() {

    override fun createBuilder(adapter: RecyclerView.Adapter<*>, type: Int): RefreshBuilder {
        return RefreshBuilder(recyclerView, adapter, type, refreshLayout)
    }
}