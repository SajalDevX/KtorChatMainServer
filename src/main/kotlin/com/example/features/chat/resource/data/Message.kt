package com.example.features.chat.resource.data

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val sessionId: String,
    val textMessage: String,
    val sender: String,
    val receiver: String,
    val timestamp: Long
)
