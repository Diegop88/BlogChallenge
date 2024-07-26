package dev.diegop88.blogchallenge.data.entities

data class NewMessageEntity(
    val user: String,
    val subject: String,
    val message: String,
    val operation: String,
)
