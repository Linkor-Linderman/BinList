package com.example.binlistapp.domain.use_case

import com.example.binlistapp.domain.model.InvalidRequestException
import com.example.binlistapp.domain.model.Request
import com.example.binlistapp.domain.repository.BinlistRepository
import javax.inject.Inject

class AddNewRequest @Inject constructor(
    private val repository: BinlistRepository
)  {
    suspend fun invoke(request: Request){
        if(request.bin.isBlank())
            throw InvalidRequestException("The bin of the request can not be empty.")
        repository.insertNewRequest(request)
    }
}