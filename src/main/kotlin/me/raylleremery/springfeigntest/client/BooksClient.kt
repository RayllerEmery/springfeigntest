package me.raylleremery.springfeigntest.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping


@FeignClient(value = "simple-books-client", url = "\${book.service.url}")
interface BooksClient {

    @GetMapping("/books")
    fun getBooks(): String?

}