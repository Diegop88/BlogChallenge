package dev.diegop88.blogchallenge.ui.home

import dev.diegop88.blogchallenge.domain.models.Message

sealed class HomeState {
    data object Loading : HomeState()
    data class Error(val throwable: Throwable) : HomeState()
    data class Success(val messages: List<Message>) : HomeState()
}
