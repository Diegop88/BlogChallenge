package dev.diegop88.blogchallenge.di

import dev.diegop88.blogchallenge.data.BlogRepository
import dev.diegop88.blogchallenge.data.BlogRepositoryImpl
import dev.diegop88.blogchallenge.data.BlogService
import dev.diegop88.blogchallenge.domain.GetMessages
import dev.diegop88.blogchallenge.domain.PostNewMessage
import dev.diegop88.blogchallenge.domain.SearchUserMessages
import dev.diegop88.blogchallenge.ui.home.HomeViewModel
import dev.diegop88.blogchallenge.ui.postMessage.PostMessageViewModel
import dev.diegop88.blogchallenge.utils.Parsers
import dev.diegop88.blogchallenge.utils.URLs
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private val client = OkHttpClient.Builder().apply {
    addInterceptor(loggingInterceptor)
}.build()

private val retrofit = Retrofit.Builder()
    .baseUrl(URLs.BASE)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

private val service = retrofit.create(BlogService::class.java)

val blogModule = module {
    single<BlogRepository> { BlogRepositoryImpl(service) }
    single { Parsers() }
    single { GetMessages(get(), get()) }
    single { PostNewMessage(get()) }
    single { SearchUserMessages(get(), get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { PostMessageViewModel(get()) }
}
