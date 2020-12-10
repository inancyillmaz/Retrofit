package com.inanc.retrofitqueries

data class MainResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<Data>,
    val support : Explain
)


