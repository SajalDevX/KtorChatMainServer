package com.example.plugins

import com.example.features.auth.resource.route.loginEndpoint
import com.example.features.auth.resource.route.signupEndpoint
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(Routing){
        signupEndpoint()
        loginEndpoint()
    }
}
