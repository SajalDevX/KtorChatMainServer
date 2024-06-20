package com.example.plugins

import com.example.features.auth.resource.route.loginEndpoint
import com.example.features.auth.resource.route.signupEndpoint
import com.example.features.chat.resource.route.chatConnectEndpoint
import com.example.features.chat.resource.route.chatHistoryEndpoint
import com.example.features.chat.resource.route.friendsListEndpoint
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(Routing) {

        signupEndpoint()
        loginEndpoint()

        authenticate("auth-jwt") {
            chatConnectEndpoint()
            friendsListEndpoint()
            chatHistoryEndpoint()
        }
    }
}
