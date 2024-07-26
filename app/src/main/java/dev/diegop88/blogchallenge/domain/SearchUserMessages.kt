package dev.diegop88.blogchallenge.domain

import dev.diegop88.blogchallenge.data.BlogRepository
import dev.diegop88.blogchallenge.utils.Parsers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchUserMessages(
    private val repository: BlogRepository,
    private val parsers: Parsers,
) {
    suspend operator fun invoke(user: String) = withContext(Dispatchers.Default) {
        parsers.parseSearchMessages(repository.getUserMessages(user).body)
    }
}
