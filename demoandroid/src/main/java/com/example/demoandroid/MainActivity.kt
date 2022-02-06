package com.example.demoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoandroid.ui.theme.Kmp_prototypeTheme
import com.example.kmpprototype.CommonViewModel
import com.example.kmpprototype.PostItem
import platformName

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = CommonViewModel()

        setContent {
            val posts = viewModel.posts.collectAsState()
            Kmp_prototypeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        Text(
                            text = "Posts on ${platformName()}",
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp, bottom = 10.dp)
                        )
                        LazyColumn(contentPadding = PaddingValues(all = 5.dp)) {
                            items(posts.value) {
                                Post(item = it)
                            }
                        }
                    }
                }
            }
            LaunchedEffect(Unit) {
                viewModel.getPosts()
            }
        }
    }
}

@Composable
fun Post(item: PostItem) {
    Column {
        Text(text = item.title, style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold))
        Text(text = item.body, style = TextStyle(fontSize = 10.sp))
        Divider(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))
    }
}
