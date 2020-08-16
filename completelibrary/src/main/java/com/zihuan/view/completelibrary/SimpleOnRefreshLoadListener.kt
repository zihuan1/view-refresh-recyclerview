package com.zihuan.view.completelibrary

import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener

/**
 * 刷新加载完成扩展
 */
open class SimpleOnRefreshLoadListener : OnRefreshLoadMoreListener {

    /**
     * 加载监听
     */
    override fun onLoadMore(refreshLayout: RefreshLayout) {
        onFusion(false)
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        onFusion()
    }

    /**
     * 刷新加载合并的方法通过isRefresh判断是刷新还是加载
     *@param isRefresh 是否是刷新
     */
    open fun onFusion(isRefresh: Boolean = true) {
    }
}