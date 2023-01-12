package com.example.binlistapp.data.remote

import com.example.binlistapp.data.remote.dto.CardDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface BinlistApi {
    @GET("/{bin}")
    suspend fun getCardDetailByBin(@Path("bin") coinId: String): CardDetailDto
}