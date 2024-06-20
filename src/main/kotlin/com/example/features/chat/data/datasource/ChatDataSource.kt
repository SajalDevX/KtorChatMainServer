package com.example.features.chat.data.datasource

import com.example.features.auth.data.dao.UserEntity
import com.example.features.chat.data.dao.MessageEntity
import kotlinx.coroutines.flow.Flow

interface ChatDataSource {
    suspend fun getFriendList(sender: String): Flow<List<UserEntity>>
    suspend fun checkSessionAvailability(sender: String, receiver: String): String?
    suspend fun createNewSession(sender: String, receiver: String): String
    suspend fun insertMessage(messageEntity: MessageEntity)
    suspend fun getHistoryMessages(sender: String, receiver: String): Flow<List<MessageEntity>>
}