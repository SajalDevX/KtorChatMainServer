package com.example.features.chat.resource

import com.example.features.chat.domain.model.chat_room.MessageResponseDto


@kotlinx.serialization.Serializable
data class ChatRoomHistoryState(
    val data: List<MessageResponseDto>? = null,
    val error: HashMap<String, String>? = null
)
