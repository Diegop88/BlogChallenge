package dev.diegop88.blogchallenge.data

import dev.diegop88.blogchallenge.data.entities.NewMessageEntity
import dev.diegop88.blogchallenge.data.entities.ResponseEntity

interface BlogRepository {
    suspend fun getAllMessages(): ResponseEntity
    suspend fun getUserMessages(user: String): ResponseEntity
    suspend fun postNewMessage(messageEntity: NewMessageEntity)
}
