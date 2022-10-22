package me.raylleremery.springfeigntest

import me.raylleremery.springfeigntest.service.ServiceImplementation
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SpringfeigntestApplication

fun main(args: Array<String>) {
	runApplication<SpringfeigntestApplication>(*args)
}
