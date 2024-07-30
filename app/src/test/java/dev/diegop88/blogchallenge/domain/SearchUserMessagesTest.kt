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
class SearchUserMessagesTest {

    private lateinit var searchUserMessages: SearchUserMessages
    private val parsers = Parsers()
    private val repository = mockk<BlogRepository>()

    @Before
    fun setUp() {
        searchUserMessages = SearchUserMessages(repository, parsers)
    }

    @Test
    fun testSearchUserMessages() = runTest {
        coEvery { repository.getUserMessages(any()) } returns response
        val messages = searchUserMessages.invoke("dan")

        coVerify { repository.getUserMessages("dan") }
        assertEquals(2, messages.size)
    }

    companion object {
        private val response = ResponseEntity(
            statusCode = 200,
            body = "{user:\"dan\",message:[{subject:\"pets\",message:\"dogs are happy\"},{subject:\"pets\",message:\"cats are grumpy\"}]}"
        )
    }
}
