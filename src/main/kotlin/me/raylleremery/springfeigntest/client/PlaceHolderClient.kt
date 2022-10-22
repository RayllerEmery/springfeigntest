package me.raylleremery.springfeigntest.client

import me.raylleremery.springfeigntest.client.response.PlaceHolderPostResponse
import me.raylleremery.springfeigntest.config.FeignFallbackFactoryConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "placeholder-client", url = "\${placeholder.post.url}", fallback = FeignFallbackFactoryConfig::class)
interface PlaceHolderClient {

    @GetMapping("posts")
    fun getPlaceholderPost(): List<PlaceHolderPostResponse>
}