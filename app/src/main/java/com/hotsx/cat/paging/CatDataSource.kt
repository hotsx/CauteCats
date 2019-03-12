package com.hotsx.cat.paging

import androidx.paging.PageKeyedDataSource
import com.hotsx.cat.entity.CatCute
import com.hotsx.cat.viewmodel.HomeViewModel

class CatDataSource(private val viewModel: HomeViewModel) : PageKeyedDataSource<Int, CatCute>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CatCute>) {
        viewModel.initialCats(callback)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CatCute>) {
        viewModel.loadCats(params.key, params.key + 1, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CatCute>) {
        viewModel.loadCats(params.key, params.key - 1, callback)
    }
}