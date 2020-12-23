package com.inanc.retrofitqueries.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val BASE_URL = "https://reqres.in/api/"

    private val okhttp3client = OkHttpClient.Builder()

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        okhttp3client.addInterceptor(logging)
    }

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp3client.build())
        .build()
        .create(ApiService::class.java)


    fun call() =
    //  api.callQueryStatic()
    // api.callQueryDynamic(2)
    //  api.callUrlByPass()
    //  api.callUrlDynamic("https://reqres.in/api/users?page=2")
        api.callReplacement("users",1)
}