package ru.max0l0gy.customer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class ActuatorTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    @SneakyThrows
    void healthCheck() {
        webTestClient.get()
                .uri("/actuator/health")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(bytes->log.info("Response: {}", new String(bytes.getResponseBody(), StandardCharsets.UTF_8)))
                .jsonPath("$.status").isEqualTo("UP")
        ;

    }
}
