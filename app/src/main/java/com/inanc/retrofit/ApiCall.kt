package com.inanc.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiCall {
    @GET("comments")
    fun callGetComments() : Call<List<ApiCallResponse>>
}