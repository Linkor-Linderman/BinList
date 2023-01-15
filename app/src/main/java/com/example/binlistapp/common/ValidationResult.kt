package com.example.binlistapp.common

data class ValidationResult(
    val successful: Boolean,
    val messageError: String? = null
)
