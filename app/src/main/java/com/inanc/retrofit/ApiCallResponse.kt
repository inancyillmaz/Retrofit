package com.inanc.retrofit



data class ApiCallResponse(
    val name: String,
    val postId: Int,
    val id: Int,
    val email: String,
    val body: String
)