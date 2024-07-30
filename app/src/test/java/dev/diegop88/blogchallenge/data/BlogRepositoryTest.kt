package dev.diegop88.blogchallenge.data

import dev.diegop88.blogchallenge.data.entities.NewMessageEntity
import dev.diegop88.blogchallenge.data.entities.ResponseEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BlogRepositoryTest {

    private val service = mockk<BlogService>()
    private lateinit var repository: BlogRepository

    @Before
    fun setUp() {
        repository = BlogRepositoryImpl(service)
    }

    @Test
    fun testGetMessages() = runTest {
        coEvery { service.getMessages() } returns response

        repository.getAllMessages()

        coVerify { service.getMessages() }
    }

    @Test
    fun testSearchUserMessages() = runTest {
        coEvery { service.getUserMessages(any()) } returns response

        repository.getUserMessages("Diego")

        coVerify { service.getUserMessages("Diego") }
    }

    @Test
    fun testPostNewMessage() = runTest {
        coEvery { service.postMessage(any(NewMessageEntity::class)) } returns response

        repository.postNewMessage(newMessage)

        coVerify { service.postMessage(newMessage) }
    }

    companion object {
        val newMessage = NewMessageEntity(
            "Diego",
            "Pets",
            "Dogs are funny",
            "add_message"
        )
        val response = ResponseEntity(
            statusCode = 200,
            body = ""
        )
    }
}
