package com.example.features.auth.resource.usecase

import com.example.common.util.Constants.ERROR_MISSING_EMAIL
import com.example.common.util.Constants.ERROR_MISSING_PASSWORD
import com.example.common.util.Constants.ERROR_MISSING_USERNAME
import com.example.common.util.Constants.ERROR_USER_EXISTS
import com.example.features.auth.domain.mapper.toUser
import com.example.features.auth.domain.model.signup.SignupRequestDto
import com.example.features.auth.domain.repository.AuthRepository
import com.example.features.auth.resource.data.AuthResponseState
import com.example.plugins.generateToken

class SignUpUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(request: SignupRequestDto): AuthResponseState {

        if (request.username.isNullOrEmpty()) return AuthResponseState(data = null, error = ERROR_MISSING_USERNAME)
        if (request.email.isNullOrEmpty()) return AuthResponseState(data = null, error = ERROR_MISSING_EMAIL)
        if (request.password.isNullOrEmpty()) return AuthResponseState(data = null, error = ERROR_MISSING_PASSWORD)

        val savedUser = repository.getUser(request.email)?.toUser()

        return if (savedUser == null) {
            val token = generateToken(signupRequestDto = request)
            AuthResponseState(data = repository.insertUser(request = request, token = token), error = null)
        } else {
            AuthResponseState(data = null, error = ERROR_USER_EXISTS)
        }
    }
}