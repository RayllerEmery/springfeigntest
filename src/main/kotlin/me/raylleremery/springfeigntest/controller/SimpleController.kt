package me.raylleremery.springfeigntest.controller

import me.raylleremery.springfeigntest.client.BooksClient
import me.raylleremery.springfeigntest.client.PlaceHolderClient
import me.raylleremery.springfeigntest.client.response.PlaceHolderPostResponse
import me.raylleremery.springfeigntest.service.ServiceImplementation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class SimpleController(val service: ServiceImplementation, val client: BooksClient, val placeHolderClient: PlaceHolderClient) {

    @GetMapping("{concat}")
    fun simpleCall(@PathVariable concat: String): String {
        val response = service.mockPort
        return "$concat : $response"
    }

    @GetMapping("getBook")
    fun simpleCallBook(): String{
        return client.getBooks() ?: "Erro na requisição"
    }

    @GetMapping("placeholder")
    fun placeholder(): List<PlaceHolderPostResponse> {
        return placeHolderClient.getPlaceholderPost()
    }
}