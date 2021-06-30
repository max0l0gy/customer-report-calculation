package ru.max0l0gy.customer.report.rest;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.StandardCharsets;

@Slf4j
@ActiveProfiles("test")
@AutoConfigureWebTestClient
@AutoConfigureWireMock(port = 0)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReportsControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    @SneakyThrows
    void reportsByCustomerId() {
        webTestClient.get()
                .uri("/v1/reports/by/customer-id/101")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(bytes->log.info("Response: {}", new String(bytes.getResponseBody(), StandardCharsets.UTF_8)))
                .jsonPath("$.status").isEqualTo("success")
                .jsonPath("$.currentTimestamp").isNumber()
                .jsonPath("$.data.processTimeInMillis").isNumber()
                .jsonPath("$.data.customerId").isEqualTo("101")
        ;

    }

}
