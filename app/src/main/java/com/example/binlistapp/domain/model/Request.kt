package com.example.binlistapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Request(
    val timestamp: Long,
    val bin: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

class InvalidRequestException(message: String): Exception(message)