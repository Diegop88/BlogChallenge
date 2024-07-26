package dev.diegop88.blogchallenge.utils

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import dev.diegop88.blogchallenge.domain.models.Message
import java.lang.reflect.Type

class Parsers {
    private val listType: Type = object : TypeToken<List<Message>>() {}.type
    private val gson = Gson()

    internal fun parseMessages(body: String): List<Message> {
        val json = gson.fromJson(body, JsonObject::class.java)
        val messages = mutableListOf<Message>()
        for ((name, value) in json.entrySet()) {
            messages.addAll(gson.fromJson<List<Message>?>(value, listType).map { it.copy(user = name) })
        }
        return messages
    }

    internal fun parseSearchMessages(body: String): List<Message> {
        val json = gson.fromJson(body, JsonObject::class.java)
        val messages = mutableListOf<Message>()
        val user = json.get("user").asString
        messages.addAll(gson.fromJson<List<Message>?>(json.get("message"), listType).map { it.copy(user = user) })
        return messages
    }
}
