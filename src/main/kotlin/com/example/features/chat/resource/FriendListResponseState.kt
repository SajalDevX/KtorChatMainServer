package com.example.features.chat.resource

import com.example.features.chat.domain.model.friend_list.FriendDataResponseDto

@kotlinx.serialization.Serializable
data class FriendListResponseState(
    val data: List<FriendDataResponseDto>? = null,
    val error: HashMap<String, String>? = null
)
