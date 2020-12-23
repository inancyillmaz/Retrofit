package com.inanc.retrofit.network

import com.inanc.retrofit.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient{

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val okhttp3client = OkHttpClient.Builder()

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        if(BuildConfig.DEBUG){
        //    okhttp3client.addInterceptor(logging)
        }
    }

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp3client.build())
        .build()
        .create(ApiCall::class.java)

    fun call() = api.callGetComments()

}