package dev.diegop88.blogchallenge.ui.postMessage

sealed class PostState {
    data object IDLE : PostState()
    data object Loading : PostState()
    data class Error(val throwable: Throwable) : PostState()
    data object Success : PostState()
}
