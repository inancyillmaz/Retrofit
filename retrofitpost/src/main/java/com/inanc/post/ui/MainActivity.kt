package com.inanc.post.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inanc.post.model.ApiCallResponse
import com.inanc.post.network.ApiClient
import com.inanc.retrofitpost.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val TAG = "RETROFIT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      ApiClient.call().enqueue(object : Callback<ApiCallResponse> {
          override fun onResponse(
              call: Call<ApiCallResponse>,
              response: Response<ApiCallResponse>
          ) {
              var body = response.body()
              Log.d(TAG, "onResponse: $body")
          }

          override fun onFailure(call: Call<ApiCallResponse>, t: Throwable) {
              Log.d(TAG, "onFailure: $t.toString()")
          }
      })
    }
}

