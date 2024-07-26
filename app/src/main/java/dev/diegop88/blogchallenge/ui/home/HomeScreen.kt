package dev.diegop88.blogchallenge.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.diegop88.blogchallenge.domain.models.Message
import dev.diegop88.blogchallenge.ui.error.Error
import dev.diegop88.blogchallenge.ui.loading.Loading
import dev.diegop88.blogchallenge.ui.message.MessageItem
import dev.diegop88.blogchallenge.ui.postMessage.AddMessage
import dev.diegop88.blogchallenge.ui.search.SearchUser
import dev.diegop88.blogchallenge.utils.Navigation
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = koinViewModel()
) {
    Log.d("Home", "Hello")

    Scaffold(
        topBar = {
            SearchUser { user ->
                if (user.isEmpty()) {
                    viewModel.getMessages()
                } else {
                    viewModel.searchByUser(user)
                }
            }
        },
        floatingActionButton = {
            AddMessage {
                navController.navigate(Navigation.NEW_MESSAGE)
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            when (val state = viewModel.homeState) {
                is HomeState.Loading -> Loading()
                is HomeState.Error -> Error(state.throwable)
                is HomeState.Success -> ShowList(state.messages)
            }
        }
    }
}

@Composable
private fun ShowList(messages: List<Message>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (messages.isEmpty()) {
            item {
                Text(text = "Post your first message")
            }
        } else {
            items(messages) {
                MessageItem(it)
            }
        }
    }
}
