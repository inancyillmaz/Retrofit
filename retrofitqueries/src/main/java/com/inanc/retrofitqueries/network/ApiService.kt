package com.inanc.retrofitqueries.network

import com.inanc.retrofitqueries.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiService {

    @GET("users?page=2")
    fun callQueryStatic(): Call<MainResponse>

    @GET("users")
    fun callQueryDynamic(@Query("page") n: Int) : Call<MainResponse>

    @GET("https://reqres.in/api/users?page=2")
    fun callUrlByPass(): Call<MainResponse>

    @GET
    fun callUrlDynamic(@Url url: String): Call<MainResponse>

    @GET("{endpoint}")
    fun callReplacement(@Path("endpoint") endpoint : String, @Query("page") n: Int) : Call<MainResponse>

}