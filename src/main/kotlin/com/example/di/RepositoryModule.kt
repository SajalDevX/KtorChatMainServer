package com.example.di

import com.example.data.repository.JwtRepository
import com.example.data.repository.JwtRepositoryImpl
import com.example.features.auth.domain.repository.AuthRepository
import com.example.features.auth.domain.repository.AuthRepositoryImpl
import org.koin.dsl.module

/**
 * Repository module
 * Configuring repositories dependency injection
 */
val repositoryModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }

//    single<ChatRepository> {
//        ChatRepositoryImpl(get(), get())
//    }

    single<JwtRepository> {
        JwtRepositoryImpl()
    }
}