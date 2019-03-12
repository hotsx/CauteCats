package com.hotsx.cat.paging

import com.hotsx.cat.entity.CatCute
import com.hotsx.cat.viewmodel.HomeViewModel

class CatDataSourceFactory(private val viewModel: HomeViewModel) : androidx.paging.DataSource.Factory<Int, CatCute>() {
    override fun create(): androidx.paging.DataSource<Int, CatCute> = CatDataSource(viewModel)
}