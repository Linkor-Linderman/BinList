package com.example.binlistapp.presentation.card_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.common.Resource
import com.example.binlistapp.domain.model.Request
import com.example.binlistapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CardDetailViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel(){

    private val _state = mutableStateOf(CardDetailState())
    val state: State<CardDetailState> = _state

    private val _bin = mutableStateOf("")
    val bin: State<String> = _bin

    fun getCardDetail(bin: String) {
        if(bin.isNotBlank()){
        useCases.getCardDetailByBinUseCase(bin).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CardDetailState(cardDetail = result.data)
                    val request = Request(
                        bin = bin,
                        timestamp = System.currentTimeMillis()
                    )
                    useCases.addNewRequest(request)
                }
                is Resource.Error -> {
                    _state.value = CardDetailState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = CardDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
        }
    }
}
