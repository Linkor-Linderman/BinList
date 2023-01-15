package com.example.binlistapp.domain.model

import com.example.binlistapp.data.remote.dto.Bank
import com.example.binlistapp.data.remote.dto.Country

data class CardDetail(
    val bank: Bank?,
    val brand: String?,
    val country: Country?,
    val number: com.example.binlistapp.data.remote.dto.Number?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)