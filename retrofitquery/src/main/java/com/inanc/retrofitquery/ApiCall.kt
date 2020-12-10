package com.inanc.retrofitqueries

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiCall {
    @GET("users?page=2")
    fun callQueryStatic(): Call<ResponseClass>

    @GET("users")
    fun callQueryDynamic(@Query("page") n: Int) : Call<ResponseClass>

    @GET("https://reqres.in/api/users?page=2")
    fun callUrlByPass(): Call<ResponseClass>

    @GET
    fun callUrlDynamic(@Url url: String): Call<ResponseClass>

    @GET("{endpoint}")
    fun callReplacement(@Path("endpoint") endpoint : String, @Query("page") n: Int) : Call<ResponseClass>
}