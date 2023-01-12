package com.example.binlistapp.presentation.card_detail_screen

import com.example.binlistapp.domain.model.CardDetail

data class CardDetailState(
    val isLoading: Boolean = false,
    val cardDetail: CardDetail? = null,
    val error: String = ""
)
