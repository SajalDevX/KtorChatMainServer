package com.example.features.auth.domain.model.login

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    val email: String? = null,
    val password: String? = null
)
