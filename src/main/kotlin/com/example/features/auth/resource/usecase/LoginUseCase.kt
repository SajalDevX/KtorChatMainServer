package com.example.features.auth.resource.usecase

import com.example.common.util.Constants.ERROR_INVALID_CREDENTIALS
import com.example.common.util.Constants.ERROR_MISSING_EMAIL
import com.example.common.util.Constants.ERROR_MISSING_PASSWORD
import com.example.features.auth.domain.mapper.toUser
import com.example.features.auth.domain.model.login.LoginRequestDto
import com.example.features.auth.domain.repository.AuthRepository
import com.example.features.auth.resource.data.AuthResponseState
import com.example.plugins.generateToken

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(request: LoginRequestDto): AuthResponseState {

        if (request.email.isNullOrEmpty()) return AuthResponseState(data = null, error = ERROR_MISSING_EMAIL)
        if (request.password.isNullOrEmpty()) return AuthResponseState(data = null, error = ERROR_MISSING_PASSWORD)

        val savedUser = repository.getUser(request.email)

        return if (savedUser?.email.equals(request.email) && savedUser?.password.equals(request.password)) {
            val token = generateToken(loginRequestDto = request)
            AuthResponseState(data = savedUser?.toUser()?.copy(token = token), error = null)
        } else {
            AuthResponseState(data = null, error = ERROR_INVALID_CREDENTIALS)
        }
    }
}