package dev.diegop88.blogchallenge.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.diegop88.blogchallenge.domain.GetMessages
import dev.diegop88.blogchallenge.domain.SearchUserMessages
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPosts: GetMessages,
    private val searchUserMessages: SearchUserMessages,
) : ViewModel() {

    var homeState by mutableStateOf<HomeState>(HomeState.Loading)
        private set

    private val handler = CoroutineExceptionHandler { _, throwable ->
        homeState = HomeState.Error(throwable)
    }

    init {
        getMessages()
    }

    fun getMessages() = viewModelScope.launch(handler) {
        homeState = HomeState.Loading
        val response = getPosts()
        homeState = HomeState.Success(response)
    }

    fun searchByUser(user: String) = viewModelScope.launch(handler) {
        homeState = HomeState.Loading
        val response = searchUserMessages(user)
        homeState = HomeState.Success(response)
    }
}
