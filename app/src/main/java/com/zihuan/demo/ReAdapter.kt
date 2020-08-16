package com.zihuan.demo

import android.content.Context
import android.util.Log
import com.zihuan.baseadapter.RecyclerAdapter
import com.zihuan.baseadapter.RecyclerViewHolder
import com.zihuan.view.crvlibrary.R
import com.zihuan.view.crvlibrary.RecyclerData

/**
 *
 * @Description
 * @author zihuan
 * @date 2019/12/4 11:06
 */
class ReAdapter(obj: Any) : RecyclerAdapter(obj), RecyclerData {
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