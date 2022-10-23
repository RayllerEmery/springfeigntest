package me.raylleremery.springfeigntest.client

import me.raylleremery.springfeigntest.client.response.PlaceHolderPostResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "placeholder-client", url = "\${placeholder.post.url}")
interface PlaceHolderClient {

    @GetMapping("posts")
    fun getPlaceholderPost(): List<PlaceHolderPostResponse>
}