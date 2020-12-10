package com.inanc.retrofitqueries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inanc.retrofitquery.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "RETROFIT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ApiCallService.call().enqueue(object : Callback<ResponseClass> {
            override fun onResponse(call: Call<ResponseClass>, response: Response<ResponseClass>) {
                var body = response.body()
                Log.d(TAG, "onResponse: ${body.toString()}")
            }
            override fun onFailure(call: Call<ResponseClass>, t: Throwable) {
                Log.d(TAG, "onFailure: $t.toString()")
            }
        })
    }
}

