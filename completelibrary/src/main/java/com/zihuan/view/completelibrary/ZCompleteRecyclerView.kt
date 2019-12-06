package com.zihuan.view.completelibrary

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.zihuan.demo.ZCompleteBuilder
import com.zihuan.demo.ZCompleteWrapper
import com.zihuan.view.crvlibrary.ZBaseCleverRecycler

/**
 * RecyclerView 模版类
 * @author Zihuan
 */
class ZCompleteRecyclerView : ZBaseCleverRecycler<ZCompleteBuilder, ZCompleteWrapper> {


    private lateinit var refreshLayout: SmartRefreshLayout

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun createView(): RecyclerView {
        refreshLayout = SmartRefreshLayout(context)
        var recyclerView = RecyclerView(context)
        refreshLayout.addView(recyclerView)
        addView(refreshLayout)
        return recyclerView
    }

    override fun createWrapper(recyclerView: RecyclerView) = ZCompleteWrapper(recyclerView, refreshLayout)

    fun getRealBuilder() = getBuilder()

}
