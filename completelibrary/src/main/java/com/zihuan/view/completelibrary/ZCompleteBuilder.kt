package com.zihuan.demo

import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.zihuan.view.crvlibrary.ZBaseRecyclerBuilder

class ZCompleteBuilder(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>, type: Int
                       , private val refreshLayout: SmartRefreshLayout
) : ZBaseRecyclerBuilder(adapter, type, recyclerView) {

    /**
     * RecyclerView设置布局参数
     */
    fun setRecyclerViewLayoutParam(width: Int = FrameLayout.LayoutParams.MATCH_PARENT, height: Int = FrameLayout.LayoutParams.WRAP_CONTENT) = apply {
        getRecyclerView().layoutParams = FrameLayout.LayoutParams(width, height)
    }

    /**
     * RefreshLayout设置布局参数
     */
    fun setRefrshLayoutParam(width: Int = FrameLayout.LayoutParams.MATCH_PARENT, height: Int = FrameLayout.LayoutParams.MATCH_PARENT) = apply {
        refreshLayout.layoutParams = FrameLayout.LayoutParams(width, height)
    }

    //设置刷新
    fun setPullEnabled(boolean: Boolean = true) = apply {
        refreshLayout.setEnableRefresh(boolean)
    }

    //    设置加载
    fun setLoadingEnabled(boolean: Boolean = true) = apply {
        refreshLayout.setEnableLoadMore(boolean)
    }

    fun setLoadListener(listener: OnRefreshLoadMoreListener) = apply {
        setPullEnabled(true)
        refreshLayout.setOnRefreshLoadMoreListener(listener)
    }

    //加载或者是刷新完成
    fun loadOrPullComplete() = apply {
        refreshLayout.finishRefresh()
        refreshLayout.finishLoadMore()
    }
}