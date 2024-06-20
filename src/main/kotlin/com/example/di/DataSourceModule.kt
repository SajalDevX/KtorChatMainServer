package com.example.di

import com.example.features.auth.data.datasource.AuthDataSource
import com.example.features.auth.data.datasource.AuthDataSourceImpl
import org.koin.dsl.module

/**
 * Data source module
 * Configuring local data sources dependencies injection
 */
val dataSourceModule = module {
    single<AuthDataSource> {
        AuthDataSourceImpl(get())
    }

//    single<ChatDataSource> {
//        ChatDataSourceImpl(get())
//    }
}