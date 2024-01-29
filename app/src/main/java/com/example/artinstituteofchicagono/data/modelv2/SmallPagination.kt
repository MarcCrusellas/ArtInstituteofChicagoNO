package com.example.artinstituteofchicagono.data.modelv2

data class SmallPagination(
    val current_page: Int,
    val limit: Int,
    val next_url: String,
    val offset: Int,
    val total: Int,
    val total_pages: Int
)