package com.inanc.retrofitqueries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "RETROFIT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ApiCallService.call().enqueue(object : Callback<MainResponse> {
            override fun onResponse(call: Call<MainResponse>, mainResponse: Response<MainResponse>) {
                var body = mainResponse.body()
                Log.d(TAG, "onResponse: ${body.toString()}")
            }
            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: $t.toString()")
            }
        })

    }
}

