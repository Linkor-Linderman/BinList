package com.example.binlistapp.presentation.request_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlistapp.domain.model.Request
import com.example.binlistapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RequestListViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _listOfRequest = mutableStateOf(emptyList<Request>())
    val listOfRequest: State<List<Request>> = _listOfRequest

    private var getRequestsJob: Job? = null

    init {
        getRequests()
    }
    private fun getRequests(){
        getRequestsJob?.cancel()
        getRequestsJob = useCases.getRequestListUseCase()
            .onEach { requests ->
                _listOfRequest.value = requests
            }
            .launchIn(viewModelScope)
    }
}