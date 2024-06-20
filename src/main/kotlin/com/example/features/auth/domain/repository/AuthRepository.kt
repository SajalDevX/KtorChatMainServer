package com.example.features.auth.domain.repository

import com.example.features.auth.data.dao.UserEntity
import com.example.features.auth.domain.model.signup.SignupRequestDto
import com.example.features.auth.resource.data.User

interface AuthRepository {
    suspend fun insertUser(request: SignupRequestDto, token: String): User
    suspend fun getUser(email: String): UserEntity?
}