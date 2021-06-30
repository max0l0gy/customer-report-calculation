package ru.max0l0gy.customer.report.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import ru.max0l0gy.customer.report.DelayConfiguration;
import ru.max0l0gy.customer.report.domain.Report;

import java.math.BigDecimal;
import java.time.Duration;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReportsService {

    private final DelayConfiguration delayConfiguration;

    public Mono<Report> calculate(Long customerId) {

        Long delay = delayConfiguration.getOptions().get(randomOf(0, delayConfiguration.getOptions().size()));
        log.info("Delay of calculation in millis = {}", delay);
        return Mono.just(
                new Report()
                        .setCustomerId(customerId)
                        .setSale(calculateSale(customerId))
                        .setProcessTimeInMillis(delay))
                .delayElement(Duration.ofMillis(delay));
    }


    private BigDecimal calculateSale(Long customerId) {
        return BigDecimal.valueOf(randomOf(5, 30));
    }

    private int randomOf(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}
