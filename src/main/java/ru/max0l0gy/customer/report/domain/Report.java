package ru.max0l0gy.customer.report.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class Report {
    private Long customerId;
    private BigDecimal sale;
    private Long processTimeInMillis;
}