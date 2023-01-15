package com.example.binlistapp.domain.use_case

data class UseCases(
    val getCardDetailByBinUseCase: GetCardDetailByBinUseCase,
    val getRequestListUseCase: GetRequestListUseCase,
    val addNewRequest: AddNewRequest,
    val validateBinUseCase: ValidateBinUseCase
)