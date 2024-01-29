package com.example.artinstituteofchicagono.data.modelv2

data class SmallArtic(
    val config: SmallConfig,
    val `data`: List<SmallData>,
    val info: SmallInfo,
    val pagination: SmallPagination
)