package com.example.binlistapp.data.remote.dto

import com.example.binlistapp.domain.model.CardDetail

data class CardDetailDto(
    val bank: Bank?,
    val brand: String?,
    val country: Country?,
    val number: Number?,
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?
)
fun CardDetailDto.toCardDetail(): CardDetail{
    return CardDetail(
        bank = bank,
        brand = brand,
        country = country,
        number = number,
        prepaid = prepaid,
        scheme = scheme,
        type = type
    )
}