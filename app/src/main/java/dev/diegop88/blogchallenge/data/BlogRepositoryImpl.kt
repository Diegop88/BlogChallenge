package dev.diegop88.blogchallenge.data

import dev.diegop88.blogchallenge.data.entities.NewMessageEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit

class BlogRepositoryImpl(
    private val blogService: BlogService,
) : BlogRepository {
    override suspend fun getAllMessages() = withContext(Dispatchers.IO) {
        delay(TimeUnit.SECONDS.toMillis(2)) // Delay to show Loading state
        blogService.getMessages()
    }

    override suspend fun getUserMessages(user: String) = withContext(Dispatchers.IO) {
        delay(TimeUnit.SECONDS.toMillis(2)) // Delay to show Loading state
        blogService.getUserMessages(user)
    }

    override suspend fun postNewMessage(messageEntity: NewMessageEntity) = withContext(Dispatchers.IO) {
        delay(TimeUnit.SECONDS.toMillis(2))
        blogService.postMessage(messageEntity)
    }
}
