package com.example.kmpprototype

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.compression.ContentEncoding
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Networking {
    val ktorClient: HttpClient = HttpClient {
        install(HttpCache)
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
                useArrayPolymorphism = true
            })
        }
        ContentEncoding { gzip() }
    }

    suspend inline fun <reified T> get(url: String): T? = runCatching {
        ktorClient.get(url).body() as? T
    }.getOrNull()
}

