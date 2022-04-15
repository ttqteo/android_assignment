package com.example.movieapp.modal

import java.util.*

data class MovieResp(
    val dates: Date? = null,
    val page: Long? = null,
    val results: List<Movie>? = null,
    val totalPages: Long? = null,
    val totalResults: Long? = null
)
