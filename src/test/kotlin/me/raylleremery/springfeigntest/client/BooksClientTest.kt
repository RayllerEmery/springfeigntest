package me.raylleremery.springfeigntest.client

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class BooksClientTest {

    @Autowired
    private lateinit var client: BooksClient

    private val server = WireMockServer(PORT)

    @BeforeAll
    fun setup() {
        server.start()
        WireMock.configureFor(HOST, PORT)
        WireMock.stubFor(
            WireMock.get("/books").willReturn(
                WireMock.aResponse().withStatus(200).withBody("All books!")
            )
        )
    }

    @Test
    fun `should call client with successfully`() {
        val response = client.getBooks()

        Assertions.assertNotNull(response)
    }

    @AfterAll
    fun tearDown(){
        if (server.isRunning) server.shutdownServer()
    }

    companion object {
        val PORT = 9561
        val HOST = "localhost"
    }

}