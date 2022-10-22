package me.raylleremery.springfeigntest.service

import me.raylleremery.springfeigntest.client.BooksClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ServiceImplementation {

    @Autowired
    lateinit var client: BooksClient

    @Value("\${service.mock.port}")
    lateinit var mockPort: String

    fun callBooks(): String {
        val response = client.getBooks()
        return "result: $response"
    }

}