package com.example.features.auth.domain.repository

import com.example.features.auth.data.dao.UserEntity
import com.example.features.auth.data.datasource.AuthDataSource
import com.example.features.auth.domain.mapper.toUser
import com.example.features.auth.domain.mapper.toUserEntity
import com.example.features.auth.domain.model.signup.SignupRequestDto
import com.example.features.auth.resource.data.User
import java.util.UUID

class AuthRepositoryImpl(
    private val dataSource: AuthDataSource
) : AuthRepository {
    override suspend fun insertUser(request: SignupRequestDto, token: String): User {
        val avatar = UUID.randomUUID().toString()
        return dataSource.insertUser(request.toUserEntity().copy(token = token, avatar = avatar)).toUser()
    }

    override suspend fun getUser(email: String) =
        dataSource.findUserByEmail(email)
}