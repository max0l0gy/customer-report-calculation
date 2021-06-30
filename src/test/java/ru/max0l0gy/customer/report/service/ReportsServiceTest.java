package ru.max0l0gy.customer.report.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.max0l0gy.customer.report.domain.Report;

@SpringBootTest
@ActiveProfiles("test")
class ReportsServiceTest {

    @Autowired
    ReportsService reportsService;

    @Test
    void getReportByCustomerId() {
        Mono<Report> report = reportsService.calculate(101L);
        StepVerifier.create(report)
                .assertNext(r -> {
                    Assertions.assertEquals(101L, r.getCustomerId());
                    Assertions.assertNotNull(r.getCustomerId());
                    Assertions.assertNotNull(r.getProcessTimeInMillis());
                })
                .verifyComplete()
        ;

    }

}
