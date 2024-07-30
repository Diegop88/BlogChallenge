package dev.diegop88.blogchallenge.domain

import dev.diegop88.blogchallenge.data.BlogRepository
import dev.diegop88.blogchallenge.data.entities.NewMessageEntity
import dev.diegop88.blogchallenge.data.entities.ResponseEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class PostNewMessageTest {

    private lateinit var postNewMessage: PostNewMessage
    private val repository = mockk<BlogRepository>()

    @Before
    fun setUp() {
        postNewMessage = PostNewMessage(repository)
    }

    @Test
    fun testPostMessage() = runTest {
        coEvery { repository.postNewMessage (any(NewMessageEntity::class)) } returns response

        val postResponse = postNewMessage.invoke(USER, SUBJECT, MESSAGE)

        coVerify { repository.postNewMessage(any(NewMessageEntity::class)) }
        assertEquals(200, postResponse.statusCode)
    }

    companion object {
        const val USER = "Diego"
        const val SUBJECT = "Pets"
        const val MESSAGE = "Dogs are funny"
        val response = ResponseEntity(
            statusCode = 200,
            body = ""
        )
    }
}
