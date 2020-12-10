package com.inanc.retrofitpost

import retrofit2.Call
import retrofit2.http.*

interface ApiCall {
    @POST("posts")
    fun makePost(@Body info: Info): Call<ApiCallResponse>

    @Headers("Cache-Control: max-age=86400", "user-agent: 123")
    @GET("endpoint/custom")
    fun makeCallHeadersStatic(): Call<ApiCallResponse>

    @GET("endpoint/custom")
    fun makeCallHeadersDynamic(@Header("Cache-Control") cacheControl: String): Call<ApiCallResponse>

    @FormUrlEncoded
    @POST("user/info")
    fun makeCallForm(
        @Field("name") first_name: String,
        @Field("surname") last_name: String
    )

    @FormUrlEncoded
    @POST("user/info")
    fun makeCallFormMultiple(
        @FieldMap fields: Map<String,String>)
}