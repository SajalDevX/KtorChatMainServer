package com.example.features.auth.resource.route

import com.example.common.util.Constants.ENDPOINT_LOGIN
import com.example.common.util.Constants.ENDPOINT_SIGNUP
import com.example.features.auth.domain.model.login.LoginRequestDto
import com.example.features.auth.domain.model.signup.SignupRequestDto
import com.example.features.auth.resource.usecase.LoginUseCase
import com.example.features.auth.resource.usecase.SignUpUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent

fun Route.signupEndpoint() {
    post(ENDPOINT_SIGNUP) {
        val request = call.receive<SignupRequestDto>()
        val useCase by KoinJavaComponent.inject<SignUpUseCase>(SignUpUseCase::class.java)
        call.respond(useCase(request = request))
    }
}

fun Route.loginEndpoint() {
    post(ENDPOINT_LOGIN) {
        val request = call.receive<LoginRequestDto>()
        val useCase by KoinJavaComponent.inject<LoginUseCase>(LoginUseCase::class.java)
        call.respond(useCase(request = request))
    }
}