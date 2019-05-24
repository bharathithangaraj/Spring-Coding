package com.satish.monitoring.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HealthCheck implements HealthIndicator {
    private Random random = new Random();

    @Override
    public Health health() {
        Health result = null;
        int errorCode = check();// perform some specific health check
        if (errorCode == 0) {
            result = Health.up().withDetail("Success", errorCode).build();
        } else {
            result = Health.down().withDetail("Error code", errorCode).build();
        }
        return result;
    }

    private int check() {
        int result = 0;
        if (random.nextBoolean()) {
            result = 42;
        }
        return result;
    }
}
