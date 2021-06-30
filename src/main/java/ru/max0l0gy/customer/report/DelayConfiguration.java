package ru.max0l0gy.customer.report;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "delay-in-millis")
public class DelayConfiguration {
    List<Long> options;
}
