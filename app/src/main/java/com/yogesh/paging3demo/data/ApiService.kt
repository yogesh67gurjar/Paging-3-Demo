package com.yogesh.paging3demo.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    suspend fun getProducts(@Query("skip") skip: Int, @Query("limit") limit: Int): ProductResponse
}