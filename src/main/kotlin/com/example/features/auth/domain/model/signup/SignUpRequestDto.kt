package com.example.features.auth.domain.model.signup

import kotlinx.serialization.Serializable

@Serializable
data class SignupRequestDto(
    val username: String? = null,
    val email: String? = null,
    val password: String? = null
)
