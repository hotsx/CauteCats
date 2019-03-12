package com.hotsx.cat.api

import com.hotsx.cat.entity.CatCute
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsService {
    @GET("images/search?mime_types=jpg,png")
    fun getCats(@Query("limit") limit: Int, @Query("page") page: Int, @Query("order") order: String): Call<List<CatCute>>
}