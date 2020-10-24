package com.zihuan.view.refreshlibrary

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.zihuan.view.crvlibrary.BaseCleverRecycler
import com.zihuan.view.crvlibrary.RecyclerViewWrapper

/**
 * RecyclerView 模版类
 * @author Zihuan
 */
class RefreshRecyclerView : BaseCleverRecycler<RefreshBuilder> {

    private lateinit var refreshLayout: SmartRefreshLayout

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun createView() = RecyclerView(context).apply {
        refreshLayout = SmartRefreshLayout(context)
//       由于SmartRefreshLayout只能添加一个view,要想在没数据的时候显示emptyView,就得再嵌套一层布局
        var recyclerParent = FrameLayout(context)
        recyclerParent.layoutParams = LayoutParams(-1, -1)
        recyclerParent.addView(this)
        refreshLayout.addView(recyclerParent)
        this@RefreshRecyclerView.addView(refreshLayout)
    }


    override fun bindRecycler() = createView()

    override fun createBuilder(wrapper: RecyclerViewWrapper<RefreshBuilder>) {
        wrapper.createBuilder<RefreshBuilder>(refreshLayout)
    }
}
