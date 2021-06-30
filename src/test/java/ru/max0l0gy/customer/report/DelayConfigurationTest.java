package ru.max0l0gy.customer.report;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class DelayConfigurationTest {
    @Autowired
    private DelayConfiguration delayConfiguration;

    @Test
    void configuration() {
        Assertions.assertEquals(1, delayConfiguration.getOptions().size());
        Assertions.assertEquals(200L, delayConfiguration.getOptions().get(0));
    }
}
