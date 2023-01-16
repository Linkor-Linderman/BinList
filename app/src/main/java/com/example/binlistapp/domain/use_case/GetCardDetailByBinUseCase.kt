package com.example.binlistapp.domain.use_case

import com.example.binlistapp.common.Resource
import com.example.binlistapp.domain.model.CardDetail
import com.example.binlistapp.domain.repository.BinlistRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCardDetailByBinUseCase @Inject constructor(
    private val repository: BinlistRepository
) {
    operator fun invoke(bin: String): Flow<Resource<CardDetail>> = flow {
        try {
            emit(Resource.Loading<CardDetail>())
            val cardDetail = repository.getCardDetailByBin(bin)
            emit(Resource.Success<CardDetail>(cardDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<CardDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CardDetail>("Could not reach server. Check your internet connection"))
        }
    }
}