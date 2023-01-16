package com.example.binlistapp.domain.use_case

import com.example.binlistapp.domain.model.Request
import com.example.binlistapp.domain.repository.BinlistRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetRequestListUseCase @Inject constructor(
    private val repository: BinlistRepository
)  {
    operator fun invoke(): Flow<List<Request>> {
        return repository.getListOfRequest()
    }
}