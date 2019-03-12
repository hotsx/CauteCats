package com.hotsx.cat.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hotsx.cat.R
import com.hotsx.cat.paging.CatPagedAdapter
import com.hotsx.cat.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    private lateinit var catsAdapter: CatPagedAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialView()
    }

    private fun initialView() {
        catsAdapter = CatPagedAdapter()
        catsRecyclerView.layoutManager = LinearLayoutManager(context)
        catsRecyclerView.adapter = catsAdapter
        viewModel.catsLiveData.observe(this, Observer {
            catsAdapter.submitList(it)
        })
    }
}
