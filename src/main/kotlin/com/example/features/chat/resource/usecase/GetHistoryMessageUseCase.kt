package com.example.features.chat.resource.usecase

import com.example.data.repository.JwtRepository
import com.example.features.chat.domain.mapper.toMessageResponseDto
import com.example.features.chat.domain.repository.ChatRepository
import com.example.features.chat.resource.ChatRoomHistoryState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHistoryMessagesUseCase(private val repository: ChatRepository, private val jwtRepository: JwtRepository) {
    suspend operator fun invoke(receiver: String): Flow<ChatRoomHistoryState> = flow {

        repository.getHistoryMessages(sender = jwtRepository.getEmailPayload(), receiver = receiver)
            .collect { messageList ->
                val result = if (messageList.isNotEmpty()) {
                    ChatRoomHistoryState(data = messageList.map { it.toMessageResponseDto() }, error = null)
                } else {
                    ChatRoomHistoryState(data = emptyList(), error = null)
                }
                emit(result)
            }
    }
}