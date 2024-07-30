package dev.diegop88.blogchallenge.domain

import dev.diegop88.blogchallenge.data.BlogRepository
import dev.diegop88.blogchallenge.data.entities.ResponseEntity
import dev.diegop88.blogchallenge.utils.Parsers
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
class GetMessagesTest {

    private lateinit var getMessages: GetMessages
    private val parsers = Parsers()
    private val repository: BlogRepository = mockk<BlogRepository>()

    @Before
    fun setUp() {
        getMessages = GetMessages(repository, parsers)
    }

    @Test
    fun testGetMessages() = runTest {
        coEvery { repository.getAllMessages() } returns response
        val messages = getMessages.invoke()

        coVerify { repository.getAllMessages() }
        assertEquals(4, messages.size)
    }

    companion object {
        private val response = ResponseEntity(
            statusCode = 200,
            body = "{dan:[{subject:\"pets\",message:\"dogs are happy\"},{subject:\"pets\",message:\"cats are grumpy\"}],bob:[{subject:\"bob stuff\",message:\"bob bob bob\"},{subject:\"bob stuff\",message:\"there once was a guy named bob\"}]}",
        )
    }
}
