package com.example.di

import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

/**
 * App module
 * Creating kmongo db
 */
val appModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("chat_app_ab")
    }
}