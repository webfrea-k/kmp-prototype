package com.example.kmpprototype

import kotlinx.serialization.Serializable

@Serializable
data class PostItem(
    val body: String = "",
    val id: Int = 0,
    val title: String = "",
    val userId: Int = 0
)