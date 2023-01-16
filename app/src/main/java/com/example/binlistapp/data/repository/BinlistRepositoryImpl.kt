package com.example.binlistapp.data.repository

import com.example.binlistapp.data.data_sourse.RequestDao
import com.example.binlistapp.data.remote.BinlistApi
import com.example.binlistapp.data.remote.dto.toCardDetail
import com.example.binlistapp.domain.model.CardDetail
import com.example.binlistapp.domain.model.Request
import com.example.binlistapp.domain.repository.BinlistRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BinlistRepositoryImpl @Inject constructor(
    private val api: BinlistApi,
    private val dao: RequestDao
) : BinlistRepository {
    override suspend fun getCardDetailByBin(bin: String): CardDetail {
        return api.getCardDetailByBin(bin).toCardDetail()
    }

    override suspend fun insertNewRequest(request: Request) {
        dao.insertRequest(request)
    }

    override fun getListOfRequest(): Flow<List<Request>> {
        return dao.getRequests()
    }
}