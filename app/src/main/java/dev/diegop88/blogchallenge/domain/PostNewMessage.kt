package dev.diegop88.blogchallenge.domain

import dev.diegop88.blogchallenge.data.BlogRepository
import dev.diegop88.blogchallenge.data.entities.NewMessageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostNewMessage(
    private val repository: BlogRepository,
) {
    suspend operator fun invoke(
        user: String,
        subject: String,
        message: String,
    ) = withContext(Dispatchers.Default) {
        val messageEntity = NewMessageEntity(user, subject, message, OPERATION)
        repository.postNewMessage(messageEntity)
    }

    companion object {
        const val OPERATION = "add_message"
    }
}
