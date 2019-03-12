package com.hotsx.cat.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServer {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun catsService(): CatsService = retrofit.create(CatsService::class.java)
}