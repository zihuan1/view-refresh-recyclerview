package com.zihuan.demo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zihuan.baseadapter.RecyclerAdapter
import com.zihuan.baseadapter.RecyclerViewHolder
import com.zihuan.view.crvlibrary.R
import com.zihuan.view.crvlibrary.ZRecyclerData

/**
 *
 * @Description
 * @author zihuan
 * @date 2019/12/4 11:06
 */
class ReAdapter(obj: Any) : RecyclerAdapter(obj), ZRecyclerData {
    var mList = ArrayList<String>()

    override fun getLayoutResId() = R.layout.layout

    override fun convert(holder: RecyclerViewHolder?, position: Int, context: Context?) {
    }


    override fun getItemCount() = mList.size

    override fun update(data: List<*>) {
        mList.addAll(data as ArrayList<String>)
        Log.e("刷新", "刷新数据")
        notifyDataSetChanged()
    }
}