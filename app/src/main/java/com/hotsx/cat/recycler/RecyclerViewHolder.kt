package com.hotsx.cat.recycler

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewHolder(val convertView: View) : RecyclerView.ViewHolder(convertView) {

    private val binding: ViewDataBinding? by lazy {
        DataBindingUtil.bind<ViewDataBinding>(convertView)
    }

    fun <T> bindData(variableId: Int, item: T) {
        binding?.setVariable(variableId, item)
    }
}