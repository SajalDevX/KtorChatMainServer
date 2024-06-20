package com.example.features.chat.domain.model.chat_room

@kotlinx.serialization.Serializable
data class MessageResponseDto(
    val textMessage: String,
    val sender: String,
    val receiver: String,
    val timestamp: Long
)
