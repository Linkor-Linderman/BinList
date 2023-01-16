package com.example.binlistapp.domain.use_case

import com.example.binlistapp.common.ValidationResult

class ValidateBinUseCase {
    operator fun invoke(bin: String): ValidationResult {
        if (bin.isBlank()) {
            return ValidationResult(
                successful = false,
                messageError = "BIN must not be empty"
            )
        }
        if (bin.length < 6) {
            return ValidationResult(
                successful = false,
                messageError = "BIN length must be 6"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}