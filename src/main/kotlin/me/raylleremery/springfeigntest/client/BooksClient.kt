package me.raylleremery.springfeigntest.client

import me.raylleremery.springfeigntest.config.FeignFallbackFactoryConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping


@FeignClient(value = "simple-books-client", url = "\${book.service.url}", fallbackFactory = FeignFallbackFactoryConfig::class)
interface BooksClient {

    @GetMapping("/books")
    fun getBooks(): String?

}