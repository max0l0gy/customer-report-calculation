package ru.max0l0gy.customer.report.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.max0l0gy.customer.report.service.ReportsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reports")
public class ReportsController {
    private final ReportsService reportsService;

    @GetMapping("/by/customer-id/{customerId}")
    public Mono<RestResponse> reportBy(@PathVariable("customerId") Long customerId) {
        return reportsService.calculate(customerId)
                .map(RestResponse::success);
    }
}
