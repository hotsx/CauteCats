package com.hotsx.cat.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mu.KotlinLogging

val logger = KotlinLogging.logger("RecyclerAdapter")

abstract class RecyclerAdapter<T>(
    @LayoutRes val layoutId: Int,
    var dataList: MutableList<T> = ArrayList()
) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                layoutId, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        convert(holder, dataList[position], position)
    }

    abstract fun convert(holder: RecyclerViewHolder, item: T, position: Int)

    fun addItem(item: T) {
        dataList.add(item)
        notifyItemInserted(dataList.size)
    }
}

class AdapterConfig<T> {

    var dataList: MutableList<T>? = null
    var mOnItemClick: ((View, T, Int) -> Unit)? = null
    var mOnItemLongClick: ((View, T, Int) -> Unit)? = null
    var layoutManger: RecyclerView.LayoutManager? = null

    fun withItems(items: MutableList<T>) {
        dataList = items
    }

    fun onItemClick(onItemClick: (view: View, T, Int) -> Unit) {
        mOnItemClick = onItemClick
    }

    fun onItemLongClick(onItemLongClick: (view: View, T, Int) -> Unit) {
        mOnItemLongClick = onItemLongClick
    }
}

fun <T> RecyclerView.deployAdapter(
    @LayoutRes layoutId: Int, variableId: Int,
    config: (AdapterConfig<T>.() -> Unit)? = null
): RecyclerAdapter<T> {
    val adapterConfig = if (config != null) AdapterConfig<T>().apply(config) else AdapterConfig()
    val recyclerAdapter = object : RecyclerAdapter<T>(layoutId, adapterConfig.dataList ?: ArrayList()) {
        override fun convert(holder: RecyclerViewHolder, item: T, position: Int) {
            holder.bindData(variableId, item)
            holder.convertView.setOnClickListener {
                adapterConfig.mOnItemClick?.invoke(it, item, position)
            }
            holder.convertView.setOnLongClickListener {
                adapterConfig.mOnItemLongClick?.invoke(it, item, position)
                return@setOnLongClickListener true
            }
        }
    }
    layoutManager = adapterConfig.layoutManger ?: LinearLayoutManager(context)
    adapter = recyclerAdapter
    return recyclerAdapter
}