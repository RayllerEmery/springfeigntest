package me.raylleremery.springfeigntest.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class ServiceImplementationTest {

    @Autowired
    lateinit var service: ServiceImplementation

    @Test
    fun `should return that mock port`() {
        Assertions.assertEquals(service.mockPort, "0000")
    }

}