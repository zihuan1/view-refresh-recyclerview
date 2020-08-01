package com.zihuan.view.completelibrary

import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import com.zihuan.view.crvlibrary.ZBaseRecyclerBuilder

class ZCompleteBuilder(
    recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>, type: Int
    , private val refreshLayout: SmartRefreshLayout
) : ZBaseRecyclerBuilder(adapter, type, recyclerView) {

    /**
     * RecyclerView设置布局参数
     */
    fun setRecyclerViewLayoutParam(
        width: Int = FrameLayout.LayoutParams.MATCH_PARENT,
        height: Int = FrameLayout.LayoutParams.WRAP_CONTENT
    ) = apply {
        getRecyclerView().layoutParams = FrameLayout.LayoutParams(width, height)
    }

    /**
     * RefreshLayout设置布局参数
     */
    fun setRefrshLayoutParam(
        width: Int = FrameLayout.LayoutParams.MATCH_PARENT,
        height: Int = FrameLayout.LayoutParams.MATCH_PARENT
    ) = apply {
        refreshLayout.layoutParams = FrameLayout.LayoutParams(width, height)
    }

    /**
     * 设置刷新
     */
    fun setPullEnabled(boolean: Boolean = true) = apply {
        refreshLayout.setEnableRefresh(boolean)
    }

    /**
     * 设置加载
     */
    fun setLoadingEnabled(boolean: Boolean = true) = apply {
        refreshLayout.setEnableLoadMore(boolean)
    }

    /**
     * 设置监听
     */
    fun setLoadListener(listener: OnRefreshLoadMoreListener) = apply {
        setPullEnabled(true)
        refreshLayout.setOnRefreshLoadMoreListener(listener)
    }

    /**
     * 设置监听
     */
    fun setLoadListener(listener: OnRefreshLoadListener) = apply {
        setPullEnabled(true)
        refreshLayout.setOnRefreshLoadMoreListener(listener)
    }


    /**
     * 显示刷新动画并且触发刷新事件
     */
    fun autoRefresh() = apply {
        refreshLayout.autoRefresh()
    }

    /**
     * 显示加载动画并且触发刷新事件
     */
    fun autoLoadMore() = apply {
        refreshLayout.autoLoadMore()
    }

    /**
     * 加载或者是刷新完成
     */
    fun loadOrPullComplete() = apply {
        refreshLayout.finishRefresh()
        refreshLayout.finishLoadMore()
    }

    /**
     * 获取刷新布局
     */
    fun getRefreshLayout() = refreshLayout

    /**
     * 覆盖父类方法,设置刷新自动设置刷新加载完成状态
     */
    override fun setData(list: ArrayList<*>): ZBaseRecyclerBuilder {
        super.setData(list)
        if (RefreshState.Refreshing == refreshLayout.state) {
            refreshLayout.finishRefresh()
        } else {
            refreshLayout.finishLoadMore()
        }
        return this
    }

    /**
     * 是否正在刷新
     */
    fun isRefreshing() = RefreshState.Refreshing == refreshLayout.state

    /**
     * 是否正在加载
     */
    fun isLoading() = RefreshState.Loading == refreshLayout.state
}