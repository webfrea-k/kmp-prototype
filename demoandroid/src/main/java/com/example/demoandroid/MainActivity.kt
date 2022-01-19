package com.example.demoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoandroid.ui.theme.Kmp_prototypeTheme
import com.example.kmpprototype.Networking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kmp_prototypeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TestComposeItem()
                }
            }
        }
    }
}

@Composable
fun TestComposeItem() {
    val todoItem = remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        val todo = Networking.getTodo()
        todoItem.value = todo?.title ?: "ERROR"
    }
    Text(text = todoItem.value)
}
