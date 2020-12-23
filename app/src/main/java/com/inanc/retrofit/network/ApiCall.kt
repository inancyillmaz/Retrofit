package com.inanc.retrofit.network

import com.inanc.retrofit.model.ApiCallResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiCall {
    @GET("comments")
    fun callGetComments() : Call<List<ApiCallResponse>>
}