package com.zihuan.view.completelibrary

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.zihuan.view.crvlibrary.ZBaseCleverRecycler

/**
 * RecyclerView 模版类
 * @author Zihuan
 */
class ZCompleteRecyclerView : ZBaseCleverRecycler<ZCompleteBuilder, ZCompleteWrapper> {


    private lateinit var refreshLayout: SmartRefreshLayout

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun createView() = RecyclerView(context).apply {
        refreshLayout = SmartRefreshLayout(context)
//       由于SmartRefreshLayout只能添加一个view,要想在没数据的时候显示emptyView,就得再嵌套一层布局
        var recyclerParent = FrameLayout(context)
        recyclerParent.layoutParams = LayoutParams(-1, -1)
        recyclerParent.addView(this)
        refreshLayout.addView(recyclerParent)
        var a=1
        this@ZCompleteRecyclerView.addView(refreshLayout)
    }


    override fun createWrapper(recyclerView: RecyclerView) =
        ZCompleteWrapper(recyclerView, refreshLayout)

    fun getRealBuilder() = getBuilder()

}
