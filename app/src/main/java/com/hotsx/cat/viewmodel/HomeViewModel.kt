package com.hotsx.cat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.hotsx.cat.api.ApiServer
import com.hotsx.cat.app.LIMIT
import com.hotsx.cat.app.ORDER
import com.hotsx.cat.entity.CatCute
import com.hotsx.cat.paging.CatDataSourceFactory
import kotlinx.coroutines.*
import mu.KLogging
import kotlin.coroutines.CoroutineContext

class HomeViewModel : ViewModel(), CoroutineScope {

    companion object : KLogging()

    private val job by lazy { SupervisorJob() }
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + job

    private val catsService = ApiServer.catsService()

    val catsLiveData by lazy {
        LivePagedListBuilder(CatDataSourceFactory(this), PagedList.Config.Builder()
            .setPageSize(LIMIT)
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(LIMIT)
            .build())
            .build()
    }

    fun initialCats(callback: PageKeyedDataSource.LoadInitialCallback<Int, CatCute>) = launch {
        catsService.getCats(LIMIT, 0, ORDER).execute().body()?.let {
            callback.onResult(it, null, 2)
        }
    }

    fun loadCats(page: Int, adjacentPageKey: Int, callback: PageKeyedDataSource.LoadCallback<Int, CatCute>) = launch {
        catsService.getCats(LIMIT, page, ORDER).execute().body()?.let {
            callback.onResult(it, adjacentPageKey)
        }
    }
}
