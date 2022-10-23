package me.raylleremery.springfeigntest.config

import me.raylleremery.springfeigntest.client.BooksClient
import org.springframework.cloud.openfeign.FallbackFactory
import org.springframework.context.annotation.Configuration

@Configuration
class FeignFallbackFactoryConfig : FallbackFactory<FallbackWithFactory> {
    override fun create(cause: Throwable?): FallbackWithFactory {
        return FallbackWithFactory
    }

}

object FallbackWithFactory : BooksClient {
    override fun getBooks(): String {
        return "general error"
    }

}