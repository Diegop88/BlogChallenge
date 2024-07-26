package dev.diegop88.blogchallenge.data

import dev.diegop88.blogchallenge.data.entities.NewMessageEntity
import dev.diegop88.blogchallenge.data.entities.ResponseEntity
import dev.diegop88.blogchallenge.utils.URLs.GET_MESSAGES
import dev.diegop88.blogchallenge.utils.URLs.GET_USER_MESSAGES
import dev.diegop88.blogchallenge.utils.URLs.POST_MESSAGE
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface BlogService {
    @GET(GET_MESSAGES)
    suspend fun getMessages(): ResponseEntity

    @GET(GET_USER_MESSAGES)
    suspend fun getUserMessages(@Path("user") user: String): ResponseEntity

    @POST(POST_MESSAGE)
    suspend fun postMessage(@Body newMessageEntity: NewMessageEntity)
}
