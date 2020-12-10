package com.inanc.retrofitpost

import com.squareup.okhttp.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiCallService {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val okhttp3client = OkHttpClient.Builder()


    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        okhttp3client.addInterceptor(logging)

        okhttp3client.addInterceptor {chain ->
            val request = chain.request()
            val newRequest = request.newBuilder()
                .addHeader("user-agent","İnanç")
                .build()
            chain.proceed(newRequest)}
    }



    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp3client.build())
        .build()
        .create(ApiCall::class.java)

    fun call() =
        api.makePost(Info("title1", "body1", 1))

}