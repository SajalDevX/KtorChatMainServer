package com.example.di

import com.example.features.auth.resource.usecase.LoginUseCase
import com.example.features.auth.resource.usecase.SignUpUseCase
import org.koin.dsl.module

/**
 * Use case module
 * Configuring useCases dependency injection
 */
val useCaseModule = module {
    single { SignUpUseCase(get()) }
    single { LoginUseCase(get()) }
}