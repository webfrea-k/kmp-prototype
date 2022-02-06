package com.example.kmpprototype

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.compression.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
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

    suspend inline fun <reified T> get(url: String): T? {
        return try {
            ktorClient.get(url).body() as? T
        } catch (ex: Exception) {
            println(ex.stackTraceToString())
            return null
        }
    }
}

