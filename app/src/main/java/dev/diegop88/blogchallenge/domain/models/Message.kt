package dev.diegop88.blogchallenge.domain.models

data class Message(
    val subject: String,
    val message: String,
    val user: String = "",
)
