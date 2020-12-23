package com.inanc.retrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inanc.retrofit.model.ApiCallResponse
import com.inanc.retrofit.network.ApiClient
import com.inanc.retrofit.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val TAG = "RETROFIT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiClient.call().enqueue(object : Callback<List<ApiCallResponse>> {
            override fun onResponse(call: Call<List<ApiCallResponse>>, response: Response<List<ApiCallResponse>>) {
                var body = response.body()
                Log.d(TAG, "onResponse: $body")
            }
            override fun onFailure(call: Call<List<ApiCallResponse>>, t: Throwable) {
                Log.d(TAG, "onFailure: $t.toString()")
            }
        })
    }
}

