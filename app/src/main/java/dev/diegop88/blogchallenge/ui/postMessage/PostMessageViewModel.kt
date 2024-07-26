package dev.diegop88.blogchallenge.ui.postMessage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.diegop88.blogchallenge.domain.PostNewMessage
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class PostMessageViewModel(
    private val postNewMessage: PostNewMessage,
) : ViewModel() {

    var postState by mutableStateOf<PostState>(PostState.IDLE)
        private set

    private val handler = CoroutineExceptionHandler { _, throwable ->
        postState = PostState.Error(throwable)
    }

    fun postMessage(
        user: String,
        subject: String,
        message: String,
    ) = viewModelScope.launch(handler) {
        postState = PostState.Loading
        postNewMessage(user, subject, message)
        postState = PostState.Success
    }
}
