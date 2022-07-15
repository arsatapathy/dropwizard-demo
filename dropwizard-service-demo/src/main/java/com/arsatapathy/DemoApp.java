package com.arsatapathy;

import com.arsatapathy.config.DemoAppConfig;
import com.arsatapathy.health.DemoHealthCheck;
import com.arsatapathy.module.DemoModule;
import com.arsatapathy.resource.DemoResource;
import com.arsatapathy.service.StudentService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DemoApp extends Application<DemoAppConfig> {

    public static void main(String[] args) throws Exception {
        new DemoApp().run(args);
    }

    @Override
    public String getName() {
        return "DEMO-APP";
    }

    @Override
    public void initialize(Bootstrap<DemoAppConfig> bootstrap) {
    }

    @Override
    public void run(DemoAppConfig configuration, Environment environment) {

        Injector injector = Guice.createInjector(new DemoModule());

        StudentService studentService = injector.getInstance(StudentService.class);

        final DemoResource demoResource = new DemoResource(
                configuration,
                studentService
        );

        final DemoHealthCheck healthCheck = new DemoHealthCheck();

        environment.jersey().register(demoResource);
        environment.healthChecks().register("demoApp", healthCheck);
    }
}
