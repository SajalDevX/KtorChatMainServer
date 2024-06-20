package com.example.features.auth.data.datasource

import com.example.features.auth.data.dao.UserEntity
import com.mongodb.client.model.Filters
import org.litote.kmongo.coroutine.CoroutineDatabase

class AuthDataSourceImpl(database: CoroutineDatabase) : AuthDataSource {
    private val users = database.getCollection<UserEntity>()

    override suspend fun insertUser(userEntity: UserEntity): UserEntity {
        users.insertOne(userEntity)
        return userEntity
    }

    override suspend fun findUserByEmail(email: String): UserEntity? =
        users.find(Filters.eq("email", email)).first()
}