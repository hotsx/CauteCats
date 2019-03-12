package com.hotsx.cat.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hotsx.cat.BR
import com.hotsx.cat.R
import com.hotsx.cat.entity.CatCute
import com.hotsx.cat.recycler.RecyclerViewHolder

class CatPagedAdapter : PagedListAdapter<CatCute, RecyclerViewHolder>(CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_home_fragment,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindData(BR.catCute, getItem(position))
    }

    companion object {
        private val CALLBACK = object : DiffUtil.ItemCallback<CatCute>() {
            override fun areItemsTheSame(oldItem: CatCute, newItem: CatCute): Boolean = oldItem == newItem

            override fun areContentsTheSame(oldItem: CatCute, newItem: CatCute): Boolean = oldItem == newItem

        }
    }
}