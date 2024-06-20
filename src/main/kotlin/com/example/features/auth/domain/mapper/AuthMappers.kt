package com.example.features.auth.domain.mapper

import com.example.features.auth.data.dao.UserEntity
import com.example.features.auth.domain.model.signup.SignupRequestDto
import com.example.features.auth.resource.data.User
import com.example.features.auth.resource.data.UserData

fun SignupRequestDto.toUserEntity() = UserEntity(
    username = username, email = email, password = password
)

fun UserEntity.toUser() = User(
    token = token,
    user = UserData(
        username = username,
        email = email,
        avatar = avatar,
        lastMessage = lastMessage
    )
)