package com.example.features.auth.data.datasource

import com.example.features.auth.data.dao.UserEntity

interface AuthDataSource {
    suspend fun insertUser(userEntity: UserEntity): UserEntity
    suspend fun findUserByEmail(email: String): UserEntity?
}