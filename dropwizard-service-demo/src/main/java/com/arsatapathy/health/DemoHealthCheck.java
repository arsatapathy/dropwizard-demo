package com.arsatapathy.health;

import com.codahale.metrics.health.HealthCheck;

public class DemoHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
