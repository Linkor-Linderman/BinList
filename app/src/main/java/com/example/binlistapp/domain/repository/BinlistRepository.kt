package com.example.binlistapp.domain.repository

import com.example.binlistapp.domain.model.CardDetail
import com.example.binlistapp.domain.model.Request
import kotlinx.coroutines.flow.Flow

interface BinlistRepository {
    suspend fun getCardDetailByBin(bin: String): CardDetail

    suspend fun insertNewRequest(request: Request)

    fun getListOfRequest(): Flow<List<Request>>
}