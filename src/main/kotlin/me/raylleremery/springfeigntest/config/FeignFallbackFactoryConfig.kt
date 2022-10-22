package me.raylleremery.springfeigntest.config

import feign.codec.ErrorDecoder
import me.raylleremery.springfeigntest.client.PlaceHolderClient
import me.raylleremery.springfeigntest.client.response.PlaceHolderPostResponse
import org.slf4j.LoggerFactory
import org.springframework.cloud.openfeign.FallbackFactory
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
class FeignFallbackFactoryConfig : PlaceHolderClient{
    val log = LoggerFactory.getLogger(this::class.java)
    override fun getPlaceholderPost(): List<PlaceHolderPostResponse> {
        log.info("[Fallback] getPlaceholderPost")
        return listOf(PlaceHolderPostResponse(
            userId = 0,
            id = 0,
            title = "error",
            body = "error"
        ))
    }

}