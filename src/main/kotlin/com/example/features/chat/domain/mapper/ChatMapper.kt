package com.example.features.chat.domain.mapper

import com.example.features.auth.resource.data.User
import com.example.features.chat.data.dao.MessageEntity
import com.example.features.chat.domain.model.chat_room.MessageResponseDto
import com.example.features.chat.domain.model.friend_list.FriendDataResponseDto
import com.example.features.chat.domain.model.friend_list.FriendInfo
import com.example.features.chat.resource.data.Message


fun User.toFriendData() = FriendDataResponseDto(
    token = token,
    friendInfo = FriendInfo(
        username = user?.username,
        email = user?.email,
        avatar = user?.avatar,
        lastMessage = user?.lastMessage
    )
)

fun Message.toMessageEntity() = MessageEntity(
    sessionId = sessionId,
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)

fun Message.toMessageResponseDto() = MessageResponseDto(
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)

fun MessageEntity.toMessage() = Message(
    sessionId = sessionId,
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)