//package com.zihuan.view.completelibrary
//
//import android.content.Context
//import android.util.AttributeSet
//import android.widget.FrameLayout
//import androidx.recyclerview.widget.RecyclerView
//import com.zihuan.view.crvlibrary.ZWrapRecyclerView
//
///**
// * RecyclerView 模版类
// * @author Zihuan
// */
//class ZCompleteRecyclerView : FrameLayout {
//
//    private lateinit var mZWrapRecyclerView: ZWrapRecyclerView
//
//    constructor(context: Context) : super(context) {
//        createView()
//    }
//
//    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
//        createView()
//    }
//
//    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
//        createView()
//    }
//
//    private fun createView() {
//        var recyclerView = RecyclerView(context)
//        addView(recyclerView)
//        mZWrapRecyclerView = ZWrapRecyclerView(recyclerView)
//    }
//
//    fun buildVerticalLayout(adapter: RecyclerView.Adapter<*>) = mZWrapRecyclerView.buildVerticalLayout(adapter)
//
//    fun buildHorizontalLayout(adapter: RecyclerView.Adapter<*>) = mZWrapRecyclerView.buildHorizontalLayout(adapter)
//
//    fun buildGridLayout(adapter: RecyclerView.Adapter<*>, type: Int) = mZWrapRecyclerView.buildGridLayout(adapter, type)
//
//    fun getRecyclerView() = mZWrapRecyclerView.getRecyclerView()
//
//    fun getBuilder() = mZWrapRecyclerView.getBuilder()
//
//}