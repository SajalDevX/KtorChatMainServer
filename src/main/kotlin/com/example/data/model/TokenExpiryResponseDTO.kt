package com.example.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TokenExpiryResponseDTO(
    val data: String? = null,
    val error: Error? = Error()
) {
    @Serializable
    data class Error(
        val message: String = "Token is not valid or has been expired."
    )
}