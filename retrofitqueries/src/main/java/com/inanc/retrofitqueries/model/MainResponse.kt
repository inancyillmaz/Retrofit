package com.inanc.retrofitqueries.model

import com.inanc.retrofitqueries.model.Data
import com.inanc.retrofitqueries.model.Explain

data class MainResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<Data>,
    val support : Explain
)


