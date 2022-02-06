package com.example.kmpprototype

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CommonViewModel {
    private var viewModelJob: Job? = null
    val posts: MutableStateFlow<List<PostItem>> = MutableStateFlow(emptyList())

    fun getPosts() {
        viewModelJob = CoroutineScope(Dispatchers.Default).launch {
            posts.value = Networking.get<List<PostItem>>("https://jsonplaceholder.typicode.com/posts").orEmpty()
        }
    }
}