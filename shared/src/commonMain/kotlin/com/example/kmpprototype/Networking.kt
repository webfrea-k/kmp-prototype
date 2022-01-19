package com.example.kmpprototype

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object Networking {
    private val ktorClient: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
                allowSpecialFloatingPointValues = true
                useArrayPolymorphism = true
            })
        }
        install(HttpCache)
        ContentEncoding { gzip() }
    }

    suspend fun getTodo(): Todo? {
        return try {
            val test: Todo? = ktorClient.get("https://jsonplaceholder.typicode.com/todos/1").body()
            println("Got todo item: ${test != null}")
            test
        } catch (ex: Exception) {
            println(ex.stackTraceToString())
            return null
        }
    }
}

